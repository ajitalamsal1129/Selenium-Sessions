package TestNGFramework;

import org.testng.annotations.Test;

public class ExceptionTimeOutTest {
//	@Test(invocationTimeOut=2000,expectedExceptions=NumberFormatException.class)//will stop the test after 2 seconds,exception handling
//	public void infiniteLoopTest() {
//		int i=1;
//		while(i==1) {
//			System.out.println(i);
//		}
	
	@Test(expectedExceptions=NumberFormatException.class)
	public void test1() {
		String x="100A";
		Integer.parseInt(x);//NumberFormatException
	}

}
