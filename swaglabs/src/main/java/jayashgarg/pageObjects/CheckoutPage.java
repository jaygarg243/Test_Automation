package jayashgarg.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CheckoutPage extends AbstractComponents{
	WebDriver driver;
	public CheckoutPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className="title")
	public WebElement title; 
	
	@FindBy(id="first-name")
	WebElement firstnameinput;
	
	@FindBy(id="last-name")
	WebElement lastnameinput;
	
	@FindBy(id="postal-code")
	WebElement postalcodeinput;
	
	@FindBy(id="cancel")
	WebElement cancelbutton;
	
	@FindBy(id="continue")
	WebElement continuebutton;
	
	public void giveCustomerData(String firstname, String lastname, String zipcode) {
		firstnameinput.sendKeys(firstname);
		lastnameinput.sendKeys(lastname);
		postalcodeinput.sendKeys(zipcode);
	}
	
	public ConfirmPayment continueToPayment() {
		continuebutton.click();
		ConfirmPayment cnfrmpay = new ConfirmPayment(driver);
		return cnfrmpay;
	}
	
	public void goBackToCart() {
		cancelbutton.click();
	}
	public void validateTitle() {
		Assert.assertEquals(title.getText().equalsIgnoreCase("Checkout: Your Information"), true);
	}
}
