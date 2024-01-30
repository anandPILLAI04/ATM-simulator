
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.Date;
import java.awt.event.*;
import java.sql.*;

public class FastCash extends JFrame implements ActionListener{

    JButton hundred,fiveHundred, thousand, twoThousand, fiveThousand, tenThousand, back;
    String pinnumber;
    FastCash(String pinnumber){
       
        setLayout(null);
        
        this.pinnumber=pinnumber;
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3); 
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        JLabel selectTransaction = new JLabel("Please select withdrawl amount");
        selectTransaction.setBounds(160,300,700,38);
        selectTransaction.setFont(new Font("System" ,Font.BOLD,22));
        selectTransaction.setForeground(Color.WHITE);
        image.add(selectTransaction);
        
        
        hundred = new JButton("Rs 100");
        hundred.setBounds(170,415,150,30);
        image.add(hundred);
        hundred.addActionListener(this);
        
        fiveHundred = new JButton("Rs 500");
        fiveHundred.setBounds(355,415,150,30);
        image.add(fiveHundred);
        fiveHundred.addActionListener(this);
        
        thousand= new JButton("Rs 1000");
        thousand.setBounds(170,450,150,30);
        image.add(thousand);
        thousand.addActionListener(this);
        
        twoThousand = new JButton("Rs 2000");
        twoThousand.setBounds(355,450,150,30);
        image.add(twoThousand);
        twoThousand.addActionListener(this);
        
        fiveThousand = new JButton("Rs 5000");
        fiveThousand.setBounds(170,485,150,30);
        image.add(fiveThousand);
        fiveThousand.addActionListener(this);
        
        tenThousand = new JButton("Rs 10000");
        tenThousand.setBounds(355,485,150,30);
        image.add(tenThousand);
        tenThousand.addActionListener(this);
        
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
        else{
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            Conn c = new Conn();
            try{
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                int balance =0;
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
                
                if(ae.getSource() != back && balance < Integer.parseInt(amount))
                {
                    JOptionPane.showMessageDialog(null,"Insufficient balance");
                    return;
                }
                Date date = new Date();
                String query = "insert into bank values('"+pinnumber+"','"+date+"','Withdrawl','"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs "+amount+" Debited Successfully");
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            }
            catch(Exception e)
            {
                System.out.print(e);
            }
        }
    }
    
    public static void main(String args[]) {
       new FastCash("");
    }
}
