package com.ManageFIR;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener {
    JButton view, add, update, remove;
    Home() {

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/home1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1120, 630);
        add(image);

        JLabel heading = new JLabel("FIR Management System");
        heading.setBounds(620, 20, 400, 40);
        heading.setFont(new Font("Raleway", Font.BOLD, 25));
        image.add(heading);
        heading.setForeground(Color.WHITE);

        add = new JButton("Add New FIR");
        add.setBounds(650, 80, 150, 40);
        add.addActionListener(this);
        image.add(add);

        view = new JButton("View FIRs");
        view.setBounds(820, 80, 150, 40);
        view.addActionListener(this);
        image.add(view);

        setSize(1120, 630);
        setLocation(250, 100);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            setVisible(false);
            new AddNewFIR();
        } else if (ae.getSource() == view) {
            setVisible(false);
            new ViewFIR();
        }
    }


    public static void main(String[] args) {
        new Home();
    }

}
