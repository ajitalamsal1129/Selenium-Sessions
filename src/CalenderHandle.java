import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CalenderHandle {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/ajitalamsal/Downloads/chromedriver");
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();//maximize window
		driver.manage().deleteAllCookies();//delete all the cookies
		
		//dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		driver.get("https://jqueryui.com/datepicker/#dropdown-month-year");
		
		driver.switchTo().frame(0);
		driver.findElement(By.id("datepicker")).click();
		Thread.sleep(5000);

		String date="32-Oct-2017";
		String dateArr[]=date.split("-");
		String day=dateArr[0];
		String month=dateArr[1];
		String year=dateArr[2];
		
		
		Select select=new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-month']")));
		select.selectByVisibleText(month);
		
		Select select1=new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-year']")));
		select1.selectByVisibleText(year);
		
		//*[@id="ui-datepicker-div"]/table/tbody/tr[1]/td[1]/a
		//*[@id="ui-datepicker-div"]/table/tbody/tr[1]/td[3]
		//*[@id="ui-datepicker-div"]/table/tbody/tr[5]/td[3]/a
		
		//for date
		String before_xpath="//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[";
		String after_xpath="]/td[";		
		
		final int totalweekdays=7;
		String dayVal=null;
		
		boolean flag=false;
		//1-1 1-2 1-3 1-4 5-5 1-6 1-7
		//2-1 2-2 2-3 2-4 2-5 2-6 2-7
		for(int rowNum=1;rowNum<=5;rowNum++) {
			for(int colNum=1;colNum<=totalweekdays;colNum++) {
				try {
				
	          dayVal=driver.findElement(By.xpath(before_xpath+rowNum+after_xpath+colNum+"]/a")).getText();
				}catch(NoSuchElementException e) {
					System.out.println("Please enter a valid date");
					flag=true;
					break;
				}
				System.out.println(dayVal);				
				if(dayVal.contentEquals(day)) {
					driver.findElement(By.xpath(before_xpath+rowNum+after_xpath+colNum+"]/a")).click();
					flag=true;//when it selects the date it will not check remaining dates
					break;
				}
				
			}
			if(flag) {//false if dayVal is not equal to day and  loop starts again
				break;
			}
		}
		
	//First outer loop will start.It will execute the combination of row 1 with columns 1-7	
		//We have to break the inner loop first.After that control will come to outer loop
		

	}

}
