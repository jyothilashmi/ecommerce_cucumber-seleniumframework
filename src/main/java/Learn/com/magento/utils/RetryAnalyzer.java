package Learn.com.magento.utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import Learn.com.magneto.base.TestContext;

public class RetryAnalyzer implements IRetryAnalyzer {

	private int retryCount=0;
	private int maxRetryCount=3;
	private TestContext testContext;
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if(retryCount<maxRetryCount)
		{
			retryCount++;
			testContext.getExtentTest().warning("Retrying test " + result.getName() + ", Attempt #" + (retryCount + 1));
			//System.out.println("Attempt"+retryCount);
			return true;
		}
		return false;
	}

}
