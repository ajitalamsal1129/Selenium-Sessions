import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameHangling {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/ajitalamsal/Downloads/chromedriver");
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();//maximize window
		driver.manage().deleteAllCookies();//delete all the cookies
		
		//dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		driver.get("https://freecrm.com");
		Thread.sleep(5000);
		
		driver.findElement(By.linkText("Log In")).click();
		driver.findElement(By.name("email")).sendKeys("ajitalamsal1129@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Purplecandy01");
        driver.findElement(By.xpath("//div[contains(@class,'ui fluid large blue submit button')]")).click();
       
        //For error unable to locate element, inside the frame element
       // driver.switchTo().frame("leftpanel");
       // driver.findElement(By.xpath("//span[contains(@class,'Contacts')]")).click();
        
		Thread.sleep(5000);

        driver.findElement(By.xpath("//*[@id=\"main-nav\"]/a[3]/span")).click();

        		

	}

}
