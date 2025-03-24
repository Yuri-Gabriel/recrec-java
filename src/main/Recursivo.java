package main;

public class Recursivo {
	//1)
	public static int calMDCRec(int m, int n, int r) {
       if(r != 0) {
           r = m%n;
           m = n;
           n = r;
           return calMDCRec(m, n, r);
       }
       return m;
    }

	//2)
	public static int fatRec(int x) {
       return (x - 1) > 0 ? x * fatRec(x -1) : x;
   }

	//3)
	public static int binRec(int num_dec, String bin_str) {
	    bin_str = Integer.toString(num_dec % 2) + bin_str;
	    try {
	        return num_dec / 2 > 0 ? binRec(num_dec / 2, bin_str) : Integer.parseInt(bin_str);
	    } catch(NumberFormatException err) {
	        return -1;
	    }
	}

	//4)
	public static int sumRec(int num) {
	    return num > 1 ? (num % 10) + sumRec(num / 10) : num;
	}

	//5)
	public static void printDigitsCresc(int limit) {
		printDigitsCresc(limit, 0);
	}
	private static void printDigitsCresc(int limit, int number) {
		if(number <= limit) {
			System.out.println(number);
			printDigitsCresc(limit, number + 1);
		}
	}

	//6)
	public static void printDigitsRegr(int limit) {
		if(limit >= 0) {
			System.out.println(limit);
			printDigitsRegr(limit - 1);
		}
	}

	//7)
	public static boolean isPalindrome(String str) {
		str = str.replace(" ", "").toLowerCase();
		return isPalindrome(str.toCharArray(), str.toCharArray().clone(), 0);
	}
	
	private static boolean isPalindrome(char[] str, char[] copy, int i) {
		if(i == (str.length + 1) / 2) {
			return String.valueOf(copy).equals(String.valueOf(str));
		}
		if(i < (str.length + 1) / 2 || i == 0) {
			char l1 = str[i];
			char l2 = str[str.length - (i + 1)];
			copy[i] = l2;
			copy[str.length - (i + 1)] = l1;
			return isPalindrome(str, copy, i + 1);
		}
		return false;
	}
	
	//8)
	public static int sumNumbers(int limit) {
		return sumNumbers(limit, 0);
	}
	private static int sumNumbers(int limit, int cont) {
		return limit != 0 ? cont + sumNumbers(limit - 1, cont + 1) : cont;
	}
	
	//9)
	public static int pow(int x, int y) {
		return externalSum(x, y, x);
	}
	private static int externalSum(int x, int y, int res) {
		return y > 1 ? externalSum(x, y - 1, internalSum(res, x)) : res;
	}
	private static int internalSum(int x, int y) {
		return y > 1 ? x + internalSum(x, y - 1) : x;
	}
	
	//10)
	public static int getFibonacciNumber(int position) {
		return getFibonacciNumber(position, 1, 0, 1, 1);
	}
	private static int getFibonacciNumber(int position, int current_index, int prev, int current, int next) {
		if(current_index <= position) {
			prev = current;
			current = next;
			next = prev + current;
			
			current_index++;
			return getFibonacciNumber(position, current_index, prev, current, next);
		}
		return prev;
	}
	
	//11)
	public static String toReverse(String text) {
		
		return toReverse(text.toCharArray(), text.toCharArray().clone(), 0);
	}
	private static String toReverse(char[] str, char[] copy, int i) {
		if(i == (str.length + 1) / 2) {
			return String.valueOf(copy);
		}
		if(i < (str.length + 1) / 2 || i == 0) {
			char l1 = str[i];
			char l2 = str[str.length - (i + 1)];
			copy[i] = l2;
			copy[str.length - (i + 1)] = l1;
			return toReverse(str, copy, i + 1);
		}
		return "";
	}
	
	//12)
	public static int sumNumbersInArray(int[] numbers) {
		return sumNumbersInArray(numbers, 0, 0);
	}
	private static int sumNumbersInArray(int[] numbers, int sum, int index) {
		return index != numbers.length ? sumNumbersInArray(numbers, sum + numbers[index], index + 1) : sum;
	}
	
	//13)
	public static int contOneCharInString(char character, String str) {
		return contOneCharInString(character, str.toCharArray(), 0, 0);
	}
	private static int contOneCharInString(char character, char[] str, int cont, int index) {
		return index != str.length ? contOneCharInString(
				character, str,
				str[index] == character ? cont + 1 : cont
				, index + 1
		) : cont;
	}
	
	//14)
	public static int getBiggerIntArray(int[] numbers) {
		return getBiggerIntArray(numbers, numbers[0], 0);
	}
	private static int getBiggerIntArray(int[] numbers, int bigger, int index) {
		return index != numbers.length ? getBiggerIntArray(
				numbers,
				numbers[index] > bigger ? numbers[index] : bigger,
				index + 1
		) : bigger;
	}
	
	//15)
	public static int getMMC(int n1, int n2) {
		return getMMC(n1, n2, 1, 2, 2);
	}
	private static int getMMC(int n1, int n2, int mmc, int current_prime_number, int current_number) {
		if(n1 != 1 || n2 != 1) {
			if(n1 % current_prime_number == 0 || n2 % current_prime_number == 0) {
				mmc *= current_prime_number;
			}
			n1 = n1 % current_prime_number == 0 ? n1 / current_prime_number : n1;
			n2 = n2 % current_prime_number == 0 ? n2 / current_prime_number : n2;
			return getMMC(
					n1,
					n2,
					mmc,
					isPrimeNumber(current_number, 1, 0) ? current_number : current_prime_number,
					current_number + 1
				);
		}
		return mmc;
	}
	private static boolean isPrimeNumber(int number, int current_divisor, int cont) {
		return current_divisor <= number ? isPrimeNumber(
				number,
				current_divisor + 1,
				number % current_divisor == 0 ? cont + 1 : cont
			) : cont <= 2;
	}
}
