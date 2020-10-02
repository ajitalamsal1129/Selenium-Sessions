import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorConcept {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "/Users/ajitalamsal/Downloads/chromedriver");
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://scgi.holf.ebay.com/ws/eBayISAPI.dll?RegisterEnterInFo&usage=2943&ru=");
		
		//1.xpath--2
//		driver.findElement(By.xpath("//*[@id='firstname']")).sendKeys("Tom");
//		driver.findElement(By.xpath("//*[@id='lastname']")).sendKeys("Peter");
//        driver.findElement(By.xpath("//*[@id='address]")).sendKeys("12,new street");
//        
        //2.id--1
//        driver.findElement(By.id("firstname")).sendKeys("Tom");
//		driver.findElement(By.id("lastname")).sendKeys("Peter");
//		
		//3.name--3
		driver.findElement(By.name("firstname")).sendKeys("Tom");
		driver.findElement(By.name("lastname")).sendKeys("Peter");
		
//		//4.LinkText
//		driver.findElement(By.linkText("Sign in")).click();
//		
		//5.partialLinkTText
//		driver.findElement(By.partialLinkText("How to pick")).click();
		
		//6.CSSSelector--2
		//if id is there--#{id}
		//if class is there--.{id}
		driver.findElement(By.cssSelector("#address1")).sendKeys("12, new street");
		
		//7.class name--not useful--4
		driver.findElement(By.className("ancAsb")).sendKeys("Tom");
        

		
		
		
		

	}

}
