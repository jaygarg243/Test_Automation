package jayashgarg.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import jayashgarg.AbstractComponents.AbstractComponents;

public class CheckOutPage extends AbstractComponents{
	WebDriver driver;
	public CheckOutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[text()='CVV Code ']/following-sibling::input")
	WebElement cvvinput;
	
	@FindBy(css=".action__submit")
	WebElement cvvsubmit;
	
	
	
	
	
	By countryDropDown = By.xpath("//input[@placeholder='Select Country']");
	
	public void selectCountry(String countrySearch, String countryMatch) {
		Actions a = new Actions(driver);
		driver.findElement(countryDropDown).sendKeys(countrySearch);
		List<WebElement> countries = driver.findElements(By.cssSelector(".list-group-item"));
		
		for(WebElement country : countries) {
			if(country.getText().equalsIgnoreCase(countryMatch)) {
				a.moveToElement(country).click().build().perform();
				break;
			}
		}
	}
	
	public ConfirmationPage submitCVV(String cvv) {
		cvvinput.sendKeys(cvv);
		cvvsubmit.click();
		return new ConfirmationPage(driver);
	}
	


}
