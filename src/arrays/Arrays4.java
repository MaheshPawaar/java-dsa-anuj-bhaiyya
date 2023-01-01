package arrays;

/*
 * 1. Print frequency of all sorted elements in a sorted array
 * 2. In the array of 0s & 1s, find the longest length of all consecutive 1s
 * 3. Move all 0s to the end of the array
 * 4. Minimum sum of sub-array
 * 5. Stock Buy and Sell problem - I
 */
public class Arrays4 {

	public static void main(String[] args) {
		int[] a = { 7, 1, 5, 3, 6, 4 };
		// printFrequency(a);
//		System.out.println(longestLenOfOnes(a));
//		zerosToEnd(a);
//		System.out.println(minSumSubarray(a));
//		System.out.println(maxProfit(a));

	}

	// Print frequency of all sorted elements in a sorted array
	private static void printFrequency(int[] a) {
		int freq = 1;

		for (int i = 1; i < a.length; i++) {
			if (a[i] == a[i - 1]) {
				freq++;
			} else {
				System.out.print(freq + " ");
				freq = 1;
			}
		}
		System.out.print(freq + " ");
	}

	// In the array of 0s & 1s, find the longest length of all consecutive 1s
	private static int longestLenOfOnes(int[] a) {
		int longestLen = 0;
		int freq = 0;

		for (int i = 0; i < a.length; i++) {
			if (a[i] == 0) {
				freq = 0;
			} else {
				freq++;
				longestLen = Math.max(longestLen, freq);
			}
		}

		return longestLen;
	}

	// Move all 0s to the end of the array
	// Alternative way is to partition array using zero as Pivot
	public static void zerosToEnd(int[] a) {
		int count = 0;
		int n = a.length;
		for (int i = 0; i < n; i++) {
			if (a[i] != 0) {
				a[count++] = a[i];
			}
		}

		while (count < n) {
			a[count++] = 0;
		}

		for (int i = 0; i < count; i++) {
			System.out.print(a[i] + " ");
		}
	}

	// Minimum sum of subarray
	public static int minSumSubarray(int[] a) {
		int currSum = Integer.MAX_VALUE;
		int minSum = Integer.MAX_VALUE;

		for (int i = 0; i < a.length; i++) {
			if (currSum > 0) {
				currSum = a[i];
			} else {
				currSum += a[i];
			}
			minSum = Math.min(minSum, currSum);
		}
		return minSum;
	}

	// Stock Buy and Sell problem - I
	// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
	public static int maxProfit(int[] a) {
		// Naive - O(n)
//		int n = a.length;
//		int[] diff = new int[n];
//		int maxProfit = 0;
//
//		for (int i = 0; i < n; i++) {
//			if (i == 0) {
//				diff[n - 1] = a[n - 1];
//			} else {
//				diff[n - i - 1] = Math.max(a[n - i - 1], diff[n - i]);
//			}
//		}
//
//		for (int i = 0; i < n; i++) {
//			maxProfit = Math.max(maxProfit, diff[i] - a[i]);
//		}
//		return maxProfit;

		int buyPrice = Integer.MAX_VALUE, profit = 0;

		for (int i = 0; i < a.length; i++) {
			buyPrice = Math.min(buyPrice, a[i]);
			profit = Math.max(profit, a[i] - buyPrice);
		}
		return profit;
	}
}
