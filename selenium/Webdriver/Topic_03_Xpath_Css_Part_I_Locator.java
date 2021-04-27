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
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_03_Xpath_Css_Part_I_Locator {
//Biến driver đại diện cho Selenium WebDriver
	WebDriver driver;
	
	@BeforeClass
	public void beforeClass() {
		// Mở trình duyệt firefox
		driver = new FirefoxDriver();

		// Thời gian để chờ cho element được tìm thấy trong 1 khoảng thời gian (30s)
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Mở AUT/ SUT
		driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");
		}
	
	@Test
	public void TC_01_ID() {
		//Nhập giá trị FirtName textbox
		driver.findElement(By.id("FirstName")).sendKeys("Automation Testing");
		sleepInSecond(3);
		//Click vào male radio button
		driver.findElement(By.id("gender-male")).click();
		sleepInSecond(3);
		}
	
	@Test
	public void TC_02_className() {
		driver.navigate().refresh();

		driver.findElement(By.className("search-box-text")).sendKeys("Macbook");
		sleepInSecond(3);
		driver.findElement(By.className("search-box-text")).click();
		sleepInSecond(3);
		}
	
	@Test
	public void TC_03_Name() {
		driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");

		driver.findElement(By.name("Email")).sendKeys("nguyenhienit94@gmail.com");
		sleepInSecond(3);

		driver.findElement(By.name("Newsletter")).click();
		sleepInSecond(3);
		}
	
	@Test
	public void TC_04_Tagname() {
		System.out.println("Sum link = " + driver.findElements(By.tagName("a")).size());

		System.out.println("Sum input = " + driver.findElements(By.tagName("input")).size());
		}

		@Test
		public void TC_05_Link_Text() {
		driver.findElement(By.linkText("Log in")).click();
		sleepInSecond(3);
		}
		
		@Test
		public void TC_06_Partial_Link_Text() {
			driver.findElement(By.partialLinkText("Recently viewed products")).click();
			sleepInSecond(3);

			driver.findElement(By.partialLinkText("viewed products")).click();
			sleepInSecond(3);

			driver.findElement(By.partialLinkText("Recently viewed")).click();
			sleepInSecond(3);
			}
		
		@Test
		public void TC_07_Css() {
			driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");

			driver.findElement(By.cssSelector("input[id='FirstName']")).sendKeys("Automation");
			sleepInSecond(3);

			driver.findElement(By.cssSelector("input[class='search-box-text ui-autocomplete-input']")).sendKeys("Macbook");
			sleepInSecond(3);

			driver.findElement(By.cssSelector("input[name='Email']")).sendKeys("nguyenhienit@gmail.com");
			sleepInSecond(3);

			driver.findElement(By.cssSelector("a[href*='login']")).click();
			sleepInSecond(3);
			}
		
		@Test
		public void TC_08_Xpath() {
			driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");

			driver.findElement(By.xpath("//*[@id='FirstName']")).sendKeys("Automation FC");
			sleepInSecond(3);

			driver.findElement(By.xpath("//input[contains(@class,'search-box-text')]")).sendKeys("Macbook");
			sleepInSecond(3);

			driver.findElement(By.xpath("//input[@name='Email']")).sendKeys("nguyenhienit94@gmail.com");
			sleepInSecond(3);

			driver.findElement(By.xpath("//a[@class='ico-login']")).click();
			sleepInSecond(3);

			driver.findElement(By.xpath("//a[contains(text(),'Recently viewed')]")).click();
			sleepInSecond(3);
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