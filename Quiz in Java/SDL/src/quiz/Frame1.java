package quiz;

import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import javax.swing.*;

public class Frame1 extends JFrame implements ActionListener
{
		private static final long serialVersionUID = 1L;
	JTextField t1;
	TextField t2;
	JLabel l1,l2;
	JButton b1,b2,b3;
	int k=0;
	
	public Frame1()
	{
			setLayout(null);
			setLayout(new BorderLayout());
			JLabel background=new JLabel();
			l1=new JLabel("User Name");
			l2= new JLabel("Password");
			t1=new JTextField(20);
			t2=new TextField(20);
			b1=new JButton("Login");
			b2=new JButton("SignIn");
			b3=new JButton("Exit");
			
			l1.setForeground(Color.white);
			l2.setForeground(Color.white);
			
			Font myFont = new Font("Courier", Font.BOLD,15);
		    t1.setFont(myFont);
		    t2.setEchoChar('*');
		    b1.setFont(myFont);
		    b2.setFont(myFont);
		    b3.setFont(myFont);
			l1.setFont(myFont);
			l2.setFont(myFont);
			
			
		    add(background);
			background.add(l1);
			background.add(t1);
			background.add(l2);
			background.add(t2);
			background.add(b1);
			background.add(b2);
			background.add(b3);
			
			l2.setForeground(Color.BLACK);
			l1.setForeground(Color.BLACK);
			b1.setForeground(Color.white);
			b2.setForeground(Color.BLACK);
			b3.setForeground(Color.white);
			
			l2.setBackground(Color.BLACK);
			l1.setBackground(Color.MAGENTA);
			b1.setBackground(Color.GREEN);
			b2.setBackground(Color.yellow);
			b3.setBackground(Color.RED);
			
			setSize(1400,720);
			setTitle("LoginPage");
			setVisible(true);
			
			l1.setBounds(750,200,200,30);
			t1.setBounds(850,200,200,30);
			l2.setBounds(750,300,100,30);
			t2.setBounds(850,300,200,30);
			b1.setBounds(750,400,100,30);
			b2.setBounds(900,400,100,30);
			b3.setBounds(800,600,200,30);
			
			b1.addActionListener(this);
			b2.addActionListener(this);
			b3.addActionListener(this);
			
			
	}
	public static void main(String ar[])
	{
		Frame1 s=new Frame1();
	}
	@Override
	public void actionPerformed(ActionEvent ae)
	{
		try
		{
		 PreparedStatement pst;
         Connection cn=DriverManager.getConnection("Jdbc:mysql://localhost:3306/test?useSSL=false","root","123456");
         
         Statement st=cn.createStatement();
		
		
				if(ae.getSource()==b1)
					
				{
					String s1,s2;
					s1=t1.getText();
		    		s2=t2.getText();
		    		k++;
		    		if(s1.equals(""))
		    		{
			    	    JOptionPane.showMessageDialog(null,"Enter username");
			             return;
			    	 }
		    		else if(!s1.equals("") && s2.equals(""))
					{
		              JOptionPane.showMessageDialog(null,"Enter Password");
		              return;
		            }
		    		if(k==4)
		    		{
		    		   JOptionPane.showMessageDialog(null,"You reaches max limit of Login!");
		    	       System.exit(0);
		    	    }
		    		
		    		String Lname,Lpass;
		    		String usernameFetchString = "select * from login where username='"+s1+"'";
		            
    			  	ResultSet rs=st.executeQuery(usernameFetchString);
    			  	
    			  	while(rs.next())
    			  		{
    			  			Lname=(rs.getString(1));
    			  			Lpass=(rs.getString(2));
      
    			  				if(Lname.equals(s1) && Lpass.equals(s2))
    			  					{
    			  						JOptionPane.showMessageDialog(null,"Login ! Successfull");
    			  						LoginSucc swings = new LoginSucc();
    			  						setVisible(false);
    			  						return ;
    			  					}
    			  				else if(Lname.equals(s1) && !Lpass.equals(s2))
    			  				  	{
    			  					     JOptionPane.showMessageDialog(null,"Wrong Password !");
    			  					   if(k==3){
    			  							
    			  			    	      JOptionPane.showMessageDialog(null,"You reaches max limit ! Try Forgot Password!");

    			  			    		}
    			  					     return ;
    			  				  	}
          
    		  			}

    		  			JOptionPane.showMessageDialog(null,"User does not Exit! Go with SignIn\n" + usernameFetchString);

    		  			rs.close();
    		  			
				}
				cn.close();	
			}
		catch(Exception e)
		{
			System.out.println("Eror:"+e);
		}
		if(ae.getSource()==b2)
		{
			new SignUP();
			setVisible(false);
		}
		
		
		if(ae.getSource()==b3)
		{
			System.exit(0);
		}
		
		
	}
	
}