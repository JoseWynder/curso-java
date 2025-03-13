package lambdas;

@FunctionalInterface
public interface Calculo {

	double executar(double a, double b);
	
	default double executor(double a, double b) {
		return executar(a, b);
	}
	
	static String muitoLegal() {
		return "muito legal";
	}
	
}
