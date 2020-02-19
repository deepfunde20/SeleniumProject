package testPages;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.HomePage;

//This class aims to execute all methods of homepage class through testng
public class TestHomePage extends BaseClass{

	
	HomePage h ;
	
	@Test (priority =0)
	public void TestTitlepage() {
		h = new HomePage (driver);
		h.UrlCheck();
		
	}
	
	
	@Test (priority =1)
	
	public void CartClick() throws InterruptedException {
		
		h.cart();
		
		Thread.sleep(4000);
	}
	
	@Test(priority=3)
	public void ScrollTest() throws InterruptedException {
		h.Scrolling();
		boolean verify =driver.findElement(By.id("social_block")).isDisplayed();
		Assert.assertEquals(verify, true); //verifying weather page reached to the bottom
	}
	
	@Test(priority=4)
	public void TabsClickAbility() throws InterruptedException {
		h.Tabs();
		Assert.assertEquals(driver.getTitle(), "My Store");
	}
}
