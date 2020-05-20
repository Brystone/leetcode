package leetcode.string;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 题目：
 * 思路：
 *
 * @author ：stone
 * @date ：Created in 2020/4/21 18:34
 */
public class IsRule {
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        System.out.print("输入IP地址：");
        String str=scan.nextLine();
        //正则表达式
        String pat="(2[5][0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\.(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\.(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\.(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})";
        Pattern p=Pattern.compile(pat);
        Matcher m=p.matcher(str);
        if(m.matches()){
            System.out.println("IP地址正确！");
        }
        else
        {
            System.out.println("IP地址不正确！");
        }
        //Arrays.
    }
}
