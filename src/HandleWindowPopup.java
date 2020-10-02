import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleWindowPopup {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/ajitalamsal/Downloads/chromedriver");
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();//maximize window
		driver.manage().deleteAllCookies();//delete all the cookies
		
		//dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		driver.get("http://www.popuptest.com/goodpopups.html");
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td/font/b/a[1]")).click();
		Thread.sleep(5000);
		
		Set<String> handler=driver.getWindowHandles();
		
		Iterator<String> it=handler.iterator();
		
		String parentWindowId=it.next();
		System.out.println("Parent window id:" + parentWindowId);
		
		String childWindowId=it.next();
		System.out.println("Child window id:" + childWindowId);

		driver.switchTo().window(childWindowId);
		Thread.sleep(500);
		
		System.out.println("Child window popup title:" +driver.getTitle());
		
		driver.close();
		
		driver.switchTo().window(parentWindowId);
		Thread.sleep(5000);
		
		System.out.println("Parent window popup title:" +driver.getTitle());


		

		
		
		
		
		

	}

}
