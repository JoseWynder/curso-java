package br.com.cod3r.app.financeiro;

import java.lang.reflect.Field;
import java.util.ServiceLoader;

import br.com.cod3r.app.Calculadora;

public class Teste {

	public static void main(String[] args) {
		
		Calculadora calc = ServiceLoader
				.load(Calculadora.class)
				.findFirst()
				.get();
		System.out.println(calc.soma(2, 3, 4));
		
//		CalculadoraImpl calc = new CalculadoraImpl();
//		System.out.println(calc.soma(2, 3, 4));
		
//		System.out.println(calc.getLoggerClass());
		
		try {
			Field fieldId = calc.getClass().getDeclaredFields()[0];
			fieldId.setAccessible(true);
			fieldId.set(calc, "def");
			fieldId.setAccessible(false);
			System.out.println(calc.getId());
//			System.out.println(fieldId.get(calc));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
