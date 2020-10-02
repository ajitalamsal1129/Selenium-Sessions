import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class BrokenLinkTest {

	public static void main(String[] args) throws InterruptedException, IOException{
		System.setProperty("webdriver.chrome.driver", "/Users/ajitalamsal/Downloads/chromedriver");
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();//maximize window
		driver.manage().deleteAllCookies();//delete all the cookies
		
		//dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		driver.get("https://www.spicejet.com");
		Thread.sleep(5000);
		
        //1.get the list of all links and images
        List<WebElement>linkslist=driver.findElements(By.tagName("a"));
        linkslist.addAll(driver.findElements(By.tagName("img")));
        System.out.println("size of full links and images--->"+linkslist.size());
        
        List<WebElement>activelinks=new ArrayList<WebElement>();
        //2iterate linkslist:excluse all the links/images which does not have any href value
        for(int i=0;i<linkslist.size();i++) {
        	System.out.println(linkslist.get(i).getAttribute("href"));
        	if(linkslist.get(i).getAttribute("href")!=null && (! linkslist.get(i).getAttribute("href").contains("javascript"))) {
        		activelinks.add(linkslist.get(i));
        	}
        }
        //get the size of the active links list
        System.out.println("size of active links and images--->"+activelinks.size());
        
        //3check the href url with httpconnection api
        for(int j=0;j<activelinks.size();j++) {
        	HttpURLConnection connection=(HttpURLConnection)new URL(activelinks.get(j).getAttribute("href")).openConnection();
        	//Import URL from Java.net first,add string,typecast,openconnect and create connect object
        	connection.connect();
        	String response=connection.getResponseMessage();//ok
        	connection.disconnect();
        	System.out.println(activelinks.get(j).getAttribute("href") +"--->"+response);

        	
        }

        
        
        
       

	}

}
