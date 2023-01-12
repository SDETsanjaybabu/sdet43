package excelPractice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InsertDataIntoExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
	FileInputStream fs=new FileInputStream("./src/test/resources/sample.xlsx");
	Workbook wk = WorkbookFactory.create(fs);
	Sheet sh = wk.getSheet("Sheet1");
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("http://localhost:8888");
	driver.findElement(By.name("user_name")).sendKeys("admin");
	driver.findElement(By.name("user_password")).sendKeys("admin");
	driver.findElement(By.id("submitButton")).click();
	List<WebElement> links = driver.findElements(By.xpath("//a"));
	int count = links.size();
	for (int i = 0; i < count; i++) 
	{
		Row r = sh.createRow(i);
		Cell c = r.createCell(0);
		c.	setCellValue(links.get(i).getAttribute("href"));
	}
	FileOutputStream fout=new FileOutputStream("./src/test/resources/sample.xlsx");
	wk.write(fout);
	}
}