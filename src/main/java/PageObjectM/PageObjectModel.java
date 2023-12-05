package PageObjectM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageObjectModel {
	
	WebDriver driver;
	
	public By Login = By.xpath("//a[@class='nav-link header-login']");
	public By sign=By.xpath("//a[@class='btn btn-link']");
	public By first=By.xpath("//input[@id='user_name']");
	public By mail=By.xpath("//input[@id='user_email']");
	public By mb=By.xpath("//input[@id='user_mobile']");
	public By search=By.xpath("//span[@role='presentation']");
	public By city=By.xpath("//span//ul//li");
	public By currecy=By.xpath("//select[@name='currency']");
	public By check=By.xpath("//input[@id='agree_checkbox_user']");
	public By rig=By.xpath("//button[@id='registration_submit_user']");
	public By asset=By.xpath("//div[@class='bravo-menu']//a[normalize-space()='Home']");
	
	
	
	public PageObjectModel(WebDriver driver2) {
		
		this.driver=driver2;
	}


	
	public WebElement Loginn()  {
		
		return driver.findElement(Login);
	}
	
    public WebElement signn()  {
		
		return driver.findElement(sign);
	}
	
    public WebElement firstname()  {
		
  		return driver.findElement(first);
  	}
	
	

    public WebElement email()  {
		
  		return driver.findElement(mail);
  	}
	

    public WebElement mobile()  {
		
  		return driver.findElement(mb);
  	}
    
    
    public WebElement searchs()  {
		
  		return driver.findElement(search);
  	}
    
    
    public List<WebElement> citysearch()  {
		
  		return driver.findElements(city);
  	}
    
    
     public WebElement currencyes()  {
		
  		return driver.findElement(currecy);
  	}
     
     public WebElement checkbox()  {
 		
  		return driver.findElement(check);
  	}
     
     public WebElement rigester()  {
 		
  		return driver.findElement(rig);
  	}

    
   public WebElement assertion()  {
		
  		return driver.findElement(asset);
  	}
}
