package controle;

//import java.math.BigInteger;

public class Primo {
	public static void main(String[] args) {
		
		long primo = 9223372036854775783L;
		externo: for(;primo >= 1; primo -= 2) {
			if(primo % 3 == 0) {
				continue;
			}
			for(int c = 5; c < primo/c; c += 6) {
				if((primo % c == 0) || (primo % (c + 2) == 0)) {
					continue externo;
				}
			}
				System.out.println(primo);
		}
	}
}