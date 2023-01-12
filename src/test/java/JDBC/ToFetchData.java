package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

import genericUtilities.DatabaseUtility;

public class ToFetchData {

	public static void main(String[] args) throws SQLException {
		
//		Driver driverRef = new Driver();
//		DriverManager.registerDriver(driverRef);
//		
//		//Step2:connect to mysql
//		
//		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
		
		DatabaseUtility dLib = new DatabaseUtility();
		dLib.connectToDB("Projects");
		
//		Statement statement = connection.createStatement();
//		
//		
//		String query = "select * from project";
//		
//		ResultSet result = statement.executeQuery(query);
//		
//
//		while(result.next())
//		{
//			System.out.println(result.getString(1)+"\t"+result.getString(2)+"\t"+result.getString(3)+"\t"+result.getString(4)+"\t"+result.getString(5)+"\t"+result.getString(6));
//			
//		}
		dLib.closeDB();
	}

}
