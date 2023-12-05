package Resources;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

public class CommonMethod {
	
	public static void hanldeassertion(String s1, String s2, String message)   {
		
		
		
		SoftAssert s=new SoftAssert();
		
		String actual = s1;
		String expected= s2;
		
		s.assertEquals(actual, expected, message);
		
		s.assertAll();
		
	}
	
	public static void clickable( WebElement e, WebDriver driver)  {
		
		 WebElement b=e;
		 
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", b);
		
	}
	
	
        public static void listhandle(List<WebElement> w, String word, WebDriver driver)    {
		 
		 List<WebElement> li=w;
		 
		 for(WebElement s:li)  {
			 
			 if(s.getText().equalsIgnoreCase(word))  {
			 
				 JavascriptExecutor jq=(JavascriptExecutor) driver;
				 
				 jq.executeScript("arguments[0].click()", s); 
			     break;
		 }
		 
		 }  
		 
	 }

}
