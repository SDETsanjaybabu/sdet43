package objectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebdriverUtility;

public class CreateContactsPage extends WebdriverUtility{

	public CreateContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(name = "firstname")
	private WebElement FirstNameEdt;
	
	@FindBy(name = "lastname")
	private WebElement LastNameEdt;
	
	@FindBy(xpath = "//img[@title='Select']")
	private WebElement selectOrgLkpImg;
	
	@FindBy(name = "search_text")
	private WebElement searchOrgEdt;
	
	@FindBy(name = "search")
	private WebElement searchBtn;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	public void createCnt(String lastname,String firstname)
	{
		LastNameEdt.sendKeys(lastname);
		FirstNameEdt.sendKeys(firstname);
		saveBtn.click();
	}
	
	public void createCntWithOrg(String firstname,String lastname,WebDriver driver, String orgName)
	{
		FirstNameEdt.sendKeys(firstname);
		LastNameEdt.sendKeys(lastname);
		selectOrgLkpImg.click();
		switchToWindowUsingTitle(driver, "Accounts&action");
		searchOrgEdt.sendKeys(orgName);
		searchBtn.click();
		driver.findElement(By.xpath("//a[.='"+orgName+"']")).click();
		switchToWindowUsingTitle(driver, "Contacts&action");
		saveBtn.click();
	}
}