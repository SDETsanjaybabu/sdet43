package TestNGMethods;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import genericUtilities.ExcelUtility;

public class BooktICKWT {
	
@Test(dataProvider = "bookingTickets")
public void bookingTicket(String src,String dst)
{
	System.out.println("book from "+src+" to "+dst);
}
@DataProvider
public Object[][] bookingTickets() throws Throwable
{
ExcelUtility eLib = new ExcelUtility();
	String src1 = eLib.getExcelData("Sheet1", 0, 0);
	String dst1 = eLib.getExcelData("sheet1", 0, 1);
	
	String src2 = eLib.getExcelData("Sheet1", 1, 0);
	String dst2 = eLib.getExcelData("Sheet1", 1, 1);
	
	Object[][] objArr = new Object[2][2];
	objArr[0][0]=src1;
	objArr[0][1]=dst1;
	
	objArr[1][0]=src2;
	objArr[1][1]=dst2;
			
	return objArr;
	
	
}
}
