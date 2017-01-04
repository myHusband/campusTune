package cpe513;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;
import java.util.ArrayList;

public class dbConnection {
DefaultTableModel model= null;
Connection conn  ;
Statement stmt ;
ArrayList<String> userArrayList = new ArrayList<String>();
ArrayList<String> passwordArrayList = new ArrayList<String>();


	
public void inserDataToMysql(String fullnameT,String adressT,String city,long telNumber,String emailT,String userText,
										String Password,long cardNumber, int secureNumber)
												throws SQLException, ClassNotFoundException{

			
    		Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/campusTune","root", "");
			//System.out.print("Database is connected !\n\n");
			stmt = conn.createStatement();
			String sql = "INSERT INTO eusers (name_surname, address, city, telephone, email, username,"
					+ " password, card_no, security_code)values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
			   PreparedStatement prepStmt =  (PreparedStatement) conn.prepareStatement(sql);
		    prepStmt.setString(1, fullnameT);
		    prepStmt.setString(2, adressT);
		    prepStmt.setString(3, city);
		    prepStmt.setLong(4, telNumber);
		    prepStmt.setString(5, emailT);
		    prepStmt.setString(6, userText);
		    prepStmt.setString(7, Password);
		    prepStmt.setLong(8, cardNumber);
		    prepStmt.setInt(9,secureNumber);
		    int n1 = prepStmt.executeUpdate();
		    if(n1>0)
			   {
			   	//System.out.print("Inserted Successfully!\n\n");
			   }
			   stmt.close();
			conn.close();					
	}
	   
    public void getDataFromMysql(String name, String passwd) throws SQLException, ClassNotFoundException{
				Class.forName("com.mysql.jdbc.Driver");
	    		conn = DriverManager.getConnection("jdbc:mysql://localhost/campusTune","root", "");
	    		//System.out.print("Database is connected !\n\n");
	    		stmt = conn.createStatement();
	    		String sql = "SELECT username,password FROM eusers where username = ?";
	    		PreparedStatement prepStmt =  (PreparedStatement) conn.prepareStatement(sql);
	    		prepStmt.setString(1, name); 
	    		ResultSet result = prepStmt.executeQuery();
	    		while(result.next()){
    			userArrayList.add(result.getString(1)) ;
    			passwordArrayList.add(result.getString(2)) ;
	    		       }	
               stmt.close();
    	       conn.close();	
    }
    
    
    public   DefaultTableModel  getDataFromProductDB() throws SQLException, ClassNotFoundException, IOException{    	
    	JTable table = new JTable();
    	DefaultTableModel dtm = new DefaultTableModel(0, 0);
    	String header[] = new String[] { "pid","name", "picture", "quantity left", "category","price", "description" };
    	dtm.setColumnIdentifiers(header);
    	table.setModel(dtm);
    	Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost/campusTune","root", "");
		//System.out.print("Database is connected !\n\n");
		stmt = conn.createStatement();
		String sql = "SELECT pid,pname,quantity_left,pcategory,price,description FROM product ";
		ResultSet result = stmt.executeQuery(sql);
		while(result.next()){
		String filepath = "images\\products\\"+result.getInt(1)+".jpg";
		File imgPath = new File(filepath);
		BufferedImage bufferedImage;
		try {
		bufferedImage = ImageIO.read(imgPath);
		ImageIcon icon = new ImageIcon(bufferedImage);
		dtm.addRow(new Object[] { result.getInt(1),result.getString(2),icon,result.getInt(3), result.getString(4),
		result.getInt(5),result.getString(6) });	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	 
		 }
		 stmt.close();
		 conn.close();
		 return dtm;
    }
    
    public void insertDataintoProductDB(String pname,String filename,int quantity,
    		String pcategory,double price,String Description ) throws Exception{
    	
    	Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost/campusTune","root", "");
		//System.out.print("Database is connected !\n\n");
		stmt = conn.createStatement();
		String sql = "INSERT INTO product (pname, picture, quantity_left, pcategory, price, description)values(?, ?, ?, ?, ?, ?)";
		   PreparedStatement prepStmt =  (PreparedStatement) conn.prepareStatement(sql);
	    prepStmt.setString(1, pname);
	    File file = new File(filename);
	    FileInputStream  fis = new FileInputStream(file);
	    prepStmt.setBinaryStream(2, fis, (int) file.length());
	    prepStmt.setInt(3, quantity);
	    prepStmt.setString(4, pcategory);
	    prepStmt.setDouble(5, price);
	    prepStmt.setString(6, Description);
	    int n1 = prepStmt.executeUpdate();
	    if(n1>0)
		   {
		   	System.out.print("Inserted Successfully!\n\n");
		   }
		   stmt.close();
		conn.close();
  
    }
    
    public void deleteProductDB(int pid) throws Exception{
    	
    	Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost/campusTune","root", "");
		//System.out.print("Database is connected !\n\n");
		stmt = conn.createStatement();
		String sql = "DELETE FROM product where pid = '"+pid+"'";
		stmt.executeUpdate(sql);
		
    }
    
}