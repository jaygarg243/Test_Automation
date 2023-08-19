package jayashgarg;

import java.io.IOException;
//import java.time.Duration;
//import java.util.List;
//import java.util.function.Predicate;

import org.testng.Assert;
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
//import jayashgarg.pageobjects.CheckOutPage;
//import jayashgarg.pageobjects.ConfirmationPage;
import jayashgarg.pageobjects.ProductCatalog;
import jayashgarg.pageobjects.cartPage;

public class ErrorValidation extends BaseTest {
	
	@Test(retryAnalyzer=Retry.class)
	public void LoginErrorValidation() throws IOException {
		
		landingpage.loginApplication("jayash@hotmail.com", "Asdffgdggh@123");
		//List<WebElement> products = productcatalog.getProductsList();
		landingpage.getErrorMessage();
		Assert.assertEquals("Incorrect email or password.",landingpage.getErrorMessage());
		System.out.println("Login Error validated");
}
	
	@Test(retryAnalyzer=Retry.class)
	public void ProductErrorValidation() throws IOException {
		
		ProductCatalog productcatalog = landingpage.loginApplication("jayash123@hotmail.com", "Qwerty@123");
		//List<WebElement> products = productcatalog.getProductsList();
		productcatalog.addProductToCart("ZARA COAT 3");
		
		cartPage cartPage = productcatalog.goToCartPage();
		cartPage.getCartList();
		Boolean match = cartPage.findProductInCart("ZARA COAT 33");
		Assert.assertFalse(match);
		System.out.println("Product Error Validated");
		
		
}
}
