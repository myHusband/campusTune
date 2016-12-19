

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.*;

public class loginForm extends JFrame implements ActionListener {
	
	

	JLabel userName = new JLabel("username :");
	JLabel passwd = new JLabel("Password :");
	
	JTextField userNameText = new JTextField();
	JPasswordField passwdText = new JPasswordField();
	
	
	
	JButton submitButton = new JButton("Login");
	

	
	char[] pass = passwdText.getPassword();
	
	

	
	
	public loginForm() {
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
		new loginForm();

	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
		if(e.getSource() ==   submitButton){
			
				 dbConnection db = new dbConnection();
				 
			  //db.createConnection();
			  try {
				db.getDataFromMysql();
				String Password = String.copyValueOf(passwdText.getPassword());
				
				if(userNameText.getText().equals(db.userText) && Password.equals(db.Password)){
    				//new ProductForm();
    			
    			}
    			else 
    				if(userNameText.getText().equals(db.userText) && Password.equals(db.Password) && 
    						userNameText.getText().equals("admin")  &&  Password.equals("admin")){
	    				AdminPanel ad = new AdminPanel();
					ad.show();
	    				//ad.setVisible(true);
	    				
	    			}
    				else 
        				if(userNameText.getText().equals(db.userText) && !Password.equals(db.Password) 
        						){
        					JOptionPane.showMessageDialog(null, "Invalid Password with  " +userNameText.getText());
    	    				
    	    				
    	    			}
				
				
    			else {JOptionPane.showMessageDialog(null, "Invalid user with username " +userNameText.getText());}
				
			
			} catch (SQLException | ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			  
		}
		
		
	}

}
