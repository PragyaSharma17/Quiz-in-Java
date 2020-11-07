package quiz;

import java.awt.event.*;
import java.awt.Color.*;
import java.awt.*;
import java.sql.*;
import javax.swing.*;

public class LoginSucc extends JFrame implements ActionListener,ItemListener
{
	JLabel l1,l2;
	JButton b1,b2,b3,b4;
	Checkbox c1,c2,c3;
	CheckboxGroup cd;
	
	public LoginSucc()
	{
		setLayout(null);
		setLayout(new BorderLayout());
		JLabel background=new JLabel();
		cd = new CheckboxGroup();
		l1=new JLabel("APPLY FOR TSETS:");
		l2=new JLabel("");
		b1=new JButton("Apply");
		b2=new JButton("Update_Info..");
		b4=new JButton("<--BACK");
		b3=new JButton("Delete_Acc..");
		c1=new Checkbox("C",cd,false);
		c2=new Checkbox("CPP",cd,false);
		c3=new Checkbox("JAVA",cd,false);
		
		Font myFont = new Font("Courier", Font.ITALIC,30);
	    l1.setFont(myFont);
	    
	   
				
	    add(background);
	    background.add(b4);
	    background.add(l1);
	    background.add(b1);
	    background.add(c1);
	    background.add(c2);
	    background.add(c3);
	    background.add(b2);
	    background.add(b3);
	    
	    
	    setBackground(Color.green);
	    setSize(1400,720);
		setTitle("LoginPage");
		setVisible(true);
		
	
		l1.setForeground(Color.BLACK);
		c1.setForeground(Color.white);
		c2.setForeground(Color.white);
		c3.setForeground(Color.white);
		b1.setForeground(Color.white);
		b2.setForeground(Color.white);
		b3.setForeground(Color.white);
		b4.setForeground(Color.white);
		

		l1.setBackground(Color.MAGENTA);
		c1.setBackground(Color.pink);
		c2.setBackground(Color.orange);
		c3.setBackground(Color.YELLOW);
		b1.setBackground(Color.GREEN);
		b2.setBackground(Color.MAGENTA);
		b3.setBackground(Color.cyan);
		b4.setBackground(Color.BLACK);
	
		
		
		
		
		l1.setBounds(350,150,500,30);
		b1.setBounds(500,400,100,30);
		c1.setBounds(400,250,100,30);
		c2.setBounds(400,300,100,30);
		c3.setBounds(400,350,100,30);
		b2.setBounds(400,600,150,50);
		b3.setBounds(700,600,150,50);
		b4.setBounds(100,100,150,50);
		
		
		c1.addItemListener(this);
		c2.addItemListener(this);
		c3.addItemListener(this);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		
		
	    
		
		}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getSource()==b1)
		{
			if(c1.getState()==true)
			{
				Cprog p=new Cprog("Test of C");
			}
			if(c2.getState()==true)
			{
				Cppprog x=new Cppprog("Test of Cpp");
		    }
			if(c3.getState()==true)
			{
				Javaprog j=new Javaprog("Test of Java");
			}
		
		}
		if(ae.getSource()==b2)
		{
			new Update();
			setVisible(false);
		}
		if(ae.getSource()==b3)
		{
			new Delete();
			setVisible(false);
		}
		if(ae.getSource()==b4)
		{
			new Frame1();
			setVisible(false);
		}
		
				
	}
	public static void main(String a[])
	{
		
		LoginSucc obj= new LoginSucc();
	}
}