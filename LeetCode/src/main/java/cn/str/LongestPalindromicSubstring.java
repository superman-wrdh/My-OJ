package cn.str;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * <p>
 * Example 1:
 * <p>
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 * <p>
 * Input: "cbbd"
 * Output: "bb"
 */
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubstring().longestPalindrome("babad"));
        System.out.println(new LongestPalindromicSubstring().longestPalindrome("cbbd"));
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int[] longest = {0, 1};
        for (int i = 0; i < s.length(); i++) {
            int[] odd = getLongest(s, i - 1, i + 1);
            int[] even = getLongest(s, i - 1, i);
            int len1 = odd[1] - odd[0], len2 = even[1] - even[0];
            int[] curr = len1 > len2 ? odd : even;
            longest = longest[1] - longest[0] > curr[1] - curr[0] ? longest : curr;
        }
        return s.substring(longest[0], longest[1]);
    }

    private int[] getLongest(String s, int left, int right) {
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) != s.charAt(right)) {
                break;
            }
            left--;
            right++;
        }
        return new int[]{left + 1, right};
    }
}
