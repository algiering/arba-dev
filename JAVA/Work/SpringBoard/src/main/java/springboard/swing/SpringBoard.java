package springboard.swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import springboard.inf.IServiceBoard;
import springboard.model.ModelBoard;
import springboard.svr.ServiceBoard;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

public class SpringBoard {

    private JFrame frame;
    private JScrollPane scrollPane;
    private static JTable table;

    private static IServiceBoard service = null;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    @SuppressWarnings("resource")
                    ApplicationContext context = new ClassPathXmlApplicationContext("classpath:ApplicationContext.xml");
                    service = context.getBean("serviceboard", ServiceBoard.class);
                    SpringBoard window = new SpringBoard();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public SpringBoard() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                getTable();
            }
        });
        frame.setBounds(100, 100, 741, 535);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().add(getScrollPane());
    }

    private JScrollPane getScrollPane() {
        if (scrollPane == null) {
            scrollPane = new JScrollPane();
            scrollPane.setBounds(12, 10, 701, 477);
            scrollPane.setViewportView(getTable());
        }
        return scrollPane;
    }

    private JTable getTable() {
        List<ModelBoard> result = null;
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        Object[] object = new Object[7];
        try {
            result = service.getBoardList();
            object[0] = result.get(0).getBoardcd();
            object[1] = result.get(0).getBoardnm();
            object[2] = result.get(0).getUseYN();
            object[3] = result.get(0).getInsertUID();
            object[4] = result.get(0).getInsertDT();
            object[5] = result.get(0).getUpdateUID();
            object[6] = result.get(0).getUpdateDT();
            
            model.addRow(object);
            
            table.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
 
        if (table == null) {
        	table = new JTable();
        	table.setModel(new DefaultTableModel(
        	    new Object[][] {
        	    },
        	    new String[] {
        	        "boardcd", "boardnm", "UseYN", "InsertUID", "InsertDT", "UpdateUID", "UpdateDT"
        	    }
        	));
        }
        return table;
    }
}
