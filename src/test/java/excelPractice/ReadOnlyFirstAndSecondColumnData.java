package excelPractice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadOnlyFirstAndSecondColumnData {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		FileInputStream fs=new FileInputStream("./src/test/resources/sample.xlsx");
		Workbook wb = WorkbookFactory.create(fs);
		Sheet sh = wb.getSheet("Sheet1");
		int count = sh.getLastRowNum();
		for (int i = 0; i <count; i++) 
		{
			Row r = sh.getRow(i);
			String c1 = r.getCell(0).getStringCellValue();
			String c2 = r.getCell(1).getStringCellValue();
			System.out.println(c1+"\t"+c2);
		}
	}
}