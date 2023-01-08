package sorting;

/** TODO
 * 1. Given a set of strings, find the longest common prefix using Divide and Conquer.
 * 2. Strassen’s Matrix Multiplication
 * 3. Find the Closest Pair of Points using Divide and Conquer algorithm.
 */
public class Sorting2 {
    public static void main(String[] args) {
        int[] a = {6, 3, 9, 1, 4, 2, 7};
//        quickSort(a, 0, a.length - 1);
        mergeSort(a, 0, a.length - 1);
        for (int e : a) {
            System.out.print(e + " ");
        }
    }

    // Quick Sort
    static void quickSort(int[] a, int l, int h) {
        if (l < h) {
            int pivot = partition(a, l, h); // Find the pivot using partitioning logic
            quickSort(a, l, pivot - 1); // Sort the elements from low till pivot-1 with this recursive call
            quickSort(a, pivot + 1, h); // Sort the elements from pivot+1 till high with this recursive call
        }
    }

    static int partition(int[] a, int l, int h) { // Partitioning Logic
        int i = l;
        int j = h;
        random(a, l, h);
        int pivot = a[l];

        while (i < j) {
            while (i < j && a[i] <= pivot) i++;
            while (a[j] > pivot) j--;
            if (i < j) {
                swap(a, i, j);
            }
        }
        swap(a, l, j);
        return j;
    }

    static void random(int[] a, int l, int h) {
        int randomIndex = l + (int) (Math.random() * (h - l + 1));
        swap(a, l, randomIndex);
    }

    static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    // Merge Sort T.C.-> O(N log N)
    static void mergeSort(int[] a, int l, int h) {
        if (l < h) {
            int mid = (l + h) / 2;
            mergeSort(a, l, mid);
            mergeSort(a, mid + 1, h);
            merge(a, l, mid, h); // Merge the sorted subarrays
        }
    }

    static void merge(int[] a, int l, int mid, int h) {
        int[] b = new int[a.length];
        int i = l; // i is for left subarray
        int j = mid + 1; // j is for right subarray
        int k = l; // k is for b[]

        while (i <= mid && j <= h) {
            if (a[i] < a[j]) {
                b[k] = a[i];
                i++;
            } else {
                b[k] = a[j];
                j++;
            }
            k++;
        }

        if (i > mid) { // If i exceeds mid means we have some elements remained in right subarray
            while (j <= h) {
                b[k++] = a[j++]; // Add to b[]
            }
        } else { // Otherwise, we have some elements remained in left subarray
            while (i <= mid) {
                b[k++] = a[i++]; // Add to b[]
            }
        }

        // Copy elements for b[] to a[]
        for (i = l; i <= h; i++) {
            a[i] = b[i];
        }
    }
}
