package java31.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FrmButton extends JFrame {

    private JPanel contentPane;
    private JButton btnNewButton;
    private JButton button;
    private JButton button_1;
    private JTextField textField;
    private JButton btnNewButton_1;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FrmButton frame = new FrmButton();
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
    public FrmButton() {
        
        setTitle("테스트 프레임");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 355, 251);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.add(getBtnNewButton());
        contentPane.add(getButton());
        contentPane.add(getButton_1());
        contentPane.add(getTextField());
        contentPane.add(getBtnNewButton_1());
    }

    private JButton getBtnNewButton() {
        if (btnNewButton == null) {
            btnNewButton = new JButton("왼쪽 버튼");
            btnNewButton.setBounds(12, 21, 97, 55);
        }
        return btnNewButton;
    }

    private JButton getButton() {
        if (button == null) {
            button = new JButton("가운데 버튼");
            button.setToolTipText("");
            button.setBounds(121, 21, 97, 55);
        }
        return button;
    }

    private JButton getButton_1() {
        if (button_1 == null) {
            button_1 = new JButton("오른쪽 버튼");
            button_1.setEnabled(false);
            button_1.setBounds(230, 21, 97, 55);
        }
        return button_1;
    }

    private JTextField getTextField() {
        if (textField == null) {
            textField = new JTextField();
            textField.setBounds(12, 86, 315, 21);
            textField.setColumns(10);
        }
        return textField;
    }

    private JButton getBtnNewButton_1() {
        if (btnNewButton_1 == null) {
            btnNewButton_1 = new JButton("창 닫기");
            btnNewButton_1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });
            btnNewButton_1.setBounds(12, 120, 315, 80);
        }
        return btnNewButton_1;
    }
}
