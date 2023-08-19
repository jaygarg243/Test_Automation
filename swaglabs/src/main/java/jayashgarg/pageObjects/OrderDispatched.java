package jayashgarg.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class OrderDispatched extends AbstractComponents {
	WebDriver driver;
	public OrderDispatched(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className="title")
	WebElement title;
	
	@FindBy(xpath="//img[@alt='Pony Express']")
	WebElement image;
	
	@FindBy(tagName="h2")
	WebElement thankmessage;
	
	public void confirmOrderSuccess() {
		Assert.assertEquals(title.getText().equalsIgnoreCase("Checkout: Complete!"),true);
		Assert.assertEquals(thankmessage.getText().equalsIgnoreCase("Thank you for your order!"),true);
	}

}
