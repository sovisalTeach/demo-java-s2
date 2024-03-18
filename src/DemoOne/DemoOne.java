package DemoOne;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DemoOne implements ActionListener {
    JFrame f;
    JPanel p1, p2;
    JLabel lbKh, lbUsd;
    JTextField tfKh, tfUsd;
    JButton btnExchange, btnClear;

    public DemoOne(){
        f = new JFrame("Demo1");
        p1 = new JPanel();
        p2 = new JPanel();
        lbKh = new JLabel("Khmer:");
        lbUsd = new JLabel("Dollar:");
        tfKh = new JTextField();
        tfUsd = new JTextField();
        btnExchange = new JButton("Exchange");
        btnClear = new JButton("Clear");

        btnExchange.addActionListener(this);
        btnClear.addActionListener(this);

        p1.setLayout(new FlowLayout());
        p2.setLayout(new FlowLayout());
        p1.add(lbKh);
        p2.add(lbUsd);

        f.add(p1);
        f.add(tfKh);
        f.add(p2);
        f.add(tfUsd);
        f.add(btnExchange);
        f.add(btnClear);
        f.setSize(500,200);
        f.setLayout(new GridLayout(3,2,10,10));
        f.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnExchange){
            String usd = tfUsd.getText();
            String khmer = tfKh.getText();
            if(usd.isEmpty()){
                double result = Double.parseDouble(khmer) /4000;
                tfUsd.setText(String.valueOf(result));
            }else {
                double result = Double.parseDouble(usd)*4000;
                tfKh.setText(String.valueOf(result));
            }
        }else {
            tfKh.setText("");
            tfUsd.setText("");
        }
    }
}
