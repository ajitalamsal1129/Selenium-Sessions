import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleFileUploadPopup {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/ajitalamsal/Downloads/chromedriver");
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://html.com/input-type-file/");
		
		driver.findElement(By.name("fileupload")).sendKeys("/Users/ajitalamsal/Downloads/geckodriver");
		
		
		
		

	}

}
