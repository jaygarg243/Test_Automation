package TestPackage;

import org.testng.annotations.Test;

public class HomeLoan {
	@Test
	public void WebLogin() {
		System.out.println("Web Login Home");
	}
	
	@Test
	public void MobileLogin() {
		System.out.println("Mobile Login Home");
	}
	
	@Test(groups= {"Smoke"})
	public void APILogin() {
		System.out.println("API Login Home");
	}
}
