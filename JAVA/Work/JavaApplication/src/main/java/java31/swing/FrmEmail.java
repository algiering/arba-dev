package java31.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextArea;

public class FrmEmail extends JFrame {

    private JPanel contentPane;
    private JButton btnCancel;
    private JButton btnOk;
    private JPanel panel;
    private JPanel panel_1;
    private JTextArea eTextArea;
    private JLabel label;
    private JLabel label_1;
    private JLabel label_2;
    private JTextField nText;
    private JTextField jobText;
    private JLabel label_3;
    private JTextField idText;
    private JLabel label_4;
    private JLabel label_5;
    private JTextField eText;
    private JButton button;
    private JButton button_1;
    private JButton button_2;
    private JButton button_3;
    private JLabel label_6;
    private JRadioButton radioButton;
    private JRadioButton radioButton_1;
    private JRadioButton radioButton_2;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FrmEmail frame = new FrmEmail();
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
    public FrmEmail() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 496, 514);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.add(getBtnCancel());
        contentPane.add(getBtnOk());
        contentPane.add(getPanel());
        contentPane.add(getPanel_1());
    }

    private JButton getBtnCancel() {
        if (btnCancel == null) {
            btnCancel = new JButton("Cancel");
            btnCancel.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });
            btnCancel.setBounds(350, 402, 97, 47);
        }
        return btnCancel;
    }

    private JButton getBtnOk() {
        if (btnOk == null) {
            btnOk = new JButton("OK");
            btnOk.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String message = "";
                    message += eTextArea.getText() + "\r\n";
                    message += nText.getText() + "\r\n";
                    message += jobText.getText() + "\r\n";
                    message += idText.getText() + "\r\n";
                    JOptionPane.showMessageDialog(null, message);
                }
            });
            btnOk.setBounds(228, 402, 97, 47);
        }
        return btnOk;
    }

    private JPanel getPanel() {
        if (panel == null) {
            panel = new JPanel();
            panel.setBorder(new LineBorder(new Color(0, 0, 255), 3, true));
            panel.setBounds(12, 27, 456, 115);
            panel.setLayout(null);
            panel.add(getLabel());
            panel.add(getLabel_1());
            panel.add(getLabel_2());
            panel.add(getNText());
            panel.add(getJobText());
            panel.add(getLabel_3());
            panel.add(getIdText());
        }
        return panel;
    }

    private JPanel getPanel_1() {
        if (panel_1 == null) {
            panel_1 = new JPanel();
            panel_1.setBorder(new LineBorder(new Color(0, 0, 255), 3, true));
            panel_1.setBounds(12, 172, 456, 223);
            panel_1.setLayout(null);
            panel_1.add(getETextArea());
            panel_1.add(getLabel_4());
            panel_1.add(getLabel_5());
            panel_1.add(getEText());
            panel_1.add(getButton());
            panel_1.add(getButton_1());
            panel_1.add(getButton_2());
            panel_1.add(getButton_3());
            panel_1.add(getLabel_6());
            panel_1.add(getRadioButton());
            panel_1.add(getRadioButton_1());
            panel_1.add(getRadioButton_2());
        }
        return panel_1;
    }

    private JTextArea getETextArea() {
        if (eTextArea == null) {
            eTextArea = new JTextArea();
            eTextArea.setBounds(26, 66, 275, 96);
        }
        return eTextArea;
    }

    private JLabel getLabel() {
        if (label == null) {
            label = new JLabel("Name");
            label.setFont(new Font("굴림", Font.BOLD, 12));
            label.setBounds(12, 10, 57, 15);
        }
        return label;
    }

    private JLabel getLabel_1() {
        if (label_1 == null) {
            label_1 = new JLabel("이름");
            label_1.setFont(new Font("굴림", Font.BOLD, 12));
            label_1.setBounds(12, 44, 57, 15);
        }
        return label_1;
    }

    private JLabel getLabel_2() {
        if (label_2 == null) {
            label_2 = new JLabel("직책");
            label_2.setFont(new Font("굴림", Font.BOLD, 12));
            label_2.setBounds(12, 72, 57, 15);
        }
        return label_2;
    }

    private JTextField getNText() {
        if (nText == null) {
            nText = new JTextField();
            nText.setColumns(10);
            nText.setBounds(74, 44, 116, 21);
        }
        return nText;
    }

    private JTextField getJobText() {
        if (jobText == null) {
            jobText = new JTextField();
            jobText.setColumns(10);
            jobText.setBounds(75, 72, 116, 21);
        }
        return jobText;
    }

    private JLabel getLabel_3() {
        if (label_3 == null) {
            label_3 = new JLabel("아이디");
            label_3.setFont(new Font("굴림", Font.BOLD, 12));
            label_3.setBounds(235, 72, 57, 15);
        }
        return label_3;
    }

    private JTextField getIdText() {
        if (idText == null) {
            idText = new JTextField();
            idText.setColumns(10);
            idText.setBounds(295, 72, 116, 21);
        }
        return idText;
    }

    private JLabel getLabel_4() {
        if (label_4 == null) {
            label_4 = new JLabel("E-mail");
            label_4.setFont(new Font("굴림", Font.BOLD, 12));
            label_4.setBounds(12, 10, 57, 15);
        }
        return label_4;
    }

    private JLabel getLabel_5() {
        if (label_5 == null) {
            label_5 = new JLabel("이메일");
            label_5.setFont(new Font("굴림", Font.BOLD, 12));
            label_5.setBounds(12, 38, 57, 18);
        }
        return label_5;
    }

    private JTextField getEText() {
        if (eText == null) {
            eText = new JTextField();
            eText.setColumns(10);
            eText.setBounds(79, 36, 203, 21);
        }
        return eText;
    }

    private JButton getButton() {
        if (button == null) {
            button = new JButton("Add");
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String email = eText.getText();
                    String emailArea = eTextArea.getText();
                    String val = emailArea + "\r\n" + email;
                    eTextArea.setText(val);
                }
            });
            button.setBounds(332, 30, 97, 47);
        }
        return button;
    }

    private JButton getButton_1() {
        if (button_1 == null) {
            button_1 = new JButton("Edit");
            button_1.setBounds(332, 84, 97, 23);
        }
        return button_1;
    }

    private JButton getButton_2() {
        if (button_2 == null) {
            button_2 = new JButton("remove");
            button_2.setBounds(332, 111, 97, 23);
        }
        return button_2;
    }

    private JButton getButton_3() {
        if (button_3 == null) {
            button_3 = new JButton("Default");
            button_3.setBounds(332, 139, 97, 23);
        }
        return button_3;
    }

    private JLabel getLabel_6() {
        if (label_6 == null) {
            label_6 = new JLabel("Mail Format");
            label_6.setFont(new Font("굴림", Font.BOLD, 12));
            label_6.setBounds(12, 172, 97, 15);
        }
        return label_6;
    }

    private JRadioButton getRadioButton() {
        if (radioButton == null) {
            radioButton = new JRadioButton("HTML");
            radioButton.setBounds(8, 190, 73, 23);
        }
        return radioButton;
    }

    private JRadioButton getRadioButton_1() {
        if (radioButton_1 == null) {
            radioButton_1 = new JRadioButton("Plain Text");
            radioButton_1.setBounds(97, 190, 90, 23);
        }
        return radioButton_1;
    }

    private JRadioButton getRadioButton_2() {
        if (radioButton_2 == null) {
            radioButton_2 = new JRadioButton("Custom");
            radioButton_2.setBounds(203, 190, 84, 23);
        }
        return radioButton_2;
    }
}
