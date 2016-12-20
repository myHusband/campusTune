package cpe513;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;

import java.sql.*;
import java.util.Vector;

public class dbConnection {
	Connection conn  ;
	Statement stmt;
	
	
	
	Vector<String> userVector = new Vector<String>();
	Vector<String> passwordVector = new Vector<String>();
	
	public void inserDataToMysql(String fullnameT,String adressT,String city,long telNumber,String emailT,String userText,
										String Password,int accNumber,int cardNumber,int serialNumber,int expireNumber,int secureNumber)
												throws SQLException, ClassNotFoundException{
try {
			
    		Class.forName("com.mysql.jdbc.Driver");
conn = DriverManager.getConnection("jdbc:mysql://localhost/campusTune","root", "");
System.out.print("Database is connected !\n\n");
stmt = conn.createStatement();
String sql = "INSERT INTO eusers (name_surname, address, city, telephone, email, username, password, account_no, card_no, serial_no, expire_date, security_code)values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
   PreparedStatement prepStmt =  (PreparedStatement) conn.prepareStatement(sql);
   prepStmt.setString(1, fullnameT);
    prepStmt.setString(2, adressT);
  prepStmt.setString(3, city);
   prepStmt.setLong(4, telNumber);
    prepStmt.setString(5, emailT);
    prepStmt.setString(6, userText);
    prepStmt.setString(7, Password);
    prepStmt.setInt(8, accNumber);
    prepStmt.setInt(9, cardNumber);
    prepStmt.setInt(10,serialNumber);
    prepStmt.setInt(11,expireNumber);
    prepStmt.setInt(12,secureNumber);
    
   int n1 = prepStmt.executeUpdate();
   
   if(n1>0)
   {
   	System.out.print("Inserted Successfully!");
   }
   stmt.close();
conn.close();
	
} catch (Exception e1) {
	// TODO Auto-generated catch block
System.out.print("Error " + e1);
	}
		
		
	}
	   
    public void getDataFromMysql() throws SQLException, ClassNotFoundException{
    	
    	
				Class.forName("com.mysql.jdbc.Driver");
	    		conn = DriverManager.getConnection("jdbc:mysql://localhost/campusTune","root", "");
	    		System.out.print("Database is connected !\n\n");
	    		
	    		stmt = conn.createStatement();
	    		String sql = "SELECT username,password FROM eusers";
	    		ResultSet result =stmt.executeQuery(sql);
	    		   		
	    		while(result.next()){
	    			userVector.add(result.getString(1)) ;
	    			passwordVector.add(result.getString(2)) ;
	    			//System.out.println(userVector + " "+ passwordVector);
	    		
	    		}	
         
         stmt.close();
    	conn.close();
    	
    }
    
}