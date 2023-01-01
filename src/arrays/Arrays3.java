package arrays;

/*
 * 1. Leaders in an array 
 * 2. Maximum Sum Sub-array (Implementation of Kadane's Algorithm)
 * 3. Container with most water
 * 4. Trapping Rain Water Problem
 */
public class Arrays3 {

	public static void main(String[] args) {
		int[] a = { 3, 5, 1, 4, 2, 6 };
//		leaders(a);
//		System.out.println("Max Sum of Subarray: " + maxSumSubarray(a));
//		System.out.println("Max area of Water: " + containerWithMostWater(a));
		System.out.println(trappingRainwater(a));
	}

	// Leaders in an array
	public static void leaders(int[] a) {
//		Naive Approach
//		int n = a.length;
//
//		for (int i = 0; i < n; i++) {
//			int curr = a[i];
//			boolean isLeader = true;
//
//			for (int j = i + 1; j < n; j++) {
//				if (a[j] > curr) {
//					isLeader = false;
//				}
//			}
//
//			if (isLeader) {
//				System.out.print(a[i] + " ");
//			}
//		}

		// Optimized Solution => O(n)
		int largest = Integer.MIN_VALUE;
		int[] leaders = new int[a.length];
		int j = 0;

		for (int i = a.length - 1; i >= 0; i--) {
			if (a[i] > largest) {
				leaders[j++] = a[i];
				largest = a[i];
			}
		}

		for (j = j - 1; j >= 0; j--) {
			System.out.print(leaders[j] + " ");
		}
	}

	// Maximum Sum Subarray
	public static int maxSumSubarray(int[] a) {
		int currSum = 0;
		int maxSum = Integer.MIN_VALUE;

		for (int i = 0; i < a.length; i++) {
			currSum += a[i];

			if (currSum > maxSum) {
				maxSum = currSum;
			}

			if (currSum < 0) {
				currSum = 0;
			}
		}
		return maxSum;
	}

	// Container with most water
	public static int containerWithMostWater(int[] a) {
//		Good bruteforce solution but takes O(n^2) time 
//		int maxArea = Integer.MIN_VALUE;
//
//		for (int i = 0; i < a.length; i++) {
//			int start = a[i];
//			for (int j = i + 1; j < a.length; j++) {
//				int end = a[j];
//				int dist = j - i;
//
//				int area = Math.min(start, end) * dist;
//				maxArea = Math.max(maxArea, area);
//			}
//		}
//		return maxArea;

		// Optimization with O(n) time
		int maxArea = Integer.MIN_VALUE;
		int l = 0;
		int r = a.length - 1;

		while (l < r) {
			int height = Math.min(a[l], a[r]);
			int distance = r - l;

			int area = height * distance;
			maxArea = Math.max(maxArea, area);

			if (a[l] < a[r]) {
				l++;
			} else {
				r--;
			}
		}
		return maxArea;
	}

	// Trapping Rain Water Problem
	public static int trappingRainwater(int[] a) {
		// This approach takes extra space
//		int n = a.length;
//		int[] l = new int[n];
//		int[] r = new int[n];
//		int water = 0;
//
//		for (int i = 0; i < n; i++) {
//			if (i == 0) {
//				l[0] = a[0];
//				r[n - 1] = a[n - 1];
//			} else {
//				l[i] = Math.max(a[i], l[i - 1]);
//				r[n - i - 1] = Math.max(a[n - i - 1], r[n - i]);
//			}
//		}
//
//		for (int i = 0; i < n; i++) {
//			water += Math.min(l[i], r[i]) - a[i];
//		}
//
//		return water;

		// O(1) Approach - Using Two Pointers
		int n = a.length;
		int l = 0, r = n - 1;
		int leftMax = 0, rightMax = 0;
		int ans = 0;

		while (l < r) {
			if (a[l] <= a[r]) {
				if (a[l] > leftMax) {
					leftMax = a[l];
				} else {
					ans += leftMax - a[l];
				}
				l++;
			} else {
				if (a[r] > rightMax) {
					rightMax = a[r];
				} else {
					ans += rightMax - a[r];
				}
				r--;
			}
		}

		return ans;
	}
}
