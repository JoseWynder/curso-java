package fundamentos.fundamentosfinal;

public class TiposDeDados {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
        // Tipos de dados primitivos em Java

        // Tipos numéricos inteiros
        byte byteVariable = 127;        // 1 byte, 1 centena.
        short shortVariable = 32_767;    // 2 bytes, 30 mil.
        int intVariable = 2_147_483_647;   // 4 bytes, 2 Bilhões (variável padrão).
        long longVariable = 9_223_372_036_854_775_807L;  // 8 bytes, 9 quintilhões.

        // Tipos numéricos de ponto flutuante
        float floatVariable = 3.4028235E38f;    // 4 bytes.
        double doubleVariable = 1.7976931348623157E308;   // 8 bytes, variável padrão. 

        // Tipo char para caracteres Unicode
        char charVariable = 'A';    // 2 bytes.

        // Tipo booleano para valores verdadeiro/falso
        boolean booleanVariable = true; // true ou false.

        // Exibindo os valores das variáveis
        System.out.println("Tipos de dados em Java: \n" +
	            "\nMenor Byte: " + Byte.MIN_VALUE +
	            "\nMaior Byte: " + Byte.MAX_VALUE +
	            "\nMenor Short: " + Short.MIN_VALUE +
	            "\nMaior Short: " + Short.MAX_VALUE +
	            "\nMenor Int: " + Integer.MIN_VALUE +
	            "\nMaior Int: " + Integer.MAX_VALUE +
	            "\nMenor Long: " + Long.MIN_VALUE +
	            "\nMaior Long:" + Long.MAX_VALUE +
	            "\nMenor Float: " + Float.MIN_VALUE +
	            "\nMaior Float: " + Float.MAX_VALUE +
	            "\nMenor Double: " + Double.MIN_VALUE +
	            "\nMaior Double: " + Double.MAX_VALUE +
        		"\nTabela Unicode: " + '\u0041');
    }
}
