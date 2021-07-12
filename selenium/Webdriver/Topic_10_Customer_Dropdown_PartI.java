package Webdriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_10_Customer_Dropdown_PartI {
	WebDriver driver;
	
	//Wait(Chờ/tạm dừng  ở 1 thời gian nào đó cho nó qua step sau)
	WebDriverWait explicitWait;
	
	//Inject 1 javascript code(Dùng khi scroll)
	JavascriptExecutor jsExcutor;
	//Lưu ý: Interface & Abstract class là không khởi tạo ( không new lên được)
	
	

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		explicitWait = new WebDriverWait(driver,15);
		//Ép kiểu tường minh 
		jsExcutor = (JavascriptExecutor) driver;
		//Ép kiểu ngầm định: Từ kiểu dữ liệu cho range nhỏ hơn về range lớn hơn: double -> float -> long -> int -> short -> byte
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}

	@Test
	public void TC_01_JQuery() {
		driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");
		
		selectItemInCustomDropdown("//span[@id='number-button']/span[contains(@class,'ui-selectmenu-icon')]", "//ul[@id='number-menu']//div", "5");
		sleepInSecond(3);
		Assert.assertTrue(driver.findElement(By.xpath("//span[@id='number-button']//span[@class='ui-selectmenu-text' and text() ='5']")).isDisplayed());
		
		selectItemInCustomDropdown("//span[@id='number-button']/span[contains(@class,'ui-selectmenu-icon')]", "//ul[@id='number-menu']//div", "17");
		sleepInSecond(3);
		Assert.assertTrue(driver.findElement(By.xpath("//span[@id='number-button']//span[@class='ui-selectmenu-text' and text() ='17']")).isDisplayed());
		
		selectItemInCustomDropdown("//span[@id='number-button']/span[contains(@class,'ui-selectmenu-icon')]", "//ul[@id='number-menu']//div", "3");
		sleepInSecond(3);
		Assert.assertTrue(driver.findElement(By.xpath("//span[@id='number-button']//span[@class='ui-selectmenu-text' and text() ='3']")).isDisplayed());
				
	}
	@Test
	public void TC_02_ReactJS() {
		driver.get("https://react.semantic-ui.com/maximize/dropdown-example-selection/");
		
		selectItemInCustomDropdown("//i[@class='dropdown icon']", "//div[@role='option']/span", "Christian");
		sleepInSecond(3);
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='divider text' and text()='Christian']")).isDisplayed());
		
		selectItemInCustomDropdown("//i[@class='dropdown icon']", "//div[@role='option']/span", "Matt");
		sleepInSecond(3);
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='divider text' and text()='Matt']")).isDisplayed());
		
		selectItemInCustomDropdown("//i[@class='dropdown icon']", "//div[@role='option']/span", "Justen Kitsune");
		sleepInSecond(3);
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='divider text' and text()='Justen Kitsune']")).isDisplayed());
		
	}
	
	@Test
	public void TC_03_VueJS() {
		driver.get("https://mikerodham.github.io/vue-dropdowns/");
		
		selectItemInCustomDropdown("//li[@class='dropdown-toggle']", "//ul[@class = 'dropdown-menu']//a", "Second Option");
		sleepInSecond(3);
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class = 'dropdown-toggle' and contains(text(),'Second Option')]")).isDisplayed());
		
		
		selectItemInCustomDropdown("//li[@class='dropdown-toggle']", "//ul[@class = 'dropdown-menu']//a", "First Option");
		sleepInSecond(3);
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class = 'dropdown-toggle' and contains(text(),'First Option')]")).isDisplayed());
		
		
		selectItemInCustomDropdown("//li[@class='dropdown-toggle']", "//ul[@class = 'dropdown-menu']//a", "Third Option");
		sleepInSecond(3);
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class = 'dropdown-toggle' and contains(text(),'Third Option')]")).isDisplayed());
		
	}
	public void selectItemInCustomDropdown(String parentXpath, String ChildXpath, String expectedItem) {
	//Click vào 1 element cho sổ hết tất cả các item trong dropdown ra -> parent element
	driver.findElement(By.xpath(parentXpath)).click();
	sleepInSecond(1);
	
	//Chờ cho tất cả các item được load thành công -> Child element
	//Chờ xong -> lấy hết tất cả lưu vào 1 list element
	List<WebElement> allItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(ChildXpath)));;
	//19 item
	
	
	/*Cách 1: Duyệt qua từng item
	for (WebElement item : allItems) {

		//Get text của item đó ra và kiểm tra xem nó có bằng với item text mình mong muốn hay không?
		if(item.getText().equals(expectedItem))
			
		// Item cần chọn nó hiển thị -> click vào item đó luôn
			if(item.isDisplayed()) {
			item.click();
			
			}else {//Item cần chọn không hiển thị(ẩn bên dưới)
			//Scroll đến item đó -> click vào item
			jsExcutor.executeScript("arguments[0].scrollIntoView(true);", item);
			sleepInSecond(2);
			
			item.click();
		}
	}*/
	
	
	
	//Cách 2: Duyệt qua từng item
	for (WebElement item : allItems) {
		//Get text của item đó ra và kiểm tra xem nó có bằng với item text mình mong muốn hay không?
		if(item.getText().trim().equals(expectedItem)) {
			if(!item.isDisplayed()) {
				System.out.println("--------- Scroll to element ---------");
				jsExcutor.executeScript("arguments[0].scrollIntoView(true);", item);
				sleepInSecond(1);
				}
		        item.click();
		        break;
		        }
		}
	}
	
	//Tìm cái element cần chọn 

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