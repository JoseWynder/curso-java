package fundamentos.operadores;

public class DesafioAritmedicos {
	public static void main(String[] args) {
		
		
		double dividendoA = 6 * (3 + 2);
		double potenciacaoA = Math.pow(dividendoA, 2);
		double quocienteA = potenciacaoA / (3 * 2);
		double result_A = quocienteA;
		//
		double dividendoB = (1 - 5) * (2 - 7);
		double quocienteB = dividendoB / 2;
		double result_B = Math.pow(quocienteB, 2);
		double dif_result = result_A - result_B;
		double result_final = Math.pow(dif_result, 3)/Math.pow(10, 3);
		
		System.out.println(result_final);
	}
}
