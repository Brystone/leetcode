package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目：22. Generate Parentheses 生成括号  3
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *
 *   "()(())",
 *   "()()()"
 * ]
 * 思路：
 *
 * @author ：stone
 * @date ：Created in 2020/3/15 18:00
 */
public class GenerateParenthesis {
    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        backtrack(list, "", 0, 0, n);
        return list;
    }

    public static void backtrack(List<String> list, String str, int open, int close, int max){
        if(str.length() == max*2){
            list.add(str);
            return;
        }
        if(open < max)
            backtrack(list, str+"(", open+1, close, max);
        if(close < open) //退出后从这执行 
            backtrack(list, str+")", open, close+1, max);
    }

    public static void main(String[] args) {
        //int[] arr = new int[]{2, 3, 6, 7};
        int i = 2;
        System.out.println(generateParenthesis(i));
    }
}
