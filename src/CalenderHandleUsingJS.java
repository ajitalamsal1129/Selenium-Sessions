import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalenderHandleUsingJS {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/ajitalamsal/Downloads/chromedriver");
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();//maximize window
		driver.manage().deleteAllCookies();//delete all the cookies
		
		//dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		driver.get("https://www.aa.com/homePage.do");
		
		//driver.switchTo().frame(2);
		
		WebElement date=driver.findElement(By.id("aa-leavingOn"));
		
		String dateVal="12/25/2020";
		
		selectDateByJS(driver,date,dateVal);

		
	}

	public static void selectDateByJS(WebDriver driver, WebElement element,String dateVal) {
	JavascriptExecutor js = ((JavascriptExecutor) driver);

    js.executeScript("arguments[0].setAttribute('value','"+dateVal+"');",  element);


    //_hjRemoteVarsFrame
}

}
