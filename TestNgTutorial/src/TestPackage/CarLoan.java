package TestPackage;

import org.testng.annotations.Parameters;
//import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class CarLoan {
	@Test(groups= {"Smoke"})
	public void WebLogin() {
		System.out.println("Web Login Car BeforeEvery");
	}
	@Parameters({"URL"})
	@Test(enabled=true)
	public void MobileLogin(String urlname) {
		System.out.println("Mobile Login Car");
		System.out.println(urlname);
	}
	
	@Test(dependsOnMethods= {"WebLogin"})
	public void APILogin() {
		System.out.println("API Login Car");
	}
	@Test
	public void WebLogout() {
		System.out.println("Web Logout Car");
	}
}
