package genericUtilities;

import java.awt.Window;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * 
 * @author SanjayBabu
 *
 */
public class WebdriverUtility {
	/**
	 * 
	 * @param driver
	 */
	//public static WebDriver driver=null;
	public void waitForPageToLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IPathConstants.impDtn));
	}
	/**
	 * 
	 * @param driver
	 */
	public void maximizeTheWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	/**
	 * 
	 * @param driver
	 */
	public void minimizeTheWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	/**
	 * 
	 * @param driver
	 */
	public void refreshThePage(WebDriver driver)
	{
		driver.navigate().refresh();
	}
	/**
	 * 
	 * @param driver
	 */
	public void backToPreviousPage(WebDriver driver)
	{
		driver.navigate().back();
	}
	/**
	 * 
	 * @param driver
	 */
	public void forwardToTheNextPage(WebDriver driver)
	{
		driver.navigate().forward();
	}
	/**
	 * 
	 * @param driver
	 */
	public void waitForPageToLoadForJSElement(WebDriver driver)
	{
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
	}
	/**
	 * 
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickable(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * 
	 * @param driver
	 * @param element
	 */
	public void waitForVisibilityOfElement(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * 
	 * @param driver
	 * @param title
	 */
	public void waitForTitleContains(WebDriver driver,String title)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.titleContains(title));
	}
	/**
	 * 
	 * @param driver
	 * @param URL
	 */
	public void urlContains(WebDriver driver,String URL)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.urlContains(URL));
	}
	/**
	 * 
	 * @param driver
	 * @param pollingTime
	 * @param element
	 */
	public void waitAndClickUsingCustomWait(WebDriver driver,Duration pollingTime,WebElement element)
	{
		FluentWait wait = new FluentWait(driver);
		wait.pollingEvery(pollingTime);
		wait.ignoring(NullPointerException.class);
		try {
			wait.wait(20);
			wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * @param element
	 * @param duration
	 * @param sleepDuration
	 */
	public void waitAndClickUsingCustomWait(WebElement element,int duration,long pollingTime)
	{
		int count=0;
		while(count< duration)//20
		{
			try {
				element.click();
				break;
			} catch (Exception e) {
				try {
					Thread.sleep(pollingTime);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				count++;
			}
		}
	}
	/**
	 * 
	 * @param driver
	 * @param URL
	 */
	public void switchToWindowUsingURL(WebDriver driver,String URL)
	{
		Set<String> set = driver.getWindowHandles();
		for (String string : set) 
		{
			driver.switchTo().window(string);
			String currentURL = driver.getCurrentUrl();
			if(currentURL.contains(URL))
			{
				break;
			}
		}
	}
	/**
	 * 
	 * @param driver
	 * @param currentTitle
	 */
	public void switchToWindowUsingTitle(WebDriver driver,String currentTitle)
	{
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while(it.hasNext())
		{
			String wId = it.next();
			driver.switchTo().window(wId);
			String title = driver.getTitle();
			if(title.contains(currentTitle))
			{
				break;
			}
		}
	}
	/**
	 * 
	 * @param driver
	 * @param expectedMsg
	 */
	public void switchToAlertWindowAndAccept(WebDriver driver,String expectedMsg)
	{
		Alert alert = driver.switchTo().alert();
		if(alert.getText().trim().equalsIgnoreCase(expectedMsg.trim()))
		{
			System.out.println("alert msg is verified");
		}else {
			System.out.println("alert msg is not verified");
		}
		alert.accept();
	}
	/**
	 * 
	 * @param driver
	 * @param expectedMsg
	 */
	public void switchToAlertWindowAndCancel(WebDriver driver,String expectedMsg)
	{
		Alert alert = driver.switchTo().alert();
		if(alert.getText().trim().equalsIgnoreCase(expectedMsg.trim()))
		{
			System.out.println("alert msg is verified");
		}else {
			System.out.println("alert msg is not verified");
		}
		alert.dismiss();
	}
	/**
	 * 
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	/**
	 * 
	 * @param driver
	 * @param id
	 */
	public void switchToFrame(WebDriver driver,String id)
	{
		driver.switchTo().frame(id);
	}
	/**
	 * 
	 * @param driver
	 * @param element
	 */
	public void switchToFrame(WebDriver driver,WebElement element)
	{
		driver.switchTo().frame(element);
	}
	/**
	 * 
	 * @param driver
	 */
	public void switchToParentFrame(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	/**
	 * 
	 * @param element
	 * @param index
	 */
	public void select(WebElement element,int index)
	{
		Select selct = new Select(element);
		selct.selectByIndex(index);
	}
	/**
	 * 
	 * @param element
	 * @param value
	 */
	public void select(WebElement element,String value)
	{
		Select selct=new Select(element);
		selct.selectByValue(value);
	}
	/**
	 * 
	 * @param element
	 * @param visible_txt
	 */
	public void selectDropDownUsingTxt(WebElement element,String visible_txt)
	{
		Select selct=new Select(element);
		selct.selectByVisibleText(visible_txt);
	}
	/**
	 * 
	 * @param driver
	 * @param element
	 */
	public void mouseOverOnElement(WebDriver driver,WebElement element)
	{
		Actions action=new Actions(driver);
		action.moveToElement(element).perform();
	}
	/**
	 * 
	 * @param element
	 */
	public void getAllOptionsIndropdown(WebElement element)
	{
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		int count = options.size();
		System.out.println(count);
		for (WebElement webElement : options) {
			String text = webElement.getText();
			System.out.println(text);
		}
	}
	/**
	 * 
	 * @param driver
	 * @param element
	 */
	public void doubleClickOnElement(WebDriver driver,WebElement element)
	{
		Actions action = new Actions(driver);
		action.doubleClick(element).perform();
	}
	/**
	 * 
	 * @param driver
	 * @param element
	 */
	public void rightClickOnElement(WebDriver driver,WebElement element)
	{
		Actions action=new Actions(driver);
		action.contextClick(element).perform();
	}
	/**
	 * 
	 * @param driver
	 */
	public void passEntryKey(WebDriver driver)
	{
		Actions action=new Actions(driver);
		action.sendKeys(Keys.ENTER).perform();
	}
	/**
	 * 
	 * @param driver
	 * @param screenShotName
	 * @throws IOException
	 */
	public static String takeScreenShot(WebDriver driver,String screenShotName) throws IOException
	{
		TakesScreenshot takesScreenShot=(TakesScreenshot)driver;
		File src = takesScreenShot.getScreenshotAs(OutputType.FILE);
		File dst = new File("./screenShots/"+screenShotName+".PNG");
		Files.copy(src, dst);
		return screenShotName;
	}
	/**
	 * 
	 * @param element
	 * @param data
	 * @param duration
	 * @param pollingTime
	 * @throws InterruptedException
	 */
	public void waitAndSendData(WebElement element, String data, int duration,  long pollingTime) throws InterruptedException
	{
		for (int i = 0; i < duration; i++) {
			try {
				element.sendKeys(data);
				break;
			}
			catch(Exception e)
			{
					Thread.sleep(pollingTime);
			}
		}
	}
	public void scrollBarAction(WebDriver driver,int x,int y)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		for (int i = 0; i < 3; i++) 
		{
			js.executeScript("window.scrollBy(x,y)");
		}
	}
}
