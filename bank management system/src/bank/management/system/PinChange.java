package bank.management.system;

import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import java.awt.*;

public class PinChange extends JFrame implements ActionListener{

    JPasswordField newText, confirmText;
    JButton back,change;
    String pinnumber;
    
    PinChange(String pinnumber){
       
        setLayout(null);
        
        this.pinnumber=pinnumber;
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3); 
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        JLabel changePin = new JLabel("CHANGE PIN");
        changePin.setBounds(250,280,700,38);
        changePin.setFont(new Font("System" ,Font.BOLD,20));
        changePin.setForeground(Color.WHITE);
        image.add(changePin);
        
        
        JLabel newPin = new JLabel("New PIN: ");
        newPin.setBounds(165,320,180,25);
        newPin.setFont(new Font("System" ,Font.BOLD,16));
        newPin.setForeground(Color.WHITE);
        image.add(newPin);
        
        newText = new JPasswordField();
        newText.setBounds(330,320,180,25);
        newText.setFont(new Font("System" ,Font.BOLD,16));
        image.add(newText);
        
        
        JLabel confirmPin = new JLabel("Confirm New PIN: ");
        confirmPin.setBounds(165,360,180,25);
        confirmPin.setFont(new Font("System" ,Font.BOLD,16));
        confirmPin.setForeground(Color.WHITE);
        image.add(confirmPin);
        
        confirmText = new JPasswordField();
        confirmText.setBounds(330,360,180,25);
        confirmText.setFont(new Font("System" ,Font.BOLD,16));
        image.add(confirmText);
        
        change = new JButton("CHANGE");
        change.setBounds(355,485,150,30);
        image.add(change);
        change.addActionListener(this);
        
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
        else if(ae.getSource()== change){
            try{
            String nPin = newText.getText();
            String cPin = confirmText.getText();
            
            if (nPin.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Enter New PIN");
                return;
            }
            
            if (cPin.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Enter Confirm New PIN");
                return;
            }
            
            if (!nPin.equals(cPin))
            {
                JOptionPane.showMessageDialog(null,"New PIN and Confirm PIN do not match");
                return;
            }
            String query1 = "update bank set pin = '"+cPin+"' where pin ='"+pinnumber+"'";
            String query2 = "update login set pin = '"+cPin+"' where pin ='"+pinnumber+"'";
            String query3 = "update signupthree set pin = '"+cPin+"' where pin ='"+pinnumber+"'";
            Conn c  = new Conn();
            c.s.executeUpdate(query1);
            c.s.executeUpdate(query2);
            c.s.executeUpdate(query3);
            JOptionPane.showMessageDialog(null,"New PIN set successfully");
            setVisible(false);
            new Transactions(nPin).setVisible(true);
        }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
    }
    
    
    public static void main(String args[]) {
        new PinChange("");
    }
}
