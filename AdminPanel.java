import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.*;

public class AdminPanel extends JFrame implements ActionListener {
	

	
	JLabel nameSurname = new JLabel("Name Surname :");
	JLabel address = new JLabel("Address :");
	JLabel city = new JLabel("Cities :");
	JLabel telphone = new JLabel("telephone no :");
	JLabel email= new JLabel("email :");
	JLabel userName = new JLabel("username :");
	JLabel passwd = new JLabel("Password :");
	JLabel re_passwd= new JLabel("Re-enter Password :");
	JLabel passLabel = new JLabel("");
	JLabel accountNumber = new JLabel("Account number :");
	JLabel cardNumber= new JLabel("Card number :");
	JLabel serialNumber = new JLabel("serial number :");
	JLabel expiredDate = new JLabel("Expire date :");
	JLabel securityCode = new JLabel("CVS :");
	JLabel CVSnumber = new JLabel("");
	
	
    JLabel nameWarning = new JLabel("");
    JLabel telWarning = new JLabel("");
		
	JTextField fullNameText = new JTextField();
	JTextField addressText = new JTextField();
	JTextField telephoneText = new JTextField();
	JTextField emailText= new JTextField();
	JTextField userNameText = new JTextField();
	JPasswordField passwdText = new JPasswordField();
	JPasswordField repassText = new JPasswordField();
	JTextField accountNumberText = new JTextField(4);
	JTextField cardNumberText= new JTextField(4);
	JTextField serialNumberText = new JTextField(4);
	JTextField  expiredDateText = new JTextField (4);
	JTextField  securityCodeText = new JTextField(3);
	
	
	JButton submitButton = new JButton("submit");
	JButton clearButton = new JButton("clear");
	
	
	JPanel cardPanel = new JPanel(null);
	JPanel userPanel = new JPanel();
	
	
	char[] pass = passwdText.getPassword();
	
	
	JComboBox cities = new JComboBox();
	String cityText;
	
	
	
	public AdminPanel() {
		// TODO Auto-generated constructor stub
		setTitle("Registration Form");
		setLayout(null);
		setSize(500,450);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		//pack();
		
	    fullNameText.setFocusable(true);
	    nameSurname.setBounds(90, 50, 100, 15);
	    add(nameSurname);
	    fullNameText.setBounds(200, 48, 150, 20);
	    add(fullNameText);
	    
	    nameWarning.setBounds(355, 50, 180, 15);
	     add(nameWarning);
	   
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
	 	 
	accountNumber.setBounds(76, 237, 150, 15);
	 	 add(accountNumber);
	 	accountNumberText.setBounds(200, 237, 64, 20);
	 	 add(accountNumberText);
	 	 
	 	 cardNumber.setBounds(97, 255, 150, 15);
	 	 add(cardNumber);
	 	cardNumberText.setBounds(200, 255, 64, 20);
	 	 add(cardNumberText);
	 	 
	 	 serialNumber.setBounds(90, 277, 150, 15);
	 	 add(serialNumber);
	 	serialNumberText.setBounds(200, 277, 64, 20);
	 	 add(serialNumberText);
	 	 
	 	 expiredDate.setBounds(105, 298, 150, 15);
	 	 add( expiredDate);
	 	 expiredDateText.setBounds(200, 298, 64, 20);
	 	 add( expiredDateText);
	 	 
	 	 securityCode.setBounds(146, 319, 150, 15);
	 	 add(securityCode);
	 	securityCodeText.setBounds(200, 319, 48, 20);
	 	 add(securityCodeText);
	 	 
	 	submitButton.setBounds(200, 350, 80, 20);
	 	add(submitButton);
	 	submitButton.addActionListener(this);
	 	
	 	clearButton.setBounds(285, 350, 70, 20);
	 	add(clearButton);
	 	clearButton.addActionListener(this);
	 	this.getContentPane().setBackground(Color.gray);
		
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//new AdminPanel();

	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getSource()== clearButton){dispose();new AdminPanel();}
		
		if(e.getSource() ==   submitButton){
		
			  
		}
		
		
	}

}