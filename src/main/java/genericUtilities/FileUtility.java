package genericUtilities;

import java.io.FileInputStream;
import java.util.Properties;
/**
 * 
 * @author SanjayBabu
 *
 */
public class FileUtility {
/**
 * its used to get the property key value from the property key
 * @param key
 * @return
 * @throws Throwable
 */
	public String getPropertyKeyValue(String key) throws Throwable
	{
		FileInputStream fileInputStream = new FileInputStream(IPathConstants.filePath);
		Properties property = new Properties();
		property.load(fileInputStream);
		String value = property.getProperty(key);
		return value;
	}
}
