package genericUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.WebDriverListener;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepo.HomePage;
import objectRepo.LoginPage;

public class BaseClass {
	
	public static WebDriver sdriver;
	public WebDriver driver;
	public DBClass dbc=new DBClass();
	public ExcelUtility elib=new ExcelUtility();
	public FileUtility flib=new FileUtility();
	public JavaUtility jLib=new JavaUtility();
	public WebdriverUtility wLib=new WebdriverUtility();
	
	@BeforeSuite
	public void dbConfig()
	{
		dbc.connectToDb();
	}
	
	@BeforeClass
	public void launchBrowser() throws Throwable
	{
		String BROWSER = flib.getPropertyKeyValue("browser");
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
		driver=WebDriverManager.chromedriver().create();
		}else if(BROWSER.equalsIgnoreCase("firefox"))
		{
		driver=WebDriverManager.firefoxdriver().create();
		}else {
		driver=WebDriverManager.chromedriver().create();
		}
		
		wLib.maximizeTheWindow(driver);
	}
	
	@BeforeMethod
	public void loginToApp() throws Throwable
	{
		String URL = flib.getPropertyKeyValue("url");
		String USERNAME = flib.getPropertyKeyValue("username");
		String PASSWORD = flib.getPropertyKeyValue("password");
		
		sdriver=driver;
		driver.get(URL);
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginToApp(USERNAME, PASSWORD);
	}
	
	@AfterMethod
	public void logoutFromApp()
	{
		HomePage homepage = new HomePage(driver);
		homepage.Logout(driver);
	}
	
	@AfterClass
	public void closeBrowser()
	{
		driver.quit();
		System.out.println("browser closed successfully");
	}
	
	@AfterSuite
	public void closeDbConfig()
	{
		dbc.closeDB();
	}
}
