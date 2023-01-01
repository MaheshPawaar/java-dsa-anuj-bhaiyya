package recursionAndBacktracking;

/*
 * 1. Factorial of a number using recursion
 * 2. Find sum of square of N natural numbers using recursion
 * 3. Check if array is a palindrome using recursion
 */
public class recursion2 {

	public static void main(String[] args) {
//		System.out.println(fact(4));
//		System.out.println(sumOfSquares(4));
//		int[] a = { 1, 2, 3, 4, 5 };
//		if (palindromeArray(a, 0, a.length - 1) == 1) {
//			System.out.println("Palindrome");
//		} else {
//			System.out.println("Not Palindrome");
//		}
	}

	// Factorial of a number using recursion
	static int fact(int n) {
		if (n == 1)
			return 1;

		return fact(n - 1) * n;
	}

	// Find sum of square of N natural numbers using recursion
	static int sumOfSquares(int n) {
		if (n == 1)
			return 1;

		return sumOfSquares(n - 1) + (n * n);

		// Alternate solution
//		return (n * (n + 1)/2) * (2 * n + 1) / 3;
	}

	// Check if array is a palindrome using recursion
	static int palindromeArray(int a[], int start, int end) {
		if (start >= end)
			return 1;

		if (a[start] == a[end]) {
			return palindromeArray(a, start + 1, end - 1);
		} else {
			return 0;
		}
	}
}
