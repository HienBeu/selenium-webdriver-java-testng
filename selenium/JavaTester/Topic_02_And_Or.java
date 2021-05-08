package JavaTester;

public class Topic_02_And_Or {
	public static void main(String[] args) {
		boolean a = true;
		boolean b = false;
		boolean c = true;
		boolean d = false;
		
		//AND(1 trong 2 cái sai -> sai)
		// TRUE & TRUE = TRUE
		System.out.print(a & c);
		
		// TRUE & FALSE = FALSE
		System.out.print(a & b);
		
		// FALSE & TRUE = FALSE
		System.out.print(b & c);
		
		// FALSE & FALSE = FALSE
		System.out.print(b & d);
		
		//OR
		// TRUE & TRUE = TRUE
		System.out.print(a | c);
				
		// TRUE & FALSE = FALSE
		System.out.print(a | b);
				
		// FALSE & TRUE = FALSE
		System.out.print(b | c);
				
		// FALSE & FALSE = FALSE
		System.out.print(b | d);
}
}