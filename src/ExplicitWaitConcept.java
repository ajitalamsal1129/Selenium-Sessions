import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitConcept {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/ajitalamsal/Downloads/chromedriver");
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();//maximize window
		driver.manage().deleteAllCookies();//delete all the cookies
		
		//dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		driver.get("http://www.facebook.com");
	
		Thread.sleep(500);
		
		//clickOn(driver,driver.findElement(By.name("login")), 20);//login button
		
		clickOn(driver,driver.findElement(By.xpath("//*[@id=\"reg_pages_msg\"]/a")), 10);//create a page link

		
		}
	public static void clickOn(WebDriver driver,WebElement locator, int timeout) {//only to click elements
		new WebDriverWait(driver,timeout).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(locator));
		locator.click();
		
	}

}
