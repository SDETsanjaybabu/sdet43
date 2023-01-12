package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.jdbc.Driver;

import genericUtilities.DatabaseUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class InsertDataIntoRmgyantraAndVerifyInDB {

	public static void main(String[] args)throws Throwable{
		String project_name="Dream12";
		Connection connection=null;
		
		DatabaseUtility dLib = new DatabaseUtility();
		
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		//maximize the browser
		driver.manage().window().maximize();
		
		//implicitly wait for 10 seconds
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//enter the URL of RMG Yantra application
		driver.get("http://localhost:8084");
		
		//enter the username in username txtfield
		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		
		//enter the password in password txtfield
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		
		//click on sign in button
		driver.findElement(By.xpath("//button[contains(.,'Sign in')]")).click();
		
		//click on projects link
		driver.findElement(By.xpath("//a[contains(.,'Projects')]")).click();
		
		//click on create project link
		driver.findElement(By.xpath("//span[contains(.,'Create Project')]")).click();
		
		//enter the project name
		driver.findElement(By.name("projectName")).sendKeys(project_name);
		
		//enter the project manager name
		driver.findElement(By.name("createdBy")).sendKeys("prakash");
		
		//select the status from project status dropdown
		WebElement statusDropdown = driver.findElement(By.xpath("//label[.='Project Status ']/following-sibling::select"));
		
		Select select=new Select(statusDropdown);
		select.selectByValue("Created");
		
		//click on add project button
		driver.findElement(By.xpath("//input[@class='btn btn-success']")).click();
		
		//get register for mysql DB	
		
//		Driver driverRef=new Driver();
//		DriverManager.registerDriver(driverRef);
//		
//		//connect to mysql DB using URL
//		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
//		
		dLib.connectToDB("Projects");
		//create a statement
//		Statement statement = connection.createStatement();
//		
//		//write a query
//		String query = "select * from project";
//		
//		//fetch all the column data
//		ResultSet result = statement.executeQuery(query);
//		
//		//verify the data in DB
//		while(result.next())
//		{
//			String allProjects = result.getString(4);
//			if(allProjects.contains(project_name))
//			{
//				System.out.println("project is created in DB");
//				break;
//			}
//		}
//		} catch (Exception e) {
//		e.printStackTrace();
//		}finally {
//			//close DB connection
//			connection.close();
//		}
		
		dLib.executeQuery("select * from project", 4, project_name);
		//close the browser
		dLib.closeDB();
	}
}