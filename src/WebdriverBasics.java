import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebdriverBasics {

	public static void main(String[] args) {
		//1.FF browser
		//geckodriver
//		System.setProperty("webdriver.gecko.driver", "/Users/ajitalamsal/Downloads/geckodriver");
//		WebDriver driver=new FirefoxDriver();//it will launch blank firefox
//		
		//chromedriver
		System.setProperty("webdriver.chrome.driver", "/Users/ajitalamsal/Downloads/chromedriver");
		WebDriver driver=new ChromeDriver();//it will launch blank firefox
		
		
		driver.get("http://www.google.com");//launch google
		
		//To print title on console
		String title=driver.getTitle();
		System.out.println(title);
		
		//to verify title
		if(title.contentEquals("Google")){
			System.out.println("correct title");
		}
		else {
			System.out.println("incorrect title");


		}
		
		System.out.println(driver.getCurrentUrl());
		
		//System.out.println(driver.getPageSource());
		
		driver.quit();
		

		
		
				
	
		
				

	}

}
