package listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
//This is the listener class which allows failed tests to retry muliple times 
//Directly this can be used at class level and at individual test level
public class RetryM implements IRetryAnalyzer {

	int max = 3;
	int counter =0;
	
	@Override
	public boolean retry(ITestResult result) {
		
		
		if (counter<max) {
			
			counter++;
			
			return true ;
		}
		
		return false;
	}

	
	
}
