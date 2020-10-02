package TestNGFramework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleTitleTest {
	

	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
	System.setProperty("webdriver.chrome.driver", "/Users/ajitalamsal/Downloads/chromedriver");
    driver=new ChromeDriver();
	driver.manage().window().maximize();//maximize window
	driver.manage().deleteAllCookies();//delete all the cookies
	driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	driver.get("http://www.google.com");
	}

    @Test
    public void googleTitleTest() {
	String title=driver.getTitle();
	System.out.println(title);
	Assert.assertEquals(title, "Google","title does not match");
}
    
    @Test
    public void googleLogoTest() throws InterruptedException {
    	Thread.sleep(5000);
    	boolean b=driver.findElement(By.id("hplogo")).isDisplayed();
    	System.out.println(b);
    	Assert.assertTrue(b);
    	Assert.assertEquals(b,true);//or this

    }
    @AfterMethod
    public void teardown() {
    	driver.quit();
    }
	

}
