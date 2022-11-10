package demoProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Databs {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver Loaded");
		
		Connection connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/table", "root", "swapna");
		if(connect.isClosed()) {
			System.out.println("we have not connected to the database");
		}else {
			System.out.println("we have connected to the database");
		}

	}

}