package fundamentos;

public class TipoString {
	public static void main(String[] args) {
		
		System.out.println("Olá pessoal".charAt(0));
		
		String s = "Boa tarde";
		System.out.println(s.concat("!!!"));
		System.out.println(s + "!!!");
		System.out.println(s.startsWith("Boa"));
		System.out.println(s.endsWith("TARDE"));
		System.out.println(s.length());
		System.out.println(s.equalsIgnoreCase("BOA TARDE"));
		
		var nome = "Pedro";
		var sobrenome = "Santos";
		var idade = 33;
		var salario = 12345.987F;
		
		System.out.println("Nome: " + nome + 
						"\nSobrenome: " + sobrenome + 
						"\nIdade: " + idade + 
						"\nSalario: " + salario);
		
		System.out.printf("\nO senhor %s %s tem %d e ganha %.2f.",
				nome, sobrenome, idade, salario);
		
		String frase = String.format("\nO senhor %s %s tem %d e ganha %.2f.",
				nome, sobrenome, idade, salario);
		System.out.println(frase);
	}
	
}
