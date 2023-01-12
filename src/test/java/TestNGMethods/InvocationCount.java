package TestNGMethods;

import org.testng.annotations.Test;

public class InvocationCount {
	@Test(invocationCount = 3)
	public void dog()
	{
		System.out.println("bow bow");
	}
	@Test(invocationCount = 2)
	public void cat()
	{
		System.out.println("meow meow");
	}

	@Test(invocationCount = 1)
	public void snake()
	{
		System.out.println("buss buss");
	}
}
