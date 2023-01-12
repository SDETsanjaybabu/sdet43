package genericUtilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListnerImp implements ITestListener{
	ExtentReports report;
	ExtentTest test;
	
	public void onTestStart(ITestResult result) {
		test=report.createTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.PASS, result.getMethod().getMethodName());
		test.log(Status.PASS,result.getThrowable());
	}

	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, result.getMethod().getMethodName());
		test.log(Status.FAIL, result.getThrowable());
		
		try {
			String screenShot = WebdriverUtility.takeScreenShot(BaseClass.sdriver, result.getMethod().getMethodName());
			test.addScreenCaptureFromPath(screenShot);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
	test.log(Status.SKIP, result.getMethod().getMethodName());
	test.log(Status.SKIP, result.getThrowable());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		ExtentSparkReporter Spark = new ExtentSparkReporter("ExtentReport/reporter.html");
		Spark.config().setTheme(Theme.DARK);
		Spark.config().setReportName("framework extent report");
		Spark.config().setDocumentTitle("sanjay doc");
		
		report=new ExtentReports();
		report.attachReporter(Spark);
		report.setSystemInfo("createdBy", "sanjay");
		report.setSystemInfo("ReviewedBy", "babu");
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
	ExtentSparkReporter spark = new ExtentSparkReporter("/exet/rport.html");
	spark.config().setTheme(Theme.DARK);
	spark.config().setReportName("sanjay");
	spark.config().setDocumentTitle("babus ");
	
	report=new ExtentReports();
	report.attachReporter(spark);
	report.setSystemInfo("hi", "bye");
	}

	public void onFinish(ITestContext context) {
	report.flush();
	}

}
