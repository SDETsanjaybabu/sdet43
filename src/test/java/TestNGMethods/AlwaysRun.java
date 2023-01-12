package TestNGMethods;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AlwaysRun {
	@Test
	public void dog()
	{
		Assert.fail();
		System.out.println("bow bow");
	}
	@Test
	public void cat()
	{
		System.out.println("meow meow");
	}

	@Test(dependsOnMethods = "dog",alwaysRun = true)
	public void snake()
	{
		System.out.println("buss buss");
	}
}
