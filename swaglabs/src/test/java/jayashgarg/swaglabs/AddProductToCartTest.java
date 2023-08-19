package jayashgarg.swaglabs;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jayashgarg.pageObjects.AbstractComponents;
import jayashgarg.pageObjects.CartPage;
import jayashgarg.pageObjects.CatalogPage;
import jayashgarg.pageObjects.CheckoutPage;
import jayashgarg.pageObjects.ConfirmPayment;
import jayashgarg.pageObjects.LoginPage;
import jayashgarg.pageObjects.OrderDispatched;
import jayashgarg.testComponents.BaseTest;

public class AddProductToCartTest extends BaseTest{
	@Test(dataProvider="getData")
	public void addProductToCart(String username, String pwd) throws InterruptedException {
		
		String product = "Sauce Labs Backpack";
		CatalogPage catalog = loginpage.login(username,pwd);
		catalog.validateTitle();
		catalog.addProductToCart(product);
		CartPage cart = catalog.goToCart();
		cart.validateTitle();
		cart.validateCartItems(product);
		CheckoutPage checkout = cart.checkout();
		checkout.validateTitle();
		checkout.giveCustomerData("Jay", "gar", "000000");	
		ConfirmPayment confrm = checkout.continueToPayment();	
		confrm.validateTitle();	
		confrm.validateTotal();	
		OrderDispatched order = confrm.finishpay();	
		order.confirmOrderSuccess();	
		
		
		
	}
	
	@DataProvider
	public Object[][] getData(){
		Object[][] obj = new Object[1][2];
		obj[0][0] = "performance_glitch_user";
		obj[0][1] = "secret_sauce";
				
		return obj;
	}
	
}
