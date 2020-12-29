package com.stefanini;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class MoneyParts {

	public static final double[] DENOMINACIONES_MONEY = { 0.05, 0.1, 0.2, 0.5, 1, 2, 5, 10, 20, 50, 100, 200 };

	public ArrayList<ArrayList<Integer>> build(String moneyString) throws Exception {

		if (StringUtils.isBlank(moneyString)) {
			throw new Exception("La moneda ingresada es nula.");
		}

		try {
			Double.parseDouble(moneyString);
		} catch (Exception e) {
			throw new Exception("El valor ingresado no corresponde a una Moneda");
		}

		Integer money = Integer.parseInt(moneyString);
		
		ArrayList<ArrayList<Integer>> out = new ArrayList<ArrayList<Integer>>();
		
		ArrayList<Integer> moneyList = new ArrayList<Integer>();
		
		combinaciones(money, moneyList, 0, out);
		
		
		
//		= (int) Math.pow(2, DENOMINACIONES_MONEY.length) - 1;
//		System.out.println("->" + x);
		
		
		
//		Double x = money % 0.05;
//		if (x == 0d) {
//			System.out.println("-->ok");
//		} else {
//			System.out.println("--error");
//		}
//		Math.fl
//		
//		System.out.println("-->" + x);
		
		
		
		
		return out;
	}
	
	public void combinaciones(int n, ArrayList<Integer> moneyList, int suma, List<ArrayList<Integer>> out) {
		if (suma == n) {
			out.add(moneyList);
//			System.out.println(moneyList);
		} else {
//			int i = 0;
			
			for (int i=1; i<=n; i++) {
				
				suma += i;
				
				if (suma <= n) {
					moneyList.add(i);
					
					combinaciones(n, moneyList, suma, out);
					
					moneyList.remove(moneyList.indexOf(i));
				}
				
				suma -= i;
			}
		}
	}
	
	public static void main(String[] args) {
		String moneyString = "4";
		
		try {
			MoneyParts moneyParts = new MoneyParts();
			ArrayList<ArrayList<Integer>> moneyOptions = moneyParts.build(moneyString);
			
			if (null != moneyOptions && !moneyOptions.isEmpty()) {

				moneyOptions.forEach(moneyOption -> {
					System.out.println("Combinacion Posible:");
					
					System.out.println(" ->");
					moneyOption.forEach(money -> System.out.print(money + ", "));
				});
			}
		} catch (Exception e) {
			System.err.println("ERROR: " + e.getMessage());
		}
	}

}
