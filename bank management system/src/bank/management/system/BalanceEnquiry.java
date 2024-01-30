package bank.management.system;

import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class BalanceEnquiry extends JFrame implements ActionListener{

    JButton back;
    String pinnumber;
    BalanceEnquiry(String pinnumber){
        setLayout(null);
        
        this.pinnumber=pinnumber;
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3); 
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        Conn c = new Conn();
        int balance =0;
        try{
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
            
            while (rs.next())
            {
                if(rs.getString("type").equals("Deposit"))
                {
                    balance += Integer.parseInt(rs.getString("amount"));
                }
                else
                {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
             }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
        JLabel changePin = new JLabel("Your Current Balance is "+balance);
        changePin.setBounds(170,280,700,80);
        changePin.setFont(new Font("System" ,Font.BOLD,20));
        changePin.setForeground(Color.WHITE);
        image.add(changePin);
        
        back = new JButton("BACK");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==back)
        {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    
    }
    
    public static void main(String args[]) {
        new BalanceEnquiry("");
    }
}
