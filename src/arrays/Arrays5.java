package arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * 1. Find if there is a sub-array with 0 sum
 * 2. Transpose of a matrix (Square Matrix is given)
 * 3. Rotate matrix 90 degrees clockwise (Square Matrix is given)
 * 4. Search element in a row-wise and column-wise sorted matrix
 */
public class Arrays5 {

	public static void main(String[] args) {
		int[][] a = { { 1,3} };
//		System.out.println(subarrayWithZeroSum(a));
//		printMatrix(a);
//		rotate90DegClockwise(a);
//		System.out.println();
//		printMatrix(a);
		System.out.println(SearchInMatrix(a, 3));

	}

	// Find if there is a sub-array with 0 sum
	public static boolean subarrayWithZeroSum(int[] a) {
		int n = a.length;
		// Using set instead of array
		Set<Integer> set = new HashSet<>();
		int sum = 0;

		for (int i = 0; i < n; i++) {
			sum += a[i];
			if (set.contains(sum)) {
				return true;
			}
			set.add(sum);
		}
		return false;
	}

	// Print Matrix
	public static void printMatrix(int[][] a) {
		int n = a.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}

	// Transpose of a matrix
	public static void transposeMatrix(int[][] a) {
		int n = a.length;
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				int temp = a[i][j];
				a[i][j] = a[j][i];
				a[j][i] = temp;

			}
		}
	}

	// Rotate matrix 90 degrees clockwise (Square Matrix is given)
	public static void rotate90DegClockwise(int[][] a) {
		transposeMatrix(a);
		int n = a.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n / 2; j++) {
				int temp = a[i][j];
				a[i][j] = a[i][n - j - 1];
				a[i][n - j - 1] = temp;

			}
		}
	}

	// Search element in a row-wise and column-wise sorted matrix
	public static boolean SearchInMatrix(int[][] a, int key) {
		int row = 0;
		int col = a[0].length - 1;

		while (row < a.length && col >= 0) {
			if (a[row][col] == key) {
				return true;
			} else if (key > a[row][col]) {
				row++;
			} else {
				col--;
			}
		}
		return false;
	}
}
