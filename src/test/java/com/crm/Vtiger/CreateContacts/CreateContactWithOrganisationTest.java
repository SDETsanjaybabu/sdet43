package com.crm.Vtiger.CreateContacts;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepo.ContactsInfoPage;
import objectRepo.CreateCnctLookUpImgPage;
import objectRepo.CreateContactsPage;
import objectRepo.CreateOrganisationPage;
import objectRepo.HomePage;
import objectRepo.LoginPage;
import objectRepo.OrganisationsInfoPage;
import objectRepo.OrganisationsPage;

public class CreateContactWithOrganisationTest {

	public static void main(String[] args) throws Throwable{
		WebDriver driver=null;
		//Fetch common data from property file
		FileInputStream fileInputStream=new FileInputStream("./src/test/resources/commondata.properties.txt");
		Properties properties = new Properties();
		properties.load(fileInputStream);

		//fetch data from property file using getproperty
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

		//Fetch the firstname from excel
		Workbook workbook = WorkbookFactory.create(new FileInputStream("./src/test/resources/Sdet37TestData.xlsx"));
		String value = workbook.getSheet("Contacts").getRow(2).getCell(2).toString();	
		String FirstName = value+randomNum;

		//Fetch the second name from excel
		String value1 = workbook.getSheet("Contacts").getRow(2).getCell(3).toString();
		String LastName = value1+randomNum;

		//Fetch the orgname from excel
		String value2 = workbook.getSheet("Organisations").getRow(1).getCell(2).toString();	
		String orgName= value+randomNum;

		//maximizw the screen
		driver.manage().window().maximize();

		//implicitly wait of 10 seconds
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		//enter the URL of the application
		driver.get(URL);

		//enter the username in the username txtfield
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginToApp(USERNAME, PASSWORD);		
		//click on Organisation link
		HomePage homePage = new HomePage(driver);
		homePage.getOrgLink().click();
		
		//click on CreateOrganisation LookUp Img
		OrganisationsPage orgsPage = new OrganisationsPage(driver);
		orgsPage.clickOnCreateOrgLkpImg();
		//enter the Organisation name
		CreateOrganisationPage crpage = new CreateOrganisationPage(driver);
		crpage.createOrg(orgName);
		//verify whether the Organisation is created or not
		OrganisationsInfoPage orgInfo = new OrganisationsInfoPage(driver);
		String name = orgInfo.getSuccessfulMsg().getText();	
		if(name.contains(orgName))
		{
			System.out.println("organisation is created");
		}else {
			System.out.println("Organisation is not created");
		}
		//click on contacts link
		homePage.getCntLink().click();
		//click on create Contacts lookup img
		CreateCnctLookUpImgPage crImg = new CreateCnctLookUpImgPage(driver);
		crImg.createOrgLkImg();
		//enter the firstname
		CreateContactsPage ccPage = new CreateContactsPage(driver);
		ccPage.createCntWithOrg(FirstName, LastName, driver, orgName);
		//verify
		ContactsInfoPage cntInfo = new ContactsInfoPage(driver);
		String contactName = cntInfo.getCntSuccessfulMg().getText();
		
		if(contactName.contains(LastName))
		{
			System.out.println("contact with org is created");
		}else {
			System.out.println("contact with org is not created");
		}

		//mouse over on adminstator link
		homePage.Logout(driver);

		//quit the browser
		driver.quit();
	}
}