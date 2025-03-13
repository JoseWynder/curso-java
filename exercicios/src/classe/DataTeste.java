package classe;

public class DataTeste {
	public static void main(String[] args) {
	
		Data data1 = new Data();
		
		Data data2 = new Data(1, 12, 2024);
		
		System.out.println(data1.obterDataFormatada());
		
		System.out.println(data2.obterDataFormatada());
		
		
	}
}
