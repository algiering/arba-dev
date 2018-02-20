package java31.st1swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import javax.swing.JRadioButton;

public class frmEmail extends JFrame {
    
    private JPanel contentPane;
    private JLabel label;
    private JLabel lblNewLabel;
    private JLabel lblNewLabel_1;
    private JTextField txtName;
    private JTextField txtJob;
    private JTextField txtId;
    private JPanel panel;
    private JLabel lblName;
    private JPanel panel_1;
    private JLabel lblEmail;
    private JLabel label_2;
    private JTextField txtEmail;
    private JLabel lblMailFormat;
    private JTextArea txtArea;
    private JButton btnAdd;
    private JButton btnEdit;
    private JButton btnRemoe;
    private JButton btnDefault;
    private JRadioButton rdbtnHtml;
    private JRadioButton rdbtnPlainText;
    private JRadioButton rdbtnCustom;
    private JButton btnOK;
    private JButton btnCancel;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frmEmail frame = new frmEmail();
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
    public frmEmail() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 525);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.add(getPanel());
        contentPane.add(getPanel_1());
        contentPane.add(getBtnOK());
        contentPane.add(getBtnCancel());
    }
    private JLabel getLabel() {
        if (label == null) {
        	label = new JLabel("이름");
        	label.setBounds(12, 31, 57, 15);
        }
        return label;
    }
    private JLabel getLblNewLabel() {
        if (lblNewLabel == null) {
        	lblNewLabel = new JLabel("직책");
        	lblNewLabel.setBounds(12, 69, 57, 15);
        }
        return lblNewLabel;
    }
    private JLabel getLblNewLabel_1() {
        if (lblNewLabel_1 == null) {
        	lblNewLabel_1 = new JLabel("아이디");
        	lblNewLabel_1.setBounds(199, 69, 57, 15);
        }
        return lblNewLabel_1;
    }
    private JTextField getTxtName() {
        if (txtName == null) {
        	txtName = new JTextField();
        	txtName.setBounds(55, 28, 116, 21);
        	txtName.setColumns(10);
        }
        return txtName;
    }
    private JTextField getTxtJob() {
        if (txtJob == null) {
        	txtJob = new JTextField();
        	txtJob.setBounds(55, 66, 116, 21);
        	txtJob.setColumns(10);
        }
        return txtJob;
    }
    private JTextField getTxtId() {
        if (txtId == null) {
        	txtId = new JTextField();
        	txtId.setBounds(242, 66, 116, 21);
        	txtId.setColumns(10);
        }
        return txtId;
    }
    private JPanel getPanel() {
        if (panel == null) {
        	panel = new JPanel();
        	panel.setBorder(new LineBorder(new Color(51, 153, 255), 2, true));
        	panel.setBounds(25, 10, 397, 130);
        	panel.setLayout(null);
        	panel.add(getLabel_1_1());
        	panel.add(getLabel());
        	panel.add(getTxtName());
        	panel.add(getLblNewLabel());
        	panel.add(getTxtJob());
        	panel.add(getLblNewLabel_1());
        	panel.add(getTxtId());
        }
        return panel;
    }
    private JLabel getLabel_1_1() {
        if (lblName == null) {
        	lblName = new JLabel("Name");
        	lblName.setBounds(12, 0, 57, 15);
        }
        return lblName;
    }
    private JPanel getPanel_1() {
        if (panel_1 == null) {
        	panel_1 = new JPanel();
        	panel_1.setLayout(null);
        	panel_1.setBorder(new LineBorder(new Color(51, 153, 255), 2, true));
        	panel_1.setBounds(25, 170, 397, 235);
        	panel_1.add(getLblEmail());
        	panel_1.add(getLabel_2());
        	panel_1.add(getTxtEmail());
        	panel_1.add(getLblMailFormat());
        	panel_1.add(getTxtArea());
        	panel_1.add(getBtnAdd());
        	panel_1.add(getBtnEdit());
        	panel_1.add(getBtnRemoe());
        	panel_1.add(getBtnDefault());
        	panel_1.add(getRdbtnHtml());
        	panel_1.add(getRdbtnPlainText());
        	panel_1.add(getRdbtnCustom());
        }
        return panel_1;
    }
    private JLabel getLblEmail() {
        if (lblEmail == null) {
        	lblEmail = new JLabel("E-mail");
        	lblEmail.setBounds(12, 2, 57, 15);
        }
        return lblEmail;
    }
    private JLabel getLabel_2() {
        if (label_2 == null) {
        	label_2 = new JLabel("이메일주소");
        	label_2.setBounds(12, 31, 79, 15);
        }
        return label_2;
    }
    private JTextField getTxtEmail() {
        if (txtEmail == null) {
        	txtEmail = new JTextField();
        	txtEmail.setColumns(10);
        	txtEmail.setBounds(83, 28, 206, 21);
        }
        return txtEmail;
    }
    private JLabel getLblMailFormat() {
        if (lblMailFormat == null) {
        	lblMailFormat = new JLabel("Mail Format");
        	lblMailFormat.setBounds(12, 177, 98, 15);
        }
        return lblMailFormat;
    }
    private JTextArea getTxtArea() {
        if (txtArea == null) {
        	txtArea = new JTextArea();
        	txtArea.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        	txtArea.setLineWrap(true);
        	txtArea.setBounds(12, 56, 277, 111);
        }
        return txtArea;
    }
    private JButton getBtnAdd() {
        if (btnAdd == null) {
        	btnAdd = new JButton("Add");
        	btnAdd.setBounds(301, 21, 84, 35);
        }
        return btnAdd;
    }
    private JButton getBtnEdit() {
        if (btnEdit == null) {
        	btnEdit = new JButton("Edit");
        	btnEdit.setBounds(301, 76, 84, 23);
        }
        return btnEdit;
    }
    private JButton getBtnRemoe() {
        if (btnRemoe == null) {
        	btnRemoe = new JButton("Remove");
        	btnRemoe.setBounds(301, 109, 84, 23);
        }
        return btnRemoe;
    }
    private JButton getBtnDefault() {
        if (btnDefault == null) {
        	btnDefault = new JButton("Default");
        	btnDefault.setBounds(301, 142, 84, 23);
        }
        return btnDefault;
    }
    private JRadioButton getRdbtnHtml() {
        if (rdbtnHtml == null) {
        	rdbtnHtml = new JRadioButton("HTML");
        	rdbtnHtml.setSelected(true);
        	rdbtnHtml.setBounds(12, 198, 79, 23);
        }
        return rdbtnHtml;
    }
    private JRadioButton getRdbtnPlainText() {
        if (rdbtnPlainText == null) {
        	rdbtnPlainText = new JRadioButton("Plain Text");
        	rdbtnPlainText.setBounds(88, 198, 84, 23);
        }
        return rdbtnPlainText;
    }
    private JRadioButton getRdbtnCustom() {
        if (rdbtnCustom == null) {
        	rdbtnCustom = new JRadioButton("Custom");
        	rdbtnCustom.setBounds(184, 198, 121, 23);
        }
        return rdbtnCustom;
    }
    private JButton getBtnOK() {
        if (btnOK == null) {
        	btnOK = new JButton("OK");
        	btnOK.setBounds(247, 415, 76, 47);
        }
        return btnOK;
    }
    private JButton getBtnCancel() {
        if (btnCancel == null) {
        	btnCancel = new JButton("Cancel");
        	btnCancel.setBounds(335, 415, 76, 47);
        }
        return btnCancel;
    }
}
