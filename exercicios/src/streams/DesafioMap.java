package streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class DesafioMap {

	public static void main(String[] args) {
		
		List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		
		Function<String, Integer> binarioParaDecimal =  str -> Integer.parseInt(str, 2);
		UnaryOperator<String> inverterString = str -> new StringBuilder(str).reverse().toString();
		
		nums.stream()
			.map(Integer::toBinaryString)
			.map(inverterString)
			.map(binarioParaDecimal)
			.forEach(System.out::println);
		
	}
}
