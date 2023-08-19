package jayashgarg.pageobjects;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import jayashgarg.AbstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents{
	
	WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}		
		//PageFactory Method
		@FindBy(id="userEmail")
		WebElement userMail;
		
		@FindBy(id="userPassword")
		WebElement userPwd;
		
		@FindBy(id="login")
		WebElement loginBtn;
		
		//div[aria-label='Incorrect email or password.']
		//.ng-tns-c4-10.ng-star-inserted.ng-trigger.ng-trigger-flyInOut.ngx-toastr.toast-error
		
		@FindBy(css="[class*='flyInOut']")
		WebElement errorMessage;
		public ProductCatalog loginApplication(String email, String password) {

			userMail.sendKeys(email);
			userPwd.sendKeys(password);
			loginBtn.click();
			return new ProductCatalog(driver);

}

		public String getErrorMessage() {
			waitForWebElementToAppear(errorMessage);
			return errorMessage.getText();
			
		}
		
		public void goTo() {
			
			driver.get("https://rahulshettyacademy.com/client");
			
		}
}