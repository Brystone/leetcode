package leetcode.string;

import java.util.HashMap;

/*
3 M.Longest Substring Without Repeating Characters
字符串中最长的连续字符长度
使用左右两个指针，右指针先遍历整个字符串将字符存入哈希表中
当遇到相同字符的时候，左指针先移动到最后一次出现字符的右侧，然后存入哈希表中
用max变量保存最后结果，每次和两个指针间的数字比较。
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>(); //键是字符，值是字符在字符串中的索引 用空间换时间
        int max = 0;
        for (int i=0, j=0; i<s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i))+1); //让左指针移动到字符最后一个出现位置的右侧
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i-j+1);
        }
        return max;
    }
}
