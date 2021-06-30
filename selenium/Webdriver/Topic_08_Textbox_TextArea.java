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

	// Declare Data test New Customer
	String name, dob, address, city, state, pin, phone, customerID;
	
	// Declare Data test EditCustomer
	String Editaddress, Editcity, Editstate, Editpin, Editphone, Editemail;

	// UI (Customer/Edit customer)
	By nameTextboxBy = By.name("name");
	By genderTextboxBy = By.name("gender");
	By dobTextboxBy = By.name("dob");
	By customerNameTextboxBy = By.name("name");
	By genderRadioButtonBy = By.name("rad1");
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
		

		// Khởi tạo data test cho New Customer
		emailAddress = "johnlips" + generateEmail();
		name = "Nguyen Thi Hien";
		dob = "1994/08/04";
		address = "Dong Da";
		city = "ha Noi";
		state = "Viet Nam";
		pin = "481994";
		phone = "0972139939";
		
		// Khởi tạo data test cho Edit Customer
		Editaddress = "Hoang Cau";
		Editcity = "Thu Duc";
		Editstate = "Ho Chi Minh "; 
		Editpin = "271987";
		Editphone = "0972139936";
		Editemail = "jerry" + generateEmail();
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

		Assert.assertEquals(driver.findElement(By.cssSelector("marquee.heading3")).getText(),"Welcome To Manager's Page of Guru99 Bank");
	
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
		
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Customer Name']/following-sibling::td")).getText(), name);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Birthdate']/following-sibling::td")).getText(), dob);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Address']/following-sibling::td")).getText(), address);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='City']/following-sibling::td")).getText(), city);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='State']/following-sibling::td")).getText(), state);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Pin']/following-sibling::td")).getText(), pin);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Mobile No.']/following-sibling::td")).getText(), phone);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Email']/following-sibling::td")).getText(), emailAddress);
		
		customerID = driver.findElement(By.xpath("//td[text()='Customer ID']/following-sibling::td")).getText();
		
		
	}

	@Test
	public void TC_04_Update() {
		driver.findElement(By.xpath("//a[text()='Edit Customer']")).click();
		driver.findElement(By.name("name")).sendKeys(customerID);
		driver.findElement(By.name("AccSubmit")).click();
		
		Assert.assertFalse(driver.findElement(nameTextboxBy).isEnabled());
		Assert.assertFalse(driver.findElement(genderTextboxBy).isEnabled());
		Assert.assertFalse(driver.findElement(dobTextboxBy).isEnabled());
		
		Assert.assertEquals(driver.findElement(nameTextboxBy).getAttribute("value"), name);
		Assert.assertEquals(driver.findElement(dobTextboxBy).getAttribute("value"), dob);
		Assert.assertEquals(driver.findElement(adressAreaBy).getText(), address);
		Assert.assertEquals(driver.findElement(cityTextboxBy).getAttribute("value"), city);
		Assert.assertEquals(driver.findElement(stateTextboxBy).getAttribute("value"), state);
		Assert.assertEquals(driver.findElement(pinTextboxBy).getAttribute("value"), pin);
		Assert.assertEquals(driver.findElement(mobilenumberTextboxBy).getAttribute("value"), phone);
		Assert.assertEquals(driver.findElement(emailTextboxBy).getAttribute("value"), emailAddress);
		
		//Edit Customer
		driver.findElement(adressAreaBy).clear();
		driver.findElement(adressAreaBy).sendKeys(Editaddress);
		
		driver.findElement(cityTextboxBy).clear();
		driver.findElement(cityTextboxBy).sendKeys(Editcity);
		
		driver.findElement(stateTextboxBy).clear();
		driver.findElement(stateTextboxBy).sendKeys(Editstate);
		
		driver.findElement(pinTextboxBy).clear();
		driver.findElement(pinTextboxBy).sendKeys(Editpin);
		
		driver.findElement(mobilenumberTextboxBy).clear();
		driver.findElement(mobilenumberTextboxBy).sendKeys(Editphone);
		
		driver.findElement(emailTextboxBy).clear();
		driver.findElement(emailTextboxBy).sendKeys(Editemail);
		
		driver.findElement(By.name("sub")).click();
		
		Assert.assertEquals(driver.findElement(By.xpath("//p[@class='heading3']")).getText(), "Customer details updated Successfully!!!");
		
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Customer Name']/following-sibling::td")).getText(), name);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Birthdate']/following-sibling::td")).getText(), dob);
		
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Address']/following-sibling::td")).getText(), Editaddress);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='City']/following-sibling::td")).getText(), Editcity);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='State']/following-sibling::td")).getText(), Editstate);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Pin']/following-sibling::td")).getText(), Editpin);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Mobile No.']/following-sibling::td")).getText(), Editphone);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Email']/following-sibling::td")).getText(), Editemail);
	}

	@Test
	public void TC_05_Update() {
		
	}
	@Test
	public void TC_06_Update() {
		
	}
	@Test
	public void TC_07_Update() {
		
	}
	@Test
	public void TC_08_Update() {
		
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
