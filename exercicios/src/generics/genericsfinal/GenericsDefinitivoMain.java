package generics.genericsfinal;

import java.util.Arrays;
import java.util.List;

public class GenericsDefinitivoMain {

	public static void main(String[] args) {
		
		
		// RESOLVENDO O TIPO A PARTIR DA INSTÂNCIA.
		
		
		// Exemplo 1
		
//		GenericsDefinitivo caixaA = new GenericsDefinitivo();
//		caixaA.guardar(2.3); // double -> Double
//			// Auto-boxing.
//		
//		Double coisaA = (Double) caixaA.abrir();
//		System.out.println(coisaA);
//		
//		GenericsDefinitivo caixaErroA = new GenericsDefinitivo();
//		caixaErroA.guardar(123);
////		String coisaErroA = (String) caixaErroA.abrir(); 
////			// Gera um erro do tipo "ClassCastException".
////		System.out.println(coisaErroA);
		
		/*
		 * Nessa situação em que você realiza um casting para adequar um atributo
		 *  específico a um Object, caso o casting não ocorra corretamente, ele geraria
		 *   um erro em tempo de execução, ou seja, esse erro só seria visto no momento em
		 *    que o usuário estiver utilizando a funcionalidade.
		 * Quando trabalhamos com Generics, caso o tipo atribuído seja inválido, geraria
		 *  um erro compilação. Sem a possibilidade de se propagar até o usuário.
		 */
		
		// Exemplo 2
		
//		 GenericsDefinitivo caixaA = new GenericsDefinitivo(); É possível criar sem especificar o tipo.
//		 Com generics os tipos só são definidos no momento em que você instância a classe.
		
		GenericsDefinitivo<String> caixaB = new GenericsDefinitivo<>();
		caixaB.guardar("Segredo!");
		
		String coisaB = caixaB.abrir();
		System.out.println(coisaB);
		
//		GenericsDefinitivo<Double> caixaErroB = new GenericsDefinitivo<>();
//		caixaErroB.guardar("");
//			// Gera um erro de compilação
//		Double coisaErroB = caixaErroB.abrir();
//		System.out.println(coisaErroB);
		
		
		// RESOLVENDO O TIPO A PARTIR DA HERANÇA.
		
		
		System.out.println();
		GenericsDefinitivoAux1 caixaC = new GenericsDefinitivoAux1();
		caixaC.guardar(123);
		
		Integer coisaC = caixaC.abrir();
		System.out.println(coisaC);
		
		
		// RESOLVENDO O TIPO A PARTIR DA HERANÇA 2.
		
		
		System.out.println();
		GenericsDefinitivoAux2<Double> caixaD = new GenericsDefinitivoAux2<>();
		caixaD.guardar(2.3);
		System.out.println(caixaD.abrir());
		
		
		// GENERICS EM MÉTODOS
		
		
		System.out.println();
		List<String> langs = Arrays.asList("JS", "PHP", "Java", "C++");
		List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6);
		
		String ultimaLinguagem1 = (String) GenericsDefinitivoAux3.getUltimo1(langs);
		System.out.println(ultimaLinguagem1);
		// Ambos sem utilizar generics.
		Integer ultimoNumero1 = (Integer) GenericsDefinitivoAux3.getUltimo1(nums);
		System.out.println(ultimoNumero1);
		
		String ultimaLinguagem2 = GenericsDefinitivoAux3.getUltimo2(langs);
		System.out.println(ultimaLinguagem2);
			// Nesse caso, o java sabe que o tipo retornado tem que ser do tipo String.
		
		Integer ultimoNumero2 = GenericsDefinitivoAux3.<Integer>getUltimo2(nums);
		System.out.println(ultimoNumero2);
		// Definindo explicitamente que nesse caso o método recebe e retorna Integer.
	}
}
