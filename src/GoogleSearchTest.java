import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTest {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/ajitalamsal/Downloads/chromedriver");
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();//maximize window
		driver.manage().deleteAllCookies();//delete all the cookies
		
		//dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		driver.get("https://www.google.com/?client=safari&channel=iphone_bm");
		
		driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("Java");
		Thread.sleep(5000);
		
		
		
		List <WebElement> list=driver.findElements(By.xpath("//div[@role='listbox']//a/descendant::div[@class='match-icon']"));//match value is the common class for all suggestions
		Thread.sleep(5000);

		System.out.println("total number of suggestions in search box:"+list.size());
		
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i).getText());
			if(list.get(i).getText().contains("java update")) {
				list.get(i).click();
			}
		}
		

	}

}
