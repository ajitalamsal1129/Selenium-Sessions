import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TotalLinks {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/ajitalamsal/Downloads/chromedriver");
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();//maximize window
		driver.manage().deleteAllCookies();//delete all the cookies
		
		//dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		driver.get("https://www.ebay.com");
		
		//1.get the total count of links on the page
		List <WebElement> Linklist=driver.findElements(By.tagName("a"));
		System.out.println(Linklist.size());
		
		//to get the text of each link on the page
		for(int i=0; i<Linklist.size();i++) {
			String LinkText=Linklist.get(i).getText();
			System.out.println(LinkText);

			
			
		}

	}

}
