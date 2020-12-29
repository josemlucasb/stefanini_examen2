package com.stefanini;

import java.util.ArrayList;
import java.util.List;

public class MoneyParts2 {

	public static void main(String[] args) {
		
		int n = 5;
		List<Integer> numeros = new ArrayList<Integer>();
		
		combinacionesSuma(n, numeros, 0);
	}
	
	public static void combinacionesSuma(int numero, List<Integer> numeros, int suma) {
		
		if (suma == numero) {
			System.out.println(numeros);
		} else {
			
			for (int i=1; i<=numero; i++) {
				
				suma += i;
				
				if (suma <= numero) {
					numeros.add(i);
					
					combinacionesSuma(numero, numeros, suma);
					
					numeros.remove(numeros.indexOf(i));
				}
				
				suma -= i;
			}
		}
		
	}
	
}
