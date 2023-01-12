package TestNGMethods;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependsOnMethods {
	@Test
	public void dog()
	{
		System.out.println("bow bow");
	}
	@Test
	public void cat()
	{
		System.out.println("meow meow");
		Assert.fail();
	}

	@Test(dependsOnMethods = {"dog","cat"})
	public void snake()
	{
		System.out.println("buss buss");
	}
}
