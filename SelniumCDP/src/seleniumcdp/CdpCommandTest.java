package seleniumcdp;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.emulation.Emulation;

public class CdpCommandTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\jayas\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		DevTools devtools = driver.getDevTools();
		
		devtools.createSession();
		Map devicemetrics = new HashMap();
		devicemetrics.put("width", 600);
		devicemetrics.put("height", 1000);
		devicemetrics.put("deviceScaleFactor", 50);
		devicemetrics.put("mobile", true);
		driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", devicemetrics);
		driver.get("http://rahulshettyacademy.com/angularAppdemo");
		driver.findElement(By.cssSelector(".navbar-toggler")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Library")).click();
		driver.close();
		
		
	}

}
