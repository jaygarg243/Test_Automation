package jayashgarg.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CartPage extends AbstractComponents{
	WebDriver driver;
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a/div")
	public List<WebElement> cartProducts;
	
	@FindBy(id="checkout")
	public WebElement checkoutbutton;
	
	@FindBy(id="continue-shopping")
	public WebElement continueshopping;
	
	@FindBy(className="title")
	public WebElement title;
	
	public void validateCartItems(String product) {
		cartProducts.stream().forEachOrdered(prod->Assert.assertEquals(prod.getText().equalsIgnoreCase(product), true));
	}
	
	public void continueShopping() {
		continueshopping.click();
	}
	public CheckoutPage checkout() {
		checkoutbutton.click();
		CheckoutPage checkout = new CheckoutPage(driver);
		return checkout;
	}
	public void validateTitle() {
		Assert.assertEquals(title.getText().equalsIgnoreCase("Your Cart"), true);
	}
}
