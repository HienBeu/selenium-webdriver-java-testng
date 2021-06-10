package Webdriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_07_Web_Element_Excecise {
	// Khai báo biến (Declare)
	WebDriver driver;
	String firstName, lastName, emailAddress, passWord, fullName;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://live.demoguru99.com/");

		// Khởi tạo data test
		firstName = "Osama";
		lastName = "Bin Laden";
		fullName = "firstName" + "" + "lastName";
		emailAddress = "osama" + generateEmail();
		passWord = "123456";
	}

	@Test
	public void TC_01_Creat_New_account() {
		driver.get("http://live.demoguru99.com/");

		driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();

		driver.findElement(By.xpath("//a[@title='Create an Account']")).click();

		driver.findElement(By.id("firstname")).sendKeys(firstName);

		driver.findElement(By.id("lastname")).sendKeys(lastName);

		driver.findElement(By.id("email_address")).sendKeys(emailAddress);

		driver.findElement(By.id("password")).sendKeys(passWord);

		driver.findElement(By.id("confirmation")).sendKeys(passWord);

		driver.findElement(By.xpath("//button[@title='Register']")).click();
		
		Assert.assertEquals(driver.findElement(By.xpath("//li[@class='success-msg']//span")).getText(), "Thank you for registering with Main Website Store.");
		
		// Dùng hàm isDisplay để kiểm tra
		driver.findElement(By.xpath("//h3[text()= 'Contact Information']/parent::div/following-sibling::div/p[contains(string(),'" + fullName + "')]")).isDisplayed();
		driver.findElement(By.xpath("//h3[text()= 'Contact Information']/parent::div/following-sibling::div/p[contains(string(),'" + emailAddress + "')]")).isDisplayed();
		
		//Dùng hàm getText
		String contactInformation = driver.findElement(By.xpath("//h3[text()= 'Contact Information']/parent::div/following-sibling::div/p")).getText();
		System.out.println(contactInformation);
		
		Assert.assertTrue(contactInformation.contains(fullName));
		Assert.assertTrue(contactInformation.contains(emailAddress));
	}

	@Test
	public void TC_01_Classname() {

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	public String generateEmail() {
		Random rand = new Random();
		return rand.nextInt(9999) + "@email.vn";
	}
	
	public void sleepInSecond(long timeoutInSecond) {
		try {
		   Thread.sleep(timeoutInSecond * 1000);
		} catch (InterruptedException e) {
		   e.printStackTrace();
		}
	}

}