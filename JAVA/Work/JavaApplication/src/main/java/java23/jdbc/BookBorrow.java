package java23.jdbc;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java23.jdbcswing.ServiceBookSwing;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BookBorrow extends JFrame {

    private JPanel contentPane;
    private JLabel lblNewLabel;
    private JLabel label;
    private JLabel label_1;
    private JLabel label_2;
    private JTextField bbTitleTxt;
    private JTextField bbPublisherTxt;
    private JTextField bbWriterTxt;
    private JTextField bbAuthIDTxt;
    private JButton borrowButton;
    private JButton button;
    private JButton btnNewButton_1;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    BookBorrow frame = new BookBorrow();
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
    public BookBorrow() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                borrowButton.setEnabled(false);
            }
        });
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 212);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.add(getLblNewLabel());
        contentPane.add(getLabel());
        contentPane.add(getLabel_1());
        contentPane.add(getLabel_2());
        contentPane.add(getBbTitleTxt());
        contentPane.add(getBbPublisherTxt());
        contentPane.add(getBbWriterTxt());
        contentPane.add(getBbAuthIDTxt());
        contentPane.add(getBorrowButton());
        contentPane.add(getButton());
        contentPane.add(getBtnNewButton_1());
    }
    
    public BookBorrow(ServiceBookSwing frame, ModelBook book) {
        commonConstructor();
        
        bbTitleTxt.setText(book.getBookname());
        bbPublisherTxt.setText(book.getPublisher());
        bbWriterTxt.setText(book.getWriter());
        
        borrowButton.setEnabled(false);
    }
    
    public void commonConstructor() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 248);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.add(getLblNewLabel());
        contentPane.add(getLabel());
        contentPane.add(getLabel_1());
        contentPane.add(getLabel_2());
        contentPane.add(getBbTitleTxt());
        contentPane.add(getBbPublisherTxt());
        contentPane.add(getBbWriterTxt());
        contentPane.add(getBbAuthIDTxt());
        contentPane.add(getBorrowButton());
        contentPane.add(getButton());
        contentPane.add(getBtnNewButton_1());
    }

    private JLabel getLblNewLabel() {
        if (lblNewLabel == null) {
        	lblNewLabel = new JLabel("책 제목");
        	lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        	lblNewLabel.setBounds(48, 22, 57, 15);
        }
        return lblNewLabel;
    }
    private JLabel getLabel() {
        if (label == null) {
        	label = new JLabel("출판사");
        	label.setHorizontalAlignment(SwingConstants.RIGHT);
        	label.setBounds(48, 59, 57, 15);
        }
        return label;
    }
    private JLabel getLabel_1() {
        if (label_1 == null) {
        	label_1 = new JLabel("저자");
        	label_1.setHorizontalAlignment(SwingConstants.RIGHT);
        	label_1.setBounds(48, 96, 57, 15);
        }
        return label_1;
    }
    private JLabel getLabel_2() {
        if (label_2 == null) {
        	label_2 = new JLabel("회원 번호 검색");
        	label_2.setHorizontalAlignment(SwingConstants.RIGHT);
        	label_2.setBounds(12, 133, 93, 15);
        }
        return label_2;
    }
    private JTextField getBbTitleTxt() {
        if (bbTitleTxt == null) {
        	bbTitleTxt = new JTextField();
        	bbTitleTxt.setBounds(117, 19, 175, 21);
        	bbTitleTxt.setColumns(10);
        }
        return bbTitleTxt;
    }
    private JTextField getBbPublisherTxt() {
        if (bbPublisherTxt == null) {
        	bbPublisherTxt = new JTextField();
        	bbPublisherTxt.setColumns(10);
        	bbPublisherTxt.setBounds(117, 56, 175, 21);
        }
        return bbPublisherTxt;
    }
    private JTextField getBbWriterTxt() {
        if (bbWriterTxt == null) {
        	bbWriterTxt = new JTextField();
        	bbWriterTxt.setColumns(10);
        	bbWriterTxt.setBounds(117, 93, 175, 21);
        }
        return bbWriterTxt;
    }
    private JTextField getBbAuthIDTxt() {
        if (bbAuthIDTxt == null) {
        	bbAuthIDTxt = new JTextField();
        	bbAuthIDTxt.setColumns(10);
        	bbAuthIDTxt.setBounds(117, 130, 93, 21);
        }
        return bbAuthIDTxt;
    }
    private JButton getBorrowButton() {
        if (borrowButton == null) {
        	borrowButton = new JButton("대여");
        	borrowButton.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	        
        	        Integer authid = Integer.valueOf(bbAuthIDTxt.getText().toString());
        	        String bookname = bbTitleTxt.getText();
        	        String publisher = bbPublisherTxt.getText();
        	        
        	        ServiceBookSwing.BorrowBook(authid, bookname, publisher);
        	        dispose();
        	    }
        	});
        	borrowButton.setBounds(312, 22, 97, 43);
        }
        return borrowButton;
    }
    private JButton getButton() {
        if (button == null) {
        	button = new JButton("취소");
        	button.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	        dispose();
        	    }
        	});
        	button.setBounds(312, 75, 97, 43);
        }
        return button;
    }
    private JButton getBtnNewButton_1() {
        if (btnNewButton_1 == null) {
        	btnNewButton_1 = new JButton("검색");
        	btnNewButton_1.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	        ModelAuth auth = new ModelAuth();
        	        auth.setAuthid(Integer.valueOf(bbAuthIDTxt.getText()));
        	        try {
                        ResultSet rs = new ServiceAuth().selectAuthid(auth);
                        rs.next();
                        JOptionPane.showMessageDialog(null, "회원번호 : " + rs.getString(1) + "\n회원명 : " + rs.getString(2), "회원 확인", JOptionPane.PLAIN_MESSAGE);        
                        borrowButton.setEnabled(true);
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                        JOptionPane.showMessageDialog(null, "해당 번호의 회원이 없습니다");
                        bbAuthIDTxt.setText("");
                        borrowButton.setEnabled(false);
                    }
        	        
        	    }
        	});
        	btnNewButton_1.setBounds(211, 129, 81, 23);
        }
        return btnNewButton_1;
    }
}
