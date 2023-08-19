package TestPackage;
//import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
//import org.testng.annotations.AfterSuite;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeSuite;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class PersonalLoan {
	
	
		@Test(dataProvider="getData")
		public void WebLogin(String user, String pwd) {
			System.out.println("Web Login Personal");
			System.out.println(user);
			System.out.println(pwd);
		}
		@Parameters({"URL","APIKey/username"})
		@Test(groups= {"Smoke"})
		public void MobileLogin(String carurl, String user) {
			System.out.println("Mobile Login Personal");
			System.out.println(carurl);
			System.out.println(user);
		}
		@Test
		public void APILogin() {
			System.out.println("API Login Executes First Before every method");
		}
		@DataProvider
		public Object getData() {
			Object[][] data = new Object[3][2];
			data[0][0] = "FirstUser";
			data[0][1] = "Pwd1";
			data[1][0] = "SecondUser";
			data[1][1] = "Pwd2";
			data[2][0] = "ThirdUser";
			data[2][1] = "Pwd3";
			return data;
		}

}
