package TestNGMethods;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class PrintUsingReporterLog {
@Test
public void dog()
{
	Reporter.log("bow bow",true);
}
@Test
public void cat()
{
	Reporter.log("meow meow",true);
}
@Test
public void snake()
{
	Reporter.log("buss buss",true);
}
}
