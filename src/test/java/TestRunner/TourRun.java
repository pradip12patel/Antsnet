package TestRunner;

import java.time.Duration;

import javax.lang.model.element.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import PageObjectM.PageObjectModel;
import Resources.BaseClass;
import Resources.CommonMethod;
import Resources.ConstantMethod;

public class TourRun extends BaseClass{
	
	PageObjectModel obj;
	
	@Test
	void Tourapplication() throws InterruptedException  {
		
		obj=new PageObjectModel(driver);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		CommonMethod.clickable(obj.Loginn(), driver);
		
       CommonMethod.clickable(obj.signn(), driver);
		
		obj.firstname().sendKeys(ConstantMethod.name);
		obj.email().sendKeys(ConstantMethod.mail);
		obj.mobile().sendKeys(ConstantMethod.mobile);
		
		WebDriverWait w=new WebDriverWait (driver, Duration.ofSeconds(20));
		
		w.until(ExpectedConditions.elementToBeClickable(obj.searchs()));
		
	//	CommonMethod.clickable(obj.searchs(), driver);
		
		CommonMethod.listhandle(obj.citysearch(), "Norway (+47)", driver);
		
		Select s=new Select(obj.currencyes());
		
		s.selectByIndex(2);
		
		CommonMethod.clickable(obj.checkbox(), driver);
		
		CommonMethod.clickable(obj.rigester(), driver);
		
	//	
		
		
		
	//	CommonMethod.hanldeassertion(obj.assertion().getText(), "HOME", "please enter the correct credentails");
		
		
		
		
		
	}

	
	
	
	
	
	
	

}
