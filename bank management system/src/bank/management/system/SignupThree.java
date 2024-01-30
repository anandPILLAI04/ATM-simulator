package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class SignupThree extends JFrame implements ActionListener{

    JRadioButton saving_acc,fd_acc,current_acc,rd_acc;
    JCheckBox atm_card,net_banking,mobile_banking,alerts,cheque,eStatement,declaration; 
    JButton cancel,submit;
    String formno;
    SignupThree(String formno) {
  
        setLayout(null);
        
        this.formno=formno;
        
        JLabel accountdetails = new JLabel("Page 3: Account Details");
        accountdetails.setFont(new Font("Tahoma" ,Font.BOLD,30));
        accountdetails.setBounds(270,100,400,40);
        add(accountdetails);
        
        JLabel type = new JLabel("Account Type");
        type.setFont(new Font("Tahoma" ,Font.BOLD,20));
        type.setBounds(100,150,300,40);
        add(type);
        
        saving_acc= new JRadioButton("Saving Account");
        saving_acc.setBounds(100,200,200,30);
        add(saving_acc);
        
        fd_acc = new JRadioButton("Fixed Deposit Account");
        fd_acc.setBounds(300,200,200,30);
        add(fd_acc);
        
        current_acc = new JRadioButton("Current Account");
        current_acc.setBounds(100,240,200,30);
        add(current_acc);
        
        rd_acc = new JRadioButton("Recurring Deposit Account");
        rd_acc.setBounds(300,240,250,30);
        add(rd_acc);
        
        ButtonGroup account_type = new ButtonGroup();
        account_type.add(saving_acc);
        account_type.add(fd_acc);
        account_type.add(current_acc);
        account_type.add(rd_acc);
        
        JLabel cardno = new JLabel("Card Number:");
        cardno.setFont(new Font("Tahoma" ,Font.BOLD,20));
        cardno.setBounds(100,285,300,40);
        add(cardno);
        
        JLabel card_details = new JLabel("Your 16 digit Card Number:");
        card_details.setFont(new Font("Tahoma" ,Font.BOLD,12));
        card_details.setBounds(100,330,300,20);
        add(card_details);
        
        JLabel number = new JLabel("XXXX-XXXX-XXXX-6969");
        number.setFont(new Font("Tahoma" ,Font.BOLD,20));
        number.setBounds(300,285,400,40);
        add(number);
        
        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Tahoma" ,Font.BOLD,20));
        pin.setBounds(100,350,300,40);
        add(pin);
        
        JLabel pin_details = new JLabel("Your 4 digit PIN Number:");
        pin_details.setFont(new Font("Tahoma" ,Font.BOLD,12));
        pin_details.setBounds(100,395,300,20);
        add(pin_details);
        
        JLabel pin_number = new JLabel("XXXX");
        pin_number.setFont(new Font("Tahoma" ,Font.BOLD,20));
        pin_number.setBounds(300,350,400,40);
        add(pin_number);
        
        
        JLabel services = new JLabel("Services Required:");
        services.setFont(new Font("Tahoma" ,Font.BOLD,20));
        services.setBounds(100,420,300,40);
        add(services);
        
        atm_card = new JCheckBox("ATM CARD");
        atm_card.setFont(new Font("Tahoma" ,Font.BOLD,14));
        atm_card.setBounds(150, 460, 200, 30);
        add(atm_card);
        
        net_banking = new JCheckBox("INTERNET BANKING");
        net_banking.setFont(new Font("Tahoma",Font.BOLD,14));
        net_banking.setBounds(350, 460, 200, 30);
        add(net_banking);
        
        mobile_banking = new JCheckBox("MOBILE BANKING");
        mobile_banking.setFont(new Font("Tahoma" ,Font.BOLD,14));
        mobile_banking.setBounds(150, 500, 200, 30);
        add(mobile_banking);
        
        alerts = new JCheckBox("EMAIL & SMS ALERT");
        alerts.setFont(new Font("Tahoma" ,Font.BOLD,14));
        alerts.setBounds(350, 500, 200, 30);
        add(alerts);
        
        cheque = new JCheckBox("CHEQUE BOOK");
        cheque.setFont(new Font("Tahoma" ,Font.BOLD,14));
        cheque.setBounds(150, 540, 200, 30);
        add(cheque);
        
        eStatement = new JCheckBox("E STATEMENT");
        eStatement.setFont(new Font("Tahoma" ,Font.BOLD,14));
        eStatement.setBounds(350, 540, 200, 30);
        add(eStatement);
        
        declaration = new JCheckBox("I confirm that the details entered are accurate to the best of my knowledge.");
        declaration.setFont(new Font("Tahoma" ,Font.BOLD,16));
        declaration.setBounds(100, 580, 800, 30);
        add(declaration);
        
        cancel = new JButton("CANCEL");
        cancel.setBounds(100, 660, 80, 30);
        cancel.addActionListener(this);
        add(cancel);
        
        submit = new JButton("SUBMIT");
        submit.setBounds(620, 660, 80, 30);
        submit.addActionListener(this);
        add(submit);
        
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);
        setSize(850,800);
        setLocation(350,50);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        
        String account_type="";
        if (ae.getSource()==submit){
            if(saving_acc.isSelected()){
                account_type = "Savings Account";
            }
            else if(fd_acc.isSelected()){
                account_type = "Fixed Deposit Account";
            }
            else if(current_acc.isSelected()){
                account_type = "Current Account";
            }
            else if(rd_acc.isSelected()){
                account_type = "Recurring Deposit Account";
            }
            
            Random random = new Random();
            String cardnumber = ""+Math.abs((random.nextLong() % 90000000L)+ 5040936000000000L);
            String pin = ""+ Math.abs((random.nextLong()% 9000L)+ 1000L);
            
            String facility ="";
            if(atm_card.isSelected())
            {
                facility= facility +" ATM CARD";
            }
            else if(net_banking.isSelected())
            {
                facility= facility +" Internet Banking";
            }
            else if(mobile_banking.isSelected())
            {
                facility= facility +" Mobile Banking";
            }
            else if(alerts.isSelected())
            {
                facility= facility +" Email & SMS alerts";
            }
            else if(cheque.isSelected())
            {
                facility= facility +" Cheque Book";
            }
            else if(eStatement.isSelected())
            {
                facility= facility +" E Statement";
            }
        
        try{
            if(account_type =="")
            {
                JOptionPane.showMessageDialog(null, "Select Account Type");
 
            }
            else if(!declaration.isSelected())
            {
                JOptionPane.showMessageDialog(null, "Fill all required fields to proceed");
            }
            else{
                Conn c = new Conn();
                String query = "insert into signupthree values('"+formno+"','"+account_type+"','"+cardnumber+"','"+pin+"','"+facility+"')";
                //System.out.println(query);
                String query2 = "insert into login values('"+formno+"','"+cardnumber+"','"+pin+"')";
                c.s.executeUpdate(query);
                c.s.executeUpdate(query2);
                JOptionPane.showMessageDialog(null, "Card Number: "+cardnumber+"\nPIN: "+pin);
                
                setVisible(false);
                new Deposit(pin).setVisible(true);
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        }
        else if(ae.getSource()==cancel)
        {
            setVisible(false);
            new Login().setVisible(true);
        }
    }

    public static void main(String args[]) {
        new SignupThree("");
    }
}
