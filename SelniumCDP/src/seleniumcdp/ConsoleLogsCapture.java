package seleniumcdp;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

public class ConsoleLogsCapture {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\jayas\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector("a[routerlink*=products]")).click();
		driver.findElement(By.linkText("Selenium")).click();
		driver.findElement(By.cssSelector(".add-to-cart")).click();
		//System.out.println(driver.findElement(By.cssSelector("p")).getText());
		driver.findElement(By.linkText("Cart")).click();
		driver.findElement(By.xpath("//td/input[1]")).clear();
		driver.findElement(By.xpath("//td/input[1]")).sendKeys("2");
		
		LogEntries entries = driver.manage().logs().get(LogType.BROWSER);
		List<LogEntry>logs = entries.getAll();
		for(LogEntry e : logs) {
			System.out.println(e.getMessage());//log4j
		}
	}

}
