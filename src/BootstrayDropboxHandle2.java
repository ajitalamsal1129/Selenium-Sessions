import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BootstrayDropboxHandle2 {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/ajitalamsal/Downloads/chromedriver");
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();//maximize window
		driver.manage().deleteAllCookies();//delete all the cookies
		
		//dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		driver.get("https://v4-alpha.getbootstrap.com/components/dropdowns/");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1300)");

		
		driver.findElement(By.xpath(("//button[contains(text(),'Dropdown button')]"))).click();
		
        List <WebElement> list=driver.findElements(By.xpath("//div[@class='dropdown-menu' and @aria-labelledby='dropdownMenuButton']//a"));


        System.out.println(list.size());
        
        for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i).getText());//for individual element we have to do get(i) because we used list class
			if(list.get(i).getText().contains("Something else here")) {//either equals or contains
				list.get(i).click();
				break;
			}

        
		

	}
	


	}
}
