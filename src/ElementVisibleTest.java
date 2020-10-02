import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementVisibleTest {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/ajitalamsal/Downloads/chromedriver");
		WebDriver driver=new ChromeDriver();
			
		driver.manage().window().maximize();//maximize window
		driver.manage().deleteAllCookies();//delete all the cookies
			
			//dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			
		driver.get("https://register.freecrm.com/register/");
		
		//1.isDisplayed() method is applicable for all the elements
		boolean b1=driver.findElement(By.name("action")).isDisplayed();
		System.out.println(b1);//true
		
		//2.isEnabled method-returns true if the element is enabled otherwise returns false
		boolean b2=driver.findElement(By.name("action")).isDisplayed();
		System.out.println(b2);//true
		
		
		//3.isSelected()--only applicable for checkbox,dropdown,radiobutton
		boolean b3=driver.findElement(By.name("terms")).isSelected();
		System.out.println(b3);//true
		
		//de-select the checkbox
		driver.findElement(By.name("terms")).click();
		boolean b4=driver.findElement(By.name("terms")).isSelected();
		System.out.println(b4);//true

		
		
		
		
		

	}

}
