package bookservice.copy;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ListSelectionModel;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;

public class TestTable extends JFrame {

    private JPanel contentPane;
    private JScrollPane scrollPane;
    private JTable table_1;

    /**
     * Launch the application.
     */
    public static void main(String[] args) throws SQLException {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TestTable frame = new TestTable();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void refreshTable(ResultSet rs, JTable table) throws SQLException {
        ResultSetMetaData rsmd = rs.getMetaData();
        Object[] tempObject = new Object[rsmd.getColumnCount()];
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        for (; rs.next();) {
            for (int i = 0; i < rsmd.getColumnCount(); i++) {
                if (rsmd.getColumnType(i + 1) == java.sql.Types.BOOLEAN)
                    tempObject[i] = rs.getBoolean(i + 1);
                else
                    tempObject[i] = rs.getString(i + 1);
            }
            model.addRow(tempObject);
        }
        if (model.getRowCount() > 0)
            table.setRowSelectionInterval(0, 0); // 첫째줄에 포커
        table.setModel(model);
    }

    /**
     * Create the frame.
     */
    public TestTable() {

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                ResultSet rs = null;
                try {
                    rs = new ServiceBook().selectAll();
                    refreshTable(rs, table_1);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.add(getScrollPane());
    }
    private JScrollPane getScrollPane() {
        if (scrollPane == null) {
        	scrollPane = new JScrollPane();
        	scrollPane.setBounds(12, 10, 410, 242);
        	scrollPane.setViewportView(getTable_1());
        }
        return scrollPane;
    }
    private JTable getTable_1() {
        if (table_1 == null) {
        	table_1 = new JTable();
        	table_1.setModel(new DefaultTableModel(
        	    new Object[][] {
        	    },
        	    new String[] {
        	        "New column", "New column", "New column", "New column", "New column", "New column", "New column"
        	    }
        	));
        }
        return table_1;
    }
}
