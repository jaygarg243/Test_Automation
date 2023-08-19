package jayashgarg.Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	static ExtentReports extent;
   public static ExtentReports getReportObject() {
	 //Extent reports
		//extent spark reporter
			String path = System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter esr = new ExtentSparkReporter(path);
		esr.config().setReportName("Web Automation Result");
		esr.config().setDocumentTitle("Test Results");
		extent = new ExtentReports();
		extent.attachReporter(esr);
		extent.setSystemInfo("Tester", "Jayash Garg");
		extent.createTest(path);
		return extent;
   }
}
