package bookservice;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JTree;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;

public class BookService extends JFrame {

    private JPanel contentPane;
    private JPanel menuPanel;
    private JPanel statusPanel;
    private JLabel lblNewLabel;
    private JScrollPane scrollPane;
    private JTable table;
    private JTabbedPane tabbedPane;
    private JPanel panel;
    private JPanel panel_1;
    private JPanel panel_2;
    private JButton btnNewButton;
    private JButton button;
    private JButton button_1;
    private JButton button_2;
    private JScrollPane scrollPane_1;
    private static JTable bInfoTable;
    private JScrollPane scrollPane_2;
    private JTree tree;
    private JPanel panel_3;
    private JLabel lblNewLabel_1;
    private JLabel label;
    private JLabel label_1;
    private JLabel label_2;
    private JLabel label_3;
    private JLabel label_4;
    private JLabel label_5;
    private JButton bBorrowButton;
    private JButton bUpdateButton;
    private JButton bDeleteButton;
    private JButton bCancelButton;
    private JTextField bTitleTxt;
    private JTextField bPubTxt;
    private JTextField bWriTxt;
    private JTextField bPriceTxt;
    private JTextField bGenreTxt;
    private JTextField bNumTxt;
    private JComboBox comboBox;
    private JTextField textField_5;
    private JButton btnNewButton_2;
    private JScrollPane scrollPane_3;
    private JTable table_2;
    private JPanel panel_4;
    private JButton btnNewButton_3;
    private JScrollPane scrollPane_4;
    private static JTable cInfoTable;
    private JPanel panel_5;
    private JLabel lblNewLabel_2;
    private JLabel label_6;
    private JLabel label_7;
    private JLabel label_8;
    private JLabel label_9;
    private JTextField cNameTxt;
    private JTextField cRrn1;
    private JTextField cPnum1;
    private JTextField cMail1;
    private JTextField cNumTxt;
    private JTextField cRrn2;
    private JTextField cPnum2;
    private JTextField cMail2;
    private JTextField textField_16;
    private JTextField cPnum3;
    private JComboBox comboBox_1;
    private JButton btnNewButton_4;
    private JLabel lblNewLabel_3;
    private JLabel label_10;
    private JLabel label_11;
    private JButton cDeleteButton;
    private JButton cUpdateButton;
    private JButton cCancelButton;

    private static BookService frame = null;
    
    private static List<Book> bookList = null;
    private static List<Customer> customerList = null;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame = new BookService();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public static void initBookData() {
        bookList = new ArrayList<>();
        bookList.add(new Book( 1 , "aaaa", "aaaa", "aaaa", "aaaa", "11111", false, 0));
        bookList.add(new Book( 2 , "bbbb", "bbbb", "bbbb", "bbbb", "22222", false, 0));
        bookList.add(new Book( 3 , "cccc", "cccc", "cccc", "cccc", "33333", true, 2));
        bookList.add(new Book( 4 , "dddd", "dddd", "dddd", "dddd", "44444", true, 4));
    }

    public static void initCostData() {
        customerList = new ArrayList<>();
        customerList.add(new Customer( 1 , "aaaa", "aaaa-aaaa", "aaaa-aaaa-aaaa", "aaaa@aaaa.com"));
        customerList.add(new Customer( 2 , "bbbb", "bbbb-bbbb", "bbbb-bbbb-bbbb", "bbbb@bbbb.com"));
        customerList.add(new Customer( 3 , "cccc", "cccc-cccc", "cccc-cccc-cccc", "cccc@cccc.com"));
        customerList.add(new Customer( 4 , "dddd", "dddd-dddd", "dddd-dddd-dddd", "dddd@dddd.com"));
    }
    
