import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HandleDropBox {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/ajitalamsal/Downloads/chromedriver");
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://scgi.holf.ebay.com/ws/eBayISAPI.dll?RegisterEnterInFo&usage=2943&ru=");
		
		//handle drop box
		Select select=new Select(driver.findElement(By.id("state")));//field is blank and we have to select
		select.deselectByVisibleText("California");//Action

		

	}

}
