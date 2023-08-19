package jayashgarg.testComponents;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class WebTables {
	@Test
	public void webTable() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\jayas\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//set js executor
		JavascriptExecutor js = (JavascriptExecutor)driver;
		//get url
		driver.get("https://testautomationpractice.blogspot.com/");
		//maximize window
		driver.manage().window().maximize();
		List<WebElement> rows = driver.findElements(By.xpath("//table[@name='BookTable']/tr/td"));
		List<WebElement> names = rows.stream().filter(cell->cell.getText().contains("Master")).collect(Collectors.toList());
		names.stream().forEach(name->System.out.println(name));
		WebElement tooltip = driver.findElement(By.id("age"));
		js.executeScript("arguments[0].scrollIntoView(true)", tooltip);
		Actions a = new Actions(driver);
		a.moveToElement(tooltip).build().perform();
		String text = tooltip.getText();
		System.out.println(text);
	}
}
