package fundamentos;

import java.util.Scanner;

public class ExerciciosConceitosBasicos {
	public static void main(String[] args) {
		
		Scanner exercicio1 = new Scanner(System.in);
		
		System.out.println("\n1.");
		System.out.print("Qual a temperatura em Fahrenheit? ");
		double fah = exercicio1.nextDouble();
		double celsius =  (fah - 32) * 5/9 ;
		System.out.printf("A temperatura em Celsius é %.2f °C", celsius);
		
		System.out.println("\n2.");
		System.out.print("Qual a temperatura em Celsius? ");
		celsius = exercicio1.nextDouble();
		fah = celsius * 9 / 5 + 32 ;
		System.out.println("A temperatura em Fahrenheits é " + fah + "°F");
		
		System.out.println("\n3.");
		System.out.print("Qual o seu peso em Kg? ");
		double peso = exercicio1.nextDouble();
		System.out.print("Qual a sua altura em metros? ");
		double altura = exercicio1.nextDouble();
		double imc = peso / (altura * altura) ;
		System.out.printf("Seu IMC é %.2f%n", imc);
		
		System.out.println("\n4.");
		System.out.print("Digite um número: ");
		double num1 = exercicio1.nextDouble();
		double quadrado = num1 * num1 ;
		double cubo = quadrado * num1 ;
		System.out.printf("O quadrado de %.2f é %.3f%n", num1, quadrado);
		System.out.printf("O cubo de %.2f é %.3f%n", num1, cubo);
		
		System.out.println("\n5.");
		System.out.print("Informe o valor da base: ");
		double base_tri = exercicio1.nextDouble();
		System.out.print("Informe o valor da altura: ");
		double altura_tri = exercicio1.nextDouble();
		double area_tri = base_tri * altura_tri / 2 ;
		System.out.println("A área do triângulo é " + area_tri);
		
		System.out.println("\n6.");
		System.out.print("Informe o valor de A: ");
		double a = exercicio1.nextDouble();
		System.out.print("Informe o valor de B: ");
		double b = exercicio1.nextDouble();
		System.out.print("Informe o valor de C: ");
		double c = exercicio1.nextDouble();
		double delta = b * b - 4 * a * c ;
		System.out.println("O delta é " + delta);
		
		
		exercicio1.close();
		
	}
}
