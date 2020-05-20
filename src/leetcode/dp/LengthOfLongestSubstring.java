package leetcode.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目:3. 无重复字符的最长子串
 * 思路：滑动窗口
 *
 * @author ：stone
 * @date ：Created in 2020/3/18 21:45
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int res  = 0;
        //map存储字符和出现的位置
        Map<Character, Integer> map = new HashMap<>();
        //遍历字符串，发现某个字符重，
        for (int j=0, i=0; j<s.length(); j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(i, map.get(s.charAt(j))); //最近一次j在字符串出现的位置
            }
            ///j-i+1是因为此时i,j索引仍处于不重复的位置，j还没有向后移动，取的[i,j]长度
            res = Math.max(res, j-i+1);
            //value为j+1是为了当出现重复字符时，i直接跳到上个相同字符的下一个位置，if中取值就不用+1了
            map.put(s.charAt(j), j+1); //优化
        }
        return res;
    }


    public static void main(String[] args)  {
        String s = "abc";
        System.out.println(s.charAt(0)); //和数组一样取索引
    }
}
