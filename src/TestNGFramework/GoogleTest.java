package TestNGFramework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleTest {
	
	WebDriver driver;
	//1//4//7
	@BeforeMethod
	public void setUp() {
	System.setProperty("webdriver.chrome.driver", "/Users/ajitalamsal/Downloads/chromedriver");
    driver=new ChromeDriver();
	driver.manage().window().maximize();//maximize window
	driver.manage().deleteAllCookies();//delete all the cookies
	driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	driver.get("http://www.google.com");

}//2
    @Test(priority=1,groups="Title")
    public void googleTitleTest() {
	String title=driver.getTitle();
	System.out.println(title);
}
    //5
    @Test(priority=2,groups="logo")
    public void googleLogoTest() throws InterruptedException {
    	Thread.sleep(5000);
    	boolean b=driver.findElement(By.id("hplogo")).isDisplayed();
    	System.out.println(b);

    }
    //9
    @Test(priority=3,groups="maillinktest")
    public void mailLinkTest() {
    	boolean c=driver.findElement(By.linkText("Gmail")).isDisplayed();
    	System.out.println(c);

    }
    
    @Test(priority=4,groups="search")
    public void Test1() {
    	System.out.println(":Test1");
    }
    @Test(priority=5,groups="search")
    public void Test2() {
    	System.out.println(":Test2");
    
    }
    @Test(priority=6,groups="search")
    public void Test3() {
    	System.out.println(":Test3");
    }
    
    //3//6//9
    @AfterMethod
    public void teardown() {
    	driver.quit();
    }
}

//TestNG will create a pair for each test cases 
//For every test cases,browser is launched
//Randomly ii can pick any test pairs if you dont define priority
    