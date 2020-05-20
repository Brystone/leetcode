package leetcode.string;

/**
 * 题目：344. Reverse String
 * Input: ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 * 思路：使用首尾两个指针，交换元素
 *T = O(n) S = O(1)
 * @author ：stone
 * @date ：Created in 2020/1/30 20:51
 */
public class ReverseString {
    public void reverseString(char[] s) {
        int front = 0;
        int behind = s.length - 1;
        if (s == null || s.length == 0) {
            return;
        }
        //遍历字符数组
       while (front < behind) {
            char tmp = s[front];
            s[front] = s[behind];
            s[behind] = tmp;
            front++;
            behind--;
       }
    }
}
