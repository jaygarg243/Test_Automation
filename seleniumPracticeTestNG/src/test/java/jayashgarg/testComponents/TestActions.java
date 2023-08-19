package jayashgarg.testComponents;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TestActions {
	@Test
	public void doActions() {
		//set webdriver
				System.setProperty("webdriver.chrome.driver","C:\\Users\\jayas\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");
				WebDriver driver = new ChromeDriver();
				//set js executor
				JavascriptExecutor js = (JavascriptExecutor)driver;
				//get url
				driver.get("https://testautomationpractice.blogspot.com/");
				//maximize window
				driver.manage().window().maximize();
				//Action Class
				Actions action = new Actions(driver);
				WebElement doubleclick = driver.findElement(By.xpath("//button[contains(text(),'Copy')]"));
				action.moveToElement(doubleclick).doubleClick().build().perform();
				WebElement draggable = driver.findElement(By.id("draggable"));
				WebElement droppable = driver.findElement(By.id("droppable"));
				action.moveToElement(draggable).clickAndHold().moveToElement(droppable).release().build().perform();
				List<WebElement> images = driver.findElements(By.cssSelector("ul[id='gallery'] li"));
				WebElement bin = driver.findElement(By.id("trash"));
				images.stream().forEach(img->action.dragAndDrop(img, bin).build().perform());
				WebElement slider = driver.findElement(By.cssSelector("div[id='slider'] span"));
				action.moveToElement(slider).clickAndHold().moveByOffset(50,0).build().perform();
				WebElement resize = driver.findElement(By.cssSelector("div[id='resizable'] div:nth-of-type(3)"));
				action.clickAndHold(resize).moveByOffset(50, 50).build().perform();
	}
}
