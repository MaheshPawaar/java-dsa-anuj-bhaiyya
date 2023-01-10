package binarySearch;

/**
 * 1. Index of the first occurrence of an element in a sorted array
 * 2. Index of the last occurrence of an element in a sorted array
 * 3. Count the total number of occurrences in a sorted array
 * 4. Search in a sorted rotated array
 * 5. Find the first position of 1 in a sorted array containing only 0s and 1s.
 * 6. Find the upper bound of an element in a sorted array (Upper bound of an element is the next greater element).
 * 7. Given a sorted array with no duplicates A and a target value B, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 */
public class BinarySearch1 {
    public static void main(String[] args) {
//        int[] a = {1, 3, 5, 9, 11, 17, 18};
//        System.out.println("Found at index: " + binarySearch(a, 5));

//        int[] a = {1, 2, 4, 4, 4, 5, 9, 9, 11, 11, 11, 14};
//        System.out.println("Left occurrence at: " + leftOccurrenceInArr(a, 4));
//        System.out.println("Right occurrence at: " + rightOccurrenceInArr(a, 4));
//        System.out.println(countOccurrences(a, 9));

//        int[] a = {4, 5, 7, 8, 9, 1, 2, 3};
//        System.out.println(searchInSortedRotatedArray(a, 2));

//        int[] a={ 0, 0, 0, 0, 0, 0, 1, 1, 1, 1 };
//        System.out.println(leftOccurrenceInArr(a,1));

//        int a[] = {5, 7, 8, 10};
//        System.out.println(upperBound(a, 8));

        int[] a = {1, 3, 5, 6};
        System.out.println("Position is: " + searchInsert(a, 7));

    }

    // Binary Search Algorithm (Iterative)
    // T.C.->O(log n) Memory -> O(1)
    static int binarySearch(int[] a, int key) {
        int left = 0;
        int right = a.length - 1;

        while (left <= right) { // Keep searching till left <= right. It ensures the search till we left with one element
            int mid = (left + right) / 2; // Find mid

            if (a[mid] == key) {
                return mid; // Found at mid
            }
            if (key > a[mid]) { // So element can be found on the right
                left = mid + 1;
            } else {
                right = mid - 1; // otherwise, element can be found on the left
            }
        }
        return -1; // Element not found
    }

    // Index of the first occurrence of an element in a sorted array
    // Find the first position of 1 in a sorted array containing only 0s and 1s.
    static int leftOccurrenceInArr(int[] a, int key) {
        int left = 0;
        int right = a.length - 1;
        int ans = -1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (a[mid] == key) {
                ans = mid; // If we got occurrence
                right = mid - 1; // Let's see we can get another occurrence on the left
            } else if (key > a[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    // Index of the last occurrence of an element in a sorted array
    static int rightOccurrenceInArr(int[] a, int key) {
        int left = 0;
        int right = a.length - 1;
        int ans = -1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (a[mid] == key) {
                ans = mid; // If we got occurrence
                left = mid + 1; // Let's see we can get another occurrence on the right
            } else if (key > a[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    // Count the total number of occurrences in a sorted array
    static int countOccurrences(int[] a, int key) {
        int leftOccur = leftOccurrenceInArr(a, key);
        int rightOccur = rightOccurrenceInArr(a, key);
        return (rightOccur - leftOccur) + 1;
    }

    // Search in a sorted rotated array
    static int searchInSortedRotatedArray(int[] a, int key) {
        // 1st Approach -> Find Pivot. Binary search from start till pivot. Binary search from pivot till end
        // 2nd Approach -> Implemented Below
        int l = 0, r = a.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (a[mid] == key) return mid;
            if (a[l] <= a[mid]) { // Left part sorted
                if (key >= a[l] && key < a[mid]) { // Left side present
                    r = mid - 1;
                } else { // Right side present
                    l = mid + 1;
                }
            } else { // Right part sorted
                if (key > a[mid] && key <= a[r]) { // Right side present
                    l = mid + 1;
                } else { // Left side present
                    r = mid - 1;
                }
            }
        }
        return -1;
    }

    // Find the upper bound of an element in a sorted array
    static int upperBound(int[] a, int key) {
        int l = 0, r = a.length - 1;
        while (l < r) {
            int m = (l + r) / 2;
            if (a[m] <= key) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        if (a[l] > key) {
            return l;
        }
        if (a[r] > key) {
            return r;
        }
        return -1;
    }

    // Given a sorted array with no duplicates A and a target value B, return the index if the target is found.
    // If not, return the index where it would be if it were inserted in order.

    static int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
