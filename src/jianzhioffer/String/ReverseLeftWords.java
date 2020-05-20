package jianzhioffer.String;

/**
 * 题目：面试题58 - II. 左旋转字符串
 * 思路：1.拼接，字符串取字串方法:s = s.substring(index1, index2)
 *      2.局部+整体翻转
 * @author ：stone
 * @date ：Created in 2020/4/9 11:28
 */
public class ReverseLeftWords {
    public String reverseLeftWords(String s, int n) {
        /**
         *  取字串，拼接 时空消耗最少
         */
        String str = "";
        str = s.substring(n,s.length()); //开始索引到结束
        str += s.substring(0,n); //
        return str;
    }
}
