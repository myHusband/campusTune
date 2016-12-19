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
	

	
	char[] pass = passwdText.getPassword();
	
	

	
	
	public login() {
		// TODO Auto-generated constructor stub
		setTitle("Login Form");
		setLayout(null);
		setSize(600,450);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	     
	 	 userName.setBounds(115, 170, 80,15);
	 	 userNameText.setBounds(200, 170, 150, 20);
	     add(userNameText);
	 	 add(userName);
	 	 
	     passwd.setBounds(115, 190, 80,15);
	  
	     passwdText.setBounds(200, 190, 150, 20);
	    
	     add(passwdText);
	     add(passwd);
	     
	     
	 	
	 	 
	 	submitButton.setBounds(200, 225, 80,30);
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
			  //db.createConnection();
			  try {
				db.getDataFromMysql(userNameText.getText(),passwdText.getPassword());
			} catch (SQLException | ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			  
		}
		
		
	}

}
