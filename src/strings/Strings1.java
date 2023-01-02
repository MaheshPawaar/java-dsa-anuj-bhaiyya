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

//        String s = "I am the boss";
//        String ans = reverseWordsInString(s);
//        System.out.println(ans);

//        String str1 = "abc";
//        String str2 = "baacd";
//        System.out.println(isSubsequence(str1, str2));

//        String str = "applejuice";
//        int index = firstAppearanceOfRepeatedChar(str);
//        if (index == -1)
//        {
//            System.out.printf("Either all characters are "
//                    + "distinct or string is empty");
//        }else {
//            System.out.println("Char is: "+str.charAt(index));

        String str = "I am the boss";
        System.out.println("Length is: " + lengthOfLastWord(str));
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

    // Check if a String is a subsequence of another string
    static boolean isSubsequence(String str1, String str2) {
        //Approach
        // 1. Using Recursion
        // 2. Using Two Pointers (Iterative)
        int m = str1.length(), n = str2.length();
        int i = 0, j = 0;

        while (i < m && j < n) {
            if (str1.charAt(i) == str2.charAt(j)) {
                i++;
            }
            j++;
        }

        // If i reaches till m (str1.length()), then it is subsequence else not
        return i == m;
    }

    // Find the Leftmost character that repeats in a string
    static int firstAppearanceOfRepeatedChar(String str) {
        // Approach
        // 1. By tracking first occurrence
        // Initialize leftmost index array of every char as -1
        int[] firstIndex = new int[256];
        for (int i = 0; i < 256; i++) {
            firstIndex[i] = -1;
        }
        // Traverse from left and update result
        // if we see a repeating character whose
        // first index is smaller than current
        // result.
        int res = Integer.MAX_VALUE;
        char[] c = str.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (firstIndex[c[i]] == -1) {
                firstIndex[c[i]] = i;
            } else {
                res = Math.min(res, firstIndex[c[i]]);
            }
        }

        if (res == Integer.MAX_VALUE) {
            return -1;
        }
        return res;
        // 2. By reverse Traversal
    }

    // Find the length of the last word in a given String
    static int lengthOfLastWord(String str) {
        // Approach
        // 1. Iterating string from index 0
        int length = 0;
        String s = str.trim();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                length = 0;
            } else {
                length++;
            }
        }
        return length;
        // 2. Iterate the string from the last index
    }
}
