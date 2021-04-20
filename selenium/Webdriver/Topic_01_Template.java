package Webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_01_Template {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("");
	}

	@Test
	public void TC_01_ID() {
	
	}
	@Test
	public void TC_01_Classname() {
		
	}
	@Test
	public void TC_01_Name() {
		
	}
	@Test
	public void TC_01_Tagname() {
		
	}
	@Test
	public void TC_01_LinkText() {
		
	}
	@Test
	public void TC_01_Partial_Link_Text() {
		
	}
	@Test
	public void TC_01_Css() {
		
	}
	@Test
	public void TC_01_Xpath() {
		
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}