package fundamentos;

import java.util.Scanner;

public class DesafioConversao {
	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.print("Informe o primeiro salário: ");
		String salario1 = entrada.next();
		System.out.print("Informe o segundo salário: ");
		String salario2 = entrada.next();
		System.out.print("Informe o terceiro salário: ");
		String salario3 = entrada.next();
		
		entrada.close();
		
		Float soma = Float.parseFloat(salario1.replace(",", ".")) + 
				Float.parseFloat(salario2.replace(",", ".")) + 
				Float.parseFloat(salario3.replace(",", "."));
		
		System.out.println(salario1);
		
		float media = soma / 3;
		
		System.out.println("A média salárial do funcionário foi " + media);
	}
}
