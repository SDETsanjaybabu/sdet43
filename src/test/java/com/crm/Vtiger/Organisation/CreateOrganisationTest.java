package com.crm.Vtiger.Organisation;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.ExcelUtility;
import genericUtilities.FileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.WebdriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepo.CreateOrganisationPage;
import objectRepo.HomePage;
import objectRepo.LoginPage;
import objectRepo.OrganisationsInfoPage;
import objectRepo.OrganisationsPage;

public class CreateOrganisationTest extends BaseClass{
	@Test
	public void ToCreateOrganisationTest() throws Throwable
	{

	
	
	//To get the Random number
	int randomNum = jLib.getRandomNumber();
	
	//Fetch data from excel sheet
	String orgName = elib.getExcelData("Organisations", 1, 2)+randomNum;
	
	
	HomePage homePage = new HomePage(driver);
	homePage.getOrgLink().click();
	
	OrganisationsPage orgPage = new OrganisationsPage(driver);
	orgPage.clickOnCreateOrgLkpImg();
	
	CreateOrganisationPage createOrgPage = new CreateOrganisationPage(driver);
	createOrgPage.createOrg(orgName);
	
	OrganisationsInfoPage infoPage = new OrganisationsInfoPage(driver);
	String org = infoPage.getSuccessfulMsg().getText();
	
//	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//	
//	//enter the password in the password txt field
//	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//	
//	//click on login button
//	driver.findElement(By.id("submitButton")).click();
//	
//	//click on Organisations link
//	driver.findElement(By.xpath("//a[.='Organizations']")).click();
//	
//	//click on create Organisation lookup img
//	driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
//	
//	//enter the Organisation name
//	driver.findElement(By.name("accountname")).sendKeys(orgName);
//	
//	//click on save button
//	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
//	
//	//verify the Organisation Name
//	String org = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	Assert.assertEquals(org, orgName);
	Reporter.log("Create Organisation test is pass",true);
	//	if(org.contains(orgName))
//	{
//		System.out.println("Organisation is created");
//	}else {
//		System.out.println("Organisation is not created");
//	}
	
	//mouseover Adminisatrator link
	homePage.Logout(driver);
//	WebElement administrator = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
//	wbty.mouseOverOnElement(driver, administrator);
//	
//	//click on signout link
//	driver.findElement(By.xpath("//a[.='Sign Out']")).click();
	
	//quit the browser
	
	}
}