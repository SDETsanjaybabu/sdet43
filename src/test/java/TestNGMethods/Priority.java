package TestNGMethods;

import org.testng.annotations.Test;

public class Priority {
	@Test(priority = 1)
	public void dog()
	{
		System.out.println("bow bow");
	}
	@Test(priority = 0)
	public void cat()
	{
		System.out.println("meow meow");
	}

	@Test(priority = -1)
	public void snake()
	{
		System.out.println("buss buss");
	}
}
