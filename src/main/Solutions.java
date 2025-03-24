package main;

public class Solutions {
	
	public static void getBigger(int[] values) {
		int bigger = 0;
		for(int n : values) {
			if(n > bigger) {
				bigger = n;
			}
		}
		System.out.println("O maior numero informado foi " + bigger);
	}
	
	public static void areEquals(int n1, int n2) {
		boolean equals = n1 == n2;
		System.out.println(equals ? "Sao enguais" : "Sao difenhentes");
		if(!equals) {
			getBigger(new int[]{n1, n2});
		}
	}
	
	public static void toMultipy(int[] values) {
		int result = 1;
		for(int n : values) {
			result *= n;
		}
		System.out.println("O resultado da multiplicação é " + result);
	}
	
	public static void calculate(double n1, char operation, double n2) {
		double result = 0;
		try {
			switch (operation) {
				case '+': {
					result = n1 + n2;
					break;
				}
				case '-': {
					result = n1 - n2;	
					break;
				}
				case '*': {
					result = n1 * n2;
					break;
				}
				case '/': {
					if(n2 <= 0) {
						throw new Exception("Divisão por 0 não pode, indetermination localized");
					}
					result = n1 / n2;
					break;
				}
				case '^': {
					if(n1 == 0 && n2 == 0) {
						throw new Exception("0 elevado a 0 é indeterminação po, se liga");
					}
					result = 1;
					for(int i = 0; i < n2; i++) {		
						result *= n1;
					}
					break;
				}
				default: {
					throw new IllegalArgumentException("Operador inválido: " + operation);
				}
			}
			System.out.println(String.format("O resultado de %.2f %c %.2f é igual a %.2f", n1, operation, n2, result));
		} catch (Exception err) {
			System.out.println(err.getLocalizedMessage());
		}
	}
	
	public static void averageStock(int numMax, int numMin, String productName) {
		try {
			if(productName.trim().equals("")) {
				throw new Exception("Escreva o nome do produto rapaz");
			}
			if(numMax < 0 || numMin < 0) {
				throw new Exception("O número maximo ou minimo do produto informado é inválido");
			}
			
			int average = (numMax + numMin) / 2;
			System.out.println(String.format("Existe em média %d unidades de %s no estoque", average, productName));
		} catch (Exception err) {
			System.out.println(err.getLocalizedMessage());
		}
	}
	
	public static void idealWeight(String name, double height, char gender) {
		try {
			double weight = 0;
			switch (gender) {
				case 'f': {
					weight = (62.1 * height) - 44.7;
					break;
				}
				case 'm': {
					weight = (72.7 * height) - 58;
					break;
				}
				default: {
					throw new IllegalArgumentException("Gênero inválido");
				}
			}
			System.out.println(String.format("O peso ideal para %s é %.2f kg", name, weight));
		} catch (Exception err) {
			System.out.println(err.getLocalizedMessage());
		}
	}
	
	public static void fromOneToOneHundred() {
		for(int i = 1; i <= 100; i++) {
			System.out.print(i + " ");
		}
	}
	
	public static void printEvenNumbers() {
		for(int i = 1; i <= 50; i++) {
			if(i % 2 == 0) {
				System.out.print(i + " ");
			}
		}
	}
	
	public static void printOddNumbers() {
		for(int i = 1; i <= 50; i++) {
			if(i % 2 != 0) {
				System.out.print(i + " ");
			}
		}
	}
	
	public static void printPrimeNumbers() {
		for(int i = 1; i <= 50; i++) {
			if(isPrimeNumber(i)) {
				System.out.print(i + " ");
			}
		}
	}
	private static boolean isPrimeNumber(int num) {
		int numberOdDividers = 0;
		for(int i = 1; i <= num; i++) {
			if(num % i == 0) {
				numberOdDividers++;
			}
		}
		return numberOdDividers == 2;
	}
	
	public static void arithmeticMean(String name, double[] values) {
		try {
			if(name.trim().equals("")) {
				throw new Exception("Informe o nome da pessoa vá");
			}
			for(double num : values) {
				if(num < 0) {
					throw new Exception("Nota menor que 0 existe é? Cada uma viu");
				}
			}
			
			double average = 0;
			for(double num : values) {
				average += num;
			}
			average /= values.length;
			
			System.out.println(String.format("A média de %s é %.2f", name, average));
		} catch (Exception err) {
			System.out.println(err.getLocalizedMessage());
		}
	}
}
