package jayashgarg.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
//import org.testng.Assert;

import jayashgarg.AbstractComponents.AbstractComponents;

public class cartPage extends AbstractComponents{
	WebDriver driver;
	public cartPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	By cartList = By.cssSelector(".cartSection h3");
	By checkout = By.xpath("//button[text()='Checkout']");
	

	public List<WebElement> getCartList() {
		List<WebElement> cartItems = driver.findElements(cartList);
		return cartItems;
	}
	
	public Boolean findProductInCart(String productName) {
		Boolean productMatch = getCartList().stream().anyMatch(cartProd->cartProd.getText().equalsIgnoreCase(productName));
		return productMatch;
	}
	
	public CheckOutPage checkout() {
		driver.findElement(checkout).click();
		return new CheckOutPage(driver);
	}
	
	

}
