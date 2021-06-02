package Webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
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
	public void TC_01_Browser() {
		//Bien driver tuong tac voi browser
		
		//Mo 1 page ra (Url) -> ham hay dung->  **
		driver.get("https://www.facebook.com/");
		
		//Lay ra duong dan (url) cua page hien tai -> **
		String localPageUrl = driver.getCurrentUrl();
		
		//Lay ra cai title cua page hien tai -> **
		driver.getTitle();
		
		//Lay toan bo HTML code cua page hien tai
		driver.getPageSource();
		
		
	    // Xu ly muon chuyen  qua 1 tab/ windowns nào đó  ->**
		driver.getWindowHandle();
		driver.getWindowHandles();
		
		//Framework(Share class/ state) giong nhu get duoc token roi dung token de login vao cac chuc nang khac
	
		
		//Cho cho element duoc tim thay trong vong xxx(chinh la hh:mm:ss) thoi  gian->**
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//setScripTimeout
		//pageLoadTimeout -> khong dung nhieu
		
		//Back ve page truoc do
		//Forward toi page truoc do
		// Refresh page hiện tại
		// Mo 1 url ra
		driver.navigate().back();
		//History (navigate().to("https://www.facebook.com/"))
		
		
		// Trong TH browser chi co duy nhat 1 tab thi deu dong browser
		// Khong quan tam bao nhieu tab -> Dong het trinh duyet co n tab luon ->**
		driver.quit();
		
		// Dong tab dang  active( tab dang dung)
		driver.close();
		
		//Windowns/Tab ->**
		//Alert ->**
		//Frame/Iframe ->**
		driver.switchTo().alert();
		
		driver.switchTo().frame(1);
		
		driver.switchTo().window("");
		
		//Dung cho full man hinh
		driver.manage().window().fullscreen();
		
		// ->**
		driver.manage().window().maximize();
		
		//Test GUI
		//Lấy ra vi tri brower so voi do phan giai man hinh hien tai
		driver.manage().window().getPosition();
		//driver.manage().windown().setPosition();	
		
		//Lay ben trong chieu rong va chieu cao cua man hinh
		driver.manage().window().getSize();
		//driver.manage().window().setSize(targetSize);
		
		//Bien.... tuong tac voi element (textbox/ dropdown/ checkbox/...)
		driver.findElement(By.id("")).clear();
		
		
		
	}
}