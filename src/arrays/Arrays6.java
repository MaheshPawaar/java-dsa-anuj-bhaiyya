package arrays;

/*
 * 1.Split array in three equal sum sub-arrays
 * 2.Find the largest sub-array with equal numbers 0s and 1s
 * 3.Majority Element Problem - Find the element that repeats more than n/2 times
 * 4.Left rotate array by 1 step
 * 5.Left rotate array by k step
 */
public class Arrays6 {

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5, 6, 7 };
//		largestSubarrayWithEqual0and1(a);
//		System.out.println(majorityElement(a));
		leftRotateByK(a, 3);
	}

	// Split array in three equal sum sub-arrays

	// Find the largest sub-array with equal numbers 0s and 1s
	public static void largestSubarrayWithEqual0and1(int[] a) {
		int n = a.length;
		int sum = 0, start = 0, end = 0;
		int maxSize = -1;

		for (int i = 0; i < n - 1; i++) {
			if (a[i] == 0) {
				sum = -1;
			} else {
				sum = 1;
			}

			for (int j = i + 1; j < n; j++) {
				if (a[j] == 0) {
					sum += -1;
				} else {
					sum += 1;
				}

				if (sum == 0 && maxSize < j - i + 1) {
					maxSize = j - i + 1;
					start = i;
				}
			}
		}
		end = start + maxSize - 1;
		if (maxSize == -1) {
			System.out.println("Not present");
		} else {
			System.out.println(start + " to " + end);
		}
	}

	// Majority Element Problem - Find the element that repeats more than n/2 times
	// Optimization is needed => This is O(n^2)
	public static int majorityElement(int[] a) {
		int n = a.length;

		for (int i = 0; i < n; i++) {
			int count = 0;
			for (int j = 0; j < n; j++) {
				if (a[i] == a[j]) {
					count++;
				}
			}
			if (count > n / 2)
				return a[i];
		}
		return -1;
	}

	// Left rotate array by 1 step
	public static void leftRotateByOne(int[] a) {
		int n = a.length;
		int temp = a[0];

		for (int i = 0; i < n - 1; i++) {
			a[i] = a[i + 1];
		}
		a[n - 1] = temp;
		printArray(a);
	}

	// Helper function to print array
	private static void printArray(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

	// Left rotate array by k step
	// Bruteforce: Use temp array to perform rotation
	public static void leftRotateByK(int[] a, int k) {
		int n = a.length;
		int op = 1;
		while (op <= k) {
			int temp = a[0];

			for (int i = 0; i < n - 1; i++) {
				a[i] = a[i + 1];
			}
			a[n - 1] = temp;
			op++;
		}
		printArray(a);
	}
}
