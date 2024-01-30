package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener{

    JTextField pan_text,aadhar_text;
    JRadioButton yes_senior_citizen, No_senior_citizen,yes_existing_account,No_existing_account;
    JComboBox religion_combobox, category_combobox, income_combobox, qualification_combobox,occupation_combobox;
    String formno;
    JButton next, cancel;

    SignupTwo(String formno){
        
        setLayout(null);
        
        this.formno=formno;
         
        JLabel additionaldetails = new JLabel("Page 2: Additional Details");
        additionaldetails.setFont(new Font("Tahoma" ,Font.BOLD,30));
        additionaldetails.setBounds(270,100,400,40);
        add(additionaldetails);
        
        
        JLabel religion = new JLabel("Religion:");
        religion.setFont(new Font("Tahoma" ,Font.BOLD,20));
        religion.setBounds(100,150,200,30);
        add(religion);
        
        String valreligion[] = {"Hindu","Christian","Muslim","Sikh","Jain","Other"};
        religion_combobox = new JComboBox(valreligion);
        religion_combobox.setBackground(Color.WHITE);
        religion_combobox.setBounds(300,150,400,30);
        add(religion_combobox);
        
        JLabel category = new JLabel("Category:");
        category.setFont(new Font("Tahoma" ,Font.BOLD,20));
        category.setBounds(100,200,150,30);
        add(category);
        
        String valcategory[] = {"General","SC","ST","Other"};
        category_combobox = new JComboBox(valcategory);
        category_combobox.setBackground(Color.WHITE);
        category_combobox.setBounds(300,200,400,30);
        add(category_combobox);
        
        JLabel income = new JLabel("Income:");
        income.setFont(new Font("Tahoma" ,Font.BOLD,20));
        income.setBounds(100,250,200,30);
        add(income);
        
        String valincome[] = {"Null","< 1,00,00","< 3,00,000","< 5,00,000","< 10,00,000","> 10,00,000"};
        income_combobox = new JComboBox(valincome);
        income_combobox.setBackground(Color.WHITE);
        income_combobox.setBounds(300,250,400,30);
        add(income_combobox);
        
        JLabel qualification = new JLabel("Qualification:");
        qualification.setFont(new Font("Tahoma" ,Font.BOLD,20));
        qualification.setBounds(100,300,150,30);
        add(qualification);
        
        String valqualification[] = {"NONE","Senior secondary","Undergraduate","Postgraduate","Doctrate"};
        qualification_combobox = new JComboBox(valqualification);
        qualification_combobox.setBackground(Color.WHITE);
        qualification_combobox.setBounds(300,300,400,30);
        add(qualification_combobox);
        
        JLabel occupation = new JLabel("Occupation:");
        occupation.setFont(new Font("Tahoma" ,Font.BOLD,20));
        occupation.setBounds(100,350,200,30);
        add(occupation);
        
        String valoccupation[] = {"Student","Unemployeed","self-employeed","Private Sector","Public Sector","Defence","Other"};
        occupation_combobox = new JComboBox(valoccupation);
        occupation_combobox.setBackground(Color.WHITE);
        occupation_combobox.setBounds(300,350,400,30);
        add(occupation_combobox);
        
        JLabel pan = new JLabel("PAN number:");
        pan.setFont(new Font("Tahoma" ,Font.BOLD,20));
        pan.setBounds(100,400,200,30);
        add(pan);
        
        pan_text = new JTextField();
        pan_text.setBounds(300,400,400,30);
        pan_text.setFont(new Font("Arial",Font.BOLD,14));
        add(pan_text);
        
        JLabel aadhar = new JLabel("Aadhar number:");
        aadhar.setFont(new Font("Tahoma" ,Font.BOLD,20));
        aadhar.setBounds(100,450,200,30);
        add(aadhar);
        
        aadhar_text = new JTextField();
        aadhar_text.setBounds(300,450,400,30);
        aadhar_text.setFont(new Font("Arial",Font.BOLD,14));
        add(aadhar_text);
        
        JLabel seniorCitizen = new JLabel("Senior Citizen:");
        seniorCitizen.setFont(new Font("Tahoma" ,Font.BOLD,20));
        seniorCitizen.setBounds(100,500,300,30);
        add(seniorCitizen);
        
        yes_senior_citizen = new JRadioButton("Yes");
        yes_senior_citizen.setBounds(300,500,100,30);
        add(yes_senior_citizen);
        
        No_senior_citizen = new JRadioButton("No");
        No_senior_citizen.setBounds(450,500,100,30);
        add(No_senior_citizen);
        
        ButtonGroup seniorCitizenGroup = new ButtonGroup();
        seniorCitizenGroup.add(yes_senior_citizen);
        seniorCitizenGroup.add(No_senior_citizen);
                
        JLabel existingAccount = new JLabel("Existing Account:");
        existingAccount.setFont(new Font("Tahoma" ,Font.BOLD,20));
        existingAccount.setBounds(100,550,300,30);
        add(existingAccount);
        
        yes_existing_account = new JRadioButton("Yes");
        yes_existing_account.setBounds(300,550,100,30);
        add(yes_existing_account);
        
        No_existing_account = new JRadioButton("No");
        No_existing_account.setBounds(450,550,100,30);
        add(No_existing_account);
        
        ButtonGroup existiongAccountGroup = new ButtonGroup();
        existiongAccountGroup.add(yes_existing_account);
        existiongAccountGroup.add(No_existing_account);
        
        next = new JButton("NEXT");
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        add(next);
        
        cancel = new JButton("CANCEL");
        cancel.setBounds(100, 660, 80, 30);
        cancel.addActionListener(this);
        add(cancel);
        
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);
        setSize(850,800);
        setLocation(350,50);
    }
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        String religion = (String) religion_combobox.getSelectedItem();
        String income = (String) income_combobox.getSelectedItem();
        String category = (String) category_combobox.getSelectedItem();
        String occupation = (String) occupation_combobox.getSelectedItem();
        String qualification = (String) qualification_combobox.getSelectedItem();
        String pan = pan_text.getText();
        String aadhar = aadhar_text.getText();
        String existing_account = null;
        if(ae.getSource()==cancel)
        {
            setVisible(false);
            new Login().setVisible(true);
        }
        if(yes_existing_account.isSelected())
        {
            existing_account="Yes";
        }
        else if(No_existing_account.isSelected()){
            existing_account="No";
        }
        String senior_citizen = null;
        if(yes_senior_citizen.isSelected())
        {
            existing_account="Yes";
        }
        else if(No_senior_citizen.isSelected()){
            existing_account="No";
        }
        try{
            Conn c = new Conn();
            String query = "insert into signuptwo values('"+formno+"','"+religion+"','"+category+"','"+income+"','"+qualification+"','"+occupation+"','"+pan+"','"+aadhar+"','"+senior_citizen+"','"+existing_account+"')";
            //System.out.println(query);
            c.s.executeUpdate(query);
            setVisible(false);
            new SignupThree(formno).setVisible(true);
            }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
  
    
    public static void main(String args[]) {
        new SignupTwo("");
    }
}
