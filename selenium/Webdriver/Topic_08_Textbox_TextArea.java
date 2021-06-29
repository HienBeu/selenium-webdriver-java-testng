package Webdriver;

import static org.testng.Assert.assertEquals;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_08_Textbox_TextArea {
	WebDriver driver;
	String emailAddress, LoginPageUrl, userID, password;

	// Data test New Customer
	String name, dob, address, city, state, pin, phone;

	// UI (Customer/Edit customer)
	By customerNameTextboxBy = By.name("name");
	By dateofbirthTextboxBy = By.name("dob");
	By adressAreaBy = By.name("addr");
	By cityTextboxBy = By.name("city");
	By stateTextboxBy = By.name("state");
	By pinTextboxBy = By.name("pinno");
	By mobilenumberTextboxBy = By.name("telephoneno");
	By emailTextboxBy = By.name("emailid");
	By passwordTextboxBy = By.name("password");

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://demo.guru99.com/V4/");
		emailAddress = "johnlips" + generateEmail();

		// Khởi tạo data test cho New Customer
		name = "Nguyen Thi Hien";
		dob = "1994/08/04";
		address = "Dong Da";
		city = "ha Noi";
		state = "Viet Nam";
		pin = "481994";
		phone = "0972139939";

	}

	@Test
	public void TC_01_ID_Register() {
		LoginPageUrl = driver.getCurrentUrl();
		driver.findElement(By.xpath("//a[text()='here']")).click();

		driver.findElement(By.name("emailid")).sendKeys(emailAddress);

		driver.findElement(By.name("btnLogin")).click();

		userID = driver.findElement(By.xpath("//td[text()='User ID :']/following-sibling::td")).getText();
		password = driver.findElement(By.xpath("//td[text()='Password :']/following-sibling::td")).getText();

	}

	@Test
	public void TC_02_Login() {
		driver.get(LoginPageUrl);
		driver.findElement(By.name("uid")).sendKeys(userID);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("btnLogin")).click();

		Assert.assertEquals(driver.findElement(By.cssSelector("marquee.heading3")).getText(),
				"Welcome To Manager's Page of Guru99 Bank");

	}

	@Test
	public void TC_03_Create_New_User() {
		driver.findElement(By.xpath("//a[text()='New Customer']")).click();
		
		driver.findElement(By.name("customerNameTextboxBy")).sendKeys(name);
		driver.findElement(By.name("dateofbirthTextboxBy")).sendKeys(dob);
		driver.findElement(By.name("adressAreaBy")).sendKeys(address);
		driver.findElement(By.name("cityTextboxBy")).sendKeys(city);
		driver.findElement(By.name("stateTextboxBy")).sendKeys(state);
		driver.findElement(By.name("pinTextboxBy")).sendKeys(pin);
		driver.findElement(By.name("passwordTextboxBy")).sendKeys(phone);
		driver.findElement(By.name("emailTextboxBy")).sendKeys(emailAddress);
		driver.findElement(By.name("passwordTextboxBy")).sendKeys(password);
		
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		
		Assert.assertEquals(driver.findElement(By.xpath("//p[@class='heading3']")).getText(), "Customer Registered Successfully!!!");
	}

	@Test
	public void TC_04_Update() {

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
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
