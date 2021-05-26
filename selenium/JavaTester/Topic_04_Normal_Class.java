package JavaTester;

import org.openqa.selenium.WebDriver;

public class Topic_04_Normal_Class {
	//Thuoc tinh
	String fullName = "Nguyen Van Nam";
	String address, street;
	//Phuong thuc
	public void setFullName(String name) {
		fullName = name;
	}
	
	public void setAddress(String addressName, String streetName) {
		address = addressName;
		street = streetName;
	}
	public String getFullName() {
		return fullName;
	}
	
	public static void main(String[] args) {
		WebDriver driver = null;
		driver.get("https://www.facebook.com/");
		
		String homePageUrl = driver.getCurrentUrl();
		
		Topic_04_Normal_Class topic = new Topic_04_Normal_Class();
		topic.setFullName("Nguyen Van Toan");
		//instance = dai dien cho kieu du lieu (Class/Interface/...)
	}
}
