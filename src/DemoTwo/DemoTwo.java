package DemoTwo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DemoTwo {
    JFrame f;
    JLabel labelCardA, labelCardB, labelCardC;
    JButton btnNext, btnPrevious;
    JPanel panelCards, panelCardA, panelCardB, panelCardC, panelButton;
    CardLayout cl;

    public DemoTwo(){
        f = new JFrame("Testing");
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setSize(500,200);
        f.setLayout(new BorderLayout(10,10));

        labelCardA = new JLabel("This is Card A!!!");
        labelCardB = new JLabel("This is Card B!!!");
        labelCardC = new JLabel("This is Card C!!!");

        btnNext = new JButton("Next");
        btnPrevious = new JButton("Previous");

        cl = new CardLayout();

        panelCardA = new JPanel(new FlowLayout());
        panelCardB = new JPanel(new FlowLayout());
        panelCardC = new JPanel(new FlowLayout());

        panelButton = new JPanel(new FlowLayout());

        panelCards = new JPanel(cl);

        panelCardA.add(labelCardA);
        panelCardB.add(labelCardB);
        panelCardC.add(labelCardC);

        panelButton.add(btnPrevious);
        panelButton.add(btnNext);

        panelCards.add(panelCardA,"card1");
        panelCards.add(panelCardB,"card2");
        panelCards.add(panelCardC,"card3");

        btnPrevious.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.previous(panelCards);
            }
        });
        btnNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.next(panelCards);
            }
        });

        f.add(panelCards, BorderLayout.CENTER);
        f.add(panelButton, BorderLayout.SOUTH);
        f.setVisible(true);

    }

}
