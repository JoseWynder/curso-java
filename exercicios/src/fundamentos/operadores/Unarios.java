package fundamentos.operadores;

public class Unarios {
	public static void main(String[] args) {
		
		int a = 2;
		int b = 1;
		
		a++; // a = a + 1
		a--; // a = a - 1
		
		++b; // b = b + 1
		--b; // b = b - 1
		
		System.out.println(a);
		System.out.println(b);
		
		System.out.println("\nMini Desafio...");
		System.out.println(--a == b++);
		System.out.println(a == b);
		System.out.println(a);
		System.out.println(b);
	}
}
