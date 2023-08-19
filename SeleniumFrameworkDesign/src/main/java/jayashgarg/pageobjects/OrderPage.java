package jayashgarg.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import jayashgarg.AbstractComponents.AbstractComponents;

public class OrderPage extends AbstractComponents {
	
	WebDriver driver;

	public OrderPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> orderlist;
	
	public Boolean findProductInOrders(String productName) {
		Boolean ordermatch = orderlist.stream().anyMatch(cartProd->cartProd.getText().equalsIgnoreCase(productName));
		return ordermatch;
	}
	
}
