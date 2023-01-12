package genericUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.mysql.jdbc.Driver;

/**
 * 
 * @author SanjayBabu
 *
 */
public class DatabaseUtility {
	/**
	 * 
	 * @param DBname
	 */
	static Driver driverRef;
	static Connection connection;
	static ResultSet result;
	public void connectToDB(String DBname)
	{
		try {
			driverRef = new Driver();
			DriverManager.registerDriver(driverRef);
			connection=DriverManager.getConnection(IPathConstants.mysqlURL+DBname,IPathConstants.mysqlUsername,IPathConstants.mysqlPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 
	 */
	public void closeDB()
	{
		try {
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * @param query
	 * @param columnNo
	 * @param expectedData
	 * @return
	 * @throws SQLException
	 */
	public boolean executeQuery(String query,int columnNo,String expectedData) throws SQLException
	{
		result=connection.createStatement().executeQuery(query);
		boolean flag = false;
		while(result.next())
		{
			if(result.getString(columnNo).equals(expectedData))
			{
				flag=true;
				break;
			}
		}
		if(flag)
		{
			System.out.println("data is present");
			return flag;
		}else {
			System.out.println("data is not present");
			return flag;
		}
	}
	/**
	 * 
	 * @param query
	 * @return
	 * @throws SQLException
	 */
	public void executeUpdate(String query) throws SQLException
	{
		int rlt=connection.createStatement().executeUpdate(query);
		if(rlt==1)
		{
			System.out.println("updated");
		}else {
			System.out.println("not updated");
		}
	}
	
}