package JavaTester;

public class Topic_03_System_Propertier {
	public static void main(String[] args) {
		String projectPath = System.getProperty("user.dir");
		System.out.print(projectPath);
}
}