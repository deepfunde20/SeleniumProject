package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class BaseClass {
	public static WebDriver driver ;
	public static Properties prop;
	
	public BaseClass() {
		
		prop = new Properties(); //Creating instance of properties class
		File src = new File ("src/main/java/properties/config.properties"); //specifying the path of propertiesfile
		try {
			FileInputStream file = new FileInputStream(src);
			
			prop.load(file); // Loading properties file into instance of properties class
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	

@BeforeSuite	 
public void browserinit() {	
		new BaseClass();  // For intializing properties instance else it will give NullPointerException
		System.setProperty("webdriver.chrome.driver",prop.getProperty("ChromePath"));
		
		driver = new ChromeDriver ();
		
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		
		
		
	
		
	}
}
