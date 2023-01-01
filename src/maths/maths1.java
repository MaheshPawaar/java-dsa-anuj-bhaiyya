package maths;

/*
 * 1.Palindrome Numbers
 * 2.GCD or HCF of two numbers
 * 3.LCM of two numbers
 * 4.Trailing zeros in a factorial
 * 5.Unique paths in a grid
 */
public class maths1 {

	public static void main(String[] args) {
//		System.out.println(isPalindrome(2002));
//		System.out.println(gcdOptimized(60, 24));
//		System.out.println(LCM(24,36));
//		System.out.println(trailingZeros(125));
//		System.out.println(uniquePaths(3,7));
	}

	// Palindrome Numbers
	static boolean isPalindrome(int num) {
		// Reverse the num and compare with original
		int temp = num;
		int revNum = 0;
		while (temp > 0) {
			int ld = temp % 10;
			temp /= 10;
			revNum = revNum * 10 + ld;
		}

		return revNum == num;
	}

	// GCD or HCF of two numbers
	public static int gcd(int a, int b) {
		// Bruteforce => O(min(a,b))
//		for (int i = Math.min(a, b); i > 1; i--) {
//			if (a % i == 0 && b % i == 0)
//				return i;
//		}
//		return -1;

		// Euclidean GCD => gcd(a,b) = gcd(a-b,b), where a > b
		// basecase
		if (a == b)
			return a;

		if (a > b)
			return gcd(a - b, b);

		return gcd(b - a, a);
	}

	// GCD Optimized
	public static int gcdOptimized(int a, int b) {
		// Euclidean GCD Optimized => gcd(a % b,b) where, a > b
//		System.out.println(a + " " + b);
		if (a < b)
			return gcdOptimized(b, a);
		if (a % b == 0)
			return b;

		return gcdOptimized(a % b, b);
	}

	// LCM of two numbers
	public static int LCM(int a, int b) {
		int hcf = gcdOptimized(a, b);
		return (a * b) / hcf;
	}

	// Trailing zeros in a factorial
	public static int trailingZeros(int n) {
		int result = 0;
		while (n > 0) {
			result += n / 5;
			n = n / 5;
		}
		return result;
	}

	// Unique paths in a grid
//	public static int uniquePaths(int m, int n) {
//		int res = 1;
//		for (int i = 1; i < n; i++) {
//			res = (res * (m + i)) / i;
//		}
//		return res;
//	}
}
