package Webdriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_07_Web_Element_Method {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		//Mở ra 1 trình duyệt
		driver = new FirefoxDriver();
		//Wait cho element xuất hiện  trong 1 khoảng thời gian XXX
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//Mở 1 page url 
		driver.get("https://demo.nopcommerce.com/");
	}

	@Test
	public void TC_01_Web_Element() {
		//Muốn thao tác được với element thì phải tìm element trước
		
		//Tìm  1 element
		driver.findElement(By.id("")); //**
		
		//Tìm nhiều element
		driver.findElements(By.id(""));
		driver.findElement(By.id("")); //**
		
		//Nếu như mình chỉ thao tác vs element 1 lần thì không cần khai báo biến
		driver.findElement(By.id("small-searchterms")).sendKeys("Apple"); //**
		
		//Nếu cần thao tác với element nhiều lần thì nên khai báo biến 
		WebElement searchTextbox = driver.findElement(By.id("small-searchterms"));
		searchTextbox.clear();//**
		searchTextbox.sendKeys("Apple");
		searchTextbox.getAttribute("Value");//**
		
		//Đếm xem có bao nhiêu element thảo mãn điều kiện 
		//Verify số lượng element trả về như mong đợi
		// Thao tác với tất cả các loại element giống nhau trong 1 page (checkbox/textbox/...)
		List checkboxes = driver.findElements(By.xpath("//div[@class='input']/input[not(@type='checkbox')]"));
		
		//Verify có đúng 6 textbox tại form đăng ký
		Assert.assertEquals(checkboxes.size(), 6);
		
		WebElement singleElement =  driver.findElement(By.className(""));
		
		//Textbox/ Textarea/ Editable dropdown
		//Dữ liệu được toàn vẹn
		searchTextbox.clear();
		searchTextbox.sendKeys("");
		
		//Button/ Link/ Radio/ Checkbox/ Custom Dropdown/...
		searchTextbox.click();//**
		
		//Các hàm có tiền tố bắt đầu bằng get luôn luôn trả về dữ liệu 
		//getTitle/ getCurrentUrl/getPageSource/getAttribute/getCssValue/getText/...
		singleElement = driver.findElement(By.xpath("//input[@id='FirstName']"));
		singleElement.getAttribute("value");
		//Automation
		
		singleElement = driver.findElement(By.xpath("//input[@id='small-searchterms']"));
		singleElement.getAttribute("placeholder");
		//Search store
		
		//Lấy ra giá trị của các thuộc tính css - thường dùng để test giao diện GUI
		//Font/ Size/ Color/ Background
		singleElement = driver.findElement(By.cssSelector(".search-box-button"));
		singleElement.getAttribute("background-color");//*(có dùng nhưng dùng ít)
		//#4ab2f1
		
		//Lấy ra tọa độ của Element so với page hiện tại (get góc bên ngoài element)
		singleElement.getLocation();
		
		//Lấy ra kích thước của element (rộng *cao) -> get góc bên trong của element(ví dụ la chiều dài button)
		singleElement.getSize();
		
		//Location + size
		singleElement.getRect();
		
		//Chụp hình lỗi -> đưa vào HTML report
		singleElement.getScreenshotAs(OutputType.FILE);//*
		
		singleElement.getTagName();
		
		//Dùng Id/ Class/ Css/ name/...( không dùng cho xpath)
		//Từ 1 element không biết  tagname -> Lấy ra được cái tagname truyền vào cho 1 locator khác
		singleElement = driver.findElement(By.cssSelector(".search-box-button"));
		String searchButtonTagname = singleElement.getTagName();//*
		//button
		
		searchTextbox = driver.findElement(By.xpath("//" + searchButtonTagname + "[@class='input']/input[not(@type='checkbox')]"));
		
		//Lấy  ra text của element (Header/ Link/ Message..)
		singleElement.getText();//**
		
		//Các hàm có tiền tố là isXXX thì trả về kiểu boolean(đúng/sai)(100%)
		//true/false
		
		//Kiểm tra xem 1 element là hiển thị cho người dùng thao tác hay không
		//true: đang hiển thị
		//false: không hiển thị
		singleElement.isDisplayed();//**
		
		//Kiểm tra xem 1 element là disable hay không 
		//Disable: người dùng không thao tác được 
		//true: không thao tác đưcọ
		//false: có thể thao tác 
		singleElement.isEnabled();//*
		
		//Kiểm tra xem 1 element đã được  chọn rồi hay chưa
		//Checkbox/ Radio/ Dropdown(có thư viện riêng)
		//true: đã chọn rồi
		//false: chưa được chọn 
		singleElement.isSelected();//**
		
		// Nó thay cho hành vi ENTER vào texbox/ click vào button
		//Chỉ dùng được trong form  (Login/ Search/ Register/...)
		singleElement.submit();
		
		singleElement = driver.findElement(By.id("small-searchterms"));
		singleElement.sendKeys("Apple");
		singleElement.submit();
		
		
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}

