import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import javax.swing.*;

public class Auxillary {

	Auxillary(){
		
	}
	void validateDetails(long cnumber,String cname,int ccvc){
		//validate from db
		String dbURL ="jdbc:derby://localhost:1527/testDB;create=true;user=test;password=test";
		Connection conn = null;
		Statement stmt = null;
		try{
			Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
			conn = DriverManager.getConnection(dbURL);
			System.out.println("Connection successful!");
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,"ERROR: "+e.toString());
		}
		try{
			stmt = conn.createStatement();
			ResultSet results = stmt.executeQuery("SELECT * FROM products"); //validate correctly
			/*GET THE COLUMN NAMES*/
			ResultSetMetaData rsdm = results.getMetaData();
			int columns = rsdm.getColumnCount();
			for (int i=1; i<=columns;i++)
			System.out.print(rsdm.getColumnLabel(i)+ "\t\t");

			System.out.print("\n");
			while (results.next()){

			int studentNo = results.getInt(1);
			String studentName = results.getString(2);
			String studentSurname = results.getString(3);
			System.out.println(studentNo + "\t\t\t"+ studentName + "\t\t\t"+studentSurname); 
			}
			results.close();
			stmt.close();
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "ERROR: "+e.toString());
		}
	}
	int checkQty(int productID,int qty){
		//updateQty(int qty)
		return 0;
	}
	void updateQty(int qty){
		
	}
}
