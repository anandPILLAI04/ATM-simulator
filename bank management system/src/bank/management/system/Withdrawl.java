
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class Withdrawl extends JFrame implements ActionListener{

    JTextField amountText;
    JButton withdraw,back;
    String pinnumber;
    
    Withdrawl(String pinnumber){
        setLayout(null);
        
        this.pinnumber = pinnumber;
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3); 
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        JLabel withdrawlInstruct = new JLabel("Enter Amount you want to withdraw");
        withdrawlInstruct.setBounds(170,300,700,40);
        withdrawlInstruct.setFont(new Font("System" ,Font.BOLD,18));
        withdrawlInstruct.setForeground(Color.WHITE);
        image.add(withdrawlInstruct);
        
        amountText = new JTextField();
        amountText.setBounds(160,340,350,40);
        image.add(amountText);
        
        withdraw = new JButton("WTIHDRAW");
        withdraw.setBounds(345,485,150,30);
        image.add(withdraw);
        withdraw.addActionListener(this);
        
        back = new JButton("BACK");
        back.setBounds(345,520,150,30);
        image.add(back);
        back.addActionListener(this);
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == withdraw)
        {
            String amount = amountText.getText();
            Date date = new Date();
            if(amount.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Please Enter Amount");
            }
            else{
                try{
                Conn c = new Conn();
                String query = "insert into bank values('"+pinnumber+"','"+date+"','Withdrawal','"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs "+amount+" Withdrawn Successfully");
                }
                catch(Exception e)
                {
                    System.out.print(e);
                }
            }
        }
        else if(ae.getSource()==back)
        {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }
    public static void main(String args[]) {
        new Withdrawl("");
    }
}
