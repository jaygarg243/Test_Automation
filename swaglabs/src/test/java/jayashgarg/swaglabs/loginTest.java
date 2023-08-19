package jayashgarg.swaglabs;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import jayashgarg.pageObjects.CatalogPage;
import jayashgarg.testComponents.BaseTest;


public class loginTest extends BaseTest{
	@Test(dataProvider="getData")
	public void login(String user, String pwd) {
		loginpage().goTo();
		CatalogPage catalog = loginpage().login(user,pwd);
		Assert.assertTrue(catalog.title.getText().equalsIgnoreCase("products"), "Incorrect creds");
	}
	
	@DataProvider
	public Object[][] getData(){
		Object[][] obj = new Object[4][2];
		obj[0][0] = "standard_user";
		obj[1][0] = "locked_out_user";
		obj[2][0] = "problem_user";
		obj[3][0] = "performance_glitch_user";
		obj[0][1] = "secret_sauce";
		obj[1][1] = "secret_sauce";
		obj[2][1] = "secret_sauce";
		obj[3][1] = "secret_sauce";
		return obj;
	}
}
