package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebdriverUtility;

public class HomePage extends WebdriverUtility{

public HomePage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

@FindBy(xpath = "//a[.='Organizations']") private WebElement orgLink;

@FindBy(xpath = "//a[.='Contacts']")
private WebElement cntLink;

@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
private WebElement admstLink;

@FindBy(xpath = "//a[.='Sign Out']")
private WebElement signOutLnk;



public WebElement getOrgLink() {
	return orgLink;
}

public WebElement getCntLink() {
	return cntLink;
}

public WebElement getAdmstLink() {
	return admstLink;
}

public WebElement getSignOutLnk() {
	return signOutLnk;
}



public void Logout(WebDriver driver)
{
	mouseOverOnElement(driver, admstLink);
	signOutLnk.click();
}
}
