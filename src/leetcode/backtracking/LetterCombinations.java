package leetcode.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 题目：
 * 思路：
 *
 * @author ：stone
 * @date ：Created in 2020/4/6 10:47
 */
public class LetterCombinations {

    /**
     * dfs
     * @param digits
     * @return
     */
    static List<String> ans = new ArrayList<>();
    public static List<String> letterCombinations(String digits) {
        String[] d_map = new String[] {"", " ", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> ans = new ArrayList<>();
        char[] ch = new char[digits.length()];
        dfs(digits, d_map,0, ch, ans);
        return ans;
    }

    private static void dfs(String digits, String[] d_map, int l, char[] ch, List<String> ans) {
        if (l == digits.length()) {
            if (l > 0) ans.add(new String(ch));
            return;
        }

        String s = d_map[Character.getNumericValue(digits.charAt(l))];

        for (int i=0; i<s.length(); i++) {
            ch[l] = s.charAt(i);
            dfs(digits, d_map,l+1, ch, ans);
        }
    }

    /**
     * BFS
     * @param digits
     * @return
     */
    public List<String> letterCombinations2(String digits) {
        if(digits==null || digits.length()==0) {
            return new ArrayList<String>();
        }
        //一个映射表，第二个位置是"abc“,第三个位置是"def"。。。
        //这里也可以用map，用数组可以更节省点内存
        String[] letter_map = {
                " ","*","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"
        };
        List<String> res = new ArrayList<>();
        //先往队列中加入一个空字符
        res.add("");
        for(int i=0;i<digits.length();i++) {
            //由当前遍历到的字符，取字典表中查找对应的字符串
            String letters = letter_map[digits.charAt(i)-'0'];
            int size = res.size();
            //计算出队列长度后，将队列中的每个元素挨个拿出来
            for(int j=0;j<size;j++) {
                //每次都从队列中拿出第一个元素
                String tmp = res.remove(0);
                //然后跟"def"这样的字符串拼接，并再次放到队列中
                for(int k=0;k<letters.length();k++) {
                    res.add(tmp+letters.charAt(k));
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        String s = "23";
        List<String> list = letterCombinations(s);
        for (String str: list) {
            System.out.println(str);
        }
    }
}
