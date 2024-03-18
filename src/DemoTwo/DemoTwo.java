package DemoTwo;

import javax.swing.*;


public class DemoTwo extends JFrame {

    public DemoTwo(){
        setTitle("Testing 2");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ImageIcon img = new ImageIcon("assets/logo.png");
        setIconImage(img.getImage());
        setSize(500,500);
        setVisible(true);
    }
}
