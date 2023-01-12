package excelPracticeScripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchOnly1stAnd2ndColumnData {

	public static void main(String[] args) throws EncryptedDocumentException, FileNotFoundException, IOException {
		Workbook workbook = WorkbookFactory.create(new FileInputStream("./src/test/resources/myExcel.xlsx"));
		Sheet sheet = workbook.getSheet("Sheet1");
		int count = sheet.getLastRowNum();
		for (int i = 0; i <=count; i++) 
		{
			Row row = sheet.getRow(i);
			String firstCellData = row.getCell(0).getStringCellValue();
			String secondCellData = row.getCell(1).getStringCellValue();
			System.out.println(firstCellData+"\t"+secondCellData);
		}
	}
}