    public static void brefresh( List<Book> bookList2, JTable table ) {
        Object [] tempObject = new Object[8];  //JTable의 컬럼 개수
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        model.setRowCount(0);  //table의 위치를 0부터 시작하도록 설정
        
        for (Book obj : bookList2) {
            tempObject[0] = obj.getBnum();
            tempObject[1] = obj.getBtitle();
            tempObject[2] = obj.getBpublisher();
            tempObject[3] = obj.getBgenre();
            tempObject[4] = obj.getBwriter();
            tempObject[5] = obj.getBprice();
            tempObject[6] = obj.getBstatus();
            tempObject[7] = obj.getbBorrowCusNo();
            
            model.addRow(tempObject); // table의 row로 추가
        }
        
        // JTable 첫번째 로우에 focus 주기
//        if (model.getRowCount() > 0) {
//            table.setRowSelectionInterval(0, 0);
//        }
        
        table.setModel(model);
    }
    
    public static void crefresh( List<Customer> list, JTable table ) {
        Object [] tempObject = new Object[5];  //JTable의 컬럼 개수
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        model.setRowCount(0);  //table의 위치를 0부터 시작하도록 설정
        
        for (Customer obj : list) {
            tempObject[0] = obj.getCnum();
            tempObject[1] = obj.getCname();
            tempObject[2] = obj.getCrrn();
            tempObject[3] = obj.getCpnum();
            tempObject[4] = obj.getCemail();
            
            model.addRow(tempObject); // table의 row로 추가
        }
        
        // JTable 첫번째 로우에 focus 주기
//        if (model.getRowCount() > 0) {
//            table.setRowSelectionInterval( 0, 0 );
//        }
        
        table.setModel(model);
    }
    
    public static void BookReg(String title, String publisher, String genre, String writer, String price) {
        int bnum = 1;
        for (Book book : bookList) {
            bnum = bnum + 1;
        }
        boolean status = false;
        int bborrowcno = 0;
        bookList.add(new Book(bnum,title,publisher,genre,writer,price,status,bborrowcno));
        brefresh(bookList, bInfoTable);
    }
    
    public static void CustomerReg(String cname, String crrn1, String crrn2, String cpn1, String cpn2, String cpn3, String cmail1, String cmail2) {
        int cnum = 1;
        for (Customer customer : customerList) {
            cnum = cnum + 1;
        }
        String crrn = crrn1 + "-" + crrn2;
        String cpnum = cpn1 + "-" + cpn2 + "-" + cpn3;
        String cemail = cmail1 + "@" + cmail2;
        customerList.add(new Customer(cnum, cname, crrn, cpnum, cemail));
        crefresh(customerList, cInfoTable);
    }

    public BookService() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                initBookData();
                initCostData();
                
