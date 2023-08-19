package jayashgarg.testComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DateAndAxes {
	@Test
	public void dateAndAxes() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\jayas\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//set js executor
		JavascriptExecutor js = (JavascriptExecutor)driver;
		//get url
		driver.get("https://testautomationpractice.blogspot.com/");
		//maximize window
		driver.manage().window().maximize();
		WebElement date = driver.findElement(By.id("datepicker"));
		date.click();
		driver.findElement(By.xpath("//div[@id='ui-datepicker-div']/table/tbody/tr[5]/td/a[contains(text(),'28')]")).click();
		
	}
}
