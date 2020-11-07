package quiz;

import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import javax.swing.*;

public class Delete extends JFrame implements ActionListener
{
	JTextField t1,t2,t3,t4,t5;
	JLabel l1,l2,l3,l4,l5;
	JButton b1,b2;
	
	public Delete()
	{
		setLayout(null);
		JLabel background=new JLabel(new ImageIcon("545909.jpg"));
		l1=new JLabel("Delete Account...");
		l3=new JLabel("UserName");
		t3=new JTextField(30);
		l4=new JLabel("Password");
		t4=new JTextField(30);
		l5=new JLabel("Type Again Password");
		t5=new JTextField(30);
		b1=new JButton("Delete");
		b2=new JButton("Exit");
		
		add(l1);
		add(l3);
		add(t3);
		add(l4);
		add(t4);
		add(l5);
		add(t5);
		add(b1);
		add(b2);
		
		Font myFont = new Font("Courier", Font.ITALIC,30);
		l1.setFont(myFont);
		l1.setForeground(Color.red);
		
		setSize(1400,720);
		setTitle("Delete Account");
		setVisible(true);
		
		l1.setBounds(450,200,400,30);
		l3.setBounds(450,300,200,30);
		t3.setBounds(600,300,200,30);
		l4.setBounds(450,350,200,30);
		t4.setBounds(600,350,200,30);
		l5.setBounds(450,400,200,30);
		t5.setBounds(600,400,200,30);
		b1.setBounds(450,550,150,50);
		b2.setBounds(650,550,150,50);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
	
		}
	
public void actionPerformed(ActionEvent ae)
{
	try
	{
		PreparedStatement pst;
        Connection cn=DriverManager.getConnection("Jdbc:mysql://localhost:3306/test?useSSL=false","root","123456");
        
        Statement st=cn.createStatement();
        if(ae.getSource()==b1)
        {
        	
        	String user=t3.getText();
        	
        	st.executeUpdate("delete from login where username='"+user+"';");
            JOptionPane.showMessageDialog(null,"Updated");
        	t3.setText("");
        	t4.setText("");
        	t5.setText("");
            cn.close();
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
	Delete s=new Delete();
}
}