package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

import genericUtilities.DatabaseUtility;

public class ToInsertData {

	public static void main(String[] args) throws SQLException {
		
		//Step1:-to register to database
		DatabaseUtility dLib = new DatabaseUtility();
		
//		Driver driverRef=new Driver();
//		DriverManager.registerDriver(driverRef);
//		
//		//step-2:to connect with mysql
//		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
		dLib.connectToDB("projects");
		
		//step-3:write query
		dLib.executeUpdate("insert into project values('TY_PROJ_003','ravi','11/07/2022','wwwww','completed','6')");
		
//		Statement statement = connection.createStatement();
//		String query = "insert into project values('TY_PROJ_003','ravi','11/07/2022','dfdfd','completed','7')";
//		
//		//step-4:execute query
//		int result = statement.executeUpdate(query);
//		
//		if(result==1)
//		{
//			System.out.println("data created");
//		}
//		else
//		{
//			System.out.println("data not created");
//		}
		dLib.closeDB();
	}

}
