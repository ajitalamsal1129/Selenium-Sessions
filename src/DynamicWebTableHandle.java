import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicWebTableHandle {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/ajitalamsal/Downloads/chromedriver");
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();//maximize window
		driver.manage().deleteAllCookies();//delete all the cookies
		
		//dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		driver.get("https://datatables.net/extensions/select/examples/initialisation/checkbox.html");
		Thread.sleep(5000);
		
		
		//*[@id="example"]/tbody/tr[1]/td[2]-row 1
		//*[@id="example"]/tbody/tr[2]/td[1]--row 2
		//*[@id="example"]/tbody/tr[3]/td[1]--row 3
		//*[@id="example"]/tbody/tr[4]/td[1]--row 4
		//*[@id="example"]/tbody/tr[5]/td[1]--row 5
		
//		String before_xpath="//*[@id='example']/tbody/tr[";
//		String after_xpath="]/td[2]";
//		
		
		//1.Using for loop
//		for(int i=1;i<=5;i++) {//starting and ending point of row
//		String name=driver.findElement(By.xpath(before_xpath + i +after_xpath)).getText();
//		System.out.println(name);
////		if(name.contains("Airi Satou")) {
//			//*[@id="example"]/tbody/tr[1]/td[1]
//			//index of checkbox and the particular name is same
//			driver.findElement(By.xpath("//*[@id=\"example\"]/tbody/tr[" + i +"]/td[1]")).click();
//		}
		
		//2.Using custom xpath
		//driver.findElement(By.xpath("//a[containd(text(),'test 2 test 2')]parent::td//preceding-sibling::td//input[@name='contact_id']")).click();//Example
		driver.findElement(By.xpath("//td[text()='Airi Satou']//preceding-sibling::td")).click();//

		
		
		
		

	}
	}




