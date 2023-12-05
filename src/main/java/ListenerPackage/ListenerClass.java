package ListenerPackage;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

import Resources.BaseClass;
import Resources.ExtentManager;

public class ListenerClass extends ExtentManager implements ITestListener {
	
	
	public void onTestStart(ITestResult result) {
		
		test=report.createTest(result.getName());
	}
	
	
	public void onTestSuccess(ITestResult result) {
		
		if(result.getStatus() == ITestResult.SUCCESS)  {
			
			test.log(Status.PASS, "Test case is passed :" + result.getName());
		}
	}
	
	
	public void onTestFailure(ITestResult result) {
		
		if(result.getStatus() == ITestResult.FAILURE)  {
			
			test.log(Status.FAIL, "Test case is faild :" + result.getName());
			
			test.log(Status.FAIL, "Test case is faild :" + result.getThrowable());
			
			String screenshotpath="";
			
			try {
				
				screenshotpath = BaseClass.screenshot(BaseClass.driver, result.getName());
				
				test.addScreenCaptureFromPath(screenshotpath);
			}
			catch(Exception e)  {
				
				e.printStackTrace();
			}
			
			
			
			
		}
	}
	
	
	
	public void onTestSkipped(ITestResult result) {
		
		if(result.getStatus() == ITestResult.SKIP)  {
			
			test.log(Status.SKIP, "Test case is skipped :" + result.getName());
		}
	}
	
	
	
	
	
	
	

}
