package jayashgarg;

import java.io.File;
import java.io.IOException;
//import java.time.Duration;
//import java.util.List;
//import java.util.function.Predicate;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

//import io.github.bonigarcia.wdm.WebDriverManager;
import jayashgarg.TestComponents.BaseTest;
import jayashgarg.TestComponents.Retry;
import jayashgarg.pageobjects.CheckOutPage;
import jayashgarg.pageobjects.ConfirmationPage;
import jayashgarg.pageobjects.OrderPage;
//import jayashgarg.pageobjects.LandingPage;
import jayashgarg.pageobjects.ProductCatalog;
import jayashgarg.pageobjects.cartPage;

public class OrderProductTest extends BaseTest {
	
	@Test(dataProvider="getData",groups= {"Purchase"},retryAnalyzer=Retry.class)
	public void standAloneTest(HashMap<String,String> input) throws IOException {
		
		ProductCatalog productcatalog = landingpage.loginApplication(input.get("email"),input.get("password"));
		//List<WebElement> products = productcatalog.getProductsList();
		productcatalog.addProductToCart(input.get("product"));
		System.out.println("Added Product");
		cartPage cartPage = productcatalog.goToCartPage();
		cartPage.getCartList();
		Boolean match = cartPage.findProductInCart(input.get("product"));
		Assert.assertTrue(match);
		
		CheckOutPage checkOutPage = cartPage.checkout();
		checkOutPage.selectCountry("ind", "India");
		ConfirmationPage confirmationPage = checkOutPage.submitCVV("123");
		
		String confirmMessage = confirmationPage.confirmOrder();
		System.out.println(confirmMessage);
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("Thankyou for the order."));
		
}
	
	@Test(dependsOnMethods={"standAloneTest"})
	public void orderHistoryTest() {
		ProductCatalog productcatalog =  landingpage.loginApplication("jayash@hotmail.com", "Asdfgh@123");
		OrderPage orderpage = productcatalog.goToOrderPage();
		Assert.assertTrue(orderpage.findProductInOrders("zara coat 3"));
	}
	
	//SS Utility
	
	
	
	//Extent Reports
	
	
	@DataProvider
	public Object[][] getData() throws IOException {
		List<HashMap<String,String>> data = getJSONDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\jayashgarg\\data\\PurchaseOrder.json");
		return new Object[][]  {{data.get(0)},{data.get(1)}};
	}
	
	/*HashMap<String,String> map = new HashMap<String,String>();
	map.put("email","jayash@hotmail.com");
	map.put("password", "Asdfgh@123");
	map.put("product", "ZARA COAT 3");
	
	HashMap<String,String> map1 = new HashMap<String,String>();
	map1.put("email","jayash@hotmail.com");
	map1.put("password", "Asdfgh@123");
	map1.put("product", "ADIDAS ORIGINAL");*/
}
