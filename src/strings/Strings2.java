package strings;

/**
 * 1. Pattern Matching Algorithm - Naive
 * 2. Check if string are rotations
 * 3. Find the longest substring with distinct characters
 */
public class Strings2 {
    public static void main(String[] args) {
//        String s = "abcabdabbacdab";
//        String p = "bda";
//        patternMatching(s, p);

        String s1 = "abcd";
        String s2 = "cdab";
        System.out.println(rotationalStrings(s1, s2));
    }

    // Pattern Matching Algorithm - Naive -> Time Complexity: O(n*m)
    // Rabin Karp Algorithm - Reduce Time Complexity of pattern matching algorithm to O(n+m) [Avg. Case]
    static void patternMatching(String s, String p) {
        int n = s.length();
        int m = p.length();

        for (int i = 0; i <= n - m; i++) {
            int j = 0;
            for (; j < m; j++) {
                // If chars don't match break the loop
                if (s.charAt(i + j) != p.charAt(j))
                    break;
            }
            // If j==m, means p is found in s
            if (j == m) {
                System.out.println("Pattern found at " + i);
            }
        }
    }

    // Check if string are rotations
    static boolean rotationalStrings(String s1, String s2) {
        // If length is not then it is false
        if (s1.length() != s2.length()) return false;
        String doubleStr = s1 + s1; // Add s1 to itself
        return doubleStr.contains(s2); // Check if doubleStr contains s2
    }
    // TODO Find the longest substring with distinct characters
}
