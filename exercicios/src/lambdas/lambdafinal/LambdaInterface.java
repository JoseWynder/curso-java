package lambdas.lambdafinal;

@FunctionalInterface // Annotation para definir que a inteface vai ser usada no contexto lambda.
	// Ela força que essa interface tenha apenas um único método abstract.
public interface LambdaInterface {

	double executar(double a, double b); // public abstract.
	
	default double executor(double a, double b) { // default
		return executar(a, b);
	}
	
	static String muitoLegal() { // static
		return "muito legal";
	}
	
	
}
