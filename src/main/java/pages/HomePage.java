package pages;

import java.awt.*;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import listeners.RetryM;

//This class have all HomePage Object library and all methods
public class HomePage extends BaseClass {

	//Object Repository or Page Library
	@FindBy(xpath="//a[@title='View my shopping cart']")
	WebElement cart;
	
	@FindBy(xpath="//img[@class='logo img-responsive']")
	WebElement ToHomePage;
	
	@FindBy(id="social_block")
	WebElement scrollendPoint;
	
	public HomePage () {
		super(); //to initialize instance of superclass we call superclass constructor by super keyword
	}
	
	
	
	public HomePage (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	

	
	public void UrlCheck () {
		
		driver.get(prop.getProperty("url")); // Go to url
		String title =driver.getTitle(); // Getting title of webpage to verify
		
		Assert.assertEquals(title, "My Store"); //Asserting with expected
		
		
	}
	
	public void cart() {
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", cart); //This is another way to click the webelements 
		Assert.assertEquals(driver.getTitle(), "Order - My Store"); 
		ToHomePage.click();	//The click through javscriptexecutor allows you to hit javascript libraries instead depending on selenium ui based click
		
		
	}
	
	public void Scrolling() throws InterruptedException {
		JavascriptExecutor js =(JavascriptExecutor)driver;
		
		//js.executeScript("window.scrollTo(0, document.body.scrollHeight)" );
		js.executeScript("arguments[0].scrollIntoView();", scrollendPoint); //Scrollingn is done through javascriptexecutor
		Thread.sleep(2000);
		js.executeScript("window.scrollTo(0,0)");
	}
	
	public void Tabs() throws InterruptedException {
		Thread.sleep(4000);
		
			List<WebElement> list2=	driver.findElements(By.xpath("//a[@class='sf-with-ul']"));
			JavascriptExecutor js =(JavascriptExecutor)driver;
			for (int i=0; i<list2.size();i++) {
				js.executeScript("arguments[0].click();", list2.get(i));
				Thread.sleep(3000);
			
				list2=driver.findElements(By.xpath("//a[@class='sf-with-ul']"));
			
			}
			WebElement el =driver.findElement(By.xpath("//a[@title='T-shirts']"));
			js.executeScript("arguments[0].click();",el); // sometimes normal selenium click method wont work so go for JavascriptExecutor
			
			ToHomePage.click();
		
		
		
	}
}
