package excelPractice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchPerticularData {
	public static void main(String[] args) throws EncryptedDocumentException, FileNotFoundException, IOException {
		Sheet sheet = WorkbookFactory.create(new FileInputStream("./src/test/resources/Sdet37TestData.xlsx")).getSheet("Sheet1");
		boolean flag=false;
		for(int i=0;i<=sheet.getLastRowNum();i++) {
			if(sheet.getRow(i)==null) continue;
			for(int j=0;j<sheet.getRow(i).getLastCellNum();j++)
			{ 
				if(sheet.getRow(i).getCell(j)==null || sheet.getRow(i).getCell(j).toString().isBlank()) continue;
				String data = new DataFormatter().formatCellValue(sheet.getRow(i).getCell(j));
				if(data.equals("s"))
				{
					System.out.println(sheet.getRow(i+1).getCell(j));
					flag=true;
					break;
				}
			}
			if(flag==true)break;
		}
	}
}
