package TestNGMethods;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AnnotationsTest {
	@BeforeGroups(groups = "abc")
	public void bg()
	{
		System.out.println("bfrGroup");
	}
	@AfterGroups(groups = "abc")
	public void ag()
	{
		System.out.println("aftGroups");
	}
	@BeforeTest(groups = "abc")
	public void bt()
	{
		System.out.println("bftTest");
	}
	@BeforeSuite(groups = "abc")
	public void bs()
	{
		System.out.println("bfrSuite");
	}

	@BeforeClass(groups = "abc")
	public void bc()
	{
		System.out.println("bfrClass");
	}

	@BeforeMethod(groups = "abc")
	public void bm()
	{
		System.out.println("bfrMtd");
	}

	@BeforeMethod(groups = "abc")
	public void am2()
	{
		System.out.println("bfrMtd2");
	}

	@Test(groups = "abc")
	public void test1()
	{
		System.out.println("Hi-Test1");
	}
	
	@Test
	public void test2()
	{
		System.out.println("Hello-Test2");
	}

	@AfterMethod(groups = "abc")
	public void am()
	{
		System.out.println("aftMtd");
	}
	@AfterClass(groups = "abc")
	public void ac()
	{
		System.out.println("aftClass");
	}
	@AfterTest(groups = "abc")
	public void at()
	{
		System.out.println("aftTest");
	}
	@AfterSuite(groups = "abc")
	public void as()
	{
		System.out.println("aftSuite");
	}
}
