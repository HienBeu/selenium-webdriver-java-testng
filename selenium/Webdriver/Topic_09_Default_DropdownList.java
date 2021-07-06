package Webdriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
	JavascriptExecutor jsExecutor;
	String firstName, lastName, emailAddress, companyName, day, month, year;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		jsExecutor = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		firstName = "AutomationFC";
		lastName = "FC1";
		companyName = "Viet nam";
		emailAddress = "autofc" + generateEmail();
		day="10";
		month="April"; 
		year ="1915";
	}

	@Test
	public void TC_01_Nopcommerce() {
		driver.get("https://demo.nopcommerce.com/");
		driver.findElement(By.className("ico-register")).click();
		sleepInSecond(2);
		driver.findElement(By.id("FirstName")).sendKeys("firstName");
		driver.findElement(By.id("LastName")).sendKeys("lastName");
		
		// Chọn item trong dropdown
		select = new Select(driver.findElement(By.name("DateOfBirthDay")));
		select.selectByVisibleText(day);
		Assert.assertEquals(select.getFirstSelectedOption().getText(), day);
		
		//Kiểm tra được đã chọn đúng item này hay chưa 
		//Assert.assertEquals(select.getFirstSelectedOption().getText(), "10");
		
		//3 cách khác nhau
		//select.selectByIndex(0); không nên dùng vì index có thể thay đổi bất kể lúc nào 
		
		//select.selectByValue("number:27"); dữ liệu động thì không thể biết được là dữ đang ntn hoặc ví dụ có dropdown k có value thì sao? -> nên có thể đúng hoặc sai
		
		
		//Dùng để verify xem trong dropdown có tổng cộng bao nhiêu item
		//Assert.assertEquals(select.getOptions().size(), 32);
		
		//Verify dropdown này không chọn nhiều item cùng lúc. Nếu chọn được là assertTrue
		//Assert.assertTrue(select.isMultiple());
		
		select = new Select(driver.findElement(By.name("DateOfBirthMonth")));
		select.selectByVisibleText(month);
		Assert.assertEquals(select.getFirstSelectedOption().getText(), month);
		
		select = new Select(driver.findElement(By.name("DateOfBirthYear")));
		select.selectByVisibleText(year);
		Assert.assertEquals(select.getFirstSelectedOption().getText(), year);
		
		driver.findElement(By.id("Email")).sendKeys(emailAddress);
		driver.findElement(By.id("Company")).sendKeys(companyName);
		driver.findElement(By.id("Password")).sendKeys("123456");
		driver.findElement(By.id("ConfirmPassword")).sendKeys("123456");
		
		clickByJS(By.id("register-button"));
		sleepInSecond(3);
		
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='result']")).getText(), "Your registration completed");
		
		driver.findElement(By.xpath("//a[@class='ico-account']")).click();
		sleepInSecond(2);
		
		Assert.assertEquals(driver.findElement(By.id("FirstName")).getAttribute("value"), firstName);
		Assert.assertEquals(driver.findElement(By.id("LastName")).getAttribute("value"), lastName);
		Assert.assertEquals(driver.findElement(By.id("Email")).getAttribute("value"), emailAddress);
		Assert.assertEquals(driver.findElement(By.id("Company")).getAttribute("value"), companyName);
		
		
		select = new Select(driver.findElement(By.name("DateOfBirthDay")));
		Assert.assertEquals(select.getFirstSelectedOption().getText(), day);
		
		select = new Select(driver.findElement(By.name("DateOfBirthMonth")));
		Assert.assertEquals(select.getFirstSelectedOption().getText(), month);
		
		select = new Select(driver.findElement(By.name("DateOfBirthYear")));
		Assert.assertEquals(select.getFirstSelectedOption().getText(), year);
	
	}


	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	public void clickByJS(By by) {
		jsExecutor.executeScript("arguments[0].click();", driver.findElement(by));
	}
	public String generateEmail() {
		Random rand = new Random();
		return rand.nextInt(9999) + "@email.net";
	}
	public void sleepInSecond(long timeoutInSecond) {
		try {
			Thread.sleep(timeoutInSecond * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

