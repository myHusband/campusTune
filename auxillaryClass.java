package cpe513;

import java.util.Arrays;
import java.sql.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;

public class auxillaryClass {

	Connection conn  ;
	Statement stmt;
	String fullnameT = null;
	String adressT;String city = null ; long telNumber;String emailT = null;String userText= null;
	char[] passText;char[] repasswordText;String Password= null;
	 int accNumber ;  int cardNumber;int serialNumber ; int expireNumber;int secureNumber ;
	
	 
	 dbConnection dbConn = new dbConnection();

	public void submitMethod(String fullname,String adress,int selectedIndex,String tele,String mail,String user,
			char[] pass,char[] repass,String  accntNo,String cardNo,String SerialNo,String expireNo,String cvsNo)
	{
		
		 
		if(fullname.equals(""))
JOptionPane.showMessageDialog(null,"Please Enter Your Full Name","ERROR_ON_NAME_SURNAME",JOptionPane.ERROR_MESSAGE);

else
{
	 fullnameT  = fullname;
	
	if(adress.equals(""))
JOptionPane.showMessageDialog(null,"Please Enter Your Home Address","ERROR_ON_ADDRESS",JOptionPane.ERROR_MESSAGE);
else {
	
	 adressT = adress;
	if(selectedIndex<= 0)
		JOptionPane.showMessageDialog(null,"Please Select Your Cities from comboBox","ERROR_ON_CITIES",JOptionPane.ERROR_MESSAGE);
else{
	city =cityToString(selectedIndex);
	
	if(tele.equals(""))
		JOptionPane.showMessageDialog(null,"Please enter Your Phone number","ERROR_ON_PHONE_NUMBER",JOptionPane.ERROR_MESSAGE);
	
	else {
		
		try{
		 String telText = tele;
		 if(tele.length() > 21){
			 JOptionPane.showMessageDialog(null,"Please enter less than 20 number in telephone","ERROR_ON_PHONE_NUMBER",JOptionPane.ERROR_MESSAGE);
			 }
		 else
		 {
			telNumber = Long.parseLong(telText);
			 

				if(mail.equals(""))
					JOptionPane.showMessageDialog(null,"Please enter Your valid Email","ERROR_ON_EMAIL",JOptionPane.ERROR_MESSAGE);
				else
				{
					 emailT = mail;
					
					
					if(emailValidation(mail)== false){
						JOptionPane.showMessageDialog(null,"Please make sure your mail contains both @ and .","ERROR_ON_EMAIL",JOptionPane.ERROR_MESSAGE);
					}
					else{
						if(user.equals(""))
							JOptionPane.showMessageDialog(null,"Please enter Your valid username","ERROR_ON_USERNAME",JOptionPane.ERROR_MESSAGE);
						else
						{
						 userText =user;
						   
						   if(pass.length==0)
								JOptionPane.showMessageDialog(null,"Please enter Your valid Password","ERROR_ON_PASSWORD",JOptionPane.ERROR_MESSAGE);
							else
							{  
								Password = String.copyValueOf(pass);
								passText = pass;
							
							    	 if(repass.length==0)
											JOptionPane.showMessageDialog(null,"Please enter Password Again","ERROR_ON_REPASSWORD",JOptionPane.ERROR_MESSAGE);
										else
										{
											repasswordText =  repass;
											
		if(!Arrays.equals(pass, repass)){
			JOptionPane.showMessageDialog(null,"Passowrd and Repassword does not match each other !!! ","ERROR_ON_PASSWORD_MATCHING",JOptionPane.ERROR_MESSAGE);
		}
		else
		{
			if(accntNo.equals(""))
				JOptionPane.showMessageDialog(null,"Please enter Your last 4 Account Number","ERROR_ON_ACCOUNT_NUMBER",JOptionPane.ERROR_MESSAGE);
			else
			{
				
				try{
				String accountText = accntNo;
				 if(accntNo.length()==4)
		    	   {
					accNumber = Integer.parseInt(accountText);
					 
					 if(cardNo.equals(""))
							JOptionPane.showMessageDialog(null,"Please enter Your last 4 card Number","ERROR_ON_CARDNUMBER",JOptionPane.ERROR_MESSAGE);
						else
						{
							try{
							String cardText = cardNo;
							 if(cardNo.length()==4)
					    	   {
								 cardNumber = Integer.parseInt(cardText);
								 
								 if(SerialNo.equals(""))
										JOptionPane.showMessageDialog(null,"Please enter Your last 4 Serial Number","ERROR_ON_SERIAL",JOptionPane.ERROR_MESSAGE);
									else
									{   try{
										String serialText = SerialNo;
										 if(SerialNo.length()==4)
								    	   {
											serialNumber = Integer.parseInt(serialText);
											
											 if(expireNo.equals(""))
													JOptionPane.showMessageDialog(null,"Please enter the month and year","ERROR_ON_EXPIREDATE",JOptionPane.ERROR_MESSAGE);
												else
												{
													try{
													String expireText = expireNo;
												       if(expireText.length()==4)
												    	   {
												    	 expireNumber = Integer.parseInt(expireText );
												    	   
												    	   if(cvsNo.equals(""))
																JOptionPane.showMessageDialog(null,"Please enter 3 digits of backside of your card","ERROR_ON_SECURITY_CODE",JOptionPane.ERROR_MESSAGE);
															else
															{
																try{
																String securityText = cvsNo;
																//restrictedNumber(securityText, 3);
																if(securityText.length()==3){
																	secureNumber = Integer.parseInt(securityText);}
																else
																{JOptionPane.showMessageDialog(null,"Please enter 3 digits in CVS","ERROR_ON_SECURITY_CODE",JOptionPane.ERROR_MESSAGE);}
																}catch(Exception e1){
																	JOptionPane.showMessageDialog(null,"Please enter 3 CVS number ","ERROR_ON_SECURITY_CODE",JOptionPane.ERROR_MESSAGE);
																}
																
																
															}
												    	   }
												       else {
												    	   JOptionPane.showMessageDialog(null,"Please enter 2 digits of month and year in Expire Date","ERROR_ON_EXPIREDATE",JOptionPane.ERROR_MESSAGE); 
												       }
													}catch(Exception e2){
														JOptionPane.showMessageDialog(null,"Please enter 4 digits  in expire date","ERROR_ON_EXPIREDATE",JOptionPane.ERROR_MESSAGE);
													}
	}//expire date
						    	   }
						       else {
						    	   JOptionPane.showMessageDialog(null,"Please enter only 4 digits of serial number","ERROR_ON_SERIAL",JOptionPane.ERROR_MESSAGE); 
						       }
								
							}
							catch(Exception e3){
								JOptionPane.showMessageDialog(null,"Please enter last 4 digits  in serial number","ERROR_ON_SERIAL",JOptionPane.ERROR_MESSAGE);
							}
								}//serial Number
						 
						 
						 
						 }
			       else {
			    	   JOptionPane.showMessageDialog(null,"Please enter only 4 digits of card number","ERROR_ON_CARDNUMBER",JOptionPane.ERROR_MESSAGE); 
			       }
					}catch(Exception e4){ JOptionPane.showMessageDialog(null,"Please enter last 4 digits of card number","ERROR_ON_CARDNUMBER",JOptionPane.ERROR_MESSAGE);}
					
				}//card nUmber
			 
			 }
       else {
    	   JOptionPane.showMessageDialog(null,"Please enter only 4 digits of account number","ERROR_ON_ACCOUNT_NUMBER",JOptionPane.ERROR_MESSAGE); 
       }
		}catch(Exception e5){ JOptionPane.showMessageDialog(null,"Please enter last 4 digits of account number","ERROR_ON_ACCOUNT_NUMBER",JOptionPane.ERROR_MESSAGE); }
	}//account number
	
	} 
}//repassword

							    
							   
							}//password
						}//username
						
					}//mailValidation
					
						}//mail
		 
		 			} //tele length
				}
		
		catch(Exception e1){
			JOptionPane.showMessageDialog(null ,"Please enter only number in telephone text","ERROR_ON_PHONE_NUMBER",JOptionPane.ERROR_MESSAGE);
			
			}
		
		}//tele	
	
	}//comboBox
}//address
}//fullname

		try {
			dbConn.inserDataToMysql( fullnameT, adressT, city,telNumber, emailT, userText,Password, accNumber, cardNumber, serialNumber, expireNumber, secureNumber);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//System.out.println(fullnameT);

 

}
					public String cityToString(int town){
						
						//int town = form.cities.getSelectedIndex() ;
					switch(town){
					
					case (0):{
						city = "nicosia";	
					 break;
					 }
					
					case (1):{
						city =  "kyrenia";
					 break;
					 }
					
					case (2):{
						city = "famagusta";
					 break;
					 }
					case (3):{
						city= "morphou";
					 break;
					 }
					case (4):{
						city = "lefke";
					 break;
					 }
					
					default:{
						JOptionPane.showMessageDialog(null,"Please Select Your Cities from comboBox","ERROR_ON_CITIES",JOptionPane.ERROR_MESSAGE);
						}
							
						
						}
						return city;
						
						
					}
					
					public Boolean emailValidation(String email){
						Boolean status= true;
						if (!email.contains("@") || !email.contains("."))
							{
								status=false;
								
							}
							return status;
					
						}
						
						
						
	

	
	
	
	
	

}
