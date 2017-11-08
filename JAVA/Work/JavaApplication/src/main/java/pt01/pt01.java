package pt01;

import java.awt.Container;
import java.awt.Label;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class pt01 extends JFrame {
    
    pt01() {
        setTitle("상품 관리");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(null);
        
        EtchedBorder tBorder;
        
        tBorder = new EtchedBorder();
        
        JLabel textLabel1 = new JLabel("상품명", JLabel.CENTER);
        JLabel textLabelBorder1 = new JLabel("", JLabel.CENTER);
        
        textLabel1.setBounds(180, 100, 100, 20);
        textLabel1.setBorder(tBorder);
        textLabelBorder1.setBounds(140, 80, 280, 100);
        textLabelBorder1.setBorder(tBorder);

        c.add(textLabel1);
        c.add(textLabelBorder1);
        
        JTextField textField1 = new JTextField(50);
        
        textField1.setBounds(180, 140, 200, 20);
        c.add(textField1);
        
        JLabel textLabel2 = new JLabel("상품설명", JLabel.CENTER);
        JLabel textLabelBorder2 = new JLabel("", JLabel.CENTER);
        
        textLabel2.setBounds(180, 200, 100, 20);
        textLabel2.setBorder(tBorder);
        textLabelBorder2.setBounds(140,180,280,100);
        textLabelBorder2.setBorder(tBorder);

        c.add(textLabel2);
        c.add(textLabelBorder2);
        
        JTextField textField2 = new JTextField(50);
        
        textField2.setBounds(180, 240, 200, 20);
        c.add(textField2);
        
        JLabel textLabel3 = new JLabel("가격", JLabel.CENTER);
        JLabel textLabelBorder3 = new JLabel("", JLabel.CENTER);
        
        textLabel3.setBounds(180, 300, 100, 20);
        textLabel3.setBorder(tBorder);
        textLabelBorder3.setBounds(140,280,280,100);
        textLabelBorder3.setBorder(tBorder);

        c.add(textLabel3);
        c.add(textLabelBorder3);
        
        JTextField textField3 = new JTextField(50);
        
        textField3.setBounds(180, 340, 200, 20);
        c.add(textField3);
        
        JLabel textLabel4 = new JLabel("생산자", JLabel.CENTER);
        JLabel textLabelBorder4 = new JLabel("", JLabel.CENTER);
        
        textLabel4.setBounds(180, 400, 100, 20);
        textLabel4.setBorder(tBorder);
        textLabelBorder4.setBounds(140,380,280,100);
        textLabelBorder4.setBorder(tBorder);

        c.add(textLabel4);
        c.add(textLabelBorder4);
        
        JTextField textField4 = new JTextField(50);
        
        textField4.setBounds(180, 440, 200, 20);
        c.add(textField4);
        
        JLabel textLabel5 = new JLabel("고유번호", JLabel.CENTER);
        JLabel textLabelBorder5 = new JLabel("", JLabel.CENTER);
        
        textLabel5.setBounds(180, 500, 100, 20);
        textLabel5.setBorder(tBorder);
        textLabelBorder5.setBounds(140,480,280,100);
        textLabelBorder5.setBorder(tBorder);

        c.add(textLabel5);
        c.add(textLabelBorder5);
        
        JTextField textField5 = new JTextField(50);
        
        textField5.setBounds(180, 540, 200, 20);
        c.add(textField5);
        
        setSize (1280,720);
        setVisible(true);
        
    }
    
    

    public static void main(String[] args) {
        
        new pt01();

    }

}
