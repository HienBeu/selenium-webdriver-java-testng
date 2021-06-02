package Webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_06_Web_Brower_Excecise {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://live.demoguru99.com/");
	}

	@Test
	public void TC_01_Verify_Url() {
		//Click vào my account ở dưới footer
		
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		
		Assert.assertEquals(driver.getCurrentUrl(),"http://live.demoguru99.com/index.php/customer/account/login/");
		
	    //click để truyền vào trang Register
		
		driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
		
		Assert.assertEquals(driver.getCurrentUrl(),"http://live.demoguru99.com/index.php/customer/account/create/");
	}
	@Test
	public void TC_02_Verify_Title() {
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		
		Assert.assertEquals(driver.getTitle(),"Customer Login");
		
		driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
		
		Assert.assertEquals(driver.getTitle(),"Create New Customer Account");
	}
	@Test
	public void TC_03_Verify_Navigation() {
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		
		
		driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
		driver.navigate().back();
		
		Assert.assertEquals(driver.getTitle(),"Customer Login");
		driver.navigate().forward();
		
	}
	@Test
	public void TC_04_Verify_Page_Source() {
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		
		// Khai báo & khởi tạo biến tại vị trí màn hình login 
		String currentPageSource = driver.getPageSource();
		
		Assert.assertTrue(currentPageSource.contains("Login or Create an Account"));
		
		driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
		
		//Khởi tạo lại tại màn hình register
		String currentPageTitle = driver.getTitle();
		Assert.assertTrue(currentPageSource.contains("Create an Account"));
		}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}