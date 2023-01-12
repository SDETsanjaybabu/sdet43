package genericUtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 
 * @author SanjayBabu
 *
 */
public class ExcelUtility {
	/**
	 * its used to read the data from excel workbook
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws Throwable
	 */
	public String getExcelData(String sheetName,int rowNum,int cellNum)throws Throwable
	{
		FileInputStream fileInputStream = new FileInputStream(IPathConstants.excelPath);
		Workbook workbook = WorkbookFactory.create(fileInputStream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		DataFormatter format=new DataFormatter();
		String value = format.formatCellValue(cell);
		return value;
	}
	/**
	 * its used to get last used 
	 * @param sheetName
	 * @return
	 * @throws Throwable
	 */
	public int getRowCount(String sheetName)throws Throwable
	{
		FileInputStream fileInputStream = new FileInputStream(IPathConstants.excelPath);
		Workbook workbook = WorkbookFactory.create(fileInputStream);
		Sheet sheet = workbook.getSheet(sheetName);	
		int value = sheet.getLastRowNum();
		return value;
	}
	/**
	 * its used to set value to excel
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @param data
	 * @throws Throwable
	 */
	public void setDataToExcel(String sheetName,int rowNum,int cellNum,String data)throws Throwable
	{
		FileInputStream fileInputStream = new FileInputStream(IPathConstants.excelPath);
		Workbook workbook = WorkbookFactory.create(fileInputStream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.createCell(cellNum);
		cell.setCellValue(data);
		FileOutputStream fileOutputStream=new FileOutputStream(IPathConstants.excelPath);
		workbook.write(fileOutputStream);
		workbook.close();
	}
}
