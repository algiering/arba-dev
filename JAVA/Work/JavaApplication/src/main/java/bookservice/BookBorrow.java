package bookservice;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BookBorrow extends JFrame {

    private JPanel contentPane;
    private JLabel lblNewLabel;
    private JLabel label;
    private JLabel label_1;
    private JLabel label_2;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JButton btnNewButton;
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
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 248);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.add(getLblNewLabel());
        contentPane.add(getLabel());
        contentPane.add(getLabel_1());
        contentPane.add(getLabel_2());
        contentPane.add(getTextField());
        contentPane.add(getTextField_1());
        contentPane.add(getTextField_2());
        contentPane.add(getTextField_3());
        contentPane.add(getBtnNewButton());
        contentPane.add(getButton());
        contentPane.add(getBtnNewButton_1());
    }
    
    public BookBorrow(BookService frame) {
        commonConstructor();
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
        contentPane.add(getTextField());
        contentPane.add(getTextField_1());
        contentPane.add(getTextField_2());
        contentPane.add(getTextField_3());
        contentPane.add(getBtnNewButton());
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
    private JTextField getTextField() {
        if (textField == null) {
        	textField = new JTextField();
        	textField.setBounds(117, 19, 175, 21);
        	textField.setColumns(10);
        }
        return textField;
    }
    private JTextField getTextField_1() {
        if (textField_1 == null) {
        	textField_1 = new JTextField();
        	textField_1.setColumns(10);
        	textField_1.setBounds(117, 56, 175, 21);
        }
        return textField_1;
    }
    private JTextField getTextField_2() {
        if (textField_2 == null) {
        	textField_2 = new JTextField();
        	textField_2.setColumns(10);
        	textField_2.setBounds(117, 93, 175, 21);
        }
        return textField_2;
    }
    private JTextField getTextField_3() {
        if (textField_3 == null) {
        	textField_3 = new JTextField();
        	textField_3.setColumns(10);
        	textField_3.setBounds(117, 130, 93, 21);
        }
        return textField_3;
    }
    private JButton getBtnNewButton() {
        if (btnNewButton == null) {
        	btnNewButton = new JButton("대여");
        	btnNewButton.setBounds(312, 22, 97, 43);
        }
        return btnNewButton;
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
        	btnNewButton_1.setBounds(211, 129, 81, 23);
        }
        return btnNewButton_1;
    }
}
