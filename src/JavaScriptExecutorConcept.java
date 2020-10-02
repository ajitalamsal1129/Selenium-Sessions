import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class JavaScriptExecutorConcept {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "/Users/ajitalamsal/Downloads/chromedriver");
		WebDriver driver=new ChromeDriver();
			
			driver.manage().window().maximize();//maximize window
			driver.manage().deleteAllCookies();//delete all the cookies
			
			//dynamic wait
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			
			driver.get("http://www.freecrm.com");
			Thread.sleep(5000);

			driver.findElement(By.linkText("Log In")).click();
			Thread.sleep(5000);

			
			driver.findElement(By.xpath("//input[@name='email']")).sendKeys("ajitalamsal1129@gmail.com");
			
			driver.findElement(By.name("password")).sendKeys("Purplecandy01");;
			Thread.sleep(5000);
			
			WebElement loginbtn=driver.findElement(By.xpath("//div[@class='ui fluid large blue submit button']"));
			flash(loginbtn,driver);//highlight the element
			drawborder(loginbtn,driver);//draw a border
			Thread.sleep(5000);
			//generateAlert(driver,"This is an issue with login button on login page");
			
			//Thread.sleep(5000);
			clickElementbyJS(loginbtn,driver);
			Thread.sleep(5000);
			
			//refresh the page
			//1.By using selenium
			driver.navigate().refresh();
			
			//2.By using JS Executor
			refreshbrowserByJS(driver);
			Thread.sleep(5000);
			//get the page title
			System.out.println(getTitleByJS(driver));
			Thread.sleep(5000);
			
			//scroll page down
			scrollPageDown(driver);		
			
			//scroll to the particular element: Example
			WebElement forgotPwdLink=driver.findElement(By.xpath("//a[contains(text(),'Forgot Password?')]"));
			scrollIntoView(forgotPwdLink,driver);
			

			//Take screenshot and store as a file name
			File src=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//			now copy the screenshot to desired location using copyFile//method
			FileUtils.copyFile(src,new File("/Users/ajitalamsal/Documents/JavaTraining/SeleniumSessions/higlight.jpg"));

			
	}
			
	

	//executeScript--to execute JavaScript Code
//	public static void flash(WebElement element, WebDriver driver) {
//		JavaScriptExecutor js=((JavaScriptExecutor)driver);
//          String bgcolor=element.getCssValue("backgroundColor");
//		for(int i=0;i<10;i++) {
//			changeColor("rgb(0,200,0)",element,driver);//1
//			changeColor(bgcolor,element,driver);//1
//			//this method is not directly available in selenium so we have to createv our own method
//		}
//	}
//	public static void changeColor(String color,WebElement element,WebDriver driver) {//color=rgb(0,200,0), element=Log In
//		JavaScriptExecutor js=((JavaScriptExecutor)driver);
//        js.executeScript("arguments[0].style.backgroundColor = '"+color+"'",  element);
//
//
//		try {
//			Thread.sleep(20);
//		}catch(InterruptedException e){
//		}
	public static void flash(WebElement element, WebDriver driver) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        String bgcolor  = element.getCssValue("backgroundColor");
        for (int i = 0; i < 100; i++) {
            changeColor("rgb(0,200,0)", element, js);
            changeColor(bgcolor, element, js);
        }
    }
    public static void changeColor(String color, WebElement element,  JavascriptExecutor js) {
        js.executeScript("arguments[0].style.backgroundColor = '"+color+"'",  element);

        try {
            Thread.sleep(20);
        }  catch (InterruptedException e) {
        }
    }
        
        public static void drawborder(WebElement element,WebDriver driver) {
            JavascriptExecutor js = ((JavascriptExecutor) driver);

            js.executeScript("arguments[0].style.border='3px solid red'",  element);


        	
        }
        
        public static void generateAlert(WebDriver driver,String message) {
            JavascriptExecutor js = ((JavascriptExecutor) driver);
            js.executeScript("alert('"+message+"')");


        	
        }
        public static void clickElementbyJS( WebElement element,WebDriver driver) {
            JavascriptExecutor js = ((JavascriptExecutor) driver);
            js.executeScript("arguments[0].click();", element);


        	
        }
        
        public static void refreshbrowserByJS(WebDriver driver) {
            JavascriptExecutor js = ((JavascriptExecutor) driver);
            js.executeScript("history.go(0)");

            

        	
        }
        public static String getTitleByJS(WebDriver driver) {
            JavascriptExecutor js = ((JavascriptExecutor) driver);
            String title=js.executeScript("return document.title;").toString();
            return title;
        	
        }
        
        public static void scrollPageDown(WebDriver driver) {
            JavascriptExecutor js = ((JavascriptExecutor) driver);
            js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        }
        public static void scrollIntoView(WebElement element,WebDriver driver) {
            JavascriptExecutor js = ((JavascriptExecutor) driver);
            js.executeScript("arguments[0],scrollIntoView(true);", element);
        

            

        	
        }

        
        
        
     }
	

		
			
		

		

			
		
		
			


	


