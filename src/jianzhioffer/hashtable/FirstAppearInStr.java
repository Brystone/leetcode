package jianzhioffer.hashtable;

public class FirstAppearInStr {
    private int firstAppearInStr(String str) {
        if (str == null || str.length() == 0) {  //字符串全是空格，有长度但是没有值
            return -1;
        }
        int[] arr = new int[256];

        //统计每个字符出现的次数
        for (int i=0; i<str.length(); i++) {
            arr[str.charAt(i)]++; //默认值是0， 每个索引的值增加
        }
        //找到索引
        for (int i=0; i<str.length(); i++) {
            if (arr[str.charAt(i)] == 1) {
                return i;
            }
        }
        return -1;
    }
}
