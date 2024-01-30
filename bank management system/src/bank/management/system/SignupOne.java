package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignupOne extends JFrame implements ActionListener{
    
    JTextField name_text, fname_text, email_text, address_text, city_text, state_text, pincode_text; 
    JRadioButton male, female,married,unmarried;
    JButton next,cancel;
    long random;
    JDateChooser dateChooser;
    
    SignupOne(){
    
        setLayout(null);
        
        Random ran = new Random();
        random = Math.abs(ran.nextLong()%9000L +1000L);
        
        JLabel formno = new JLabel("APPLICATION FORM NO: "+ random);
        formno.setFont(new Font("Tahoma" ,Font.BOLD,38));
        formno.setBounds(140,20,600,100);
        add(formno);
        
        JLabel personaldetails = new JLabel("Page 1: Personal Details");
        personaldetails.setFont(new Font("Tahoma" ,Font.BOLD,30));
        personaldetails.setBounds(290,100,400,40);
        add(personaldetails);
        
        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Tahoma" ,Font.BOLD,20));
        name.setBounds(100,150,100,30);
        add(name);
        
        
        name_text = new JTextField();
        name_text.setBounds(300,150,400,30);
        name_text.setFont(new Font("Arial",Font.BOLD,14));
        add(name_text);
                
               
        JLabel fname = new JLabel("Father's Name:");
        fname.setFont(new Font("Tahoma" ,Font.BOLD,20));
        fname.setBounds(100,200,200,30);
        add(fname);
        
        fname_text = new JTextField();
        fname_text.setBounds(300,200,400,30);
        fname_text.setFont(new Font("Arial",Font.BOLD,14));
        add(fname_text);
        
        JLabel dob = new JLabel("Date Of Birth:");
        dob.setFont(new Font("Tahoma" ,Font.BOLD,20));
        dob.setBounds(100,250,200,30);
        add(dob);
        
        dateChooser = new JDateChooser();
        dateChooser.setBounds(300,250,400,30);
        dateChooser.setForeground(new Color(105,105,105));
        add(dateChooser);
        
        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Tahoma" ,Font.BOLD,20));
        gender.setBounds(100,300,200,30);
        add(gender);
        
        male = new JRadioButton("MALE");
        male.setBounds(300,300,100,30);
        add(male);
        
        female = new JRadioButton("FEMALE");
        female.setBounds(450,300,100,30);
        add(female);
        
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        
        
        JLabel email = new JLabel("Email:");
        email.setFont(new Font("Tahoma" ,Font.BOLD,20));
        email.setBounds(100,350,200,30);
        add(email);
        
        email_text = new JTextField();
        email_text.setBounds(300,350,400,30);
        email_text.setFont(new Font("Arial",Font.BOLD,14));
        add(email_text);
        
        JLabel marital_status = new JLabel("Marital Status:");
        marital_status.setFont(new Font("Tahoma" ,Font.BOLD,20));
        marital_status.setBounds(100,400,200,30);
        add(marital_status);
        
        married = new JRadioButton("MARRIED");
        married.setBounds(300,400,100,30);
        add(married);
        
        unmarried = new JRadioButton("UNMARRIED");
        unmarried.setBounds(450,400,150,30);
        add(unmarried);
        
        
        ButtonGroup marital_status_Group = new ButtonGroup();
        marital_status_Group.add(married);
        marital_status_Group.add(unmarried);
        
        
        JLabel address = new JLabel("Address:");
        address.setFont(new Font("Tahoma" ,Font.BOLD,20));
        address.setBounds(100,450,200,30);
        add(address);
        
        address_text = new JTextField();
        address_text.setBounds(300,450,450,30);
        address_text.setFont(new Font("Arial",Font.BOLD,14));
        add(address_text);
        
        JLabel city = new JLabel("City:");
        city.setFont(new Font("Tahoma" ,Font.BOLD,20));
        city.setBounds(100,500,200,30);
        add(city);
        
        city_text = new JTextField();
        city_text.setBounds(300,500,400,30);
        city_text.setFont(new Font("Arial",Font.BOLD,14));
        add(city_text);
        
        JLabel state = new JLabel("State:");
        state.setFont(new Font("Tahoma" ,Font.BOLD,20));
        state.setBounds(100,550,200,30);
        add(state);
        
        state_text = new JTextField();
        state_text.setBounds(300,550,400,30);
        state_text.setFont(new Font("Arial",Font.BOLD,14));
        add(state_text);
        
        JLabel pincode = new JLabel("Pincode:");
        pincode.setFont(new Font("Tahoma" ,Font.BOLD,20));
        pincode.setBounds(100,600,200,30);
        add(pincode);
        
        pincode_text = new JTextField();
        pincode_text.setBounds(300,600,400,30);
        pincode_text.setFont(new Font("Arial",Font.BOLD,14));
        add(pincode_text);
        
        next = new JButton("NEXT");
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        add(next);
        
        cancel = new JButton("CANCEL");
        cancel.setBounds(100, 660, 80, 30);
        cancel.addActionListener(this);
        add(cancel);
        
        getContentPane().setBackground(Color.WHITE);
        setSize(850,800);
        setLocation(350,50);
        setVisible(true);
        
}
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        String formno =""+random;
        String name = name_text.getText();
        String fname = fname_text.getText();
        String dob = ( (JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected())
        {
            gender="Male";
        }
        else if(female.isSelected()){
            gender="Female";
        }
        String email=email_text.getText();
        String marital_status=null;
        if(married.isSelected())
        {
            marital_status="Married";
        }
        else if(unmarried.isSelected()){
            marital_status="Unmarried";
        }
        String address = address_text.getText();
        String city = city_text.getText();
        String state = state_text.getText();
        String pincode = pincode_text.getText();
        
        try{
            if(ae.getSource()== cancel){
                setVisible(false);
                new Login().setVisible(true);
            }
            else if(dob.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Enter DOB");
            }
            else if(email.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Email is required");
            }
            else if(marital_status.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Enter Marital Status ");
            }
            else if(gender.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Enter Gender ");
            }
            else if(state.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Enter State");
            }
            else if(city.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Enter City");
            }
            else if(pincode.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Enter Pincode");
            }
            else if(address.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Enter Address");
            }
            else if(fname.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Enter Father's name");
            }
            else if(name.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Name is required");
            }
            else{
                Conn c = new Conn();
                String query = "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital_status+"','"+address+"','"+city+"','"+state+"','"+pincode+"')";
                //System.out.println(query);
                c.s.executeUpdate(query);
                
                setVisible(false);
                new SignupTwo(formno).setVisible(true);
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public static void main(String args[]) {
        new SignupOne();
        
    }
}
