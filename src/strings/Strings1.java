package strings;

/**
 * 1. Check if two strings are anagram of each other
 * 2. Reverse the words in a given string
 * 3. Check if a String is a subsequence of another string.
 * - abbc is subsequence of paabcbbcd
 * - abc is not subsequence of baacd
 * 4. Find the Leftmost character that repeats in a string.
 * - p is the leftmost character that repeats in applejuice
 * 5. Find the length of the last word in a given String.
 * - The length of the last word in “I am the boss” is 4(boss)
 */
public class Strings1 {
    public static void main(String[] args) {
//        String s1 = "abcda";
//        String s2 = "adacc";
//        System.out.println(isAnagram(s1, s2));

        String s = "I am the boss";
        String ans = reverseWordsInString(s);
        System.out.println(ans);
    }

    // Check if two strings are anagram of each other
    public static boolean isAnagram(String str1, String str2) {
        // Anagram - Two strings with same types of chars., repeating same no. of times
        // or permutations of a string are anagrams

        // Approach
        // Increment the occurrence of each char while iterating str1, store in array
        // Decrement the occurrence of each char while iterating str2
        // Finally, iterate over int array, if i != 0 return false else true
        int[] ans = new int[256];

        for (int i = 0; i < str1.length(); i++) {
            ans[str1.charAt(i)]++;
        }

        for (int i = 0; i < str2.length(); i++) {
            ans[str2.charAt(i)]--;
        }

        for (int i : ans) {
            if (i != 0)
                return false;
        }
        return true;
    }

    // Reverse the words in a given string
     static String reverseWordsInString(String s) {
        // Approaches
        // 1. Using split() method
        // 2. Using Stack
        // 3. Without any extra space

        // Without any extra space
        // 1. Reverse every word
        // 2. Lastly, Reverse whole string
        char[] c = s.toCharArray();

        int start = 0;
        int end = 0;
        for (; end < s.length(); end++) {
            if (c[end] == ' ') {
                reverseChars(c, start, end - 1);
                start = end + 1;
            }
        }
        reverseChars(c, start, end - 1);
        // Step 2
        reverseChars(c, 0, s.length() - 1);
        return new String(c);
    }

    static void reverseChars(char[] s, int i, int j) {
        // Both i and j are inclusive
        while (i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;

            i++;
            j--;
        }
    }
}
