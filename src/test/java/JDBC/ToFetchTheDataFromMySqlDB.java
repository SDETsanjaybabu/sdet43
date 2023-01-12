package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

import genericUtilities.DatabaseUtility;

public class ToFetchTheDataFromMySqlDB {

	public static void main(String[] args) throws SQLException {
		//step1:register to DB
		String prject_name="teach";
		
		DatabaseUtility dLib = new DatabaseUtility();
		
		dLib.connectToDB("projects");
//		Driver driverRef=new Driver();
//		DriverManager.registerDriver(driverRef);
//		//step2:connect to mysql
//		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
		
		//step3:create statement\query
		dLib.executeQuery("select * from project", 4, prject_name);
		
//		Statement statement = connection.createStatement();
//		String query = "select * from project";
//		
//		//step4:execute the query
//		ResultSet result = statement.executeQuery(query);
//		boolean flag = false;
//		while(result.next())
//		{
//			String projects = result.getString(4);
//			if(projects.contains(prject_name))
//			{
//				flag=true;
//				break;
//			}
//		}
//		if(flag)
//		{
//			System.out.println("created");
//		}else {			
//			System.out.println("not created");
//		}
//		//step5:close DB connection
//		connection.close();
//		System.out.println("closed");
		dLib.closeDB();
	}
}