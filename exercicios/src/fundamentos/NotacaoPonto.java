package fundamentos;

public class NotacaoPonto {
	public static void main(String[] args) {

			//double a = 2.3;
			String s = "Bom dia X";
			s = s.replace("X", "Senhora");
			System.out.println(s);
			s.concat("!!!");
			System.out.println(s.concat("!!!"));
			System.out.println("José".toUpperCase());
			String y = "Boa noite Y"
					.replace("Y", "José")
					.toLowerCase()
					.concat("!!");
			System.out.println(y);
			
	}
}
