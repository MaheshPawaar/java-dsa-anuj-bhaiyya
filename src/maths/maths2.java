package maths;

import java.util.Arrays;

/*
 * 1. Check number is prime or not
 * 2. Print all divisors of N
 * 3. Sieve of Eratosthenes
 * 4. Fast Power, calculate pow(a,b)
 * 5. Calculate the a^b mid n for large values of a and b.
 */
public class maths2 {
    public static void main(String[] args) {
//		System.out.println(isPrimeEfficient(53));
//		printDivisors(25);
//		printSortedDivisors(7);
//		sieveOfEratosthenes(20);
        System.out.println(fastPower(3, 0));
    }

    // Check number is prime or not
    public static boolean isPrime(int n) {
        // Bruteforce => O(n)
//		if(n==1) return false;
//		for (int i = 2; i < n; i++) {
//			if (n % i == 0)
//				return false;
//		}
//		return true;

        // Efficient => for loop from 2 to sq. root of N
        if (n == 1)
            return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public static boolean isPrimeEfficient(int n) {
        // 1 is non-prime
        if (n == 1)
            return false;

        // 2 and 3 are prime
        if (n == 2 || n == 3)
            return true;

        // If N is divisible by 2 or 3 then it's non-prime
        if (n % 2 == 0 || n % 3 == 0)
            return false;

        for (int i = 5; i * i <= n; i += 6) {
            // If i = 5 then next i will be at i=5+2=7
            if (n % i == 0 || n % (i + 2) == 0)
                return false;
        }
        return true;
    }

    // Print all divisors of N
    // Optimized
    public static void printDivisors(int n) {
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                System.out.println(i);
                if (n / i != i) {
                    System.out.println(n / i);
                }
            }
        }
    }

    // Print all divisors of N (In sorted order)
    public static void printSortedDivisors(int n) {
        int i = 1;
        for (; i * i <= n; i++) {
            if (n % i == 0) {
                System.out.println(i);
            }
        }
        i--;
        for (; i >= 1; i--) {
            if (n % i == 0) {
                if (n / i != i) {
                    System.out.println(n / i);
                }
            }
        }
    }

    // Sieve of Eratosthenes
    public static void sieveOfEratosthenes(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            if (isPrime[i])
                System.out.println(i);
        }
    }

    // Fast Power, calculate pow(a,b)
    public static int fastPower(int a, int b) {
        if (b == 0) return 1;
        int halfRes = fastPower(a, b / 2);
        int fullRes = halfRes * halfRes;
        if (b % 2 != -0) {
            fullRes = fullRes * a;
        }
        return fullRes;
    }

    // TODO Calculate the a^b mid n for large values of a and b.
}
