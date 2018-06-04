package medium;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/description/
 * <p>
 * 找一个字符串的子串, 这个子串是该字符串中的最长回文
 * <p>
 * E.g.
 * <p>
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 */
public class No_0005_LongestPalindromicSubstring {
    private int low;
    private int maxLen;

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        for (int i = 0; i < len - 1; i++) {
            extendPalindrome(s, i, i); // assume odd length, try to extend Palindrome as possible
            extendPalindrome(s, i, i + 1); // assume even length.
        }
        return s.substring(low, low + maxLen);
    }

    private void extendPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        if (maxLen < right - left - 1) {
            low = left + 1;
            maxLen = right - left - 1;
        }
    }

    public static void main(String[] args) {
        System.out.println(new No_0005_LongestPalindromicSubstring().longestPalindrome("babad"));
        System.out.println(new No_0005_LongestPalindromicSubstring().longestPalindrome("abb"));
    }
}
