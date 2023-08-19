package seleniumcdp;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v109.fetch.Fetch;
import org.openqa.selenium.devtools.v109.network.model.Request;

public class PerformMocking {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\jayas\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		DevTools devtools = driver.getDevTools();
		
		devtools.createSession();
		
		devtools.send(Fetch.enable(Optional.empty(), Optional.empty()));
		devtools.addListener(Fetch.requestPaused(), request->{
			Request req = request.getRequest();
			String url = req.getUrl();
			if(url.contains("shetty")) {
				String newUrl = url.replace("=shetty", "=BadGuy");
				System.out.println(newUrl);
				devtools.send(Fetch.continueRequest(request.getRequestId(), Optional.of(newUrl), Optional.of(request.getRequest().getMethod()), Optional.empty(), Optional.empty(),Optional.empty()));
			}
			else {
				devtools.send(Fetch.continueRequest(request.getRequestId(), Optional.of(request.getRequest().getUrl()), Optional.of(request.getRequest().getMethod()), Optional.empty(), Optional.empty(),Optional.empty()));
			}
		});
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector("button[routerlink*=library]")).click();
		
	}

}
