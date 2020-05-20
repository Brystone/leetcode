package leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目：412. Fizz Buzz 3和3的倍数是fizz，5和5的倍数是buzz，同时是两个倍数两个就是fizzbuzz
 * 15 -->["1", "2", "Fizz", ]
 * 思路：每到3和5的倍数就清0
 *不是将15-->["1", "2"，，] || 用 fizz buze 来表示
 * @author ：stone
 * @date ：Created in 2020/1/30 21:39
 */
public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>(n); //用集合来操作
        for (int i=1, fizz=0, buzz=0; i<=n; i++) { //每次从0开始计算，所以初试著不能为1
            fizz++;
            buzz++; //对应的位置赋值，加完就立马判断 一定是先判断两个，不然会同时加
          if (fizz == 3 && buzz == 5) {
                list.add("FizzBuzz");
                fizz = 0;
                buzz = 0; //每次清0，重新计数
            } else if (fizz==3) {
                list.add("Fizz");
                fizz = 0;
            } else if (buzz == 5) {
              list.add("Buzz");
              buzz = 0;
          } else {
                list.add(Integer.toString(i)); //整形转换为字符串
            }
         }
         return list;
    }

    public static void main(String[] args) {
        System.out.println(Integer.toString(1));
        //System.out.println(""+1);
    }
}
