package Webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_06_Web_Brower_Method {
	//Interface
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();//Class
	}

	@Test
	public void TC_01_ID() {
		//Bien driver tuong tac voi browser
		driver.
		
		//Bien.... tuong tac voi element (textbox/ dropdown/ checkbox/...)
	}
}