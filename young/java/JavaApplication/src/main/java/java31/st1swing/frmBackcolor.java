package java31.st1swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmBackcolor extends JFrame {
    
    private JPanel contentPane;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frmBackcolor frame = new frmBackcolor();
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
    public frmBackcolor() {
        setTitle("이벤트 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JButton btnNewButton = new JButton("노란색");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {                
                // 배경색 바꾸기
                contentPane.setBackground( Color.YELLOW );                
            }
        });
        btnNewButton.setBounds(68, 33, 97, 23);
        contentPane.add(btnNewButton);
        
        JButton btnNewButton_1 = new JButton("핑크색");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 배경색 바꾸기
                contentPane.setBackground( Color.PINK );   
            }
        });
        btnNewButton_1.setBounds(212, 33, 97, 23);
        contentPane.add(btnNewButton_1);
    }
}
