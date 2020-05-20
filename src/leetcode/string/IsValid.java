package leetcode.string;

import java.util.Stack;

/**
 * 题目：20. 有效的括号
 * 思路：用栈
 *
 * @author ：stone
 * @date ：Created in 2020/3/28 18:04
 */
public class IsValid {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') stack.push(')');
            else if (c == '[') stack.push(']');
            else if (c == '{') stack.push('}');
            else if (c != stack.pop() || stack.isEmpty()) return false;
        }
        return stack.isEmpty();
    }
}
