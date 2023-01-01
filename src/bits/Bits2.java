package bits;

import java.util.Arrays;

/**
 * 1. Find only non-repeating element in an array where every other element repeats twice.
 * 2. Find two non-repeating element in an array where every other element repeats twice.
 * 3. Swap two bits in a given integer
 * 4. Reverse the bits of an 32-bit unsigned integer
 */
public class Bits2 {
    public static void main(String[] args) {
//        int[] a = {2, 1, 4, 1, 2, 3, 4, 7};
//        System.out.println(nonRepeatingElement(a));
//        System.out.println(Arrays.toString(twoNonRepeatingElement(a)));
//        System.out.println(swapTwoBits(10, 1, 2));
    }

    // Find only non-repeating element in an array where every other element repeats twice.
    public static int nonRepeatingElement(int[] a) {
        int res = 0;

        for (int i : a) {
            res = res ^ i;
        }
        return res;
    }

    // Find two non-repeating element in an array where every other element repeats twice.
    public static int[] twoNonRepeatingElement(int[] a) {
        int xor = 0;

        for (int i : a) {
            xor = xor ^ i;
        }

        int temp = xor;
        int mask = xor & (~(xor - 1));

        for (int i : a) {
            if ((mask & i) == 0) {
                temp = temp ^ i;
            }
        }

        int firstNumber = temp;
        int secondNumber = xor ^ firstNumber;

        int[] res = new int[2];
        res[0] = firstNumber;
        res[1] = secondNumber;

        return res;
    }

    // Swap two bits in a given integer
    public static int swapTwoBits(int n, int i, int j) {
        int ith = (n >> i) & 1;
        int jth = (n >> j) & 1;

        int xor = ith ^ jth;

        if (xor == 0) return n;
        int mask = (1 << i) | (1 << j);
        return n ^ mask;
    }

    // Reverse the bits of an 32-bit unsigned integer
    static long reverse32BitUInt(long n) {
        long res = 0;
        int i = 0;

        while (i <= 31) {
            if ((n & (1 << i)) != 0) {
                res += (1 << (31-i));
            }
            i++;
        }
        return res;
    }
}
