package jayashgarg.testComponents;

import java.util.Optional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.devtools.v109.network.Network;
import org.openqa.selenium.devtools.v109.network.model.ConnectionType;
//import org.openqa.selenium.devtools.DevTools;
import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeSuite;

import jayashgarg.pageObjects.AbstractComponents;
import jayashgarg.pageObjects.LoginPage;

public class BaseTest {
    WebDriver driver;
	public LoginPage loginpage;
	AbstractComponents abs;
	
	public WebDriver initializeDriver() {
		driver = new ChromeDriver();
		return driver;
	}
	@BeforeMethod
	public LoginPage loginpage() {
		WebDriver driver = initializeDriver();
		loginpage = new LoginPage(driver);
		abs = new AbstractComponents(driver);
		abs.slowNetSpeed();
		loginpage.goTo();
		return loginpage;
	}
	@AfterMethod
	public void teardown() {
		driver.close();
	}
}
