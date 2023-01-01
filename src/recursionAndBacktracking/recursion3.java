package recursionAndBacktracking;

/*
 * 1. Sum of digits in a number using recursion
 * 2. Generate all subsets / subsequence of a string
 * 3. Tower of Hanoi problem
 */
public class recursion3 {

	public static void main(String[] args) {
//		System.out.println(sumOfDigits(2314));
//		String s = "abc";
//		generateSubsets(s);
		towerOfHanoi(3, 'A', 'C', 'B');

	}

	// Sum of digits in a number using recursion
	static int sumOfDigits(int n) {
		if (n == 0)
			return 0;

		int lastDigit = n % 10;

		return lastDigit + sumOfDigits(n / 10);
	}

	// Generate all subsets / subsequence of a string
	// Subsequence - A string formed using the original string by removing zero or
	// more characters
	static void generateSubsets(String s) {
		utilGenerateSubsets(s, 0, "");
	}

	static void utilGenerateSubsets(String s, int i, String cur) {
		if (i == s.length()) {
			System.out.println(cur);
			return;
		}

		utilGenerateSubsets(s, i + 1, cur);
		utilGenerateSubsets(s, i + 1, cur + s.charAt(i));
	}

	// Tower of Hanoi problem
	static void towerOfHanoi(int n, char from, char to, char aux) {
		if (n == 0)
			return;

		towerOfHanoi(n - 1, from, aux, to);
		System.out.println("Move " + n + " from " + from + " to " + to);
		towerOfHanoi(n - 1, aux, to, from);
	}
}
