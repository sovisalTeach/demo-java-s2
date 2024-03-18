package TaskTwo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class LogIn implements ActionListener {
    JFrame f;
    JLabel lSiginTitle, lSignUpTitle, lUsername, lPassword, lUsername2, lPassword2, lRepassword, lYourAttempt, lAttempt, lCorrect, lIncorrect;
    JButton btnSignUp, btnSignIn, btnClear, btnClear2;
    JTextField tUserName1, tUserName2;
    JPasswordField tPassword, tPassword2, tRepassword;
    JPanel pMain, pLogin, pLoginCenter, pSign, pSignCenter, pCorrect, pIncorrect;
    CardLayout cl;

    int attempt = 3;

    String varUsername, varPassword;

    public LogIn(){
        f = new JFrame("Username Login");
        ImageIcon img = new ImageIcon("assets/man_4140048.png");
        Font font = new Font("Eurostile",Font.PLAIN, 16);
        cl = new CardLayout();
        pMain = new JPanel();
        pMain.setLayout(cl);
        pLogin = new JPanel(new BorderLayout(10,10));
        pLoginCenter = new JPanel(new GridLayout(4,2));
        pSign = new JPanel(new BorderLayout(10,10));
        pSignCenter = new JPanel(new GridLayout(4,2));
        pCorrect = new JPanel(new BorderLayout(10,10));
        pIncorrect = new JPanel(new BorderLayout(10,10));
        lSiginTitle = new JLabel("Sign In");
        lSiginTitle.setHorizontalAlignment(JLabel.CENTER);
        lSiginTitle.setVerticalAlignment(JLabel.CENTER);
        lSignUpTitle = new JLabel("Sign Up");
        lSignUpTitle.setHorizontalAlignment(JLabel.CENTER);
        lSignUpTitle.setVerticalAlignment(JLabel.CENTER);
        lUsername = new JLabel("Username:");
        lUsername.setHorizontalAlignment(JLabel.CENTER);
        lUsername.setVerticalAlignment(JLabel.CENTER);
        lPassword = new JLabel("Password:");
        lPassword.setHorizontalAlignment(JLabel.CENTER);
        lPassword.setVerticalAlignment(JLabel.CENTER);
        lUsername2 = new JLabel("Username:");
        lUsername2.setHorizontalAlignment(JLabel.CENTER);
        lUsername2.setVerticalAlignment(JLabel.CENTER);
        lPassword2 = new JLabel("Password:");
        lPassword2.setHorizontalAlignment(JLabel.CENTER);
        lPassword2.setVerticalAlignment(JLabel.CENTER);
        lRepassword = new JLabel("Re-Password:");
        lRepassword.setHorizontalAlignment(JLabel.CENTER);
        lRepassword.setVerticalAlignment(JLabel.CENTER);
        lYourAttempt = new JLabel("Your Attempts Have Only:");
        lYourAttempt.setVerticalAlignment(JLabel.CENTER);
        lAttempt = new JLabel();
        lAttempt.setText(String.valueOf(attempt));
        lAttempt.setHorizontalAlignment(JLabel.CENTER);
        lAttempt.setVerticalAlignment(JLabel.CENTER);
        ImageIcon imgCorrect = new ImageIcon("assets/correct.png");
        lCorrect = new JLabel("Welcome to Our Application");
        lCorrect.setIcon(imgCorrect);
        lCorrect.setVerticalTextPosition(JLabel.TOP);
        lCorrect.setHorizontalTextPosition(JLabel.CENTER);
        lCorrect.setIconTextGap(15);
        lCorrect.setHorizontalAlignment(JLabel.CENTER);
        lCorrect.setVerticalAlignment(JLabel.CENTER);
        ImageIcon imgIncorrect = new ImageIcon("assets/incorrect.png");
        lIncorrect = new JLabel("You have used all of three attempts!!!");
        lIncorrect.setIcon(imgIncorrect);
        lIncorrect.setVerticalTextPosition(JLabel.TOP);
        lIncorrect.setHorizontalTextPosition(JLabel.CENTER);
        lIncorrect.setIconTextGap(15);
        lIncorrect.setHorizontalAlignment(JLabel.CENTER);
        lIncorrect.setVerticalAlignment(JLabel.CENTER);

        tUserName1 = new JTextField();
        tUserName2 = new JTextField();
        tPassword = new JPasswordField();
        tPassword2 = new JPasswordField();
        tRepassword = new JPasswordField();
        btnSignIn = new JButton("Sign In");
        btnSignUp = new JButton("Sign Up");
        btnClear = new JButton("Clear");
        btnClear2 = new JButton("Clear");

        btnSignUp.addActionListener(this);
        btnSignIn.addActionListener(this);
        btnClear.addActionListener(this);
        btnClear2.addActionListener(this);

        pSignCenter.add(lUsername);
        pSignCenter.add(tUserName1);
        pSignCenter.add(lPassword);
        pSignCenter.add(tPassword);
        pSignCenter.add(lRepassword);
        pSignCenter.add(tRepassword);
        pSignCenter.add(btnSignUp);
        pSignCenter.add(btnClear);

        pLoginCenter.add(lUsername2);
        pLoginCenter.add(tUserName2);
        pLoginCenter.add(lPassword2);
        pLoginCenter.add(tPassword2);
        pLoginCenter.add(btnSignIn);
        pLoginCenter.add(btnClear2);
        pLoginCenter.add(lYourAttempt);
        pLoginCenter.add(lAttempt);

        pSign.add(lSignUpTitle,BorderLayout.NORTH);
        pSign.add(pSignCenter,BorderLayout.CENTER);

        pLogin.add(lSiginTitle,BorderLayout.NORTH);
        pLogin.add(pLoginCenter,BorderLayout.CENTER);

        pCorrect.add(lCorrect, BorderLayout.CENTER);

        pIncorrect.add(lIncorrect, BorderLayout.CENTER);

        pMain.add(pSign,"SignUp");
        pMain.add(pLogin,"LogIn");
        pMain.add(pCorrect,"Correct");
        pMain.add(pIncorrect, "Incorrect");

        f.add(pMain);
        f.setIconImage(img.getImage());
        f.setSize(500,350);
        f.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnSignUp){
            String pwdTemp = Arrays.toString(tPassword.getPassword());
            String repwdTemp = Arrays.toString(tRepassword.getPassword());
            if(pwdTemp.compareToIgnoreCase(repwdTemp)==0){
                varUsername = tUserName1.getText();
                varPassword = pwdTemp;
                cl.next(pMain);
            }else {
                System.out.println("Password Not Match");
            }

        } else if  (e.getSource()==btnSignIn) {
            String userTemp = tUserName2.getText();
            String pwdTemp = Arrays.toString(tPassword2.getPassword());
            if(attempt==1){
                cl.show(pMain,"Incorrect");
            }else {
                if((varUsername.compareToIgnoreCase(userTemp)==0)&&(varPassword.compareToIgnoreCase(pwdTemp))==0){
                    cl.show(pMain,"Correct");
                }else {
                    attempt--;
                    lAttempt.setText(String.valueOf(attempt));
                }
            }


        } else if (e.getSource()==btnClear) {
            tUserName1.setText("");
            tPassword.setText("");
            tRepassword.setText("");
        } else if (e.getSource()==btnClear2) {
            tUserName2.setText("");
            tPassword2.setText("");
        }
    }
}
