import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BootstrapDropboxHandle {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/ajitalamsal/Downloads/chromedriver");
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();//maximize window
		driver.manage().deleteAllCookies();//delete all the cookies
		
		//dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		driver.get("http://www.jquery-az.com/boots/demo.php?ex=63.0_2");
		
		driver.findElement(By.xpath("//span[contains(@class,'multiselect-selected-text')]")).click();
		//to get collection of li in single object.if you hit on label only element will get selected
		List<WebElement> list=driver.findElements(By.xpath("//ul[contains(@class,'multiselect-container dropdown-menu')]//li//a//label"));
		
		System.out.println(list.size());
		
		//To click on all elements
		//2 elements were already selected by default so it will de-select them
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i).getText());
			list.get(i).click();

		}

//		
//		for(int i=0;i<list.size();i++) {
//			System.out.println(list.get(i).getText());//for individual element we have to do get(i) because we used list class
//			if(list.get(i).getText().contains("Angular")) {//either equals or contains
//				list.get(i).click();
//				break;
//			}

			
		}

	}


