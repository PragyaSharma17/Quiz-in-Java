package quiz;

import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import javax.swing.*;

public class SignUP extends JFrame implements ActionListener
{
	JTextField t1,t2,t3,t4,t5;
	JLabel l1,l2,l3,l4,l5;
	JButton b1,b2;
	
	public SignUP()
	{
		setLayout(null);
		setLayout(new BorderLayout());
		JLabel background=new JLabel();
		l1=new JLabel("Email-id");
		l2= new JLabel("MobileNo");
		t1=new JTextField(30);
		t2=new JTextField(30);
		l3=new JLabel("UserName");
		t3=new JTextField(30);
		l4=new JLabel("Password");
		t4=new JTextField(30);
		l5=new JLabel("Type Again Password");
		t5=new JTextField(30);
		b1=new JButton("SignIn");
		b2=new JButton("Exit");
		add(background);
		
		background.add(l1);
		background.add(t1);
		background.add(l2);
		background.add(t2);
		background.add(l3);
		background.add(t3);
		background.add(l4);
		background.add(t4);
		background.add(l5);
		background.add(t5);
		background.add(b1);
		background.add(b2);
		
		setSize(1400,720);
		setTitle("SignUp Page");
		setVisible(true);
		l2.setForeground(Color.BLACK);
		l1.setForeground(Color.BLACK);
		l3.setForeground(Color.BLACK);
		l4.setForeground(Color.BLACK);
		l5.setForeground(Color.BLACK);
		
		b2.setForeground(Color.BLACK);
		b1.setBackground(Color.GREEN);
		b2.setBackground(Color.RED);
		l1.setBounds(450,200,200,30);
		t1.setBounds(600,200,200,30);
		l2.setBounds(450,250,200,30);
		t2.setBounds(600,250,200,30);
		l3.setBounds(450,300,200,30);
		t3.setBounds(600,300,200,30);
		l4.setBounds(450,350,200,30);
		t4.setBounds(600,350,200,30);
		l5.setBounds(450,400,200,30);
		t5.setBounds(600,400,200,30);
		b1.setBounds(450,450,150,30);
		b2.setBounds(600,450,150,30);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
	
		}
	
public void actionPerformed(ActionEvent ae)
{
	try
	{
		PreparedStatement pst;
        Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useSSL=false","root","123456");


	    System.out.println("Connected");
	    
        Statement st=cn.createStatement();
        if(ae.getSource()==b1)
        {
        	 pst=cn.prepareStatement("insert into login values(?,?,?,? )");
        	 String Email=t1.getText();
        	 String MobileNo=t2.getText();
        	 String UserName=t3.getText();
        	 String Password=t4.getText();
        	 String Password1=t5.getText();
        	 
        	 if(Email.equals("") ||MobileNo.equals("")||UserName.equals("")||Password.equals("")||Password1.equals(""))
				{
		  			JOptionPane.showMessageDialog(null,"Fill Fields !");
		  			return ;
				}
        	 if(Password.equals(Password1))
        	 {
        		 System.out.println("Passwords are same");
        	 }
        	 else
        	 {
        		 JOptionPane.showMessageDialog(null,"Password Dosen't Match!");
        	 }
        	 String Lname,Lpass;
			  	  ResultSet check=st.executeQuery("select * from login where username='"+UserName+"'");
			  	  while(check.next())
			  	  {
			  	  		Lname=(check.getString(1));
			  	  							
			  	  		 if(Lname.equals(UserName))
					      {
			  	  			JOptionPane.showMessageDialog(null,"UserName availabel");
			  	 					return ;
			  	  		   }//Duplicate entry checking
			  	  }
			  	  
			  	  
			  	  pst.setString(1,UserName);
			  	  pst.setString(2,Password);
			  	  pst.setString(3,MobileNo);
			  	  pst.setString(4, Email);
			  	  pst.executeUpdate();
			   	  t1.setText("");
                  t2.setText("");
                  t3.setText("");
                  t4.setText("");
                  t5.setText("");
                  Frame1 f=new Frame1();
        }
        
        if(ae.getSource()==b2)
        {
        	System.exit(0);
        }
		
	}
	catch(Exception e)
	{
		System.out.println("Eror:"+e);
	}
	
}

public static void main(String ar[])
{
	SignUP s=new SignUP();
}
}