package com.crm.Vtiger.Organisation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import genericUtilities.WebdriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * 
 * @author SanjayBabu
 *
 */
public class CreateOrgWithIndustryAndType {

	public static void main(String[] args) throws IOException {
		WebDriver driver=null;

		WebdriverUtility wLib = new WebdriverUtility();
		//Fetch data from property file
		FileInputStream fileInputStream=new FileInputStream("./src/test/resources/commondata.properties.txt");
		Properties properties=new Properties();
		properties.load(fileInputStream);

		String BROWSER = properties.getProperty("browser");
		String URL = properties.getProperty("url");
		String USERNAME = properties.getProperty("username");
		String PASSWORD = properties.getProperty("password");

		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver=WebDriverManager.chromedriver().create();
		}else if(BROWSER.contentEquals("firefox"))
		{
			driver=WebDriverManager.firefoxdriver().create();
		}else if(BROWSER.equalsIgnoreCase("microsoftEdge"))
		{
			driver=WebDriverManager.edgedriver().create();
		}else {
			driver=WebDriverManager.chromedriver().create();
		}

		//Get a random number
		Random random=new Random();
		int randomNum = random.nextInt(1000);

		//Fetch data from excel sheet
		Workbook workbook = WorkbookFactory.create(new FileInputStream("./src/test/resources/Sdet37TestData.xlsx"));
		String value = workbook.getSheet("Organisations").getRow(1).getCell(2).toString();	
		String orgName = value+randomNum;

		//maximizw the screen
		driver.manage().window().maximize();

		//implicitly wait of 10 seconds
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		//enter the URL of the application
		driver.get(URL);

		//enter the username in the username txtfield
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);

		//enter the password in the password txt field
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);

		//click on login button
		driver.findElement(By.id("submitButton")).click();

		//click on Organisations link
		driver.findElement(By.xpath("//a[.='Organizations']")).click();

		//click on create Organisation lookup img
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();

		//enter the Organisation name
		driver.findElement(By.name("accountname")).sendKeys(orgName);

		//select industry from industry dropdown
		WebElement instryDropDown = driver.findElement(By.name("industry"));

		wLib.getAllOptionsIndropdown(instryDropDown);
		
		Select select=new Select(instryDropDown);
		select.selectByValue("Communications");

		//select type from type dropdown
		WebElement typeDropDowns = driver.findElement(By.name("accounttype"));

		Select select1 = new Select(typeDropDowns);
		select1.selectByValue("Investor");

		//click on save button
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		//verify the Organisation Name
		String name = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(name, orgName);
		Reporter.log("CreateOrgWithIndustryAndType",true);
		//		if(name.contains(orgName))
//		{
//			System.out.println("Organisation with industry and type is created");
//		}else {
//			System.out.println("Organisation industry and type is not created");
//		}

		//mouseover Adminisatrator link
		WebElement administrator = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions action=new Actions(driver);
		action.moveToElement(administrator).perform();

		//click on signout link
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();

		//quit the browser
		driver.quit();
		softAssert.assertAll();
	}
}