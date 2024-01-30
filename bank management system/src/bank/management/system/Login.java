
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    
    JButton login,signup,clear;
    JTextField cardno_text;
    JPasswordField pin_text;
    
    Login(){
        setTitle("AUTOMATED TELLER MACHINE");
        
        setLayout(null);
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/banklogo.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label= new JLabel(i3);
        label.setBounds(70,10,100,100);
        add(label);
        
        JLabel heading_text = new JLabel("Welcome to ATM");
        heading_text.setFont(new Font("Tahoma",Font.BOLD,38));
        heading_text.setBounds(200,40,400,40);
        add(heading_text);
        
        JLabel cardno = new JLabel("Card No:");
        cardno.setFont(new Font("Tahoma",Font.BOLD,28));
        cardno.setBounds(120,150,150,40);
        add(cardno);
        
        cardno_text = new JTextField();
        cardno_text.setBounds(300, 150, 230, 40);
        cardno_text.setFont(new Font("Arial",Font.BOLD,14));
        add(cardno_text);
        
        
        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Tahoma",Font.BOLD,28));
        pin.setBounds(120,220,250,40);
        add(pin);
        
        pin_text = new JPasswordField();
        pin_text.setBounds(300, 220, 230, 40);
        pin_text.setFont(new Font("Arial",Font.BOLD,14));
        add(pin_text);
        
        login = new JButton("SIGN IN"); 
        login.setBounds(300, 300, 100, 30);
        login.addActionListener(this);
        add(login);
        
        clear = new JButton("CLEAR"); 
        clear.setBounds(430, 300, 100, 30);
        clear.addActionListener(this);
        add(clear);
        
        signup = new JButton("SIGN UP"); 
        signup.setBounds(300, 350, 230, 30);
        signup.addActionListener(this);
        add(signup);
        
        
        getContentPane().setBackground(Color.WHITE);
        setSize(800,480);
        setVisible(true);
        setLocation(350,200);
}
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() ==  login){
            try
            {
                String cardnumber =cardno_text.getText();
                String pinnumber = pin_text.getText();
                Conn c = new Conn();
                String query ="select * from login where cardnumber = '"+cardnumber+"' and pin = '"+pinnumber+"'";
                ResultSet rs = c.s.executeQuery(query);
                if(rs.next())
                {
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Wrong Cardnumber or PIN");
                }
            }
            catch(Exception e)
            {
                System.out.print(e);
            }
        }
        else if(ae.getSource() == signup){
            setVisible(false);
            new SignupOne().setVisible(true);
        }
        else if(ae.getSource() == clear){
            pin_text.setText("");
            cardno_text.setText("");
        }
    }
    
    
    public static void main(String args[]) {
        new Login();
    }
}
