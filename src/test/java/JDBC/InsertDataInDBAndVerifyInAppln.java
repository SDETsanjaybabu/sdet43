package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.mysql.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InsertDataInDBAndVerifyInAppln {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		String project_name="c1";
		Connection connection=null;
		WebDriver driver=null;
		try {
			Driver driverRef=new Driver();
			DriverManager.registerDriver(driverRef);
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
			Statement statement = connection.createStatement();
			String query = "insert into project values('TY_PROJ_202','sanjay','12/07/2022','"+project_name+"','Completed','8')";
			statement.executeUpdate(query);
			
		
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			driver.get("http://localhost:8084");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
			driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
			driver.findElement(By.xpath("//button[.='Sign in']")).click();
			driver.findElement(By.xpath("//a[.='Projects']")).click();
			List<WebElement> projects = driver.findElements(By.xpath("//table[@class='table table-striped table-hover']//tbody/tr/td[2]"));
			for (WebElement webElement : projects) 
			{
				String allprojects = webElement.getText();
				if(allprojects.contains(project_name))
				{
					System.out.println("project is created");
					break;
				}
			}
		} catch (Exception e) {
			connection.close();
			System.out.println("DB is closed");
		}
		driver.quit();
		}
}