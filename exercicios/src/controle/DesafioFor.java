package controle;

public class DesafioFor {
	public static void main(String[] args) {
		
		for(String valor = "#"; !"######".equals(valor); valor += "#") {
			System.out.println(valor);
		}
	}
}
