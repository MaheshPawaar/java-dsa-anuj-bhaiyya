package strings;

/**
 * 1. Check if two strings are anagram of each other
 * Check if a String is a subsequence of another string.
 * abbc is subsequence of paabcbbcd
 * abc is not subsequence of baacd
 * 2. Find the Leftmost character that repeats in a string.
 * p is the leftmost character that repeats in applejuice
 * 3. Find the length of the last word in a given String.
 * The length of the last word in “I am the boss” is 4(boss)
 */
public class Strings1 {
    public static void main(String[] args) {
        StringBuilder b = new StringBuilder("Dogs");
        b.replace(0, 3, "CAT");
        System.out.println(b);
    }
}
