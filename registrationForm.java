package cpe513;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.*;

public class registrationForm extends JFrame implements ActionListener {
	

	
	JLabel nameSurname = new JLabel("Name Surname :");
	JLabel address = new JLabel("Address :");
	JLabel city = new JLabel("Cities :");
	JLabel telphone = new JLabel("telephone no :");
	JLabel email= new JLabel("email :");
	JLabel userName = new JLabel("username :");
	JLabel passwd = new JLabel("Password :");
	JLabel re_passwd= new JLabel("Re-enter Password :");
	JLabel passLabel = new JLabel("");
	JLabel accountNumber = new JLabel(" Card number:");
	
	
	JLabel securityCode = new JLabel("CVC :");
	
	
	
   
    JLabel telWarning = new JLabel("");
		
	JTextField fullNameText = new JTextField();
	JTextField addressText = new JTextField();
	JTextField telephoneText = new JTextField();
	JTextField emailText= new JTextField();
	JTextField userNameText = new JTextField();
	JPasswordField passwdText = new JPasswordField();
	JPasswordField repassText = new JPasswordField();
	JTextField cardPart1 = new JTextField("####");
	JTextField  cardPart2= new JTextField("####");
	JTextField  cardPart3 = new JTextField("####");
	JTextField   cardPart4 = new JTextField ("####");
	JTextField  securityCodeText = new JTextField("###");
	
	
	JButton submitButton = new JButton("submit");
	JButton clearButton = new JButton("clear");
	
	JLabel carddetailLabel= new JLabel("");
	JLabel cardImage = new JLabel("");
	
	JLabel cvsLabel = new JLabel("");
	
	JPanel cardPanel = new JPanel(null);
	JPanel userPanel = new JPanel();
	
	
	char[] pass = passwdText.getPassword();
	
	
	JComboBox cities = new JComboBox();
	String cityText;
	
	ImageIcon icon2 = new ImageIcon("images\\login\\acceptance_marks_offline_trays_clear_UK_198x50mm.jpg");
	ImageIcon icon = new ImageIcon("images\\login\\cvc_visa.gif");
	public registrationForm() {
		// TODO Auto-generated constructor stub
		setTitle("Registration Form");
		setLayout(null);
		setSize(450,400);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		//pack();
		
	    fullNameText.setFocusable(true);
	    nameSurname.setBounds(90, 50, 100, 15);
	    add(nameSurname);
	    fullNameText.setBounds(200, 48, 150, 20);
	    add(fullNameText);
	    
	   
	   
	     address.setBounds(130, 73,80, 15);
	     add(address);
	     addressText.setBounds(200, 70,150, 20);
	     add(addressText);
	     
	     cities.setBounds(200, 95,100, 25);
	     cities.addItem("-------------");
	     cities.addItem("Nicosia");
	     cities.addItem("Kyrenia");
	     cities.addItem("Famagusta");
	     cities.addItem("Morphou");
	     cities.addItem("Lefke");
	     city.setBounds(140, 105, 50, 15);
	     add(cities);
	     add(city);
	     
	     
	     telphone.setBounds(97, 130, 80,15);
	     telephoneText.setBounds(200, 129, 150, 20);
	     telWarning.setBounds(370, 130, 200, 15);
	    // telWarning.setText("****Only number allowed here****");
	     telWarning.setForeground(Color.white);
	     add(telWarning);
	     add(telphone);
	     add(telephoneText);
	     
	     email.setBounds(140, 150, 80,15);
	     emailText.setBounds(200, 150, 150, 20);
	     add(emailText);
	     add(email);
	     
	 	 userName.setBounds(115, 170, 80,15);
	 	 userNameText.setBounds(200, 170, 150, 20);
	     add(userNameText);
	 	 add(userName);
	 	 
	     passwd.setBounds(115, 190, 80,15);
	     passLabel.setBounds(355, 190, 220, 20);
	     passLabel.setForeground(Color.red);
	     passwdText.setBounds(200, 190, 150, 20);
	     add(passLabel);
	     add(passwdText);
	     add(passwd);
	     
	     
	 	 re_passwd.setBounds(62, 210, 120,15);
	 	repassText.setBounds(200, 210, 150, 20);
	     add(repassText);
	 	 add(re_passwd);
	 	 
		 cardImage.setBounds(200, 231, 150, 25);
	 	 add(cardImage);
	 	 cardImage.setIcon(icon2);
	 	 
	 	 accountNumber.setBounds(100, 257, 150, 15);
	 	 add(accountNumber);
	 	 cardPart1 .setBounds(200, 257, 38, 20);
	 	 add( cardPart1 );
	 	 cardPart1 .setColumns(4);
	 	
	 	 cardPart2 .setBounds(239, 257, 38, 20);
	 	 add(cardPart2);
	 	cardPart2.setColumns(4);
	 	 
	 	 
	 	cardPart3.setBounds(278, 257, 38, 20);
	 	 add(cardPart3);
	 	cardPart3.setColumns(4);
	 	 
	 	
	 	cardPart4.setBounds(317, 257, 38, 20);
	 	 add( cardPart4);
	 	 
	 	 securityCode.setBounds(150, 282, 150, 15);
	 	 add(securityCode);
	 	securityCodeText.setBounds(200, 282, 32, 20);
	 	 add(securityCodeText);
	 	 
	 	 cvsLabel.setBounds(235, 277, 150, 30);
	 	 add(cvsLabel);
	 	 cvsLabel.setIcon(icon);
	 	 
	 	 
	 	submitButton.setBounds(200, 320, 80, 20);
	 	add(submitButton);
	 	submitButton.addActionListener(this);
	 	
	 	clearButton.setBounds(285, 320, 70, 20);
	 	add(clearButton);
	 	clearButton.addActionListener(this);
	 	//this.getContentPane().setBackground(Color.gray);
		
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new registrationForm();

	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getSource()== clearButton){dispose();new registrationForm();}
		
		if(e.getSource() ==   submitButton){
			  auxillaryClass aux = new auxillaryClass();
			  
			  aux.validateRegistrationForm(fullNameText.getText(),addressText.getText(),cities.getSelectedIndex(),telephoneText.getText(),
					  emailText.getText(),userNameText.getText(),passwdText.getPassword(),repassText.getPassword(),
					  cardPart1.getText(),cardPart2.getText(),cardPart3.getText(),
					  cardPart4.getText(),securityCodeText.getText());
			  aux.cityToString(cities.getSelectedIndex());
			 // dispose();
			  	  
		}
		
		
	}

}
