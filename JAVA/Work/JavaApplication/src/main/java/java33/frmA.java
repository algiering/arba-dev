package java33;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmA extends JFrame {

    private JPanel contentPane;
    private static frmA frame = null;
    private JButton btnNewButton;
    private JTextField textField;
    private JButton btnNewButton_1;
    private JButton btnNewButton_2;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame = new frmA();
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
    public frmA() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.add(getBtnNewButton());
        contentPane.add(getTextField());
        contentPane.add(getBtnNewButton_1());
        contentPane.add(getBtnNewButton_2());
    }
    private JButton getBtnNewButton() {
        if (btnNewButton == null) {
        	btnNewButton = new JButton("New button");
        	btnNewButton.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	        String value = textField.getText();
        	        frmB frm = new frmB(frame);
        	        frm.refresh(value);
        	        frm.setVisible(true);
        	    }
        	});
        	btnNewButton.setBounds(12, 10, 97, 23);
        }
        return btnNewButton;
    }
    private JTextField getTextField() {
        if (textField == null) {
        	textField = new JTextField();
        	textField.setBounds(12, 231, 116, 21);
        	textField.setColumns(10);
        }
        return textField;
    }
    private JButton getBtnNewButton_1() {
        if (btnNewButton_1 == null) {
        	btnNewButton_1 = new JButton("New button");
        	btnNewButton_1.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	        frmB frm = new frmB(frame, textField.getText());
        	        frm.setVisible(true);
        	    }
        	});
        	btnNewButton_1.setBounds(12, 75, 97, 23);
        }
        return btnNewButton_1;
    }
    private JButton getBtnNewButton_2() {
        if (btnNewButton_2 == null) {
        	btnNewButton_2 = new JButton("New button");
        	btnNewButton_2.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	        frmB frm = new frmB();
        	        frm.setVisible(true);
        	    }
        	});
        	btnNewButton_2.setBounds(12, 143, 97, 23);
        }
        return btnNewButton_2;
    }
    public void refresh (String value) {
        textField.setText(value);
    }
    public String returnText() {
        return textField.getText();
    }
}
