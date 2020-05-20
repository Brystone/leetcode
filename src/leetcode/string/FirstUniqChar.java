package leetcode.string;

/**
 * 题目：387. First Unique Character in a String 字符串中第一个不重复的字符的索引
 * s = "leetcode"  return 0.
 * 思路：将字符串中的字符转换为数组中的索引，并对索引赋值
 *      1.遍历字符串，s[i] - 'a', 得到asiic码，并且自增
 *      2.再遍历字符串，如果数组值为1，则当前数就是第一个不重复的数
 * @author ：stone
 * @date ：Created in 2020/2/1 10:57
 */
public class FirstUniqChar {
    public int firstUniqChar(String s) {
        int[] freq = new int[256];
        for (int i=0; i<s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        for (int i=0; i<s.length(); i++) {

            if (freq[s.charAt(i) - 'a'] == 1) { //同样的位置
                return i;
            }
        }
        return -1;
    }
}
