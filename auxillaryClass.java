package cpe513;

import java.util.Arrays;
import java.sql.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;

public class auxillaryClass {


Statement stmt;
String fullnameT = null;
String adressT;
String city = null ;
long telNumber;
String emailT = null;
String userText= null;
char[] passText;
char[] repasswordText;
String Password= null;
int secureNumber ;
long cardNumber;




	 
	 //This method will validate my registration form and submit the value to dbConnection form
public void validateRegistrationForm(String fullname,String adress,int selectedIndex,String tele,String mail,String user,
			char[] pass,char[] repass,String  cardPart1,String  cardPart2,String  cardPart3,String  cardPart4,String cvcNo)
	{
if(fullname.equals(""))// check if name and surname is  empty
JOptionPane.showMessageDialog(null,"Please Enter Your Full Name",
		"ERROR_ON_NAME_SURNAME",JOptionPane.ERROR_MESSAGE);
else
{
	fullnameT  = fullname;
if(adress.equals(""))   // check if address is  empty
JOptionPane.showMessageDialog(null,"Please Enter Your Home Address",
		"ERROR_ON_ADDRESS",JOptionPane.ERROR_MESSAGE);
else {
 adressT = adress; 
 if(selectedIndex<= 0)//check if any item got Selected in cities comboBox from registration form
		JOptionPane.showMessageDialog(null,"Please Select Your Cities from comboBox",
				"ERROR_ON_CITIES",JOptionPane.ERROR_MESSAGE);
else{
city =cityToString(selectedIndex);//set Selected Index to string 
	if(tele.equals(""))//check if telephone number is empty
		JOptionPane.showMessageDialog(null,"Please enter Your Phone number",
				"ERROR_ON_PHONE_NUMBER",JOptionPane.ERROR_MESSAGE);
	
	else {
		
try{
 String telText = tele; //set telephone text to telText
 
 {
	telNumber = Long.parseLong(telText);//set telephone number to long
	 

		if(mail.equals(""))//check if email is empty
			JOptionPane.showMessageDialog(null,"Please enter Your valid Email",
					"ERROR_ON_EMAIL",JOptionPane.ERROR_MESSAGE);
		else
		{
			 emailT = mail;
			
					//check if email contains @ and .
					if(emailValidation(emailT)== false){
						JOptionPane.showMessageDialog(null,"Please make sure your mail contains both @ and .",
								"ERROR_ON_EMAIL",JOptionPane.ERROR_MESSAGE);
					}
					else{
						if(user.equals(""))//check if user name is empty
							JOptionPane.showMessageDialog(null,"Please enter Your valid username",
									"ERROR_ON_USERNAME",JOptionPane.ERROR_MESSAGE);
						else
						{
						 userText =user;
						   
						   if(pass.length==0)//check if password is empty
								JOptionPane.showMessageDialog(null,"Please enter Your valid Password",
										"ERROR_ON_PASSWORD",JOptionPane.ERROR_MESSAGE);
							else
							{  
								Password = String.copyValueOf(pass);//change pass characters to string
							
							    	 if(repass.length==0)//check if re password is empty
											JOptionPane.showMessageDialog(null,"Please enter Password Again",
													"ERROR_ON_REPASSWORD",JOptionPane.ERROR_MESSAGE);
										else
										{
											repasswordText =  repass;
											
		if(!Arrays.equals(pass, repass)){//check if the password and re password are the same
			JOptionPane.showMessageDialog(null,"Passowrd and Repassword does not match each other !!! ",
					"ERROR_ON_PASSWORD_MATCHING",JOptionPane.ERROR_MESSAGE);
		}
		else
		{
			if( cardPart1.equals(""))//check the first 4 of 16 card number is not empty
				JOptionPane.showMessageDialog(null,"Please enter Your last 4 Account Number",
						"ERROR_ON_ACCOUNT_NUMBER",JOptionPane.ERROR_MESSAGE);
			else
			{
				
				try{
				String accountText =  cardPart1;
				
				 if( cardPart1.length()==4)			//check cardText contains only 4 first numbers
		    	   {
					//accNumber = Integer.parseInt(accountText);
					 
					 if( cardPart2.equals(""))                    //check the second 4 of 16 card number is empty
							JOptionPane.showMessageDialog(null,"Please enter Your last 4 card Number",
									"ERROR_ON_CARDNUMBER",JOptionPane.ERROR_MESSAGE);
						else
						{
							try{
							String cardText =  cardPart2;
							 if( cardPart2.length()==4)  //check cardText contains only 4 first numbers
					    	   {
								// cardNumber = Integer.parseInt(cardText);
								 
					 if( cardPart3.equals(""))			 //check the third 4 of 16 card number is empty
							JOptionPane.showMessageDialog(null,"Please enter Your last 4 Serial Number",
									"ERROR_ON_SERIAL",JOptionPane.ERROR_MESSAGE);
						else
						{   try{
							String serialText =  cardPart3;
							 if( cardPart3.length()==4)  //check cardText contains only 4 first numbers
					    	   {
								// = Integer.parseInt(serialText);
								
								 if( cardPart4.equals("")) 	//check the fourth 4 of 16 card number is empty
										JOptionPane.showMessageDialog(null,"Please enter the month and year",
												"ERROR_ON_EXPIREDATE",JOptionPane.ERROR_MESSAGE);
									else
									{
					try{
					String expireText =  cardPart4;
				       if(expireText.length()==4) //check cardText contains only 4 first numbers
				    	   {
				    	// expireNumber = Integer.parseInt(expireText );
				    	   
				    	   if(cvcNo.equals("")) //check the CVC number is empty
								JOptionPane.showMessageDialog(null,"Please enter 3 digits of backside of your card",
										"ERROR_ON_SECURITY_CODE",JOptionPane.ERROR_MESSAGE);
							else
							{
								try{
								String securityText = cvcNo;
								
								if(securityText.length()==3){ //check CVC text contains only 3 first numbers
									secureNumber = Integer.parseInt(securityText);}
								else
								{JOptionPane.showMessageDialog(null,"Please enter 3 digits in CVS",
										"ERROR_ON_SECURITY_CODE",JOptionPane.ERROR_MESSAGE);}
								}catch(Exception e1){
									JOptionPane.showMessageDialog(null,"Please enter 3 CVS number ",
											"ERROR_ON_SECURITY_CODE",JOptionPane.ERROR_MESSAGE);
								}
								
								
							}
    	   }
       else {
    	   JOptionPane.showMessageDialog(null,"Please enter 2 digits of month and year in Expire Date",
    			   "ERROR_ON_EXPIREDATE",JOptionPane.ERROR_MESSAGE); 
       }
	}catch(Exception e2){
		JOptionPane.showMessageDialog(null,"Please enter 4 digits  in expire date",
				"ERROR_ON_EXPIREDATE",JOptionPane.ERROR_MESSAGE);
													}
	}//expire date
						    	   }
						       else {
						    	   JOptionPane.showMessageDialog(null,"Please enter only 4 digits of serial number",
						    			   "ERROR_ON_SERIAL",JOptionPane.ERROR_MESSAGE); 
						       }
								
							}
							catch(Exception e3){
								JOptionPane.showMessageDialog(null,"Please enter last 4 digits  in serial number",
										"ERROR_ON_SERIAL",JOptionPane.ERROR_MESSAGE);
							}
								}//serial Number
						 
						 
						 
						 }
			       else {
			    	   JOptionPane.showMessageDialog(null,"Please enter only 4 digits of card number",
			    			   "ERROR_ON_CARDNUMBER",JOptionPane.ERROR_MESSAGE); 
			       }
					}catch(Exception e4){
						JOptionPane.showMessageDialog(null,"Please enter last 4 digits of card number",
							"ERROR_ON_CARDNUMBER",JOptionPane.ERROR_MESSAGE);}
					
				}//card nUmber
			 
			 }
       else {
    	   JOptionPane.showMessageDialog(null,"Please enter only 4 digits of account number",
    			   "ERROR_ON_ACCOUNT_NUMBER",JOptionPane.ERROR_MESSAGE); 
       }
		}catch(Exception e5){
			JOptionPane.showMessageDialog(null,"Please enter last 4 digits of account number",
				"ERROR_ON_ACCOUNT_NUMBER",JOptionPane.ERROR_MESSAGE); }
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
			JOptionPane.showMessageDialog(null ,"Please enter only number in telephone text",
					"ERROR_ON_PHONE_NUMBER",JOptionPane.ERROR_MESSAGE);
			
			}
		
		}
	
	}
}
}
//concatenate card number	
cardNumber = concatCardTxt(cardPart1,cardPart2,cardPart3,cardPart4);	
//System.out.println(cardNumber);
		
//Call insertion method from dbConnection form			
if(!fullnameT.equals("") && !adressT.equals("") && !city.equals("") && telNumber !=0 && !emailT.equals("")
                  && !userText.equals("") && !Password.equals("")   && cardNumber !=0  && secureNumber !=0){
	 dbConnection dbConn = new dbConnection();
		try {
			dbConn.inserDataToMysql( fullnameT, adressT, city,telNumber, emailT, userText,Password, 
					 cardNumber, secureNumber);
			 new ProductForm();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.toString());
		}
		
	}
}


//Get the select index from cities comboBox in registration form to string
public String cityToString(int town){
switch(town){
case (1):{
city = "nicosia";	
 break;
 }
case (2):{
city =  "kyrenia";
 break;
 }

case (3):{
city = "famagusta";
break;
 }
case (4):{
city= "morphou";
break;
 }
case (5):{
city = "lefke";
break;
 }
default:{
	JOptionPane.showMessageDialog(null,"Please Select Your Cities from comboBox",
			"ERROR_ON_CITIES",JOptionPane.ERROR_MESSAGE);
	}
	}
	return city;	
}


//check an email if it contains both @ and .

public Boolean emailValidation(String email){
Boolean status= true;
if (!email.contains("@") || !email.contains("."))
{
	status=false;	
}
return status;

	}

//concatenate the different 4 text field of card number to get 16 card number

long concatCardTxt(String cardNumber1TextField,String cardNumber2TextField,
		String cardNumber3TextField,String cardNumber4TextField){
	String cardNumber = cardNumber1TextField+""+cardNumber2TextField
			+""+cardNumber3TextField+""+cardNumber4TextField;
	return Long.parseLong(cardNumber);
}

}
