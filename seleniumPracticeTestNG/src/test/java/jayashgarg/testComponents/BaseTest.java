package jayashgarg.testComponents;

import java.awt.AWTException;
import java.awt.Desktop.Action;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class BaseTest {
	@Test
	public void formTest() throws IOException, InterruptedException, AWTException{
		//set webdriver
		System.setProperty("webdriver.chrome.driver","C:\\Users\\jayas\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//set js executor
		JavascriptExecutor js = (JavascriptExecutor)driver;
		//get url
		driver.get("https://testautomationpractice.blogspot.com/");
		//maximize window
		driver.manage().window().maximize();
		//switch to iframe
		driver.switchTo().frame("frame-one1434677811");
		//by id
		WebElement firstnameinput = driver.findElement(By.id("RESULT_TextField-1"));
		firstnameinput.sendKeys("jayash");
		//by xpath, contains text
		WebElement lastnameinput = driver.findElement(By.xpath("//*[contains(text(),'Last Name')]/following-sibling::input"));
		lastnameinput.sendKeys("garg");
		//by xpath, following sibling
		WebElement phone = driver.findElement(By.name("RESULT_TextField-3"));
		phone.sendKeys("9897317524");
		driver.findElement(By.xpath("//*[contains(text(),'Country')]/following-sibling::input")).sendKeys("India");
		driver.findElement(By.xpath("//*[contains(text(),'City')]/following-sibling::input")).sendKeys("Meerut");
		
		//css selector type='email'
		driver.findElement(By.cssSelector("input[type='email']")).sendKeys("jayashgarg99@gmail.com");
		//css selector, :first-of-type
		WebElement radio = driver.findElement(By.cssSelector("table tbody tr:first-of-type input[type='radio']"));
		//Actions action = new Actions(driver);
		//action.moveToElement(radio).click().build().perform();
		js.executeScript("arguments[0].click()", radio);
		//list of webelements
		List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
		//stream
		checkboxes.stream().forEach(checkbox->js.executeScript("arguments[0].click()", checkbox));
		//dropdown Select class
		WebElement dropdown = driver.findElement(By.id("RESULT_RadioButton-9"));
		Select select = new Select(dropdown);
		select.selectByVisibleText("Evening");
		//File Upload Robot class
		WebElement upload = driver.findElement(By.cssSelector("input[type='file']"));
		js.executeScript("arguments[0].click()", upload);
		Robot rb = new Robot();
		StringSelection str = new StringSelection("C:\\Users\\jayas\\Documents\\jayash docs\\resume\\JAYASH GARG RESUME.pdf"); 
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(5000);
		//driver.close();
	}
}
