package TestNGFramework;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGConcept {
	         //Pairs
     //BeforeMethod-@Test1-@AfterMethod
     //BeforeMethod-@Test2-@AfterMethod
    //BeforeMethod-@Test3-@AfterMethod
    //@BeforeMehod and @AfterMethod is executed each time with every @Test
	//Others--one time execution

	
	
	//Pre-condition annotations-Starting with @Before
	@BeforeSuite//1
	public void setup() {
		System.out.println("@BeforeSuite--Setup system property for chrome");
		
	}
	
	@BeforeTest//2
	public void launchbrowser() {
		System.out.println("@BeforeTest--launchbrowser");
		
	}
	
	@BeforeClass//3
	public void login() {
		System.out.println("@BeforeClass--login to app");
		
	}
	
	
	
	@BeforeMethod//4
	public void enterurl() {
		System.out.println("@BeforeMethod--enter URL");
		
	}
	//Test cases-starting with @Test
	@Test//5
	public void googleTitleTest() {
		System.out.println("--Google Title Test");
		
	}
	
	@Test
	public void searchTest() {
		System.out.println("@Test--Search Test");
		
	}
	@Test
	public void googleLogoTest() {
		System.out.println("@Test--google logo test");
		
	}
	
	
	//Post condition-starting with @After
	@AfterMethod//6
	public void logout() {
		System.out.println("@AfterMethod--logout from app");
		
		
		
	}
	
	@AfterClass//7
	public void closeBrowser() {
		System.out.println("@AfterClass--close Browser");
		
	}
	
	@AfterTest//8
	public void deleteAllCookies() {
		System.out.println("@AfterTest--delete all cookies");
		
	}
	
	@AfterSuite//9
	public void generateTestReport() {
		System.out.println("@AfterSuite--Generate Test Report");
		
	}
	
	//OUTPUT
	/* @BeforeSuite--Setup system property for chrome
	@BeforeTest--launchbrowser
	@BeforeClass--login to app
	@BeforeMethod--enter URL
	@Test--google logo test
	@AfterMethod--logout from app
	@BeforeMethod--enter URL
	--Google Title Test
	@AfterMethod--logout from app
	@BeforeMethod--enter URL
	@Test--Search Test
	@AfterMethod--logout from app
	@AfterClass--close Browser
	@AfterTest--delete all cookies
	PASSED: googleLogoTest
	PASSED: googleTitleTest
	PASSED: searchTest */

	
	
	
	
	
	
	
	

}
