package bookmanagemant;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class BookManagemant extends JFrame {

    private JPanel contentPane;
    private JButton btnNewButton;
    private JButton button;
    private JButton button_1;
    private JButton button_2;
    private JLabel lblNewLabel;
    private JLabel lblBookName;
    private JLabel lblPublisher;
    private JLabel lblYear;
    private JLabel lblPrice;
    private JLabel lblUseyn;
    private JLabel lblAurthid;
    private JTextField txtBid;
    private JTextField txtName;
    private JTextField txtPub;
    private JTextField txtYear;
    private JTextField txtPrice;
    private JTextField txtAuth;
    private JCheckBox chkbox;
    private JScrollPane scrollPane;
    private static JTable table;

    private static List<Book> books = null;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    BookManagemant frame = new BookManagemant();
                    frame.setVisible(true);
                    
                    // 기초 데이터 생성
                    initData();
                    
                    // 데이터 바인딩
                    frame.refresh(books, table);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public BookManagemant() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
            }
        });
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 621, 508);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.add(getBtnNewButton());
        contentPane.add(getButton());
        contentPane.add(getButton_1());
        contentPane.add(getButton_2());
        contentPane.add(getLblNewLabel());
        contentPane.add(getLblBookName());
        contentPane.add(getLblPublisher());
        contentPane.add(getLblYear());
        contentPane.add(getLblPrice());
        contentPane.add(getLblUseyn());
        contentPane.add(getLblAurthid());
        contentPane.add(getTxtBid());
        contentPane.add(getTxtName());
        contentPane.add(getTxtPub());
        contentPane.add(getTxtYear());
        contentPane.add(getTxtPrice());
        contentPane.add(getTxtAuth());
        contentPane.add(getChkbox());
        contentPane.add(getScrollPane_1());
    }

    private JButton getBtnNewButton() {
        if (btnNewButton == null) {
            btnNewButton = new JButton("조회");
            btnNewButton.setBounds(12, 201, 69, 23);
            btnNewButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                }
            });
        }
        return btnNewButton;
    }

    public static void initData() {
        books = new ArrayList<>();
        books.add(new Book(1, "operating system", "wiley", "2003", 30700, false, 1));
        books.add(new Book(2, "mysql", "oreilly", "2009", 58700, true, 2));
        books.add(new Book(3, "java", "hall", "2013", 40000, true, 3));
        books.add(new Book(4, "first sql", "wiley", "2015", 57700, true, 4));
    }

    private JButton getButton() {
        if (button == null) {
            button = new JButton("추가");
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                }
            });
            button.setBounds(93, 201, 69, 23);
        }
        return button;
    }

    private JButton getButton_1() {
        if (button_1 == null) {
            button_1 = new JButton("수정");
            button_1.setBounds(174, 201, 69, 23);
        }
        return button_1;
    }

    private JButton getButton_2() {
        if (button_2 == null) {
            button_2 = new JButton("삭제");
            button_2.setBounds(255, 201, 69, 23);
        }
        return button_2;
    }

    private JLabel getLblNewLabel() {
        if (lblNewLabel == null) {
            lblNewLabel = new JLabel("Book ID");
            lblNewLabel.setBounds(24, 252, 88, 15);
        }
        return lblNewLabel;
    }

    private JLabel getLblBookName() {
        if (lblBookName == null) {
            lblBookName = new JLabel("Book Name");
            lblBookName.setBounds(24, 277, 88, 15);
        }
        return lblBookName;
    }

    private JLabel getLblPublisher() {
        if (lblPublisher == null) {
            lblPublisher = new JLabel("Publisher");
            lblPublisher.setBounds(24, 302, 88, 15);
        }
        return lblPublisher;
    }

    private JLabel getLblYear() {
        if (lblYear == null) {
            lblYear = new JLabel("Year");
            lblYear.setBounds(24, 327, 88, 15);
        }
        return lblYear;
    }

    private JLabel getLblPrice() {
        if (lblPrice == null) {
            lblPrice = new JLabel("Price");
            lblPrice.setBounds(24, 352, 88, 15);
        }
        return lblPrice;
    }

    private JLabel getLblUseyn() {
        if (lblUseyn == null) {
            lblUseyn = new JLabel("Use_yn");
            lblUseyn.setBounds(24, 378, 88, 15);
        }
        return lblUseyn;
    }

    private JLabel getLblAurthid() {
        if (lblAurthid == null) {
            lblAurthid = new JLabel("Auth ID");
            lblAurthid.setBounds(24, 403, 88, 15);
        }
        return lblAurthid;
    }

    private JTextField getTxtBid() {
        if (txtBid == null) {
            txtBid = new JTextField();
            txtBid.setBounds(133, 252, 231, 21);
            txtBid.setColumns(10);
        }
        return txtBid;
    }

    private JTextField getTxtName() {
        if (txtName == null) {
            txtName = new JTextField();
            txtName.setBounds(133, 277, 231, 21);
            txtName.setColumns(10);
        }
        return txtName;
    }

    private JTextField getTxtPub() {
        if (txtPub == null) {
            txtPub = new JTextField();
            txtPub.setBounds(133, 302, 231, 21);
            txtPub.setColumns(10);
        }
        return txtPub;
    }

    private JTextField getTxtYear() {
        if (txtYear == null) {
            txtYear = new JTextField();
            txtYear.setBounds(133, 327, 231, 21);
            txtYear.setColumns(10);
        }
        return txtYear;
    }

    private JTextField getTxtPrice() {
        if (txtPrice == null) {
            txtPrice = new JTextField();
            txtPrice.setBounds(133, 352, 231, 21);
            txtPrice.setColumns(10);
        }
        return txtPrice;
    }

    private JTextField getTxtAuth() {
        if (txtAuth == null) {
            txtAuth = new JTextField();
            txtAuth.setBounds(133, 400, 231, 21);
            txtAuth.setColumns(10);
        }
        return txtAuth;
    }

    private JCheckBox getChkbox() {
        if (chkbox == null) {
            chkbox = new JCheckBox("");
            chkbox.setBounds(129, 376, 115, 23);
        }
        return chkbox;
    }

    private JScrollPane getScrollPane_1() {
        if (scrollPane == null) {
            scrollPane = new JScrollPane();
            scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
            scrollPane.setBounds(12, 10, 581, 181);
            scrollPane.setViewportView(getTable());
        }
        return scrollPane;
    }

    private JTable getTable() {
        if (table == null) {
            table = new JTable();
            table.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    int row = table.getSelectedRow();

                    String savedId = table.getValueAt(row, 0).toString();
                    String name = table.getValueAt(row, 1).toString();
                    String publisher = table.getValueAt(row, 2).toString();
                    String year = table.getValueAt(row, 3).toString();
                    String price = table.getValueAt(row, 4).toString();
                  //Boolean use = (Boolean) table.getValueAt(row, 5);
                    String authid = table.getValueAt(row, 6).toString();

                    txtBid.setText(savedId);
                    txtName.setText(name);
                    txtPub.setText(publisher);
                    txtYear.setText(year);
                    txtPrice.setText(price);
                    txtAuth.setText(authid);

                }
            });
            table.setModel(new DefaultTableModel(new Object[][] {},
                    new String[] { "bookid", "bookname", "publisher", "year", "price", "use_yn", "authid" }) {
                Class[] columnTypes = new Class[] { Integer.class, String.class, String.class, String.class,
                        Integer.class, Boolean.class, Integer.class };

                public Class getColumnClass(int columnIndex) {
                    return columnTypes[columnIndex];
                }
            });
        }
        return table;
    }
    
    public void refresh( List<Book> list, JTable table ) {
        Object [] tempObject = new Object[7];  //JTable의 컬럼 개수
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        model.setRowCount(0);  //table의 위치를 0부터 시작하도록 설정
        
        for (Book obj : list) {
            tempObject[0] = obj.getBookid();
            tempObject[1] = obj.getBookname();
            tempObject[2] = obj.getPublisher();
            tempObject[3] = obj.getYear();
            tempObject[4] = obj.getPrice();
            tempObject[6] = obj.getAuthid();
            
            model.addRow(tempObject); // table의 row로 추가
        }
        
        // JTable 첫번째 로우에 focus 주기
        if (model.getRowCount() > 0) {
            table.setRowSelectionInterval(0, 0);
        }
        
        table.setModel(model);
    }
}
