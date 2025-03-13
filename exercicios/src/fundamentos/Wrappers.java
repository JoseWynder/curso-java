package fundamentos;

//import java.util.Scanner;

public class Wrappers {
	public static void main(String[] args) {
		
		Byte b = 10;
		Short s = 100;
		Integer i = 10000; // int
		Long l = 100000L;
		
		System.out.println(b.toString());
		System.out.println(s.byteValue());
		System.out.println(i * 3);
		System.out.println(l / 3);
		
		Float f = 123.10F;
		System.out.println(f);
		Double d = 1234.5678;
		System.out.println(d);
		
		Boolean bo = Boolean.parseBoolean("true");
		System.out.println(bo);
		System.out.println(bo.toString().toUpperCase());
		
		Character c = '#'; // char
		System.out.println(c + "...");
	}
}
