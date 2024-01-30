package bank.management.system;

import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class MiniStatement  extends JFrame{

    String pinnumber;
    MiniStatement(String pinnumber)
    {
        setLayout(null);
        setTitle("MINI STATEMENT");
        this.pinnumber=pinnumber;
        
        JLabel mini = new JLabel("");
        add(mini);
        mini.setBounds(20,140,400,200);
        
        JLabel bank = new JLabel("Royal Bank");
        bank.setBounds(140,20,200,40);
        bank.setFont(new Font("Raleway",Font.BOLD,18));
        add(bank);
        
        JLabel card = new JLabel();
        card.setBounds(20,80,300,20);
        card.setFont(new Font("Raleway",Font.BOLD,14));
        add(card);
        
        JLabel balance = new JLabel();
        balance.setBounds(20,400,300,20);
        balance.setFont(new Font("Raleway",Font.BOLD,14));
        add(balance);
        
        try
        {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from login where pin = '"+pinnumber+"'");
            while(rs.next())
            {
                card.setText("Card Number: "+rs.getString("cardnumber").substring(0,4)+"XXXXXXXX"+rs.getString("cardnumber").substring(12));
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
        try
        {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
            while(rs.next())
            {
                mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount")+"<br><br><html>");
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
        int bal =0;
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
            
            while (rs.next())
            {
                if(rs.getString("type").equals("Deposit"))
                {
                    bal += Integer.parseInt(rs.getString("amount"));
                }
                else
                {
                    bal -= Integer.parseInt(rs.getString("amount"));
                }
             }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        balance.setText("Your Account Balance: "+bal);
        setSize(400,600);
        setLocation(20,20);
        setVisible(true);
    }
    
    public static void main(String args[]) {
        new MiniStatement("");
    }
}
