package cpe513;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import java.sql.*;

public class dbConnection {
	Connection conn  ;
	Statement stmt;
	
	String userText= null;
	String Password= null;
	
	 
	auxillaryClass aux2 = new auxillaryClass();
	
 
    
    
    public void getDataFromMysql(String username, char[] pass) throws SQLException, ClassNotFoundException{
    	
    	if(username.equals(""))
			JOptionPane.showMessageDialog(null,"Please Enter Your username","ERROR_ON_USERNAME",JOptionPane.ERROR_MESSAGE);
		
		else
		{
			userText  = username;
			if(pass.length==0)
				JOptionPane.showMessageDialog(null,"Please enter Your valid Password","ERROR_ON_PASSWORD",JOptionPane.ERROR_MESSAGE);
			else
			{  
				Password = String.copyValueOf(pass);
				
				Class.forName("com.mysql.jdbc.Driver");
	    		conn = DriverManager.getConnection("jdbc:mysql://localhost/campusTune","root", "");
	    		System.out.print("Database is connected !\n\n");
	    		
	    		stmt = conn.createStatement();
	    		String sql = "SELECT username,password FROM eusers";
	    		ResultSet result =stmt.executeQuery(sql);
	    		//ResultSetMetaData rsdm = result.getMetaData();
	    		
	    		while(result.next()){
	    			String user = result.getString(1);
	    			String passwd= result.getString(2);
	    			
	    			if(username.equals(user) && Password.equals(passwd)){
	    				new ProductForm();
	    				break;
	    			}
	    			else 
	    				if(username.equals(user) && Password.equals(passwd) && username.equals("admin") &&  Password.equals("admin")){
		    				AdminPaneL ad = new AdminPaneL();
		    				ad.setVisible(true);
		    				break;
		    			}
	    			else {JOptionPane.showMessageDialog(null, "Invalid user with username " + username);}
	    		}
	    		
	    		
				
				
			}
		}
         
         stmt.close();
    	conn.close();
    	
    }
    
    public static void main(String[] args){
    	//createConnection();
    	//insertDataToMysql();
    }

	


	
    

}
