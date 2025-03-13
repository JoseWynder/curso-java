package fundamentos;

public class Temperatura {
	public static void main(String[] args) {
		
		System.out.println("Converte graus para fahrenheits!");
		float fahrenheits = 100f;
		final float MULT_FORMULA = 5/9.0f;
		final byte SUB_FORMULA = 32;
		float celsius = (fahrenheits - SUB_FORMULA) * MULT_FORMULA;
		System.out.println("\n" + fahrenheits + "°F são " + celsius + "°C. ");
	}
}
