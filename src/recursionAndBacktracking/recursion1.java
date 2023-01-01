package recursionAndBacktracking;

/*
 * 1. Print N natural numbers using recursion
 * 2. Sum of N natural numbers using recursion
 * 3. Find the power of a number using recursion
 * 4. Find the number of paths in n x m matrix
 */

public class recursion1 {

	public static void main(String[] args) {
//		printNaturalNumbers(10);
//		System.out.println(power(3, 4));
		System.out.println(numberOfPathsInMatrix(3, 2));
	}

	// Print N natural numbers using recursion
	public static void printNaturalNumbers(int n) {
		if (n == 0) {
			return;
		}
		printNaturalNumbers(n - 1);
		System.out.print(n + " ");
	}

	// Sum of N natural numbers using recursion
	public static int naturalNumSum(int n) {
		if (n == 0)
			return 0;

		return naturalNumSum(n - 1) + n;
	}

	// Find the power of a number using recursion
	public static int power(int a, int b) {
		if (b == 1)
			return a;

		return power(a, b - 1) * a;
	}

	// Find the number of paths in n x m matrix
	// Can also be solved using DP
	static int numberOfPathsInMatrix(int n, int m) {
		if (n == 1 || m == 1)
			return 1;

		int rightSideAns = numberOfPathsInMatrix(n, m - 1);
		int downSideAns = numberOfPathsInMatrix(n - 1, m);

		return rightSideAns + downSideAns;
	}
}
