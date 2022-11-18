package com.ant.question03;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 *
 *
 * 示例1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
 *    请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。
 *
 * </p>
 *
 * @author Ant
 * @since 2022/4/28 12:28 上午
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
//        final int max = solution.lengthOfLongestSubstring("dvdf");
//        final int max = solution.lengthOfLongestSubstring("bbbbb");
        final int max = solution.lengthOfLongestSubstring("abcdd");
//        final int max = solution.lengthOfLongestSubstring("au");
//        final int max = solution.lengthOfLongestSubstring(" ");
//        final int max = solution.lengthOfLongestSubstring("");
        System.out.println(max);
    }

    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        Map<Character, Integer> distinctMap = new HashMap<>();
        int max = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (distinctMap.containsKey(s.charAt(i))) {
                // 取两者最大，是为了保证窗口只能往后滑动，避免窗口往前滑动
                left = Math.max(left, distinctMap.get(s.charAt(i)) + 1);
            }
            distinctMap.put(s.charAt(i), i);
            // i-left + 1（下标从0开始）
            max = Math.max(max, i-left + 1);
        }
        return max;
    }

}
