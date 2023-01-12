package excelPracticeScripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class InsertSingleDataIntoExcel {

	public static void main(String[] args) throws EncryptedDocumentException, FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		Workbook workbook = WorkbookFactory.create(new FileInputStream("./src/test/resources/myExcel.xlsx"));
		Sheet sheet = workbook.getSheet("Sheet1");
		Row row = sheet.getRow(0);
		Cell cell = row.createCell(1);
		cell.setCellValue("Hi");

		FileOutputStream fout=new FileOutputStream("./src/test/resources/myExcel.xlsx");
		workbook.write(fout);
	}
}