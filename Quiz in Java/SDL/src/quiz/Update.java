package quiz;

import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import javax.swing.*;

public class Update extends JFrame implements ActionListener
{
	JTextField t1,t3,t4,t5;
	JLabel l1,l3,l4,l5,l;
	JButton b1,b2;
	
	public Update()
	{
		setLayout(null);
		setLayout(new BorderLayout());
		JLabel background=new JLabel(new ImageIcon("545909.jpg"));
		l=new JLabel("Update Information..");
		l1=new JLabel("Email-id");
		t1=new JTextField(30);
		l3=new JLabel("UserName");
		t3=new JTextField(30);
		l4=new JLabel("Password");
		t4=new JTextField(30);
		l5=new JLabel("Type Again Password");
		t5=new JTextField(30);
		b1=new JButton("Update");
		b2=new JButton("Exit");
		
		Font myFont = new Font("Courier", Font.ITALIC,30);
		l.setFont(myFont);
		
add(background);
		background.add(l);
		background.add(l1);
		background.add(t1);
		background.add(l3);
		background.add(t3);
		background.add(l4);
		background.add(t4);
		background.add(l5);
		background.add(t5);
		background.add(b1);
		background.add(b2);
		
		l.setForeground(Color.black);
		l1.setForeground(Color.black);
		l3.setForeground(Color.black);
		l4.setForeground(Color.black);
		l5.setForeground(Color.black);
		
		b2.setForeground(Color.BLACK);
		l1.setBackground(Color.MAGENTA);
		b1.setBackground(Color.GREEN);
		b2.setBackground(Color.RED);
		
		setSize(1400,720);
		setTitle("SignUp Page");
		setVisible(true);
		
		l.setBounds(100,100,500,30);
		l1.setBounds(450,200,200,30);
		t1.setBounds(600,200,200,30);
		l3.setBounds(450,250,200,30);
		t3.setBounds(600,250,200,30);
		l4.setBounds(450,300,200,30);
		t4.setBounds(600,300,200,30);
		l5.setBounds(450,350,200,30);
		t5.setBounds(600,350,200,30);
		b1.setBounds(450,450,150,30);
		b2.setBounds(650,450,150,30);
		
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
        	String email=t1.getText();
        	String password=t4.getText();
        	String user=t3.getText();
        	
        	st.executeUpdate("update login set Email='"+email+"',Password='"+password+"' where UserName='"+user+"';");
            JOptionPane.showMessageDialog(null,"Updated");
        	t1.setText("");
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
	Update s=new Update();
}
}