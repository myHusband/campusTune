package cpe513;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.*;

public class login extends JFrame implements ActionListener {
	
	JLabel userName = new JLabel("username :");
	JLabel passwd = new JLabel("Password :");
	
	JTextField userNameText = new JTextField();
	JPasswordField passwdText = new JPasswordField();
	
	JButton submitButton = new JButton("Login");
		
	public login() {
		// TODO Auto-generated constructor stub
		
		setTitle("Login Form");
		setLayout(null);
		setSize(400,250);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	     
	 	 userName.setBounds(75, 100, 80,15);
	 	 userNameText.setBounds(150, 100, 150, 20);
	     add(userNameText);
	 	 add(userName);
	 	 
	     passwd.setBounds(75, 130, 80,15);
	     passwdText.setBounds(150, 130, 150, 20); 
	     add(passwdText);
	     add(passwd);
	  
	 	submitButton.setBounds(150, 160, 80,30);
	 	add(submitButton);
	 	submitButton.addActionListener(this);
	 	this.getContentPane().setBackground(Color.gray);
		
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new login();

	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
		if(e.getSource() ==   submitButton){
			
			dbConnection db = new dbConnection();
			
			try{
				db.getDataFromMysql();
				String Password = String.copyValueOf(passwdText.getPassword());
				
				if((db.userVector.contains(userNameText.getText())) && (db.passwordVector.contains(Password)) && 
						userNameText.getText().equals("admin")  &&  Password.equals("admin")){
					dispose();
					new AdminPaneL();
					
    			}
				
				else if((db.userVector.contains(userNameText.getText())) && (db.passwordVector.contains(Password))	)
				{
					dispose();
					new ProductForm(); }
				
				else if((db.userVector.contains(userNameText.getText())) && !(db.passwordVector.contains(Password)) ){
					JOptionPane.showMessageDialog(null, " Invalid Password   " ,"ERROR_ON_PASSWORD",JOptionPane.ERROR_MESSAGE);
				}
				else {JOptionPane.showMessageDialog(null, "Invalid username  ","ERROR_ON_USERNAME",JOptionPane.ERROR_MESSAGE);}
				
				
			}catch(Exception ee){System.out.println(ee.toString());}
			
		}
		
		
	}

}