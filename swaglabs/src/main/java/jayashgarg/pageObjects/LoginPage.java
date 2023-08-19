package jayashgarg.pageObjects;

import java.util.Optional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.devtools.v109.network.Network;
import org.openqa.selenium.devtools.v109.network.model.ConnectionType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractComponents{
	WebDriver driver;
	AbstractComponents abs;
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="user-name")
	WebElement username;
	
	@FindBy(id="password")
	WebElement pwd;
	
	@FindBy(id="login-button")
	WebElement loginbtn;
	
	public void goTo() {
		driver.get("https://www.saucedemo.com/");
	}
	
	public CatalogPage login(String userinput, String pwdinput) {
		username.sendKeys(userinput);
		pwd.sendKeys(pwdinput);
		loginbtn.click();
		abs = new AbstractComponents(driver);
		abs.slowNetSpeed();
		CatalogPage catalog = new CatalogPage(driver);
		return catalog;
	}
}
