package sorting;

import java.util.Arrays;

/**
 * 1. Insertion in two sorted arrays
 * 2. Sort an array with three types of elements (Dutch National Flag problem)
 * 3. Union of two sorted arrays
 * 4. Find the minimum difference between two elements in an array
 * 5. Sort an array of two types of elements
 */
public class Sorting1 {
    public static void main(String[] args) {
//        int[] a = {9, 5, 2, 6, 3, 1};
//        bubbleSort(a);
//        insertionSort(a);
//        selectionSort(a);


//        int[] a = {2, 2, 5, 6, 6, 8, 8};
//        int[] b = {1, 1, 2, 3, 6, 6, 9};
//        intersectionInSortedArrays(a, b);

//        int a[] = {2, 2, 1, 0, 0, 1, 2, 0, 1};
//        sortThreeTypesOfElements(a);

//        int a1[] = {1, 3, 4, 5, 7};
//        int a2[] = {2, 3, 5, 6};
//        unionOfSortedArrays(a1, a2);

//        int[] a = {1, 19, -4, 31, 38, 25, 100};
//        System.out.println(minDifferenceInElements(a));

        int[] a = {1, 1, 1, 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 0};
        for (int i : a) {
            System.out.print(i + " ");
        }
    }

    // Bubble Sort -> O(n^2)
    // Little optimization can be done by using boolean variable
    // So when array is sorted fun will not iterate
    static void bubbleSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            boolean isSwapped = false;
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    isSwapped = true;
                    swap(a, j, j + 1);
                }
            }
            if (!isSwapped) break;
        }
    }

    //Swap fun for swapping two elements in an array
    static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    // Insertion Sort
    static void insertionSort(int[] a) {
        // Assuming first element is sorted, take next element and keep it comparing till it founds it appropriate position
        for (int i = 1; i < a.length; i++) {
            int temp = a[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (temp < a[j]) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            a[j + 1] = temp;
        }
    }

    // Selection Sort
    static void selectionSort(int[] a) {
        // Select the min. element from unsorted part and place it at the end of the sorted part
        for (int i = 0; i < a.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            swap(a, min, i);
        }
    }

    // Intersection in two sorted arrays
    // Handle Duplicates
    static void intersectionInSortedArrays(int[] a, int[] b) {
        int i = 0, j = 0;

        while (i < a.length && j < b.length) {
            if (i > 0 && a[i] == a[i - 1]) {
                i++;
                continue;
            }

            if (a[i] == b[j]) {
                System.out.print(a[i] + " ");
                i++;
                j++;
            } else if (a[i] > b[j]) {
                j++;
            } else if (a[i] < b[j]) {
                i++;
            }
        }
    }

    // Sort an array with three types of elements (Dutch National Flag problem)
    // Naive approach -> Bubble Sort
    // Optimization -> Using pointers approach
    static void sortThreeTypesOfElements(int[] a) {
        int low = 0, mid = 0;
        int high = a.length - 1;
        int temp = 0;

        while (mid <= high) {
            if (a[mid] == 0) {
                temp = a[low];
                a[low] = a[mid];
                a[mid] = temp;
                low++;
                mid++;
            } else if (a[mid] == 1) {
                mid++;
            } else if (a[mid] == 2) {
                temp = a[mid];
                a[mid] = a[high];
                a[high] = temp;
                high--;
            }
        }
    }

    // Union of two sorted arrays
    static void unionOfSortedArrays(int[] a, int[] b) {
        // This approach handles duplicates
        int m = a.length;
        int n = b.length;
        int i = 0, j = 0;

        while (i < m && j < n) {
            if (a[i] < b[j]) {
                System.out.print(a[i++] + " ");
            } else if (b[j] < a[i]) {
                System.out.print(b[j++] + " ");
            } else {
                System.out.print(b[j++] + " ");
                i++;
            }
        }

        // Print remaining elements from one of the large array
        while (i < m) {
            System.out.print(a[i] + " ");
            i++;
        }

        while (j < n) {
            System.out.print(b[j] + " ");
            j++;
        }
    }

    // Find the minimum difference between two elements in an array
    static int minDifferenceInElements(int[] a) {
        Arrays.sort(a);
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < a.length - 1; i++) {
            int diff = a[i + 1] - a[i];
            if (diff < ans) {
                ans = diff;
            }
        }
        return ans;
    }

    // Sort an array of two types of elements
    static void sortTwoTypes(int[] arr) {
        int type0 = 0;
        int type1 = arr.length - 1;

        while (type0 < type1) {
            if (arr[type0] == 1) {
                // swap type0 and type1
                arr[type0] = arr[type0] + arr[type1];
                arr[type1] = arr[type0] - arr[type1];
                arr[type0] = arr[type0] - arr[type1];
                type1--;
            } else {
                type0++;
            }
        }
    }
}