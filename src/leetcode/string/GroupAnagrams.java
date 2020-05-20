package leetcode.string;

import java.util.*;

/**
 * 题目：49. Group Anagrams  输出所有字符一样的字符串
 * nput: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output: [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 *思路:先对字符排序 放入map中, key:排好序的字符串 value:所有满足要求的字符串 输出map的值即可
 * @author ：stone
 * @date ：Created in 2020/3/15 21:46
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        //转为字符并排序
        for (String s: strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars); //把键存入map
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<String>()); //放键值 值是集合形式
                //通过值相加
            }
            map.get(key).add(s);
        }
        return new ArrayList<List<String>>(map.values()); //集合存放集合
    }
}
