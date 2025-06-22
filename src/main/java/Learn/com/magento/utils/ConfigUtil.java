package Learn.com.magento.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigUtil {
	private static Properties prop = new Properties();
	
	public static void loadConfig()
	{
		try
		{
			
			FileInputStream file=new FileInputStream(System.getProperty("user.dir") + File.separator + "resources" +File.separator+"config.properties");
			prop.load(file);
			
		}
		catch(IOException e)
		{
            e.printStackTrace();
            
		}
	}
	public static String getProperty(String key)
	{
		return prop.getProperty(key);
	}

}
