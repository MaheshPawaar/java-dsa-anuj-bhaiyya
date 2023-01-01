package arrays;

/*
 * Array Programs in this file:
 * 1. Search
 * 2. Delete
 * 3. Largest element in an array
 * 4. Second largest element in an array
 * 5. Remove Duplicates from an array
 */
public class Arrays1 {

    public static void main(String[] args) {
//		int[] a = { 2, 1, 4, 6, 5 };
//		int key = 4;
        int[] a = {2, 2, 3, 4, 4, 7, 7, 7, 9, 10};
        int n = removeDuplicates(a);
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
    }

    // Search element in an array => Time Complexity: O(n)
    public static void search(int[] a, int key) {
        int res = -1;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == key) {
                res = i;
                break;
            }
        }
        if (res == -1) {
            System.out.println("Not found");
        } else {
            System.out.println("Key is present at: " + res);
        }
    }

    // Delete element from an array => Time Complexity: O(n)
    public static void delete(int[] a, int key) {
        int i = 0;
        int n = a.length;

        for (; i < n; i++) {
            if (a[i] == key) {
                break;
            }
        }

        if (i == n)
            return;

        for (int j = i; j < n - 1; j++) {
            a[j] = a[j + 1];
        }
    }

    // Largest element in an array => Time Complexity: O(n)
    public static int maxElement(int[] a) {
        if (a.length == 0)
            return -1;

        int maxIndex = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > a[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    // Second largest element in an array => Time Complexity: O(n)
    public static int secondMaxElement(int[] a) {
        if (a.length < 2)
            return -1;

        int largest = 0, second = -1;
        for (int i = 1; i < a.length; i++) {
            if (a[i] > a[largest]) {
                second = largest;
                largest = i;
            } else if (a[i] < a[largest]) {
                if (second == -1 || a[i] > a[second]) {
                    second = i;
                }
            }
        }

        return second;
    }

    // Remove Duplicates from a sorted array
    public static int removeDuplicates(int[] a) {
        int j = 0;
        int n = a.length;
        for (int i = 0; i < n; i++) {
            if (a[i] != a[j]) {
                a[j + 1] = a[i];
                j++;
            }
        }
        j++;
        return j;
    }
}
