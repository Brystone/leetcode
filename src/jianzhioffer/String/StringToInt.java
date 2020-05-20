package jianzhioffer.String;
/*
将字符串转为整数
str.charAt[i]取出第i个字符的ASCII码 字符 ‘0’-‘9’的ASCII码是连续的，减去0即可
 */

public class StringToInt {

    public static int stringToInt(String str) {
        //字符串为空, 不符合要求的都置为0
        if (str == null || str.length()==0) {
            return 0;
        }
        //首字母是否含有符号，负号需要返回，正号可以不写
        boolean isNegative = false;
        long num = 0; //长整形
        for (int i=0; i<str.length(); i++) {
            if (i==0 && str.charAt(i) == '-' || i==0 && str.charAt(i) == '+') {
                if (str.charAt(0) == '-') {
                    isNegative = true;
                }
                //字符串只有一个符号
                if (str.length() == 1) {
                    return 0;
                }
                continue; //继续执行下去
            }

            //第二个开始有任何字符不是数字返回0
            if (str.charAt(i) < '0'|| str.charAt(i) > '9') {
                return 0;
            }

            int flag = isNegative? -1:1; //将负号转为-1
            num = num * 10 + flag * (str.charAt(i) - '0'); //'-123' --> 123


            //转为整数后越界 正数大于最大值，负数小于最小值
            if (!isNegative&&num>Integer.MAX_VALUE || isNegative&&num<Integer.MIN_VALUE) {
                return 0;
            }
        }
        return (int)num;
    }

    public static void main(String[] args) {
        String string1 = "123";
        String string2 = "+";
        String string3 = "-123";
        String string4 = "1111111111111";
        String string5 = "123";

        System.out.println(stringToInt(string1));
        System.out.println(stringToInt(string2));
        System.out.println(stringToInt(string3));
        System.out.println(stringToInt(string4));
        System.out.println(stringToInt(string5));
    }
}
