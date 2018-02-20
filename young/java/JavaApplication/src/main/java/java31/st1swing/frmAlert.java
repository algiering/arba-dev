package java31.st1swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmAlert extends JFrame {
    
    private JPanel contentPane;
    private JTextField txtField;
    private JButton btnClick;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frmAlert frame = new frmAlert();
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
    public frmAlert() {
        setTitle("알림창 띄우기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 431, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.add(getTxtField());
        contentPane.add(getBtnClick());
    }
    
    private JTextField getTxtField() {
        if (txtField == null) {
        	txtField = new JTextField();
        	txtField.setBounds(38, 40, 174, 21);
        	txtField.setColumns(10);
        }
        return txtField;
    }
    private JButton getBtnClick() {
        if (btnClick == null) {
        	btnClick = new JButton("click");
        	btnClick.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	        
        	        String tmp = txtField.getText();
        	        JOptionPane.showMessageDialog(null, tmp );
        	    }
        	});
        	btnClick.setBounds(247, 39, 97, 23);
        }
        return btnClick;
    }
}
