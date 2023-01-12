package genericUtilities;

import java.util.Date;
import java.util.Random;

/**
 * it contains java specific libraries like get random number and get system date
 * @author SanjayBabu
 *
 */
public class JavaUtility {
	/**
	 * its used to get random number within the range 1000
	 * @return
	 */
	public int getRandomNumber()
	{
		Random random = new Random();
		int ranNum = random.nextInt();
		return ranNum;
	}
	/**
	 * its used to get system date and time
	 * @return
	 */
	public String getSystemDate()
	{
		Date dateAndTime = new Date();
		return dateAndTime.toString();
	}
	/**
	 * its used to get system date and time in specific format
	 * @return
	 */
	public String getSystemDateInRequiredFormate()
	{
		Date date = new Date();
		String dateAndTime = date.toString();
		String[] arr = dateAndTime.split(" ");

		String DD = arr[2];
		String MM = arr[1];
		String YYYY = arr[5];
		String Day = arr[1];
		String Time = arr[3];
		
		String finalFormat = DD+" "+MM+" "+YYYY+" "+Day+" "+Time;
		return finalFormat;
	}
}