package medium;

import java.util.*;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 */
public class No_0003_Longest_Substring_Without_Repeating_Characters {

    public int lengthOfLongestSubstring(String s) {

        HashMap<Character, Integer> map = new HashMap<>(32);
        int headIdx = 0;
        int tailIdx = 0;
        int longestCount = 0;
        int length = s.length();

        for (; tailIdx < length; tailIdx++) {
            char c = s.charAt(tailIdx);
            if (map.containsKey(c) && map.get(c) >= headIdx) {
                int currentRoundCount = tailIdx - headIdx;
                if (currentRoundCount > longestCount) {
                    longestCount = currentRoundCount;
                }
                int newHeadIdx = map.get(c) + 1;
                headIdx = newHeadIdx;
            }
            map.put(c, tailIdx);
        }

        return (tailIdx - headIdx) > longestCount ? (tailIdx - headIdx) : longestCount;
    }

    public static void main(String[] args) {
        No_0003_Longest_Substring_Without_Repeating_Characters obj = new No_0003_Longest_Substring_Without_Repeating_Characters();
        System.out.println(obj.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(obj.lengthOfLongestSubstring("bbbbb"));
        System.out.println(obj.lengthOfLongestSubstring("pwwkew"));
        System.out.println(obj.lengthOfLongestSubstring("dvdf"));
        System.out.println(obj.lengthOfLongestSubstring("abba"));
        System.out.println(obj.lengthOfLongestSubstring(""));
    }
}
