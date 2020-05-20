package leetcode.string;

/**
 * 题目：5. 最长回文子串 输出字符串
 * 输入: "babad"
 * 输出: "bab" "aba"
 * 思路：
 *
 * @author ：stone
 * @date ：Created in 2020/3/25 10:54
 */
public class LongestPalindromeString {
    public static String longestPalindrome(String s) {
        int i=0, j=s.length()-1;
        StringBuilder sb = new StringBuilder();

        while (i<j) {
            if (s.charAt(i) == s.charAt(j)) {
                for (int m=i; m<=j; m++) {
                    if (s.charAt(i) == s.charAt(i+1)) {

                    }
                }
            }
            i++;
            j--;
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String s = "abacs";
        System.out.println(longestPalindrome(s));
    }
}
