package java31.st2table;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class frmBooks extends JFrame {
    
    // List
    private static List<Book> books = null;
    
    private JPanel contentPane;
    private static JTable table;
    private JTextField txtBookid;
    private JTextField txtBookname;
    private JTextField txtPublisher;
    private JTextField txtYear;
    private JTextField txtPrice;
    private JTextField txtAuthid;
    private JCheckBox chkUseyn;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {                    
                    frmBooks frame = new frmBooks();
                    frame.setVisible(true);
                    
                    // 기초 데이터 생성
                    initData();
                    
                    // 데이터 바인딩
                    frame.refreshTable(books, table);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    public static void initData() {
        books = new ArrayList<>();
        books.add( new Book(1, "operating system"  , "wiley"     , "2003", 30700, false, 1 ) ) ;
        books.add( new Book(2, "mysql"             , "oreilly"   , "2009", 58700, true , 2 ) ) ;
        books.add( new Book(3, "java"              , "hall"      , "2013", 40000, true , 3 ) ) ;
        books.add( new Book(4, "first sql"         , "wiley"     , "2015", 57700, true , 4 ) ) ;
    }
    
    /**
     * Create the frame.
     */
    public frmBooks() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 689, 493);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(12, 10, 649, 121);
        contentPane.add(scrollPane);
        
        table = new JTable();
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // 선택한 로우를 리턴.
                int row = table.getSelectedRow();

                String bookid    = table.getValueAt(row, 0).toString();
                String bookname  = table.getValueAt(row, 1).toString();
                String publisher = table.getValueAt(row, 2).toString();
                String year      = table.getValueAt(row, 3).toString();
                String price     = table.getValueAt(row, 4).toString();
                Boolean useyn    = (boolean) table.getValueAt(row, 5) ;
                String authid    = table.getValueAt(row, 6).toString();
                
                txtBookid.setText(bookid);  // bookid
                txtBookname.setText(bookname);   // bookname
                txtPublisher.setText(publisher);  // publisher
                txtYear.setText( year );
                chkUseyn.setSelected( useyn );
                txtPrice.setText( price  );
            }
        });
        table.setModel(new DefaultTableModel(
            new Object[][] {
            },
            new String[] {
                "bookid", "bookname", "publisher", "year", "price", "use_yn", "authid"
            }
        ) {
            Class[] columnTypes = new Class[] {
                Integer.class, String.class, String.class, String.class, Integer.class, Boolean.class, Object.class
            };
            public Class getColumnClass(int columnIndex) {
                return columnTypes[columnIndex];
            }
        });
        table.getColumnModel().getColumn(1).setPreferredWidth(139);
        table.getColumnModel().getColumn(2).setPreferredWidth(114);
        table.getColumnModel().getColumn(5).setPreferredWidth(54);
        scrollPane.setViewportView(table);
        
        JButton btnNewButton = new JButton("조회");
        btnNewButton.setBounds(12, 164, 97, 23);
        contentPane.add(btnNewButton);
        
        JButton btnNewButton_1 = new JButton("추가");
        btnNewButton_1.setBounds(121, 164, 97, 23);
        contentPane.add(btnNewButton_1);
        
        JButton btnNewButton_2 = new JButton("수정");
        btnNewButton_2.setBounds(230, 164, 97, 23);
        contentPane.add(btnNewButton_2);
        
        JButton btnNewButton_3 = new JButton("삭제");
        btnNewButton_3.setBounds(339, 164, 97, 23);
        contentPane.add(btnNewButton_3);
        
        JLabel lblNewLabel = new JLabel("bookid");
        lblNewLabel.setBounds(12, 217, 57, 15);
        contentPane.add(lblNewLabel);
        
        txtBookid = new JTextField();
        txtBookid.setBounds(93, 214, 116, 21);
        contentPane.add(txtBookid);
        txtBookid.setColumns(10);
        
        txtBookname = new JTextField();
        txtBookname.setColumns(10);
        txtBookname.setBounds(93, 245, 116, 21);
        contentPane.add(txtBookname);
        
        JLabel lblBookname = new JLabel("bookname");
        lblBookname.setBounds(12, 248, 79, 15);
        contentPane.add(lblBookname);
        
        txtPublisher = new JTextField();
        txtPublisher.setColumns(10);
        txtPublisher.setBounds(93, 276, 116, 21);
        contentPane.add(txtPublisher);
        
        JLabel lblPublisher = new JLabel("publisher");
        lblPublisher.setBounds(12, 279, 57, 15);
        contentPane.add(lblPublisher);
        
        txtYear = new JTextField();
        txtYear.setColumns(10);
        txtYear.setBounds(93, 307, 116, 21);
        contentPane.add(txtYear);
        
        JLabel lblYear = new JLabel("year");
        lblYear.setBounds(12, 310, 57, 15);
        contentPane.add(lblYear);
        
        txtPrice = new JTextField();
        txtPrice.setColumns(10);
        txtPrice.setBounds(93, 340, 116, 21);
        contentPane.add(txtPrice);
        
        JLabel lblPrice = new JLabel("price");
        lblPrice.setBounds(12, 343, 57, 15);
        contentPane.add(lblPrice);
        
        JLabel lblUseyn = new JLabel("use_yn");
        lblUseyn.setBounds(12, 374, 57, 15);
        contentPane.add(lblUseyn);
        
        txtAuthid = new JTextField();
        txtAuthid.setColumns(10);
        txtAuthid.setBounds(93, 399, 116, 21);
        contentPane.add(txtAuthid);
        
        JLabel lblAuthid = new JLabel("authid");
        lblAuthid.setBounds(12, 402, 57, 15);
        contentPane.add(lblAuthid);
        
        chkUseyn = new JCheckBox("New check box");
        chkUseyn.setBounds(94, 370, 115, 23);
        contentPane.add(chkUseyn);
    }
    
    public void refreshTable( List<Book> list, JTable table ) {
        Object [] tempObject = new Object[ 7 ]; // JTable의 컬럼 갯수.
        DefaultTableModel model = (DefaultTableModel)table.getModel() ;
        model.setRowCount(0 ); // table 위치를 0 부터 시작하도록 설정.
        
        for (Book obj : list ) {            
            tempObject[0] = obj.getBookid();
            tempObject[1] = obj.getBookname();
            tempObject[2] = obj.getPublisher();
            tempObject[3] = obj.getYear();
            tempObject[4] = obj.getPrice();
            tempObject[5] = obj.getUse_yn();
            tempObject[6] = obj.getAuthid();
            
            model.addRow(tempObject); // table의 row로 추가
        }
        
        // JTable 첫번째 로우에 focus 주기
        if( model.getRowCount() > 0 ) {
            table.setRowSelectionInterval(0, 0);
        }
        
        table.setModel(model);
    }
    
    
    
    
    
    
    
    
    
    
}
