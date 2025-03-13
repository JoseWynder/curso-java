package br.com.cod3r.exerciciossb.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculadora2")
public class CalculadoraController2 {

	@GetMapping
	public int calcular(@RequestParam(name = "op") String[] operacoes,
			@RequestParam(name = "vl") int[] valores) {
		int total = valores[0];
		for(int i = 0; i < valores.length-1; i++) {
			switch(operacoes[i]) {
			case " ":
				total += valores[i+1];
				break;
			case "-":
				total -= valores[i+1];
				break;
			case "*":
				total *= valores[i+1];
				break;
			case "/":
				if((total != 0) && (valores[i+1] != 0))
					total /= valores[i+1];
				break;
			}
		}
		return total;
	}

}
