package Resources;

import org.testng.internal.TestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	
	public static ExtentReports report;
	public static ExtentSparkReporter htmlreport;
	public static ExtentTest test;
	
	public static void setup()  {
	
		
		
		htmlreport=new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/TestResult/"+"My_Report_"+BaseClass.getcurrentdate() + ".html");
		
		htmlreport.config().setTheme(Theme.DARK);
		htmlreport.config().setDocumentTitle("Automation");
		htmlreport.config().setReporter(htmlreport);
		htmlreport.config().setReportName("Tour_Application");
		
		
		
		report= new ExtentReports();
		
		report.attachReporter(htmlreport);
		report.setSystemInfo("window10", "IOS");
		report.setSystemInfo("host name", "local name");
		report.setSystemInfo("tester", "test");
		
		
	}
	
	
	public static void endreport()   {
		
		report.flush();
	}
	

}
