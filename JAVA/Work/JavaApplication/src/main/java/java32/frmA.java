package java32;

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
    private JButton btnNewButton;
    private JTextField textField;
    
    private static frmA frame = null;
    private JButton button;
    

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
        contentPane.add(getButton());
    }

    private JButton getBtnNewButton() {
        if (btnNewButton == null) {
        	btnNewButton = new JButton("New button");
        	btnNewButton.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	        String val = textField.getText();
        	        frmB frm = new frmB(frame, val);
        	        frm.setVisible(true);
        	        
        	        frm.setText(textField.getText());
        	        frm.setParent( frame );
        	    }
        	});
        	btnNewButton.setBounds(12, 10, 97, 23);
        }
        return btnNewButton;
    }
    private JTextField getTextField() {
        if (textField == null) {
        	textField = new JTextField();
        	textField.setBounds(12, 170, 116, 21);
        	textField.setColumns(10);
        }
        return textField;
    }
    public void refresh( String value ) {
        textField.setText(value);
    }
    private JButton getButton() {
        if (button == null) {
        	button = new JButton("New button");
        	button.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	        String val = textField.getText();
        	        frmB frm = new frmB(val);
                    frm.setVisible(true);
        	    }
        	});
        	button.setBounds(12, 73, 97, 23);
        }
        return button;
    }
}
