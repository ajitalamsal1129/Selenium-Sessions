import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HTMLUnitDrverConcept {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/ajitalamsal/Downloads/chromedriver");
		
		//Mandatory options
		//1.chrome version should be greater than 59 on mac and greater than 60 on windows
		//2.window-size=1400,800
		ChromeOptions options=new ChromeOptions();
		options.addArguments("window.size=1400,800");//it will work even without this but in some applications it will not work
		options.addArguments("--headless");
	
		WebDriver driver=new ChromeDriver(options);
		//WebDriver driver=new HtmlUnitDriver();
		
		driver.manage().window().maximize();//maximize window
		driver.manage().deleteAllCookies();//delete all the cookies
		
		//dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		driver.get("http://www.freecrm.com");

		
		System.out.println("Before login title is=="+driver.getTitle());
		
		driver.findElement(By.linkText("Log In")).click();
		Thread.sleep(5000);


		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("ajitalamsal1129@gmail.com");
		
		driver.findElement(By.name("password")).sendKeys("Purplecandy01");;
		
		driver.findElement(By.xpath("//div[@class='ui fluid large blue submit button']")).click();
		Thread.sleep(5000);

		System.out.println("After login title is=="+driver.getTitle());

	}
}


		
		

		
		


	


