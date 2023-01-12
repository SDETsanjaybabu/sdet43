package excelPractice;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchMultipleDataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
//		FileInputStream fileInputStream=new FileInputStream("./src/test/resources/Sdet37TestData.xlsx");
//		Workbook workbook = WorkbookFactory.create(fileInputStream);
//		Sheet sheet = workbook.getSheet("Organisations");
//		for (int i = 0; i <=sheet.getLastRowNum(); i++) 
//		{
//			Row row = sheet.getRow(i);
//			for (int j = 0; j <=row.getLastCellNum(); j++) 
//			{
//				Cell cell = row.getCell(j);
//				DataFormatter format=new DataFormatter();
//				String value = format.formatCellValue(cell);
//				System.out.println(value);
//			}
//			System.out.println();
//		}
		
		FileInputStream fs=new FileInputStream("./src/test/resources/Sdet37TestData.xlsx");
		Workbook wk = WorkbookFactory.create(fs);
		Sheet sh = wk.getSheet("Organisations");
		for (int i = 0; i <=sh.getLastRowNum(); i++) 
		{
			Row r = sh.getRow(i);
			for (int j = 0; j <r.getLastCellNum(); j++) 
			{
				Cell c = r.getCell(j);
				String value = c.toString();
				System.out.println(value);
			}
			System.out.println();
		}
	}
}