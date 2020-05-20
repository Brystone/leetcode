package leetcode.string;

/**
 * 题目：409. 最长回文串
 * 思路：
 *
 * @author ：stone
 * @date ：Created in 2020/3/19 14:00
 */
public class LongestPalindrome {
    public int longestPalindrome(String s) {
        int res = 0; int odd = 0;
        int[] charArr = new int[26 + 26];
        //字符放到数组里面去，统计个数，区分大小写
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) >= 'a') {
                charArr[s.charAt(i) - 'a']++;
            } else {
                charArr[s.charAt(i) - 'A' + 26]++;
            }
        }

        for (int i: charArr) {
            res += i;
            if (i % 2 == 1) {
                odd += 1;
            }
        }
        return  odd > 0 ? res - odd + 1 : res; //如果没有奇数就不用再减去-1
    }
}
