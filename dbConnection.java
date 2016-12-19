

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import java.sql.*;
import java.util.Vector;

public class dbConnection {
	Connection conn  ;
	Statement stmt;
	
	String userText= null;
	String Password= null;
	

	 
	
	
 
    
    
    public void getDataFromMysql() throws SQLException, ClassNotFoundException{
    	
    	
				Class.forName("com.mysql.jdbc.Driver");
	    		conn = DriverManager.getConnection("jdbc:mysql://localhost/campusTune","root", "");
	    		System.out.print("Database is connected !\n\n");
	    		
	    		stmt = conn.createStatement();
	    		String sql = "SELECT username,password FROM eusers";
	    		ResultSet result =stmt.executeQuery(sql);
	    		   		
	    		while(result.next()){
	    			this.userText = result.getString(1);
	    			this.Password = result.getString(2);
	    			//System.out.println(user + " "+ passwd);
	    		
	    		}	
         
         stmt.close();
    	conn.close();
    	
    }
    
}