package com.ManageFIR;
import javax.swing.* ;
import java.awt.*;
import java.awt.event.*;

public class Splash extends JFrame implements ActionListener{
    Splash(){
        getContentPane().setBackground(Color.BLACK);
        setLayout(null);

        JLabel Heading = new JLabel("FIR MANAGEMENT SYSTEM");
        Heading.setBounds(100,30,1200,60);
        Heading.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,50));
        Heading.setForeground(Color.cyan);
        add(Heading);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/CyberHP1.jpg"));
        Image i2 =i1.getImage().getScaledInstance(1100,700,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image3 = new JLabel(i3);
        image3.setBounds(50,100,1050,500);
        add(image3);


        JButton continueB = new JButton("Continue");
        continueB.setBounds(500,400,200,50);
        continueB.setFont((new Font(Font.SANS_SERIF,Font.PLAIN,20)));
        continueB.setBackground(Color.BLACK);
        continueB.setForeground(Color.white);
        continueB.addActionListener(this);
        add(continueB);



        setSize(1170,650);
        setLocation(200,50);
        setVisible(true);



    }
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Login();
    }


    public static void main(String[] args) {

        new Splash();
    }

}
