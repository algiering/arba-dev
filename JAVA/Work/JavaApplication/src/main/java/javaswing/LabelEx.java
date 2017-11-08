package javaswing;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class LabelEx extends JFrame{
    public LabelEx() {
        setTitle("레이블 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        JLabel textLabel = new JLabel("소녀전선");
        ImageIcon img = new ImageIcon("image/test.png");
        JLabel imageLabel = new JLabel(img);
        ImageIcon icon = new ImageIcon("image/test2.png");
        JLabel label = new JLabel("소녀전선",icon,SwingConstants.CENTER);
        
        c.add(textLabel);
        c.add(imageLabel);
        c.add(label);
        setSize(300,500);
        setVisible(true);
        
    }
    
    public static void main(String[] args) {
        new LabelEx();
    }

}
