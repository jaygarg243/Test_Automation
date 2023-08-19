package jayashgarg.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ConfirmPayment extends AbstractComponents {
	WebDriver driver;
	public ConfirmPayment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className="title")
	 WebElement title;
	
	@FindBy(xpath="//div[@class='cart_item_label']//a")
	List<WebElement> confirmedcartitems;
	
	@FindBy(xpath="//div[@class='summary_info']/div[2]")
	 WebElement cardsummary;
	
	@FindBy(xpath="//div[@class='summary_info']/div[4]")
	 WebElement shippingsummary;
	
	@FindBy(xpath="//div[@class='summary_subtotal_label']")
	 WebElement subtotal;
	
	@FindBy(xpath="//div[@class='summary_tax_label']")
	 WebElement tax;
	
	@FindBy(xpath="//div[@class='summary_info_label summary_total_label']")
	 WebElement total;
	
	@FindBy(id="finish")
	 WebElement finish;
	
	public void validateTotal(){
		int dollarsignindex = subtotal.getText().indexOf("$");
		String subt = subtotal.getText().substring(dollarsignindex+1);
		float sub = Float.parseFloat(subt);
		int dollarsignindex2 = tax.getText().indexOf("$");
		String subt2 = tax.getText().substring(dollarsignindex2+1);
		float sub2 = Float.parseFloat(subt2);
		int dollarsignindex3 = total.getText().indexOf("$");
		String subt3 = total.getText().substring(dollarsignindex3+1);
		float sub3 = Float.parseFloat(subt3);
		Assert.assertEquals(sub3==sub+sub2, true);
	}
	
	public void validateCartItems(String product) {
		confirmedcartitems.stream().forEachOrdered(prod->Assert.assertEquals(prod.getText().equalsIgnoreCase(product), true));
	}
	
	public OrderDispatched finishpay() {
		finish.click();
		OrderDispatched order = new OrderDispatched(driver);
		return order;
	}
	public void validateTitle() {
		Assert.assertEquals(title.getText().equalsIgnoreCase("Checkout: Overview"), true);
	}

}
