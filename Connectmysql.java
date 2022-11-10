package demoProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class Connectmysql {
  @Test
  public void testdb() throws ClassNotFoundException, SQLException {
	  Class.forName("com.mysql.cj.jdbc.Driver");
	  System.out.println("Driver Loaded");
	  
	Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/selenium","root","Mukunda@12345");
	  
	System.out.println("connected to mysql db");
	  
	Statement stm=con.createStatement();
	
	ResultSet rs=stm.executeQuery("select * from seleniumuser");
	
	while(rs.next()){
		String firstname=rs.getString("firstname");
		System.out.println("Database record is:" +firstname);
		
		String email1=rs.getString("email");
		System.out.println("Database record is:" +email1);
		
	}
	
	
	
  }
  
  
  
}
