
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener{

    JButton deposit,cashWithdrawl, fastCash, miniStatement, pinChange, balancedEnquiry, exit;
    String pinnumber;
    Transactions(String pinnumber){
       
        setLayout(null);
        
        this.pinnumber=pinnumber;
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3); 
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        JLabel selectTransaction = new JLabel("Please select your transaction");
        selectTransaction.setBounds(175,300,700,40);
        selectTransaction.setFont(new Font("System" ,Font.BOLD,22));
        selectTransaction.setForeground(Color.WHITE);
        image.add(selectTransaction);
        
        
        deposit = new JButton("DEPOSIT");
        deposit.setBounds(170,415,150,30);
        image.add(deposit);
        deposit.addActionListener(this);
        
        cashWithdrawl = new JButton("CASH WITHDRAWL");
        cashWithdrawl.setBounds(355,415,150,30);
        image.add(cashWithdrawl);
        cashWithdrawl.addActionListener(this);
        
        fastCash= new JButton("FAST CASH");
        fastCash.setBounds(170,450,150,30);
        image.add(fastCash);
        fastCash.addActionListener(this);
        
        miniStatement = new JButton("MINI STATEMENT");
        miniStatement.setBounds(355,450,150,30);
        image.add(miniStatement);
        miniStatement.addActionListener(this);
        
        pinChange = new JButton("PIN CHANGE");
        pinChange.setBounds(170,485,150,30);
        image.add(pinChange);
        pinChange.addActionListener(this);
        
        balancedEnquiry = new JButton("BALANCE ENQUIRY");
        balancedEnquiry.setBounds(355,485,150,30);
        image.add(balancedEnquiry);
        balancedEnquiry.addActionListener(this);
        
        exit = new JButton("EXIT");
        exit.setBounds(355,520,150,30);
        exit.addActionListener(this);
        image.add(exit);
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == deposit)
        {
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }
        else if(ae.getSource()== cashWithdrawl)
        {
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        }
        else if(ae.getSource()== fastCash)
        {
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        }
        else if(ae.getSource()== pinChange)
        {
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        }
        else if(ae.getSource()== balancedEnquiry)
        {
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        }
        else if(ae.getSource()== miniStatement)
        {
            new MiniStatement(pinnumber).setVisible(true);
        }    
        else if(ae.getSource()==exit)
        {
            System.exit(0);
        }
    }
    public static void main(String args[]) {
        new Transactions("");
    }
}
