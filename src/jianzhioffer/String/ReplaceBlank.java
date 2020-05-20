package jianzhioffer.String;

import java.util.ArrayList;

/*
替换空格
思路：用一个sb逐个添加字符
 */
public class ReplaceBlank {
    //遍历字符串，计算出原来长度和替换空格后的长度 类的对象

    public static String replaceBlank2(String s) {
        if (s == null) {
            return null;
        }
        StringBuilder res = new StringBuilder();
        //遍历字符数组
        for (char c : s.toCharArray()) {
            if (c == ' ') res.append("%20");
            else res.append(c);
        }
        return res.toString();
    }
}

