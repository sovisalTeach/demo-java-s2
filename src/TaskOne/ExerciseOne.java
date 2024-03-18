package TaskOne;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExerciseOne implements ActionListener {
    JFrame f;
    JLabel l1, l2, lResult;
    JTextField t1, t2, tResult;
    JButton bPlus, bMinus, bDivide, bMulti, bEqual, bClear;

    String sign;

    public ExerciseOne(){
        f = new JFrame("Swing Calculator");
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        l1 = new JLabel("First Number:");
        l1.setVerticalAlignment(JLabel.CENTER);
        l1.setHorizontalAlignment(JLabel.CENTER);
        l2 = new JLabel("Second Number:");
        l2.setVerticalAlignment(JLabel.CENTER);
        l2.setHorizontalAlignment(JLabel.CENTER);
        lResult = new JLabel("Result:");
        lResult.setVerticalAlignment(JLabel.CENTER);
        lResult.setHorizontalAlignment(JLabel.CENTER);
        t1 = new JTextField();
        t2 = new JTextField();
        tResult = new JTextField();
        tResult.setEditable(false);
        bPlus = new JButton("+");
        bMinus = new JButton("-");
        bMulti = new JButton("*");
        bDivide = new JButton("/");
        bEqual = new JButton("=");
        bClear = new JButton("Clear");

        bPlus.addActionListener(this);
        bMulti.addActionListener(this);
        bMinus.addActionListener(this);
        bDivide.addActionListener(this);
        bEqual.addActionListener(this);
        bClear.addActionListener(this);

        f.add(l1);
        f.add(t1);
        f.add(l2);
        f.add(t2);
        f.add(lResult);
        f.add(tResult);
        f.add(bPlus);
        f.add(bMinus);
        f.add(bMulti);
        f.add(bDivide);
        f.add(bEqual);
        f.add(bClear);

        f.setLayout(new GridLayout(6,2));
        f.setSize(400,350);
        f.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        double result =0;
        double num1, num2;
        if(e.getSource()==bPlus){
            sign = "+";
        } else if (e.getSource()==bMinus) {
            sign = "-";
        } else if (e.getSource()==bMulti) {
            sign = "*";
        } else if (e.getSource()==bDivide) {
            sign = "/";
        } else if (e.getSource()==bEqual) {
            switch (sign){
                case "+":
                    num1 = Double.parseDouble(t1.getText());
                    num2 = Double.parseDouble(t2.getText());
                    result = num1+num2;
                    break;
                case "-":
                    num1 = Double.parseDouble(t1.getText());
                    num2 = Double.parseDouble(t2.getText());
                    result = num1-num2;
                    break;
                case "*":
                    num1 = Double.parseDouble(t1.getText());
                    num2 = Double.parseDouble(t2.getText());
                    result = num1*num2;
                    break;
                case "/":
                    num1 = Double.parseDouble(t1.getText());
                    num2 = Double.parseDouble(t2.getText());
                    result = num1/num2;
                    break;
            }
            tResult.setText(String.valueOf(result));
        } else if (e.getSource()==bClear) {
            num1=0;
            num2=0;
            result=0;
            t1.setText("");
            t2.setText("");
            tResult.setText("");
        }
    }
}
