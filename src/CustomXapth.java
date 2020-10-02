import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomXapth {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/ajitalamsal/Downloads/chromedriver");
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();//maximize window
		driver.manage().deleteAllCookies();//delete all the cookies
		
		//dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		driver.get("https://www.ebay.com");
		
		//absolute path not recommended:
		//1.performance issue
		//2.not reloiable
		//3.can be chanfged at any time in future
		
		//driver.findElement(By.xpath("//input[@class='gh-tb ui-autocomplete-input']")).sendKeys("Java");
		//driver.findElement(By.xpath("//input[@name='_nkw']")).sendKeys("Java");
		
		driver.findElement(By.xpath("//input[contains(@class,'h-tb ui-autocomplete-input')]")).sendKeys("Java");
        
		//dynamic id:input
		//starts with
		//id=test_123
		//id=test_456
		//id=test_789
		//id=test_test_456_test
		
		//ends with
		//id=123_test_t
		//id=456_test_t
		//id=678_test_t
		
//		driver.findElement(By.xpath("//input[contains(@id,'test_')]")).sendKeys("Test");
//		driver.findElement(By.xpath("//input[starts-with(@id,'test_')]")).sendKeys("Test");
//		driver.findElement(By.xpath("//input[ends-with(@id,'_test_t')]")).sendKeys("Test");
		
		//for links:custom xpath
		//all the links are represented by <a> html tag
		driver.findElement(By.xpath("//a[contains(text(),'My eBay')]")).click();

		
		
		

		
		



		
		
		
		
		
		


		

		
		

	}

}
