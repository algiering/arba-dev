package calculator;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JLabel;

public class Cal extends JFrame {

    private JPanel contentPane;
    private JTextField aField;
    private JTextField bField;
    private JButton addButton;
    private JButton btnExit;
    private JButton subButton;
    private JButton multiButton;
    private JButton divButton;
    
    private static double a = 0;
    private static double b = 0;
    private static double result = 0;
    private JTextArea resultField;
    private JLabel lblNewLabel;
    private JLabel lblB;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Cal frame = new Cal();
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
    public Cal() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 618, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.add(getResultField());
        contentPane.add(getAField());
        contentPane.add(getBField());
        contentPane.add(getAddButton());
        contentPane.add(getBtnExit());
        contentPane.add(getSubButton());
        contentPane.add(getMultiButton());
        contentPane.add(getDivButton());
        contentPane.add(getLblNewLabel());
        contentPane.add(getLblB());
    }
    private JTextField getAField() {
        if (aField == null) {
        	aField = new JTextField();
        	aField.setFont(new Font("굴림", Font.BOLD, 30));
        	aField.setBounds(12, 143, 116, 67);
        	aField.setColumns(10);
        }
        return aField;
    }
    private JTextField getBField() {
        if (bField == null) {
        	bField = new JTextField();
        	bField.setFont(new Font("굴림", Font.BOLD, 30));
        	bField.setColumns(10);
        	bField.setBounds(474, 143, 116, 67);
        }
        return bField;
    }
    private JButton getAddButton() {
        if (addButton == null) {
        	addButton = new JButton("+");
        	addButton.setFont(new Font("굴림", Font.BOLD, 20));
        	addButton.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	        a = Double.valueOf(aField.getText());
        	        b = Double.valueOf(bField.getText());
        	        result = a + b;
        	        freshResult(result);
        	    }
        	});
        	addButton.setBounds(171, 143, 245, 56);
        }
        return addButton;
    }
    private JButton getBtnExit() {
        if (btnExit == null) {
        	btnExit = new JButton("EXIT");
        	btnExit.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	        System.exit(0);
        	    }
        	});
        	btnExit.setBounds(493, 417, 97, 35);
        }
        return btnExit;
    }
    private JButton getSubButton() {
        if (subButton == null) {
        	subButton = new JButton("-");
        	subButton.setFont(new Font("굴림", Font.BOLD, 20));
        	subButton.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	        a = Double.valueOf(aField.getText());
                    b = Double.valueOf(bField.getText());
                    result = a - b;
                    freshResult(result);
        	    }
        	});
        	subButton.setBounds(171, 211, 245, 56);
        }
        return subButton;
    }
    private JButton getMultiButton() {
        if (multiButton == null) {
        	multiButton = new JButton("*");
        	multiButton.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	        a = Double.valueOf(aField.getText());
                    b = Double.valueOf(bField.getText());
                    result = a * b;
                    freshResult(result);
        	    }
        	});
        	multiButton.setFont(new Font("굴림", Font.BOLD, 20));
        	multiButton.setBounds(171, 277, 245, 56);
        }
        return multiButton;
    }
    private JButton getDivButton() {
        if (divButton == null) {
        	divButton = new JButton("/");
        	divButton.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	        a = Double.valueOf(aField.getText());
                    b = Double.valueOf(bField.getText());
                    result = a / b;
                    freshResult(result);
        	    }
        	});
        	divButton.setFont(new Font("굴림", Font.BOLD, 20));
        	divButton.setBounds(171, 343, 245, 56);
        }
        return divButton;
    }
    
    private void freshResult (double value) {
        
        resultField.setText(String.valueOf(value));
    }
    private JTextArea getResultField() {
        if (resultField == null) {
        	resultField = new JTextArea();
        	resultField.setLineWrap(true);
        	resultField.setFont(new Font("굴림", Font.BOLD, 45));
        	resultField.setBounds(12, 10, 578, 123);
        }
        return resultField;
    }
    private JLabel getLblNewLabel() {
        if (lblNewLabel == null) {
        	lblNewLabel = new JLabel("A");
        	lblNewLabel.setFont(new Font("굴림", Font.BOLD, 30));
        	lblNewLabel.setBounds(55, 220, 21, 35);
        }
        return lblNewLabel;
    }
    private JLabel getLblB() {
        if (lblB == null) {
        	lblB = new JLabel("B");
        	lblB.setFont(new Font("굴림", Font.BOLD, 30));
        	lblB.setBounds(523, 220, 28, 35);
        }
        return lblB;
    }
}
