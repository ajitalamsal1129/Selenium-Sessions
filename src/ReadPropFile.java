import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class ReadPropFile {
	static WebDriver driver;

	public static void main(String[] args) throws IOException, InterruptedException {
		Properties prop=new Properties();
		FileInputStream ip=new FileInputStream("/Users/ajitalamsal/Documents/JavaTraining/SeleniumSessions/src/config.properties");
		prop.load(ip);
		
		System.out.println(prop.getProperty("name"));
		System.out.println(prop.getProperty("age"));
		
		String url=prop.getProperty("URL");
		System.out.println(url);
		
		String browserName=prop.getProperty("browser");
		System.out.println(browserName);
		
		if(browserName.contentEquals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/Users/ajitalamsal/Downloads/chromedriver");
			 driver=new ChromeDriver();
		}
		else if(browserName.contentEquals("FF")){
		System.setProperty("webdriver.gecko.driver", "/Users/ajitalamsal/Downloads/geckodriver");
		 driver=new FirefoxDriver();//it will launch blank firefox
		}else if(browserName.contentEquals("safari")) {
			driver=new SafariDriver();
		}
		driver.get(url);
		Thread.sleep(5000);
        driver.findElement(By.name(prop.getProperty("firstname_name"))).sendKeys(prop.getProperty("Firstname"));
		driver.findElement(By.name(prop.getProperty("lastname_name"))).sendKeys(prop.getProperty("Lastname"));
		Thread.sleep(5000);
		driver.findElement(By.xpath(prop.getProperty("email_name"))).sendKeys(prop.getProperty("Username"));

		

		
		

			
			
		}


	

		
		
		
		
		

	}


