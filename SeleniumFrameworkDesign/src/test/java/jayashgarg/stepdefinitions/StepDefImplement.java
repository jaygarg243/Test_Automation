package jayashgarg.stepdefinitions;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import jayashgarg.TestComponents.BaseTest;
import jayashgarg.pageobjects.CheckOutPage;
import jayashgarg.pageobjects.ConfirmationPage;
import jayashgarg.pageobjects.LandingPage;
import jayashgarg.pageobjects.ProductCatalog;
import jayashgarg.pageobjects.cartPage;

public class StepDefImplement extends BaseTest {
	public LandingPage landingPage;
	public ProductCatalog productcatalog;
	public ConfirmationPage confirmationPage;
	@Given("I landed on Ecommerce Page")
	public void I_landed_on_Ecommerce_Page() throws IOException {
		landingPage = launchApplication();
	}
	@Given("^Logged in with username (.+) and password (.+)$")
	public void logged_in_username_and_password(String username, String password) {
		productcatalog = landingPage.loginApplication(username, password);
	}
	@When("^I add product (.+) to cart$")
	public void add_product_to_cart(String product) {
		List<WebElement> products = productcatalog.getProductsList();
		productcatalog.addProductToCart(product);
	}
	@And("^checkout product (.+) and submit the order$")
	public void checkout_product(String product) {
		cartPage cartPage = productcatalog.goToCartPage();
		cartPage.getCartList();
		Boolean match = cartPage.findProductInCart(product);
		Assert.assertTrue(match);
		
		CheckOutPage checkOutPage = cartPage.checkout();
		checkOutPage.selectCountry("ind", "India");
		confirmationPage = checkOutPage.submitCVV("123");
	}
		
	
	@Then("{string} message is displayed on confirmation page")
	public void message_displayed_confirmation_page(String message) {
		String confirmMessage = confirmationPage.confirmOrder();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase(message));
		driver.close();
	}
	
	@Then("^\"([^\"]*)\" message is displayed$")
	public void error_message_displayed_confirmation_page(String message) {
		Assert.assertEquals(message,landingpage.getErrorMessage());
		driver.close();
	}
}
