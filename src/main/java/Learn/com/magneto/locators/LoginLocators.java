package Learn.com.magneto.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginLocators {

	@FindBy(id="email")
	protected WebElement txtEmail;
	
	@FindBy(id="pass")
	protected WebElement txtPassword;
	
	@FindBy(id="send2")
	protected WebElement btnSignin;
	
	
	
}
