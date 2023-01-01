package arrays;

/*
 * 1. Given an array arr[], find the maximum j – i such that arr[j] > arr[i]
 * 2. Find two numbers in a sorted array with the given sum
 * 3. Find three numbers in an unsorted array with the given sum
 */
public class Arrays7 {

	public static void main(String[] args) {
		int[] a = { 1, 2, 7, 8, 10, 12 };
//		System.out.println(maxDifference(a));
		System.out.println(twoSum(a, 10));
	}

	// Given an array arr[], find the maximum j – i such that arr[j] > arr[i]
	public static int maxDifference(int[] a) {
		// Using Extra space
		int n = a.length;
		int[] rightMax = new int[n];
		int[] leftMin = new int[n];

		rightMax[n - 1] = a[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			rightMax[i] = Math.max(rightMax[i + 1], a[i]);
		}

		leftMin[0] = a[0];
		for (int i = 1; i < n; i++) {
			leftMin[i] = Math.min(leftMin[i - 1], a[i]);
		}

		int i = 0, j = 0;
		int ans = 0;
		while (i < n && j < n) {
			if (leftMin[i] < rightMax[j]) {
				ans = Math.max(ans, j - i);
				j++;
			} else {
				i++;
			}
		}
		return ans;
	}

	// Find two numbers in a sorted array with the given sum
	// O(n)
	public static boolean twoSum(int[] a, int target) {
		int l = 0;
		int r = a.length - 1;

		while (l < r) {
			int currSum = a[l] + a[r];
			if (currSum > target) {
				r--;
			} else if (currSum < target) {
				l++;
			} else {
				return true;
			}
		}
		return false;
	}
	
	// Find three numbers in an unsorted array with the given sum
	
}
