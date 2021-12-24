package hello;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class sele {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "c://chromedriver_win32//chromedriver.exe");
	//System.setProperty("webdriver.chrome.driver", "c://chromedriver_win32//geckodriver.exe");
	
	
			ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://globalgarner.com/");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().window().maximize();
	
		
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/nav/div/div/div[4]/div/ul/li[4]/span/span/a")).click();
		
	

		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/ul/li[1]/a/div")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("username")).sendKeys("8141143966");
		Thread.sleep(2000);
		  driver.findElement(By.name("password")).sendKeys("global916");
		  driver.findElement(By.xpath("//button[@class='bp3-button bp3-button bp3-intent-primary bp3-button bp3-default bp3-fill login-btn']")).click();
		  driver.findElement(By.linkText("Best Shopping Websites")).click();
		  JavascriptExecutor js=(JavascriptExecutor)driver;
		
	
			  		int count=0;	 
			while(driver.findElement(By.xpath("//span[normalize-space()='Load More']")).isDisplayed()==true)
			{

				
				
				WebElement element=driver.findElement(By.xpath("//span[contains(text(),'Load More')]"));
				  element.click();
				  Thread.sleep(2000);
				  js.executeScript("window.scrollBy(0,5000)");
			count++;
			System.out.println(count);
			if(count==9)
			{
			List<WebElement>links=driver.findElements(By.xpath("//div[@class=' brandsDiv']//a"));
			//System.out.println(links.size());
			
			
	    	 
		 	  
	 		   ArrayList<String> targets = new ArrayList<String>();
	  		   //collect targets locations                                               //store all link for different location
	  		   for (WebElement link : links)
	  		   {	  			    	  			  
	  		        targets.add(link.getAttribute("href"));
	  		              		
				}
	  		 for (String target : targets) {
	  			 
	  			  ((JavascriptExecutor) driver).executeScript("window.open()");
   	  		    ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());            //open all link on new tab
   	  		    driver.switchTo().window(tabs.get(1));                                                
	  			    System.out.println(tabs.size());
	  			  
	  			  driver.get(target);
	  			 js.executeScript("window.scrollBy(0,5000)");
	  		      
	  		driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[2]/div[3]/button/span")).click();
	  		
	  		 if (js.executeScript("return document.readyState").toString().equals("complete")); //first link load  and status complete
  		 	 Thread.sleep(10000); 
  		 	for (String handle : driver.getWindowHandles())
  		 	{
  	    	    driver.switchTo().window(handle);
  	    	   // System.out.println(String.format(" url: %s", driver.getCurrentUrl()));
  	    	  
  	    	    String url=driver.getCurrentUrl();                                           //convert url to string
  	    	   
  	        	if((url.contains("globalgarner"))||(url.contains("blank")))
  	    	    {
  	        		
  	    	    if(url.contains("dummy"))                                         // take final url and match with expirel ink
  	    	    	{ 
  	    	    		System.out.println(url);
  	    	    		Thread.sleep(2000);
  	    	     	   System.out.println("Page Is not loaded.");
  	    	     	       	 
  	    	    	}
  	       }
  	    	    
  	        	
  	    	    else
  	    	    {
  	    	    	
  	    	    	
  	    	    	System.out.println(url);
  	    	    	if(url.contains("dummy"))
  	    	    	{
  	    	    		System.out.println("page is not loaded");
  	    	    	}
  	    	    }
  	    	
  	   }
  	   
  		  driver.close();                                //  close url after loading one url
	      		    	      
		   Iterator<String> it = tabs.iterator();
		       String child = it.next();                              // get second tab or url
		       Thread.sleep(2000);                        
		       
		       driver.switchTo().window(child);      		      
  		      	   
  		 }
  		      	  		     	 
	 
	
	       break;
	     }
	  		      
	  			  
	  			  
	  			  
	  		 }
	  		 
		
		  
		 
		  }
	
	
	
}


	