                brefresh(bookList, bInfoTable);
                crefresh(customerList, cInfoTable);
            }
        });
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1280, 720);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.add(getMenuPanel());
        contentPane.add(getStatusPanel());
        contentPane.add(getTabbedPane());
    }

    private JPanel getMenuPanel() {
        if (menuPanel == null) {
            menuPanel = new JPanel();
            menuPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
            menuPanel.setBounds(10, 10, 1242, 77);
            menuPanel.setLayout(null);
            menuPanel.add(getBtnNewButton());
            menuPanel.add(getButton());
            menuPanel.add(getButton_1());
            menuPanel.add(getButton_2());
        }
        return menuPanel;
    }

    private JPanel getStatusPanel() {
        if (statusPanel == null) {
            statusPanel = new JPanel();
            statusPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
            statusPanel.setBounds(10, 97, 231, 575);
            statusPanel.setLayout(null);
            statusPanel.add(getLblNewLabel());
            statusPanel.add(getScrollPane());
        }
        return statusPanel;
    }

    private JLabel getLblNewLabel() {
        if (lblNewLabel == null) {
            lblNewLabel = new JLabel("대출 상황");
            lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
            lblNewLabel.setBounds(76, 6, 74, 15);
        }
        return lblNewLabel;
    }

    private JScrollPane getScrollPane() {
        if (scrollPane == null) {
            scrollPane = new JScrollPane();
            scrollPane.setBounds(0, 27, 230, 548);
            scrollPane.setViewportView(getTable());
        }
        return scrollPane;
    }

    private JTable getTable() {
        if (table == null) {
            table = new JTable();
            table.setModel(new DefaultTableModel(new Object[][] {},
                    new String[] { "\uC774\uB984", "\uCC45 \uC81C\uBAA9", "\uB300\uC5EC\uB0A0\uC9DC" }) {
                Class[] columnTypes = new Class[] { String.class, String.class, String.class };

                public Class getColumnClass(int columnIndex) {
                    return columnTypes[columnIndex];
                }
            });
        }
        return table;
    }

    private JTabbedPane getTabbedPane() {
        if (tabbedPane == null) {
            tabbedPane = new JTabbedPane(JTabbedPane.TOP);
            tabbedPane.setBounds(253, 97, 999, 575);
            tabbedPane.addTab("책 정보", null, getPanel(), null);
            tabbedPane.addTab("회원 관리", null, getPanel_1(), null);
            tabbedPane.addTab("대여 목록", null, getPanel_2(), null);
        }
        return tabbedPane;
    }

    private JPanel getPanel() {
        if (panel == null) {
            panel = new JPanel();
            panel.setLayout(null);
            panel.add(getScrollPane_1());
            panel.add(getScrollPane_2());
            panel.add(getPanel_3());
        }
        return panel;
    }

    private JPanel getPanel_1() {
        if (panel_1 == null) {
            panel_1 = new JPanel();
            panel_1.setLayout(null);
            panel_1.add(getScrollPane_4());
            panel_1.add(getPanel_5());
        }
        return panel_1;
    }

    private JPanel getPanel_2() {
        if (panel_2 == null) {
            panel_2 = new JPanel();
            panel_2.setLayout(null);
            panel_2.add(getScrollPane_3());
            panel_2.add(getPanel_4());
        }
        return panel_2;
    }

    private JButton getBtnNewButton() {
        if (btnNewButton == null) {
            btnNewButton = new JButton("회원 등록");
            btnNewButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    CustomerRegist cr = new CustomerRegist(frame);
                    cr.setVisible(true);
                }
            });
            btnNewButton.setBounds(12, 10, 135, 57);
        }
        return btnNewButton;
    }

    private JButton getButton() {
        if (button == null) {
            button = new JButton("책 등록");
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    BookRegist br = new BookRegist(frame);
                    br.setVisible(true);
                }
            });
            button.setBounds(159, 10, 135, 57);
        }
        return button;
    }

    private JButton getButton_1() {
        if (button_1 == null) {
            button_1 = new JButton("새로고침");
            button_1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    brefresh(bookList, bInfoTable);
                    crefresh(customerList, cInfoTable);
                }
            });
            button_1.setBounds(306, 10, 135, 57);
        }
        return button_1;
    }

    private JButton getButton_2() {
        if (button_2 == null) {
            button_2 = new JButton("프로그램 종료");
            button_2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });
            button_2.setBounds(453, 10, 135, 57);
        }
        return button_2;
    }

    private JScrollPane getScrollPane_1() {
        if (scrollPane_1 == null) {
            scrollPane_1 = new JScrollPane();
            scrollPane_1.setBounds(0, 229, 994, 317);
            scrollPane_1.setViewportView(getBInfoTable());
        }
        return scrollPane_1;
    }

    private JTable getBInfoTable() {
        if (bInfoTable == null) {
            bInfoTable = new JTable();
            bInfoTable.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    int row = bInfoTable.getSelectedRow();
                    
                    String bNum       = bInfoTable.getValueAt(row, 0).toString();
                    String bTitle     = bInfoTable.getValueAt(row, 1).toString();
                    String bPublisher = bInfoTable.getValueAt(row, 2).toString();
                    String bGenre     = bInfoTable.getValueAt(row, 3).toString();
                    String bWriter    = bInfoTable.getValueAt(row, 4).toString();
                    String bPrice     = bInfoTable.getValueAt(row, 5).toString();
                    
                    bNumTxt.setText(bNum);
                    bTitleTxt.setText(bTitle);
                    bPubTxt.setText(bPublisher);
                    bGenreTxt.setText(bGenre);
                    bWriTxt.setText(bWriter);
                    bPriceTxt.setText(bPrice);
                }
            });
            bInfoTable.setModel(
                    new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                    "No.", "\uC81C\uBAA9", "\uCD9C\uD310\uC0AC", "\uC7A5\uB974", "\uC800\uC790", "\uAC00\uACA9", "\uB300\uC5EC\uC815\uBCF4", "\uB300\uC5EC\uC790 ID"
                }
            ) {
                Class[] columnTypes = new Class[] {
                    Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Boolean.class, Integer.class
                };
                public Class getColumnClass(int columnIndex) {
                    return columnTypes[columnIndex];
                }
            });
        }
        return bInfoTable;
    }

    private JScrollPane getScrollPane_2() {
        if (scrollPane_2 == null) {
            scrollPane_2 = new JScrollPane();
            scrollPane_2.setBounds(0, 0, 260, 230);
            scrollPane_2.setViewportView(getTree());
        }
        return scrollPane_2;
    }

    private JTree getTree() {
        if (tree == null) {
            tree = new JTree();
            tree.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                }
            });
            tree.setModel(new DefaultTreeModel(
                new DefaultMutableTreeNode("장르") {
                    {
                    }
                }
            ));
        }
        return tree;
    }

    private JPanel getPanel_3() {
        if (panel_3 == null) {
            panel_3 = new JPanel();
            panel_3.setBounds(260, 0, 734, 230);
            panel_3.setLayout(null);
            panel_3.add(getLblNewLabel_1());
            panel_3.add(getLabel());
            panel_3.add(getLabel_1());
            panel_3.add(getLabel_2());
            panel_3.add(getLabel_3());
            panel_3.add(getLabel_4());
            panel_3.add(getLabel_5());
            panel_3.add(getBBorrowButton());
            panel_3.add(getBUpdateButton());
            panel_3.add(getBDeleteButton());
            panel_3.add(getBCancelButton());
            panel_3.add(getBTitleTxt());
            panel_3.add(getBPubTxt());
            panel_3.add(getBWriTxt());
            panel_3.add(getBPriceTxt());
            panel_3.add(getBGenreTxt());
            panel_3.add(getBNumTxt());
            panel_3.add(getComboBox());
            panel_3.add(getTextField_5());
            panel_3.add(getBtnNewButton_2());
        }
        return panel_3;
    }

    private JLabel getLblNewLabel_1() {
        if (lblNewLabel_1 == null) {
            lblNewLabel_1 = new JLabel("책 제목");
            lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
            lblNewLabel_1.setBounds(12, 12, 57, 15);
        }
        return lblNewLabel_1;
    }

    private JLabel getLabel() {
        if (label == null) {
            label = new JLabel("출판사");
            label.setHorizontalAlignment(SwingConstants.CENTER);
            label.setBounds(12, 39, 57, 15);
        }
        return label;
    }

    private JLabel getLabel_1() {
        if (label_1 == null) {
            label_1 = new JLabel("저자");
            label_1.setHorizontalAlignment(SwingConstants.CENTER);
            label_1.setBounds(12, 66, 57, 15);
        }
        return label_1;
    }

    private JLabel getLabel_2() {
        if (label_2 == null) {
            label_2 = new JLabel("가격");
            label_2.setHorizontalAlignment(SwingConstants.CENTER);
            label_2.setBounds(12, 93, 57, 15);
        }
        return label_2;
    }

    private JLabel getLabel_3() {
        if (label_3 == null) {
            label_3 = new JLabel("장르");
            label_3.setHorizontalAlignment(SwingConstants.CENTER);
            label_3.setBounds(12, 120, 57, 15);
        }
        return label_3;
    }

    private JLabel getLabel_4() {
        if (label_4 == null) {
            label_4 = new JLabel("검색");
            label_4.setHorizontalAlignment(SwingConstants.CENTER);
            label_4.setBounds(12, 147, 57, 15);
        }
        return label_4;
    }

    private JLabel getLabel_5() {
        if (label_5 == null) {
            label_5 = new JLabel("책 번호");
            label_5.setHorizontalAlignment(SwingConstants.CENTER);
            label_5.setBounds(255, 12, 57, 15);
        }
        return label_5;
    }

    private JButton getBBorrowButton() {
        if (bBorrowButton == null) {
            bBorrowButton = new JButton("대여하기");
            bBorrowButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    BookBorrow bb = new BookBorrow(frame);
                    bb.setVisible(true);
                }
            });
            bBorrowButton.setBounds(12, 172, 111, 48);
        }
        return bBorrowButton;
    }

    private JButton getBUpdateButton() {
        if (bUpdateButton == null) {
            bUpdateButton = new JButton("수정");
            bUpdateButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    int bIndex = bInfoTable.getSelectedRow();
                    
                    int bnum = Integer.valueOf(bNumTxt.getText());
                    String btitle = bTitleTxt.getText();
                    String bpublisher = bPubTxt.getText();
                    String bgenre = bGenreTxt.getText();
                    String bwriter = bWriTxt.getText();
                    String bprice = bPriceTxt.getText();
                    boolean bstatus = (boolean) bInfoTable.getValueAt(bIndex, 6);
                    int bbcn = (int) bInfoTable.getValueAt(bIndex, 7);
                    
                    bookList.remove(bIndex);
                    
                    Book book = new Book(bnum, btitle, bpublisher, bgenre, bwriter, bprice, bstatus, bbcn);
                    bookList.add(bIndex, book);
                    
                    brefresh(bookList, bInfoTable);
                }
            });
            bUpdateButton.setBounds(135, 172, 111, 48);
        }
        return bUpdateButton;
    }

    private JButton getBDeleteButton() {
        if (bDeleteButton == null) {
            bDeleteButton = new JButton("삭제");
            bDeleteButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    int bIndex = bInfoTable.getSelectedRow();
                    bookList.remove(bIndex);
                    brefresh(bookList, bInfoTable);
                }
            });
            bDeleteButton.setBounds(258, 172, 111, 48);
        }
        return bDeleteButton;
    }

    private JButton getBCancelButton() {
        if (bCancelButton == null) {
            bCancelButton = new JButton("취소");
            bCancelButton.setBounds(381, 172, 111, 48);
        }
        return bCancelButton;
    }

    private JTextField getBTitleTxt() {
        if (bTitleTxt == null) {
            bTitleTxt = new JTextField();
            bTitleTxt.setBounds(81, 9, 116, 21);
            bTitleTxt.setColumns(10);
        }
        return bTitleTxt;
    }

    private JTextField getBPubTxt() {
        if (bPubTxt == null) {
            bPubTxt = new JTextField();
            bPubTxt.setColumns(10);
            bPubTxt.setBounds(81, 36, 116, 21);
        }
        return bPubTxt;
    }

    private JTextField getBWriTxt() {
        if (bWriTxt == null) {
            bWriTxt = new JTextField();
            bWriTxt.setColumns(10);
            bWriTxt.setBounds(81, 63, 116, 21);
        }
        return bWriTxt;
    }

    private JTextField getBPriceTxt() {
        if (bPriceTxt == null) {
            bPriceTxt = new JTextField();
            bPriceTxt.setColumns(10);
            bPriceTxt.setBounds(81, 90, 116, 21);
        }
        return bPriceTxt;
    }

    private JTextField getBGenreTxt() {
        if (bGenreTxt == null) {
            bGenreTxt = new JTextField();
            bGenreTxt.setColumns(10);
            bGenreTxt.setBounds(81, 117, 116, 21);
        }
        return bGenreTxt;
    }

    private JTextField getBNumTxt() {
        if (bNumTxt == null) {
            bNumTxt = new JTextField();
            bNumTxt.setColumns(10);
            bNumTxt.setBounds(324, 9, 35, 21);
        }
        return bNumTxt;
    }

    private JComboBox getComboBox() {
        if (comboBox == null) {
            comboBox = new JComboBox();
            comboBox.setModel(new DefaultComboBoxModel(new String[] {"책 번호", "제목", "출판사", "장르", "저자", "가격", "대여정보"}));
            comboBox.setBounds(81, 144, 71, 21);
        }
        return comboBox;
    }

    private JTextField getTextField_5() {
        if (textField_5 == null) {
            textField_5 = new JTextField();
            textField_5.setBounds(164, 144, 125, 21);
            textField_5.setColumns(10);
        }
        return textField_5;
    }

    private JButton getBtnNewButton_2() {
        if (btnNewButton_2 == null) {
            btnNewButton_2 = new JButton("검색");
            btnNewButton_2.setBounds(293, 143, 76, 23);
        }
        return btnNewButton_2;
    }

    private JScrollPane getScrollPane_3() {
        if (scrollPane_3 == null) {
            scrollPane_3 = new JScrollPane();
            scrollPane_3.setBounds(0, 123, 994, 423);
            scrollPane_3.setViewportView(getTable_2());
        }
        return scrollPane_3;
    }

    private JTable getTable_2() {
        if (table_2 == null) {
            table_2 = new JTable();
            table_2.setModel(new DefaultTableModel(new Object[][] {},
                    new String[] { "No.", "\uC774\uB984", "\uC804\uD654\uBC88\uD638", "\uC8FC\uBBFC\uBC88\uD638",
                            "\uBA54\uC77C\uC8FC\uC18C", "\uCC45 \uC81C\uBAA9", "\uCD9C\uD310\uC0AC", "\uC7A5\uB974",
                            "\uC800\uC790", "\uCC45 \uBC88\uD638", "\uB300\uC5EC \uB0A0\uC9DC" }));
        }
        return table_2;
    }

    private JPanel getPanel_4() {
        if (panel_4 == null) {
            panel_4 = new JPanel();
            panel_4.setBounds(0, 0, 994, 123);
            panel_4.setLayout(null);
            panel_4.add(getBtnNewButton_3());
        }
        return panel_4;
    }

    private JButton getBtnNewButton_3() {
        if (btnNewButton_3 == null) {
            btnNewButton_3 = new JButton("반납완료");
            btnNewButton_3.setBounds(761, 40, 221, 73);
        }
        return btnNewButton_3;
    }

    private JScrollPane getScrollPane_4() {
        if (scrollPane_4 == null) {
            scrollPane_4 = new JScrollPane();
            scrollPane_4.setBounds(0, 211, 701, 335);
            scrollPane_4.setViewportView(getCInfoTable());
        }
        return scrollPane_4;
    }

    private JTable getCInfoTable() {
        if (cInfoTable == null) {
            cInfoTable = new JTable();
            cInfoTable.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    int row = cInfoTable.getSelectedRow();
                    
                    String cNum  = cInfoTable.getValueAt(row, 0).toString();
                    String cName = cInfoTable.getValueAt(row, 1).toString();
                    String cRrn  = cInfoTable.getValueAt(row, 2).toString();
                    String cPnum = cInfoTable.getValueAt(row, 3).toString();
                    String cMail = cInfoTable.getValueAt(row, 4).toString();
                   
                    String[] crArray = cRrn.split("-");
                    String[] cpnArray = cPnum.split("-");
                    String[] cmArray = cMail.split("@");
                    
                    cNumTxt.setText(cNum);
                    cNameTxt.setText(cName);
                    cRrn1.setText(crArray[0]);
                    cRrn2.setText(crArray[1]);
                    cPnum1.setText(cpnArray[0]);
                    cPnum2.setText(cpnArray[1]);
                    cPnum3.setText(cpnArray[2]);
                    cMail1.setText(cmArray[0]);
                    cMail2.setText(cmArray[1]);
                }
            });
            cInfoTable.setModel(
                    new DefaultTableModel(new Object[][] {}, new String[] { "\uD68C\uC6D0\uBC88\uD638", "\uC774\uB984",
                            "\uC8FC\uBBFC\uBC88\uD638", "\uC804\uD654\uBC88\uD638", "\uBA54\uC77C\uC8FC\uC18C" }));
        }
        return cInfoTable;
    }

    private JPanel getPanel_5() {
        if (panel_5 == null) {
            panel_5 = new JPanel();
            panel_5.setBounds(0, 0, 701, 211);
            panel_5.setLayout(null);
            panel_5.add(getLblNewLabel_2());
            panel_5.add(getLabel_6());
            panel_5.add(getLabel_7());
            panel_5.add(getLabel_8());
            panel_5.add(getLabel_9());
            panel_5.add(getCNameTxt());
            panel_5.add(getCRrn1());
            panel_5.add(getCPnum1());
            panel_5.add(getCMail1());
            panel_5.add(getCNumTxt());
            panel_5.add(getCRrn2());
            panel_5.add(getCPnum2());
            panel_5.add(getCMail2());
            panel_5.add(getTextField_16());
            panel_5.add(getCPnum3());
            panel_5.add(getComboBox_1());
            panel_5.add(getBtnNewButton_4());
            panel_5.add(getLblNewLabel_3());
            panel_5.add(getLabel_10());
            panel_5.add(getLabel_11());
            panel_5.add(getCDeleteButton());
            panel_5.add(getCUpdateButton());
            panel_5.add(getCCancelButton());
        }
        return panel_5;
    }

    private JLabel getLblNewLabel_2() {
        if (lblNewLabel_2 == null) {
            lblNewLabel_2 = new JLabel("이름");
            lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
            lblNewLabel_2.setBounds(12, 13, 57, 15);
        }
        return lblNewLabel_2;
    }

    private JLabel getLabel_6() {
        if (label_6 == null) {
            label_6 = new JLabel("주민번호");
            label_6.setHorizontalAlignment(SwingConstants.RIGHT);
            label_6.setBounds(12, 41, 57, 15);
        }
        return label_6;
    }

    private JLabel getLabel_7() {
        if (label_7 == null) {
            label_7 = new JLabel("전화번호");
            label_7.setHorizontalAlignment(SwingConstants.RIGHT);
            label_7.setBounds(12, 69, 57, 15);
        }
        return label_7;
    }

    private JLabel getLabel_8() {
        if (label_8 == null) {
            label_8 = new JLabel("메일주소");
            label_8.setHorizontalAlignment(SwingConstants.RIGHT);
            label_8.setBounds(12, 97, 57, 15);
        }
        return label_8;
    }

    private JLabel getLabel_9() {
        if (label_9 == null) {
            label_9 = new JLabel("검색");
            label_9.setHorizontalAlignment(SwingConstants.RIGHT);
            label_9.setBounds(12, 125, 57, 15);
        }
        return label_9;
    }

    private JTextField getCNameTxt() {
        if (cNameTxt == null) {
            cNameTxt = new JTextField();
            cNameTxt.setBounds(81, 10, 86, 21);
            cNameTxt.setColumns(10);
        }
        return cNameTxt;
    }

    private JTextField getCRrn1() {
        if (cRrn1 == null) {
            cRrn1 = new JTextField();
            cRrn1.setColumns(10);
            cRrn1.setBounds(81, 38, 86, 21);
        }
        return cRrn1;
    }

    private JTextField getCPnum1() {
        if (cPnum1 == null) {
            cPnum1 = new JTextField();
            cPnum1.setColumns(10);
            cPnum1.setBounds(81, 66, 86, 21);
        }
        return cPnum1;
    }

    private JTextField getCMail1() {
        if (cMail1 == null) {
            cMail1 = new JTextField();
            cMail1.setColumns(10);
            cMail1.setBounds(81, 94, 86, 21);
        }
        return cMail1;
    }

    private JTextField getCNumTxt() {
        if (cNumTxt == null) {
            cNumTxt = new JTextField();
            cNumTxt.setColumns(10);
            cNumTxt.setBounds(178, 10, 27, 21);
        }
        return cNumTxt;
    }

    private JTextField getCRrn2() {
        if (cRrn2 == null) {
            cRrn2 = new JTextField();
            cRrn2.setColumns(10);
            cRrn2.setBounds(178, 38, 86, 21);
        }
        return cRrn2;
    }

    private JTextField getCPnum2() {
        if (cPnum2 == null) {
            cPnum2 = new JTextField();
            cPnum2.setColumns(10);
            cPnum2.setBounds(178, 66, 86, 21);
        }
        return cPnum2;
    }

    private JTextField getCMail2() {
        if (cMail2 == null) {
            cMail2 = new JTextField();
            cMail2.setColumns(10);
            cMail2.setBounds(178, 94, 86, 21);
        }
        return cMail2;
    }

    private JTextField getTextField_16() {
        if (textField_16 == null) {
            textField_16 = new JTextField();
            textField_16.setColumns(10);
            textField_16.setBounds(167, 122, 86, 21);
        }
        return textField_16;
    }

    private JTextField getCPnum3() {
        if (cPnum3 == null) {
            cPnum3 = new JTextField();
            cPnum3.setColumns(10);
            cPnum3.setBounds(276, 66, 86, 21);
        }
        return cPnum3;
    }

    private JComboBox getComboBox_1() {
        if (comboBox_1 == null) {
            comboBox_1 = new JComboBox();
            comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"회원번호", "이름", "주민번호", "메일주소"}));
            comboBox_1.setBounds(81, 122, 86, 21);
        }
        return comboBox_1;
    }

    private JButton getBtnNewButton_4() {
        if (btnNewButton_4 == null) {
            btnNewButton_4 = new JButton("검색");
            btnNewButton_4.setBounds(252, 121, 70, 23);
        }
        return btnNewButton_4;
    }

    private JLabel getLblNewLabel_3() {
        if (lblNewLabel_3 == null) {
            lblNewLabel_3 = new JLabel("-");
            lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
            lblNewLabel_3.setBounds(163, 69, 18, 15);
        }
        return lblNewLabel_3;
    }

    private JLabel getLabel_10() {
        if (label_10 == null) {
            label_10 = new JLabel("-");
            label_10.setHorizontalAlignment(SwingConstants.CENTER);
            label_10.setBounds(261, 69, 18, 15);
        }
        return label_10;
    }

    private JLabel getLabel_11() {
        if (label_11 == null) {
            label_11 = new JLabel("@");
            label_11.setHorizontalAlignment(SwingConstants.CENTER);
            label_11.setBounds(163, 97, 18, 15);
        }
        return label_11;
    }

    private JButton getCDeleteButton() {
        if (cDeleteButton == null) {
            cDeleteButton = new JButton("회원삭제");
            cDeleteButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    int cIndex = cInfoTable.getSelectedRow();
                    customerList.remove(cIndex);
                    crefresh(customerList, cInfoTable);
                    }
                }
            );
            cDeleteButton.setBounds(12, 150, 120, 51);
        }
        return cDeleteButton;
    }

    private JButton getCUpdateButton() {
        if (cUpdateButton == null) {
            cUpdateButton = new JButton("회원수정");
            cUpdateButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    int cIndex = cInfoTable.getSelectedRow();
                    
                    int cnum = Integer.valueOf(cNumTxt.getText());
                    String cname = cNameTxt.getText();
                    String crrn = cRrn1.getText()+"-"+cRrn2.getText();
                    String cpnum = cPnum1.getText()+"-"+cPnum2.getText()+"-"+cPnum3.getText();
                    String cemail = cMail1.getText()+"@"+cMail2.getText();

                    customerList.remove(cIndex);
                    
                    Customer element = new Customer(cnum, cname, crrn, cpnum, cemail);
                    customerList.add(cIndex, element);
                    
                    crefresh(customerList, cInfoTable);
                }
            });
            cUpdateButton.setBounds(144, 150, 120, 51);
        }
        return cUpdateButton;
    }

    private JButton getCCancelButton() {
        if (cCancelButton == null) {
            cCancelButton = new JButton("취소");
            cCancelButton.setBounds(276, 150, 120, 51);
        }
        return cCancelButton;
    }
    
    private void commonConstructor() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1280, 720);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.add(getMenuPanel());
        contentPane.add(getStatusPanel());
        contentPane.add(getTabbedPane());
    }
}
