package java31.st1swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmButton extends JFrame {
    
    private JPanel contentPane;
    private JButton btnLeft;
    private JButton btnCenter;
    private JButton btnRight;
    private JTextField txtField;
    private JButton btnNewButton_3;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frmButton frame = new frmButton();
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
    public frmButton() {
        setTitle("테스트 프레임");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.add(getBtnLeft());
        contentPane.add(getBtnCenter());
        contentPane.add(getBtnRight());
        contentPane.add(getTxtField());
        contentPane.add(getBtnNewButton_3());
    }
    private JButton getBtnLeft() {
        if (btnLeft == null) {
        	btnLeft = new JButton("왼쪽버튼");
        	btnLeft.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	        String temp1 = txtField.getText();
        	        String temp2 = temp1 + " / 왼쪽버튼";        	        
        	        txtField.setText(temp2 );
        	    }
        	});
        	btnLeft.setBounds(43, 43, 97, 63);
        }
        return btnLeft;
    }
    private JButton getBtnCenter() {
        if (btnCenter == null) {
        	btnCenter = new JButton("중간버튼");
        	btnCenter.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {

                    String temp1 = txtField.getText();
                    String temp2 = temp1 + " / 중간버튼";                   
                    txtField.setText(temp2 );
        	    }
        	});
        	btnCenter.setBounds(152, 43, 97, 63);
        }
        return btnCenter;
    }
    private JButton getBtnRight() {
        if (btnRight == null) {
        	btnRight = new JButton("오른쪽버튼");
        	btnRight.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {

                    txtField.setText("오른쪽버튼");
        	    }
        	});
        	btnRight.setEnabled(false);
        	btnRight.setBounds(261, 43, 97, 63);
        }
        return btnRight;
    }
    private JTextField getTxtField() {
        if (txtField == null) {
        	txtField = new JTextField();
        	txtField.setBounds(43, 133, 315, 21);
        	txtField.setColumns(10);
        }
        return txtField;
    }
    private JButton getBtnNewButton_3() {
        if (btnNewButton_3 == null) {
        	btnNewButton_3 = new JButton("창닫기");
        	btnNewButton_3.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	        System.exit(0); 
        	    }
        	});
        	btnNewButton_3.setBounds(43, 181, 315, 47);
        }
        return btnNewButton_3;
    }
}
