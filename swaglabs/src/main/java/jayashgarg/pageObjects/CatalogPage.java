package jayashgarg.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CatalogPage extends AbstractComponents{
	WebDriver driver;
	public CatalogPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className="title")
	public WebElement title;
	
	@FindBy(className="app_logo")
	public WebElement appname;
	
	@FindBy(className="shopping_cart_link")
	public WebElement cartbutton;
	
	public void addProductToCart(String product) {
		String xpath = "//div[text()='"+product+"']/parent::a/parent::div/following-sibling::div/button";
		WebElement addProductToCartButton = driver.findElement(By.xpath(xpath));
		addProductToCartButton.click();
	}
	
	public CartPage goToCart() {
		cartbutton.click();
		CartPage cart = new CartPage(driver);
		return cart;
	}
	
	public void validateTitle() {
		Assert.assertEquals(title.getText().equalsIgnoreCase("products"), true);
	}
	
	
	
}
