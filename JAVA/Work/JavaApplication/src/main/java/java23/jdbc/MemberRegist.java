package java23.jdbc;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java23.jdbcswing.ServiceBookSwing;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MemberRegist extends JFrame {

    private JPanel contentPane;
    private JLabel lblNewLabel;
    private JLabel label;
    private JLabel label_1;
    private JLabel label_2;
    private JLabel label_3;
    private JButton btnNewButton;
    private JButton button_1;
    private JTextField cnameTxt;
    private JTextField crrnTxt1;
    private JTextField crrnTxt2;
    private JTextField cpnumTxt2;
    private JTextField cpnumTxt3;
    private JTextField cmail1Txt;
    private JComboBox cmail2Txt;
    private JLabel lblNewLabel_1;
    private JLabel label_4;
    private JLabel label_5;
    private JLabel label_6;
    private JComboBox cpnumTxt1;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MemberRegist frame = new MemberRegist();
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
    public MemberRegist() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 397, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.add(getLblNewLabel());
        contentPane.add(getLabel());
        contentPane.add(getLabel_1());
        contentPane.add(getLabel_2());
        contentPane.add(getLabel_3());
        contentPane.add(getBtnNewButton());
        contentPane.add(getButton_1());
        contentPane.add(getCnameTxt());
        contentPane.add(getCrrnTxt1());
        contentPane.add(getCrrnTxt2());
        contentPane.add(getCpnumTxt2());
        contentPane.add(getCpnumTxt3());
        contentPane.add(getCmail1Txt());
        contentPane.add(getCmail2Txt());
        contentPane.add(getLblNewLabel_1());
        contentPane.add(getLabel_4());
        contentPane.add(getLabel_5());
        contentPane.add(getLabel_6());
        contentPane.add(getCpnumTxt1());
    }
    
    public MemberRegist(BookService frame) {
        commonConstructor();
    }
    
    public void commonConstructor() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 397, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.add(getLblNewLabel());
        contentPane.add(getLabel());
        contentPane.add(getLabel_1());
        contentPane.add(getLabel_2());
        contentPane.add(getLabel_3());
        contentPane.add(getBtnNewButton());
        contentPane.add(getButton_1());
        contentPane.add(getCnameTxt());
        contentPane.add(getCrrnTxt1());
        contentPane.add(getCrrnTxt2());
        contentPane.add(getCpnumTxt2());
        contentPane.add(getCpnumTxt3());
        contentPane.add(getCmail1Txt());
        contentPane.add(getCmail2Txt());
        contentPane.add(getLblNewLabel_1());
        contentPane.add(getLabel_4());
        contentPane.add(getLabel_5());
        contentPane.add(getLabel_6());
        contentPane.add(getCpnumTxt1());
    }

    private JLabel getLblNewLabel() {
        if (lblNewLabel == null) {
        	lblNewLabel = new JLabel("회원 정보 입력");
        	lblNewLabel.setFont(new Font("굴림", Font.BOLD, 15));
        	lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        	lblNewLabel.setBounds(12, 10, 118, 33);
        }
        return lblNewLabel;
    }
    private JLabel getLabel() {
        if (label == null) {
        	label = new JLabel("이름");
        	label.setHorizontalAlignment(SwingConstants.RIGHT);
        	label.setBounds(12, 53, 57, 15);
        }
        return label;
    }
    private JLabel getLabel_1() {
        if (label_1 == null) {
        	label_1 = new JLabel("주민번호");
        	label_1.setHorizontalAlignment(SwingConstants.RIGHT);
        	label_1.setBounds(12, 87, 57, 15);
        }
        return label_1;
    }
    private JLabel getLabel_2() {
        if (label_2 == null) {
        	label_2 = new JLabel("전화번호");
        	label_2.setHorizontalAlignment(SwingConstants.RIGHT);
        	label_2.setBounds(12, 121, 57, 15);
        }
        return label_2;
    }
    private JLabel getLabel_3() {
        if (label_3 == null) {
        	label_3 = new JLabel("메일계정");
        	label_3.setHorizontalAlignment(SwingConstants.RIGHT);
        	label_3.setBounds(12, 155, 57, 15);
        }
        return label_3;
    }
    private JButton getBtnNewButton() {
        if (btnNewButton == null) {
        	btnNewButton = new JButton("가입");
        	btnNewButton.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	        String cname = cnameTxt.getText();
        	        String crrn1 = crrnTxt1.getText();
        	        String crrn2 = crrnTxt2.getText();
        	        String cpn1 = cpnumTxt1.getSelectedItem().toString();
        	        String cpn2 = cpnumTxt2.getText();
        	        String cpn3 = cpnumTxt3.getText();
        	        String cmail1 = cmail1Txt.getText();
        	        String cmail2 = cmail2Txt.getSelectedItem().toString();
        	        
        	        String crrn = crrn1 + "-" + crrn2;
        	        String cpn = cpn1 + "-" + cpn2 + "-" + cpn3;
        	        String cmail = cmail1 + "@" + cmail2;
                    
        	        ServiceBookSwing.AuthReg(cname, crrn, cpn, cmail);
        	        dispose();
        	    }
        	});
        	btnNewButton.setBounds(81, 201, 97, 51);
        }
        return btnNewButton;
    }
    private JButton getButton_1() {
        if (button_1 == null) {
        	button_1 = new JButton("취소");
        	button_1.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	        dispose();
        	    }
        	});
        	button_1.setBounds(193, 201, 97, 51);
        }
        return button_1;
    }
    private JTextField getCnameTxt() {
        if (cnameTxt == null) {
        	cnameTxt = new JTextField();
        	cnameTxt.setBounds(81, 50, 97, 21);
        	cnameTxt.setColumns(10);
        }
        return cnameTxt;
    }
    private JTextField getCrrnTxt1() {
        if (crrnTxt1 == null) {
        	crrnTxt1 = new JTextField();
        	crrnTxt1.setBounds(81, 84, 97, 21);
        	crrnTxt1.setColumns(10);
        }
        return crrnTxt1;
    }
    private JTextField getCrrnTxt2() {
        if (crrnTxt2 == null) {
        	crrnTxt2 = new JTextField();
        	crrnTxt2.setBounds(204, 84, 116, 21);
        	crrnTxt2.setColumns(10);
        }
        return crrnTxt2;
    }
    private JTextField getCpnumTxt2() {
        if (cpnumTxt2 == null) {
        	cpnumTxt2 = new JTextField();
        	cpnumTxt2.setBounds(158, 118, 73, 21);
        	cpnumTxt2.setColumns(10);
        }
        return cpnumTxt2;
    }
    private JTextField getCpnumTxt3() {
        if (cpnumTxt3 == null) {
        	cpnumTxt3 = new JTextField();
        	cpnumTxt3.setBounds(249, 118, 73, 21);
        	cpnumTxt3.setColumns(10);
        }
        return cpnumTxt3;
    }
    private JTextField getCmail1Txt() {
        if (cmail1Txt == null) {
        	cmail1Txt = new JTextField();
        	cmail1Txt.setBounds(81, 152, 116, 21);
        	cmail1Txt.setColumns(10);
        }
        return cmail1Txt;
    }
    private JComboBox getCmail2Txt() {
        if (cmail2Txt == null) {
        	cmail2Txt = new JComboBox();
        	cmail2Txt.setModel(new DefaultComboBoxModel(new String[] {"naver.com", "hanmail.net", "hotmail.com"}));
        	cmail2Txt.setBounds(217, 152, 128, 21);
        }
        return cmail2Txt;
    }
    private JLabel getLblNewLabel_1() {
        if (lblNewLabel_1 == null) {
        	lblNewLabel_1 = new JLabel("-");
        	lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        	lblNewLabel_1.setBounds(176, 87, 30, 15);
        }
        return lblNewLabel_1;
    }
    private JLabel getLabel_4() {
        if (label_4 == null) {
        	label_4 = new JLabel("-");
        	label_4.setHorizontalAlignment(SwingConstants.CENTER);
        	label_4.setBounds(132, 121, 30, 15);
        }
        return label_4;
    }
    private JLabel getLabel_5() {
        if (label_5 == null) {
        	label_5 = new JLabel("-");
        	label_5.setHorizontalAlignment(SwingConstants.CENTER);
        	label_5.setBounds(225, 121, 30, 15);
        }
        return label_5;
    }
    private JLabel getLabel_6() {
        if (label_6 == null) {
        	label_6 = new JLabel("@");
        	label_6.setHorizontalAlignment(SwingConstants.CENTER);
        	label_6.setBounds(191, 155, 30, 15);
        }
        return label_6;
    }
    private JComboBox getCpnumTxt1() {
        if (cpnumTxt1 == null) {
        	cpnumTxt1 = new JComboBox();
        	cpnumTxt1.setModel(new DefaultComboBoxModel(new String[] {"010", "011", "016", "019"}));
        	cpnumTxt1.setBounds(81, 118, 57, 21);
        }
        return cpnumTxt1;
    }
}
