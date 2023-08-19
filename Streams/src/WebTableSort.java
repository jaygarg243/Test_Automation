import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class WebTableSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\jayas\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		//click on column
		driver.findElement(By.cssSelector("table th:first-child")).click();
		//Capture all web elements into list
		List<WebElement> products = driver.findElements(By.xpath("//tr/td[1]"));
		//capture names of all webelements into new list
		List<String> product_names = products.stream().map(s->s.getText()).collect(Collectors.toList());
		//System.out.println(product_names.size());
		//product_names.stream().forEach(s->System.out.println(s));
		//sort on list created in step 3
		List<String> sortedList = product_names.stream().sorted().collect(Collectors.toList());
		//compare original vs sorted
		Assert.assertTrue(product_names.equals(sortedList));
		//print the price of a particular product
		List<String> price;
		do {
			List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));
			price = rows.stream().filter(s->s.getText().contains("Rice")).map(s->getVegPrice(s)).collect(Collectors.toList());
			if(price.size()<1) {
				driver.findElement(By.xpath("//a[@aria-label='Next']")).click();
			}
		}
		while(price.size()<1);
		
		
		
		
		//Pagination
	
		
		

	}
	private static String getVegPrice(WebElement s) {
		String priceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return priceValue;
	}

}
