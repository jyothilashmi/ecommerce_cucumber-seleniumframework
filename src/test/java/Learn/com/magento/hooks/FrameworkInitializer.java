package Learn.com.magento.hooks;

import Learn.com.magento.utils.ConfigUtil;
import Learn.com.magento.utils.LoggerUtil;
import io.cucumber.java.BeforeAll;

public class FrameworkInitializer {
	
	@BeforeAll
	public static void loadFrameworkConfig()
	{
		ConfigUtil.loadConfig();
		LoggerUtil.getInfo("Framework config file has been successfully loaded.");
	}
	

}
