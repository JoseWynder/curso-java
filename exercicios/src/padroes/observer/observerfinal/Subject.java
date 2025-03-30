package padroes.observer.observerfinal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Subject {
	
	public static List<InterfaceEvento> observers = new ArrayList<>();
	
	void adicionarObserver(InterfaceEvento observer) {
		observers.add(observer);
	}
	
	public void monitorar() {
		
		String input;
		
		Scanner entrada = new Scanner(System.in);

		do {
			System.out.print("Evento ocorreu?");
			input = entrada.nextLine();
			
			
			if("sim".equalsIgnoreCase(input)) { 
				Evento evento = new Evento(new Date());
				
				observers.forEach(obs -> obs.ocorreu(evento));
				input = "sair";
			} else if("nao".equalsIgnoreCase(input)) {
				System.out.println("Alarme falso...");
			}
			
			
		} while(!"sair".equalsIgnoreCase(input));
		
		entrada.close();
	}
}
