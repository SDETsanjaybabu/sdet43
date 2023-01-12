package TestNGMethods;

import org.testng.annotations.Test;

public class EnaledMethod {
	@Test(enabled = true)
	public void dog()
	{
		System.out.println("bow bow");
	}
	@Test(enabled = true)
	public void cat()
	{
		System.out.println("meow meow");
	}

	@Test(enabled = false)
	public void snake()
	{
		System.out.println("buss buss");
	}
}
