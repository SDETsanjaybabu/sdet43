package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.fasterxml.jackson.core.sym.Name;


/**
 * 
 * @author SanjayBabu
 *
 */
public class LoginPage {
	/**
	 * 
	 * @param driver
	 */
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	@FindBys({@FindBy(name = "user_name"),@FindBy(xpath = "//input[@type='text']")})
	private WebElement userNameEdt;

	@FindAll({@FindBy(name = "user_password"),@FindBy(xpath = "//input[@type='passwor']")})
	private WebElement pwdTxtEdt;

	@FindBy(id = "submitButton")
	private WebElement  lgnBtn;


	public WebElement getUserNameEdt() {
		return userNameEdt;
	}
	public WebElement getPwdEdt()
	{
		return pwdTxtEdt;
	}
	public WebElement getLoginBtn() {
		return lgnBtn;
	}


	public void loginToApp(String username,String password)
	{
		userNameEdt.sendKeys(username);
		pwdTxtEdt.sendKeys(password);
		lgnBtn.click();
	}
}
