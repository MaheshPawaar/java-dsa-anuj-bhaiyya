package arrays;

/*
 * 1. Smallest Element in array
 * 2. Third Largest Element in array
 * 3. Check if array is sorted
 * 4. Reverse the given array
 * 5. Replace every element with the greatest element on its right side
 */
public class Arrays2 {

	public static void main(String[] args) {
		int[] a = { 17,18,5,4,6,1 };
//		System.out.println("Smallest is present at Index: " + smallestElement(a));
//		System.out.println("Third Largest Element is present at: " + thirdLargest(a));
//		System.out.println("Array is Sorted? :" + isSorted(a));
//		reverseArray(a);
//		for (int i = 0; i < a.length; i++) {
//			System.out.print(a[i] + " ");
//		}
		replaceWithGreatest(a);
	}

	// Smallest element in sorted array
	public static int smallestElement(int[] a) {
		int smallest = -1;
		for (int i = 0; i < a.length; i++) {
			if (smallest == -1 || a[i] < a[smallest]) {
				smallest = i;
			}
		}
		return smallest;
	}

	// Third largest element in an array
	public static int thirdLargest(int[] a) {
		if (a.length < 3)
			return -1;

		int largest = 0, second = -1, third = -1;

		for (int i = 1; i < a.length; i++) {
			if (a[i] > a[largest]) {
				third = second;
				second = largest;
				largest = i;
			} else if (second == -1 || a[i] > a[second]) {
				third = second;
				second = i;

			} else if (third == -1 || a[i] > a[third]) {
				third = i;

			}
		}

		return third;
	}

	// Check if array is sorted
	public static boolean isSorted(int[] a) {
		int n = a.length;
		for (int i = 1; i < n; i++) {
			if (a[i - 1] > a[i]) {
				return false;
			}
		}
		return true;
	}

	// Reverse the array
	public static void reverseArray(int[] a) {
		int start = 0, end = a.length - 1;

		while (start < end) {
			int temp = a[start];
			a[start] = a[end];
			a[end] = temp;

			start++;
			end--;
		}
	}

	// Replace every element with the greatest element on its right side
	public static void replaceWithGreatest(int[] a) {
		int n = a.length;
		int largest = a[n - 1];

		a[n - 1] = -1;

		for (int i = n - 2; i >= 0; i--) {
			int temp = a[i];
			a[i] = largest;

			if (temp > largest) {
				largest = temp;
			}
		}

		for (int i = 0; i < n; i++) {
			System.out.print(a[i] + " ");
		}
	}
}
