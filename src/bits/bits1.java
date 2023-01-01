package bits;

/**
 * 1. Find the ith Bit
 * 2. Toggle the ith bit
 * 3. Check if number is power of two
 * 4. Count the number of set bits in a number
 */
public class bits1 {
    public static void main(String[] args) {
//        System.out.println(findIthBit(5, 1));
//        System.out.println(toggleIthBit(75, 4));
//        System.out.println(isPowerOfTwo(15));
//        System.out.println(countSetBits(15));
        System.out.println(countSetBitOptimised(10));
    }

    // Find the ith Bit
    // Approach -> 1. Left shift 1 by i times 2. n & mask, print the result
    public static int findIthBit(int n, int i) {
        int mask = 1 << (i - 1);
        int res = n & mask;

        if (res == 0) return 0;
        else return 1;
    }

    // Toggle the ith bit
    public static int toggleIthBit(int n, int i) {
        int mask = 1 << (i - 1);
        return (n ^ mask);
    }

    // Check if number is power of two
    public static boolean isPowerOfTwo(int n) {
        int res = n & (n - 1);
        if (res == 0) {
            return true;
        }
        return false;
    }

    // Count the number of set bits in a number
    public static int countSetBits(int n) {
        int count = 0;

        while (n > 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }

    public static int countSetBitOptimised(int n) {
        int count = 0;

        while (n > 0) {
            count++;
            n = (n & (n - 1));
        }
        return count;
    }
}
