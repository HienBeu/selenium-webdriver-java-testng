package Webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_09_Default_DropdownList {
	WebDriver driver;
	Select select;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void TC_01_Nopcommerce() {
		driver.get("https://demo.nopcommerce.com/");
		driver.findElement(By.className("ico-register")).click();
		driver.findElement(By.id("FirstName")).sendKeys("Automation");
		driver.findElement(By.id("LastName")).sendKeys("FC");
		
		select = new Select(driver.findElement(By.name("DateOfBirthDay")));
		
		//3 cách khác nhau
		//select.selectByIndex(0); không nên dùng vì index có thể thay đổi bất kể lúc nào 
		
		//select.selectByValue("number:27"); dữ liệu động thì không thể biết được là dữ đang ntn hoặc ví dụ có dropdown k có value thì sao? -> nên có thể đúng hoặc sai
		
	
		select.selectByVisibleText("");
	
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