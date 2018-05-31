package medium;

import java.util.*;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 *
 * 基本思路就是通过滑动窗口(左边界是向右滑动的), 并且在某个数据结构中跟踪每个字符最后出现的位置(可以用数组,也可以HashMap),
 * 每次窗口向右滑动拿到一个新的字符时, 判断这个字符是否以前出现过, 如果:
 * (1) 该字符以前没出现过
 * (2) 该字符以前出现过, 但上一次出现的位置已经不在滑动窗口内(也就是在左边界的左边)
 * 就可以Accept这个字符, 否则就认为遇到一个重复字符了, 遇到重复字符时需要:
 * 把滑动窗口的左边界Update成`重复字符`的最后出现位置+1
 *
 */
public class No_0003_Longest_Substring_Without_Repeating_Characters {

    public int lengthOfLongestSubstring(String s) {
        int ret = 0;
        int left = 0;   // the left boundary of slide window

        // Since all chars are in ASCII range
        // Can use a 128-length array to present the position of each char
        int[] charPositions = new int[128];
        Arrays.fill(charPositions, -1);

        for (int i = 0, length = s.length(); i < length; i++) {
            char c = s.charAt(i);
            // If never meet this char before, or the char had met before but is out of the left boundary,
            // we can accept it as NOT repeating
            if (charPositions[c] == -1 || charPositions[c] < left) {
                ret = (i - left + 1) > ret ? (i - left + 1) : ret;
            } else {    // Duplicated char within the left boundary found.
                left = charPositions[c] + 1;
            }
            charPositions[c] = i;   // Update the position of each char every time
        }

        return ret;
    }

    public static void main(String[] args) {
        No_0003_Longest_Substring_Without_Repeating_Characters obj = new No_0003_Longest_Substring_Without_Repeating_Characters();
        System.out.println(obj.lengthOfLongestSubstring("abcabcbb"));   // 3
        System.out.println(obj.lengthOfLongestSubstring("bbbbb"));  // 1
        System.out.println(obj.lengthOfLongestSubstring("pwwkew")); // 3
        System.out.println(obj.lengthOfLongestSubstring("dvdf"));   // 3
        System.out.println(obj.lengthOfLongestSubstring("abba"));   // 2
        System.out.println(obj.lengthOfLongestSubstring(""));   // 0
    }
}
