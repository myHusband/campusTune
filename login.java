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
	JPanel headerPanel = new JPanel();
	JLabel headerLabel = new JLabel("");
	
	
	
	ImageIcon icon = new ImageIcon("images\\login\\login3.jpg");
		
	public login() {
		// TODO Auto-generated constructor stub
		
		setTitle("Login Form");
		setLayout(null);
		setSize(400,250);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	   headerLabel.setBounds(10,50, 150, 98);
	   add(headerLabel);
	   headerLabel.setIcon(icon);
	 	 userName.setBounds(160, 50, 70,15);
	 	 userNameText.setBounds(230, 50, 150, 20);
	     add(userNameText);
	 	 add(userName);
	     passwd.setBounds(160, 68, 80,15);
	     passwdText.setBounds(230, 68, 150, 20); 
	     add(passwdText);
	     add(passwd);
	 	submitButton.setBounds(230, 90, 80,30);
	 	add(submitButton);
	 	submitButton.addActionListener(this);
		//this.getContentPane().setBackground(Color.gray);
	 	
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
			String Password = String.copyValueOf(passwdText.getPassword());
			try{
				db.getDataFromMysql(userNameText.getText(),Password);
				if((db.userArrayList.contains(userNameText.getText())) && (db.passwordArrayList.contains(Password)) && 
						userNameText.getText().equals("admin")  &&  Password.equals("admin")){
					dispose();
					new AdminPanel();	
    			}
				else if((db.userArrayList.contains(userNameText.getText())) && (db.passwordArrayList.contains(Password))	)
				{
					dispose();
					//new ProductForm();
					}
				else if((db.userArrayList.contains(userNameText.getText())) && !(db.passwordArrayList.contains(Password)) ){
					JOptionPane.showMessageDialog(null, " Invalid Password   " ,"ERROR_ON_PASSWORD",JOptionPane.ERROR_MESSAGE);
				}
				else 
				{JOptionPane.showMessageDialog(null, "Invalid username  ","ERROR_ON_USERNAME",JOptionPane.ERROR_MESSAGE);}	
			}catch(Exception ee)
			{System.out.println(ee.toString());}
			
		}
		
		
	}

	



}