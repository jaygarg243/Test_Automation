package seleniumcdp;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.emulation.Emulation;

public class SetGeolocation {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\jayas\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		DevTools devtools = driver.getDevTools();
		
		devtools.createSession();
		Map<String, Object> coords = new HashMap<String, Object>();
		coords.put("latitude", 40);
		coords.put("longitude", 3);
		coords.put("accuracy", 1);
		devtools.send(Emulation.setGeolocationOverride(Optional.of(40), Optional.of(3), Optional.of(1)));
		//driver.executeCdpCommand("Emulation.setGeolocationOverride", coords);
		driver.get("http://www.google.com");
		driver.findElement(By.name("q")).sendKeys("Netflix",Keys.ENTER);
		driver.findElements(By.cssSelector(".LC20lb")).get(0).click();
		String msg = driver.findElements(By.cssSelector(".default-ltr-cache-qsjwmk")).get(0).getText();
		System.out.println(msg);
	}
	

}
