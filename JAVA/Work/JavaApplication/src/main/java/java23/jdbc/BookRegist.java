package java23.jdbc;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java23.jdbcswing.ServiceBookSwing;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BookRegist extends JFrame {

    private JPanel contentPane;
    private JLabel lblNewLabel;
    private JLabel lblNewLabel_1;
    private JLabel label;
    private JLabel label_1;
    private JLabel label_2;
    private JLabel label_3;
    private JButton btnNewButton;
    private JButton button;
    private JTextField titleTxt;
    private JTextField publisherTxt;
    private JTextField writerTxt;
    private JTextField priceTxt;
    private JTextField genreTxt;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    BookRegist frame = new BookRegist();
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
    public BookRegist() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 315, 350);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.add(getLblNewLabel());
        contentPane.add(getLblNewLabel_1());
        contentPane.add(getLabel());
        contentPane.add(getLabel_1());
        contentPane.add(getLabel_2());
        contentPane.add(getLabel_3());
        contentPane.add(getBtnNewButton());
        contentPane.add(getButton());
        contentPane.add(getTitleTxt());
        contentPane.add(getPublisherTxt());
        contentPane.add(getWriterTxt());
        contentPane.add(getPriceTxt());
        contentPane.add(getGenreTxt());
    }
    public BookRegist(ServiceBookSwing frame) {
        commonConstructor();
    }
    
    public void commonConstructor() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 314, 350);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.add(getLblNewLabel());
        contentPane.add(getLblNewLabel_1());
        contentPane.add(getLabel());
        contentPane.add(getLabel_1());
        contentPane.add(getLabel_2());
        contentPane.add(getLabel_3());
        contentPane.add(getBtnNewButton());
        contentPane.add(getButton());
        contentPane.add(getTitleTxt());
        contentPane.add(getPublisherTxt());
        contentPane.add(getWriterTxt());
        contentPane.add(getPriceTxt());
    }
    private JLabel getLblNewLabel() {
        if (lblNewLabel == null) {
        	lblNewLabel = new JLabel("책 정보 입력");
        	lblNewLabel.setFont(new Font("굴림", Font.BOLD, 15));
        	lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        	lblNewLabel.setBounds(12, 10, 100, 34);
        }
        return lblNewLabel;
    }
    private JLabel getLblNewLabel_1() {
        if (lblNewLabel_1 == null) {
        	lblNewLabel_1 = new JLabel("책 제목");
        	lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
        	lblNewLabel_1.setBounds(12, 57, 57, 15);
        }
        return lblNewLabel_1;
    }
    private JLabel getLabel() {
        if (label == null) {
        	label = new JLabel("출판사");
        	label.setHorizontalAlignment(SwingConstants.RIGHT);
        	label.setBounds(12, 93, 57, 15);
        }
        return label;
    }
    private JLabel getLabel_1() {
        if (label_1 == null) {
        	label_1 = new JLabel("저자");
        	label_1.setHorizontalAlignment(SwingConstants.RIGHT);
        	label_1.setBounds(12, 129, 57, 15);
        }
        return label_1;
    }
    private JLabel getLabel_2() {
        if (label_2 == null) {
        	label_2 = new JLabel("가격");
        	label_2.setHorizontalAlignment(SwingConstants.RIGHT);
        	label_2.setBounds(12, 165, 57, 15);
        }
        return label_2;
    }
    private JLabel getLabel_3() {
        if (label_3 == null) {
        	label_3 = new JLabel("장르");
        	label_3.setHorizontalAlignment(SwingConstants.RIGHT);
        	label_3.setBounds(12, 198, 57, 15);
        }
        return label_3;
    }
    private JButton getBtnNewButton() {
        if (btnNewButton == null) {
        	btnNewButton = new JButton("등록");
        	btnNewButton.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	        String title = titleTxt.getText();
        	        String publisher = publisherTxt.getText();
        	        String writer = writerTxt.getText();
        	        String price = priceTxt.getText();
        	        String genre = genreTxt.getText();
        	        
        	        ServiceBookSwing.BookReg(title, publisher, writer, price, genre);
        	        dispose();
        	    }
        	});
        	btnNewButton.setBounds(41, 237, 97, 52);
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
        	button.setBounds(160, 237, 97, 52);
        }
        return button;
    }
    private JTextField getTitleTxt() {
        if (titleTxt == null) {
        	titleTxt = new JTextField();
        	titleTxt.setBounds(77, 54, 116, 21);
        	titleTxt.setColumns(10);
        }
        return titleTxt;
    }
    private JTextField getPublisherTxt() {
        if (publisherTxt == null) {
        	publisherTxt = new JTextField();
        	publisherTxt.setColumns(10);
        	publisherTxt.setBounds(77, 90, 116, 21);
        }
        return publisherTxt;
    }
    private JTextField getWriterTxt() {
        if (writerTxt == null) {
        	writerTxt = new JTextField();
        	writerTxt.setColumns(10);
        	writerTxt.setBounds(77, 126, 116, 21);
        }
        return writerTxt;
    }
    private JTextField getPriceTxt() {
        if (priceTxt == null) {
        	priceTxt = new JTextField();
        	priceTxt.setColumns(10);
        	priceTxt.setBounds(77, 162, 67, 21);
        }
        return priceTxt;
    }
    private JTextField getGenreTxt() {
        if (genreTxt == null) {
        	genreTxt = new JTextField();
        	genreTxt.setColumns(10);
        	genreTxt.setBounds(77, 195, 116, 21);
        }
        return genreTxt;
    }
}
