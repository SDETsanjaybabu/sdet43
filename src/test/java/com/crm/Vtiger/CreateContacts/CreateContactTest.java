package com.crm.Vtiger.CreateContacts;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtilities.IPathConstants;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactTest {
	static WebDriver driver;
	
	@Test
	public  void main() throws IOException {
		// TODO Auto-generated method stub
		//WebDriver driver=null;
		//Fetch common data from property file
		FileInputStream fileInputStream=new FileInputStream(IPathConstants.filePath);
		Properties properties = new Properties();
		properties.load(fileInputStream);
		
		//fetch data from property file using getproperty
		String BROWSER = properties.getProperty("browser");
		String URL = properties.getProperty("url");
		String USERNAME = properties.getProperty("username");
		String PASSWORD = properties.getProperty("password");
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			//System.setProperty(IPathConstants.chromeKey,IPathConstants.chromePath);
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			//driver=WebDriverManager.chromedriver().create();
		}else if(BROWSER.contentEquals("firefox"))
		{
			driver=WebDriverManager.firefoxdriver().create();
		}else if(BROWSER.equalsIgnoreCase("microsoftEdge"))
		{
			driver=WebDriverManager.edgedriver().create();
		}else {
			//driver=WebDriverManager.chromedriver().create();
		}
	
		//Get a random number
		Random random=new Random();
		int randomNum = random.nextInt(1000);
		
		//Fetch data from excel sheet
		Workbook workbook = WorkbookFactory.create(new FileInputStream(IPathConstants.excelPath));
		String value = workbook.getSheet("Contacts").getRow(2).getCell(2).toString();	
		String FirstName = value+randomNum;
		
		String value1 = workbook.getSheet("Contacts").getRow(2).getCell(3).toString();
		String LastName = value1+randomNum;
		
		//maximizw the screen
		driver.manage().window().maximize();
		
		//implicitly wait of 10 seconds
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IPathConstants.impDtn));
		
		//enter the URL of the application
		driver.get(URL);
		
		//enter the username in the username txtfield
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		
		//enter the password in the password txt field
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		
		//click on login button
		driver.findElement(By.id("submitButton")).click();
		
		//click on Organisations link
		driver.findElement(By.xpath("//a[.='Contacts']")).click();
		Assert.fail();
		//click on create Organisation lookup img
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		//enter the firstname
		driver.findElement(By.name("firstname")).sendKeys(FirstName);
		
		//enter the lastname
		driver.findElement(By.name("lastname")).sendKeys(LastName);
		
		//click on save button
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				
		//verify the Organisation Name
		String name = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(name.contains(LastName))
		{
			System.out.println("contact is created");
		}else {
			System.out.println("contact is not created");
		}
				
		//mouseover Adminisatrator link
		WebElement administrator = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions action=new Actions(driver);
		action.moveToElement(administrator).perform();
				
		//click on signout link
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();	
		
		//quit the browser
		driver.quit();
	}

}
