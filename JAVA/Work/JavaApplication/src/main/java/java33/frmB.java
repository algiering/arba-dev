package java33;

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
    private frmA parent = null;
    private JTextField textField;
    private JButton btnNewButton;

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
    public frmB(frmA parent, String value) {
        commonConstruct();
        refresh(value);
        this.parent = parent;
    }
    
    public frmB(frmA parent) {
        commonConstruct();
        this.parent = parent;
    }

    public frmB() {
        
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
        	        String value = textField.getText();
        	        parent.refresh(value);
        	    }
        	});
        	btnNewButton.setBounds(12, 229, 97, 23);
        }
        return btnNewButton;
    }
    
    public void refresh(String value) {
        textField.setText(value);
    }
    
    private void commonConstruct() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.add(getTextField());
        contentPane.add(getBtnNewButton());
    }
}
