package Webdriver;

import java.util.concurrent.TimeUnit;

//import org.junit.AfterClass;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_04_Xpath_Css_Part_II_Technical {
//Biến driver đại diện cho Selenium WebDriver
	WebDriver driver;
	
	@BeforeClass
	public void beforeClass() {
		// Mở trình duyệt firefox
		driver = new FirefoxDriver();

		// Thời gian để chờ cho element được tìm thấy trong 1 khoảng thời gian (30s)
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Mở AUT/ SUT
		}
	
	@Test
	public void TC_01_Login_Empty_Email_Password() {
		driver.get("http://live.demoguru99.com/index.php");
		driver.findElement(By.xpath("//div[@class = 'footer']//a[@title = 'My Account']")).click();
		
		driver.findElement(By.id("email")).sendKeys("");
		driver.findElement(By.id("pass")).sendKeys("");
		driver.findElement(By.name("send")).click();
		
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='advice-required-entry-email']")).getText(), "This is a required field.");
		
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='advice-required-entry-pass']")).getText(), "This is a required field.");
		
		}
	@Test
	public void TC_02_Login_with_Invalid_Email() {
		driver.get("http://live.demoguru99.com/index.php");
		driver.findElement(By.xpath("//div[@class = 'footer']//a[@title = 'My Account']")).click();
		
		driver.findElement(By.id("email")).sendKeys("123@123.456");
		driver.findElement(By.id("pass")).sendKeys("123456");
		driver.findElement(By.name("send")).click();
		
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='advice-validate-email-email']")).getText(), "Please enter a valid email address. For example johndoe@domain.com.");
	
	}
	
	@Test
	public void TC_03_Login_with_Invalid_Password() {
		driver.get("http://live.demoguru99.com/index.php");
		driver.findElement(By.xpath("//div[@class = 'footer']//a[@title = 'My Account']")).click();
		
		driver.findElement(By.id("email")).sendKeys("nguyenhienit94@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("123");
		driver.findElement(By.name("send")).click();
		
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='advice-validate-password-pass']")).getText(), "Please enter 6 or more characters without leading or trailing spaces.");
	
	}
	
	@Test
	public void TC_04_Login_with_Incorect_Password() {
		driver.get("http://live.demoguru99.com/index.php");
		driver.findElement(By.xpath("//div[@class = 'footer']//a[@title = 'My Account']")).click();
		
		driver.findElement(By.id("email")).sendKeys("nguyenhienit94@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("123123123");
		driver.findElement(By.name("send")).click();
		
		Assert.assertEquals(driver.findElement(By.xpath(".//li[@class='error-msg']//span")).getText(), "Invalid login or password.");
	
	
		}
		
		
		@AfterClass
		public void afterClass() {
			driver.quit();
			}
		
			public void sleepInSecond(long timeoutInSecond) {
			try {
			   Thread.sleep(timeoutInSecond * 1000);
			} catch (InterruptedException e) {
			   e.printStackTrace();
			}
			}
			}