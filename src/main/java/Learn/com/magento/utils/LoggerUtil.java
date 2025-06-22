package Learn.com.magento.utils;

import org.apache.logging.log4j.Logger;

import org.apache.logging.log4j.LogManager;



public class LoggerUtil {
	
	private static final Logger logger=LogManager.getLogger(LoggerUtil.class);
	
	public static void getInfo(String message)
	{
		logger.info(message);
		
	}
public static void getWarning(String message)
{
	logger.warn(message);
}
public static void getError(String message)
{
	logger.error(message);
}
}
