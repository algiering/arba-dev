package java32;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmB extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JButton btnNewButton;

    private frmA parent = null;

    
    public frmA getParent() {
        return parent;
    }

    public void setParent(frmA parent) {
        this.parent = parent;
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frmB frame = new frmB();
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
    public frmB() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.add(getTextField());
        contentPane.add(getBtnNewButton());
    }

    public frmB(String val) {
        textField.setText(val);
        commonConstructor();
        
    }

    public void setText(String value) {
        textField.setText(value);
    }

    private JTextField getTextField() {
        if (textField == null) {
            textField = new JTextField();
            textField.setBounds(12, 10, 116, 21);
            textField.setColumns(10);
        }
        return textField;
    }

    private JButton getBtnNewButton() {
        if (btnNewButton == null) {
            btnNewButton = new JButton("New button");
            btnNewButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    parent.refresh(textField.getText());
                }
            });
            btnNewButton.setBounds(12, 41, 97, 23);
        }
        return btnNewButton;
    }

    public frmB(frmA parent, String val) {
        
        textField.setText(val);
        commonConstructor();
        this.parent = parent;
    }

    private void commonConstructor() {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.add(getTextField());
        contentPane.add(getBtnNewButton());
    }

}
