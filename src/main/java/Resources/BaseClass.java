package Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClass {
	
	public static WebDriver driver;
	Properties p;
	
	public void DriverInitilize() throws IOException    {
	
	FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\data.properties");
	
	   p=new Properties();
	   
	   p.load(file);
	   
	  String key1= p.getProperty("browser");
	  
	  if(key1.equalsIgnoreCase("chrome"))  {
		  
		  System.setProperty("webdriver.driver.chrome","G:\\chromedriver-win32\\chromedriver.exe");
		  
		  ChromeOptions op=new ChromeOptions();
		  
		  op.addArguments("--remote-allow-origins=*");
		  op.addArguments("--notification-off");
		  op.setBinary("C:\\Users\\LENOVO\\.cache\\selenium\\chrome\\win64\\116.0.5845.49\\chrome.exe");
		  
		  driver=new ChromeDriver(op);
		    
	  }
	  else if(key1.equalsIgnoreCase("firefox"))   {
		  
		  driver=new FirefoxDriver();
	  }
	  else {
		  
		  System.out.println("please  check the browser name");
	  }
	}
	
	@BeforeSuite
	public void beforesuite()  {
		
		ExtentManager.setup();
	}
	
	
	  @BeforeMethod
	  public void openurl() throws IOException  {
		  
		  DriverInitilize();
		  
		String key2= p.getProperty("url");
		  
		  driver.get(key2);
	  
	}
	  @AfterMethod
	  public void down()  {
		  
		  driver.manage().window().maximize();
	  }
	  
	  
	  @AfterSuite
	  public void closes()  {
		  
		  ExtentManager.endreport();
	  }

	
	public static String screenshot(WebDriver driver, String screenshotname) throws IOException  {
		
		String dateformate = new SimpleDateFormat("yyyy-MM-dd-hhmmss").format(new Date());
		
		TakesScreenshot ts=(TakesScreenshot) driver;
		
		File source = ts.getScreenshotAs(OutputType.FILE);
		
		String destination=System.getProperty("user.dir")+"/Screenshots/" + screenshotname + dateformate + ".png";
		
		File finaldestination = new File(destination);
		
		FileUtils.copyFile(source, finaldestination);
		
		return destination;
	}
	
	
	public static String getcurrentdate()  {
		
		String currentdate = new SimpleDateFormat("yyyy-MM-ddhhmmss").format(new Date());
		
		return currentdate; 
		
	}

}
