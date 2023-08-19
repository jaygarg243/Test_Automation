package jayashgarg.TestComponents;

import java.awt.Dimension;
import java.io.File;
import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;
import jayashgarg.pageobjects.LandingPage;

public class BaseTest {
	public WebDriver driver;
	public LandingPage landingpage;
	public WebDriver initializeDriver() throws IOException {
		
		//properties class
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/jayashgarg/Resources/GlobalData.properties");
		prop.load(fis);
		String browsername = System.getProperty("browser")!=null?System.getProperty("browser"):prop.getProperty("browser");
		
		if(browsername.contains("chrome")) {
			ChromeOptions options = new ChromeOptions();
			
			WebDriverManager.chromedriver().setup();
			if(browsername.contains("headless")) {
				options.addArguments("headless");
			}	
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
		}
		else if(browsername.equalsIgnoreCase("edge")) {
			//edge
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else if(browsername.equalsIgnoreCase("firefox")) {
			//firefox
			
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return driver;
	}
	
	
	public List<HashMap<String,String>> getJSONDataToMap(String filepath) throws IOException{
		//json to string
		String JSONContent = FileUtils.readFileToString(new File(filepath),StandardCharsets.UTF_8);
		//String to hashmap jackson databind
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String,String>> data = mapper.readValue(JSONContent, new TypeReference<List<HashMap<String,String>>>(){});
		return data;
	}
	
	public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File ss = new File(System.getProperty("user.dir")+"//reports//"+testCaseName + ".png");
		FileUtils.copyFile(src, ss);
		return System.getProperty("user.dir")+"//reports//"+testCaseName + ".png";
	}
	
	
	@BeforeMethod
	public LandingPage launchApplication() throws IOException {
		driver=initializeDriver();
		landingpage = new LandingPage(driver);
		landingpage.goTo();
		return landingpage;
	}
	@AfterMethod
	public void teardown() {
		driver.close();
	}
}
