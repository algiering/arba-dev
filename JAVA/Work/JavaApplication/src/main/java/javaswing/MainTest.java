package javaswing;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.TextArea;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MainTest extends JFrame {
    JTextField tf = new JTextField(10);
    JTextArea ta = new JTextArea(30,50);
    
    public MainTest() {
        setTitle("도서 관리 프로그램");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        
        c.add(new JScrollPane(ta));
        
        setSize(1280,720);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        
        new MainTest();
    
    }

}
