package com.ManageFIR;

import net.proteanit.sql.DbUtils;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ViewFIR extends JFrame implements ActionListener{
    JTable table;
    Choice cFIRId;
    JButton search, update, back;

    ViewFIR() {

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel searchlbl = new JLabel("Search by FIR Id");
        searchlbl.setBounds(20, 20, 150, 20);
        add(searchlbl);

        cFIRId = new Choice();
        cFIRId.setBounds(180, 20, 150, 20);
        add(cFIRId);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from FIR");
            while(rs.next()) {
                cFIRId.add(rs.getString("FIRId"));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        table = new JTable();

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from FIR");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 100, 900, 600);
        add(jsp);

        search = new JButton("Search");
        search.setBounds(20, 70, 80, 20);
        search.addActionListener(this);
        add(search);

        back = new JButton("Back");
        back.setBounds(320, 70, 80, 20);
        back.addActionListener(this);
        add(back);

        setSize(900, 700);
        setLocation(300, 100);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == search) {

            String query = "select * from FIR where FIRId = '"+cFIRId.getSelectedItem()+"'";
            try {

                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        else {
            setVisible(false);
            new Home();
        }
    }

    public static void main(String[] args) {

        new ViewFIR();
    }
}
