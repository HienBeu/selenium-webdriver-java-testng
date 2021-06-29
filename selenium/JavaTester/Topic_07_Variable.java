package JavaTester;
import java.util.Random;

public class Topic_07_Variable {
	String address;
	
	static String cityName = "Nguyen Van Troi";
	public static void main(String[] args) {
		Topic_07_Variable tp7_01 = new Topic_07_Variable();
		tp7_01.address = "Ho Chi Minh";
		System.out.println(tp7_01.address);
		
		Topic_07_Variable tp7_02 = new Topic_07_Variable();
		tp7_02.address = "Ha Noi";
		System.out.println(tp7_02.address);
	}

}
