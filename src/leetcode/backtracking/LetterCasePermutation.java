package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author stone
 * @version 1.0
 * @ClassName LetterCasePermutation
 * @Description  784 E 字母大小写全排列
 * @date 2020/5/15 20:28
 */
public class LetterCasePermutation {
    public static List<String> letterCasePermutation(String S) {
        List<String> list = new ArrayList<String>();
        backtrack(S.toCharArray(), list, 0);
        return list;
    }

    private static void backtrack(char[] c, List<String> list, int i) {
        if (i == c.length) {
            list.add(new String(c));
            return;
        }
        else if (Character.isLetter(c[i])) {
            c[i] = Character.toLowerCase(c[i]);
            backtrack(c, list, i + 1); //
            c[i] = Character.toUpperCase(c[i]); //  i=0
            backtrack(c, list, i + 1);
        } else backtrack(c, list, i + 1);
    }

    public static void main(String[] args) {
        String s = "a1b2";
        System.out.println(letterCasePermutation(s));
    }
}
