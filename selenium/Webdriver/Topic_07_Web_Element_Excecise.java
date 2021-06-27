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
	String firstName, lastName, emailAddress, password, fullName;
	
	By emailTextbox = By.id("mail");
	By eduTextarea = By.id("edu");
	By under18Radio = By.id("under_18");
	By javaCheckbox = By.id("java");
	
	By passwordTextbox = By.id("password");
	By disableCheckbox = By.id("check-disbaled");
	By disableButton = By.id("button-disabled");

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Khởi tạo data test
		firstName = "Osama";
		lastName = "Bin Laden";
		fullName = firstName + " " + lastName;
		emailAddress = "osama" + generateEmail();
		//osama5135@gmail.com
		//osama5136@gmail.com
		password = "123456";
	}

	//@Test
	public void TC_01_Create_New_Account() {
		driver.get("http://live.demoguru99.com/");

		driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//a[@title='Create an Account']")).click();

		driver.findElement(By.id("firstname")).sendKeys(firstName);

		driver.findElement(By.id("lastname")).sendKeys(lastName);

		driver.findElement(By.id("email_address")).sendKeys(emailAddress);

		driver.findElement(By.id("password")).sendKeys(password);

		driver.findElement(By.id("confirmation")).sendKeys(password);

		sleepInSecond(30);
		
		driver.findElement(By.xpath("//button[@title='Register']")).click();
		
		
		Assert.assertEquals(driver.findElement(By.xpath("//li[@class='success-msg']//span")).getText(), "Thank you for registering with Main Website Store.");
		
		// Dùng hàm isDisplay để kiểm tra
		Assert.assertTrue(driver.findElement(By.xpath("//h3[text()= 'Contact Information']/parent::div/following-sibling::div/p[contains(string(),'" + fullName + "')]")).isDisplayed());
		sleepInSecond(3);
		Assert.assertTrue(driver.findElement(By.xpath("//h3[text()= 'Contact Information']/parent::div/following-sibling::div/p[contains(string(),'" + emailAddress + "')]")).isDisplayed());
		
		//Dùng hàm getText
		String contactInformation = driver.findElement(By.xpath("//h3[text()= 'Contact Information']/parent::div/following-sibling::div/p")).getText();
		System.out.println(contactInformation);
		
		Assert.assertTrue(contactInformation.contains(fullName));
		Assert.assertTrue(contactInformation.contains(emailAddress));
		
		driver.findElement(By.cssSelector(".skip-account")).click();
		
		driver.findElement(By.cssSelector("a[title = 'Log Out']")).click();
		
	}
	
	//@Test
	public void TC_02_Login_With_Valid_Email_And_Password() {
		driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
		
		driver.findElement(By.cssSelector("#email")).sendKeys(emailAddress);
		driver.findElement(By.cssSelector("#pass")).sendKeys(password);
		driver.findElement(By.xpath("//button[@title='Login']")).click();
		
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='welcome-msg']//strong")).getText(), "Hello, " + fullName +  "!");
	}

	//@Test
	public void TC_03_Displayed_Newbie_Cach1() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		//Hàm kiểm tra điều kiện
		//Nếu đk đúng thì mới vào bên trong hàm if
		//Sai thì không vào
		if(driver.findElement(By.id("mail")).isDisplayed()) {
			driver.findElement(By.id("mail")).sendKeys("Automation FC");
			System.out.println("Mail textbox is displayed");
		}else {
			System.out.println("Mail textbox is not displayed (undisplayed)");
		}
		
		if(driver.findElement(By.id("edu")).isDisplayed()) {
			driver.findElement(By.id("edu")).sendKeys("Automation FC");
			System.out.println("Education textarea is displayed");
		}else {
			System.out.println("Education textarea is not displayed (undisplayed)");
		}
		
		if(driver.findElement(By.id("under_18")).isDisplayed()) {
			driver.findElement(By.id("under_18")).click();
			System.out.println("Radio button 'under 18' is displayed");
		}else {
			System.out.println("Radio button 'under 18' is not displayed (undisplayed)");
		}
		
		}
		
	//@Test
	public void TC_03A_Displayed_Function_Cach2() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
	
		
		if(isElementDisplayed(emailTextbox)) {
			sendKeyToElement(emailTextbox, "Automation FC");
		}
		
		if(isElementDisplayed(eduTextarea)) {
			sendKeyToElement(eduTextarea, "Automation FC");
		}
		
		if(isElementDisplayed(under18Radio)) {
			clickToElement(under18Radio);
		}
		}
	
		//if-else
		//Đúng vào if - sai vào  else
		
	
	//@Test
	public void TC_04_Selected_Funtion() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		
		clickToElement(under18Radio);
		clickToElement(javaCheckbox);
		
		//Verify checkbox/radio are selected 
		Assert.assertTrue(isElementSelected(under18Radio));
		Assert.assertTrue(isElementSelected(javaCheckbox));
		
		clickToElement(under18Radio);
		clickToElement(javaCheckbox);
		
		//Verify checkbox is  de-selected 
		Assert.assertFalse(isElementSelected(javaCheckbox));
		
		//Verify radio are selected 
		Assert.assertTrue(isElementSelected(under18Radio));
		
		
	}
	
	//@Test
	public void TC_05_Enable() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		
		//Expected nó enabled
		Assert.assertTrue(isElementEnabled(emailTextbox));
		Assert.assertTrue(isElementEnabled(eduTextarea));
		Assert.assertTrue(isElementEnabled(under18Radio));
		Assert.assertTrue(isElementEnabled(javaCheckbox));
		
		//Expected nó disable
		Assert.assertFalse(isElementEnabled(passwordTextbox));
		Assert.assertFalse(isElementEnabled(disableCheckbox));
		Assert.assertFalse(isElementEnabled(disableButton));
		
	}
	
	@Test
	public void TC_06_Register_Validate() {
		driver.get("https://login.mailchimp.com/signup/");
		
		By passwordTextbox = By.id("new_password");
		By signUpButton = By.cssSelector("#create-account");
		By newsletterCheckbox = By.id("marketing_newsletter");
		By upperCaseCompleted = By.cssSelector(".uppercase-char.completed");
		By lowerCaseCompleted = By.cssSelector(".lowercase-char.completed");
		By numberCompleted = By.cssSelector(".number-char.completed");
		By specialCharCompleted = By.cssSelector(".special-char.completed");
		By greaterThan8CharCompleted = By.cssSelector("li[class='8-char completed']");
		
		driver.findElement(By.id("email")).sendKeys("automation@hotmail.net");
		driver.findElement(By.id("new_username")).sendKeys("automation.net");
		
		//Uppercase
		driver.findElement(passwordTextbox).sendKeys("AUTOMATION");
		sleepInSecond(2);
		Assert.assertTrue(isElementDisplayed(upperCaseCompleted));
		Assert.assertFalse(isElementEnabled(signUpButton));
		
		//Lowercase
		driver.findElement(passwordTextbox).clear();
		driver.findElement(passwordTextbox).sendKeys("automation");
		sleepInSecond(2);
		Assert.assertTrue(isElementDisplayed(lowerCaseCompleted));
		Assert.assertFalse(isElementEnabled(signUpButton));
		

		//Number
		driver.findElement(passwordTextbox).clear();
		driver.findElement(passwordTextbox).sendKeys("123456");
		sleepInSecond(2);
		Assert.assertTrue(isElementDisplayed(numberCompleted));
		Assert.assertFalse(isElementEnabled(signUpButton));
		
		//Special
		driver.findElement(passwordTextbox).clear();
		driver.findElement(passwordTextbox).sendKeys("@#$%^&*");
		sleepInSecond(2);
		Assert.assertTrue(isElementDisplayed(specialCharCompleted));
		Assert.assertFalse(isElementEnabled(signUpButton));
		
		//>=8char
		driver.findElement(passwordTextbox).clear();
		driver.findElement(passwordTextbox).sendKeys("automationtesting");
		sleepInSecond(2);
		Assert.assertTrue(isElementDisplayed(lowerCaseCompleted));
		Assert.assertTrue(isElementDisplayed(greaterThan8CharCompleted));
		Assert.assertFalse(isElementEnabled(signUpButton));
		
		//All criteria
		driver.findElement(passwordTextbox).clear();
		driver.findElement(passwordTextbox).sendKeys("automation123***");
		sleepInSecond(2);
		
		Assert.assertFalse(isElementDisplayed(lowerCaseCompleted));
		Assert.assertFalse(isElementDisplayed(upperCaseCompleted));
		Assert.assertFalse(isElementDisplayed(numberCompleted));
		Assert.assertFalse(isElementDisplayed(greaterThan8CharCompleted));
		Assert.assertFalse(isElementDisplayed(specialCharCompleted));
		
		
		Assert.assertTrue(isElementEnabled(signUpButton));
		
		clickToElement(newsletterCheckbox);
		Assert.assertTrue(isElementSelected(newsletterCheckbox));
	}
	
	@AfterClass
	public void afterClass() {
		//driver.quit();
	}
	
	public String generateEmail() {
		Random rand = new Random();
		return rand.nextInt(9999) + "@email.vn";
	}
	
	public boolean isElementDisplayed(By by) {
		if(driver.findElement(by).isDisplayed()) {
			System.out.println(by + "is displayed");
			return true;
		} else {
			System.out.println(by + "is not displayed");
			return false;
		}
		
	}
	
	public boolean isElementSelected(By by) {
		if(driver.findElement(by).isSelected()) {
			System.out.println(by + "is selected");
			return true;
		} else {
			System.out.println(by + "is not selected");
			return false;
		}
		
	}
	
	public boolean isElementEnabled(By by) {
		if(driver.findElement(by).isEnabled()) {
			System.out.println(by + "is enable");
			return true;
		} else {
			System.out.println(by + "is disabled");
			return false;
		}
		
	}
	
	public void sendKeyToElement(By by, String value) {
		driver.findElement(by).clear();
		driver.findElement(by).sendKeys(value);
	}
	
	public void clickToElement(By by) {
		driver.findElement(by).click();
	}
	
	public void sleepInSecond(long timeoutInSecond) {
		try {
		   Thread.sleep(timeoutInSecond * 1000);
		} catch (InterruptedException e) {
		   e.printStackTrace();
		}
	}

}