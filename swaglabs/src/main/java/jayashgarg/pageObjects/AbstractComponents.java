package jayashgarg.pageObjects;

import java.time.Duration;
import java.util.Optional;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.devtools.v109.network.Network;
import org.openqa.selenium.devtools.v109.network.model.ConnectionType;
import org.openqa.selenium.support.PageFactory;

public class AbstractComponents {
	WebDriver driver;
	public AbstractComponents(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void waitImplicit() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	}
	
	public void slowNetSpeed() {
		DevTools devtools = ((HasDevTools) driver).getDevTools();
		devtools.createSession();
		System.out.println(devtools.getCdpSession());
		devtools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		devtools.send(Network.emulateNetworkConditions(false, 5000, 20000, 10000, Optional.of(ConnectionType.CELLULAR3G)));
		System.out.println("Internet Slowed");
	}
}
