package TestNGFramework;

import org.testng.annotations.Test;

public class TestNGFeatures {
	@Test
	public void loginTest() {
		System.out.println("login test");
		//int i=9/0;
	}
	
	@Test(dependsOnMethods="loginTest")
	public void HomePageTest() {
		System.out.println("Homepage test");
	}
	
	@Test(dependsOnMethods="loginTest")
	public void searchPageTest() {
		System.out.println("Search Page test");
	}
	
	@Test(dependsOnMethods="loginTest")
	public void RegPageTest() {
		System.out.println("Reg Page test");
	}
	
	
	
	
	

}
