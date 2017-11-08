package javaswing;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


public class CheckBoxTest extends JFrame{
    JCheckBox[] fruits = new JCheckBox[3];
    String [] names = {"갸악", "거누형", "하늘풀"};
    JLabel sumLabel;
    
    CheckBoxTest() {
        setTitle("갸악 템");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        c.add(new JLabel("갸악"));
        MyItemListner listner = new MyItemListner();
        
        for(int i=0; i<fruits.length; i=i+1) {
            fruits[i] = new JCheckBox(names[i]);
            fruits[i].setBorderPainted(true);
            c.add(fruits[i]);
            fruits[i].addItemListener(listner);
        }
        sumLabel = new JLabel("현재 0 원 입니다.");
        c.add(sumLabel);
        setSize(250,200);
        setVisible(true);
    }

    
    class MyItemListner implements ItemListener{
        
        int sum = 0;
        
        @Override
        public void itemStateChanged(ItemEvent e) {
            // TODO Auto-generated method stub
            if(e.getStateChange() == ItemEvent.SELECTED) {
                if(e.getItem() == fruits[0])
                    sum += 100;
                else if(e.getItem() == fruits[1]) {
                    sum += 500;
                }
                else {
                    sum += 20000;
                }
            }
            
            else {
                if(e.getItem() == fruits[0]) {
                    sum -= 100;
                }
                else if(e.getItem() == fruits[1]) {
                    sum -= 500;
                }
                else {
                    sum -= 20000;
                }
            }
            sumLabel.setText("똥");
            
        }

    }
    
    public static void main(String[] args) {
        new CheckBoxTest();
    }

    
}
