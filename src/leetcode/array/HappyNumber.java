package leetcode.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 题目：202. Happy Number 输入19
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 * 思路：使用HashSet存储数据，定义一个变量存储中间结果
 * 1.当 n != 1时不断遍历集合
 * 2.取个位数并且用Math.pow来计算平方并相加
* 3.n/10取10位数，相加的前提是 n!= 0
 * 4.相加完以后先判断集合中是否有此数，有则说明相求和过程中会发生循环，返回fasle
 * 5.循环此过程，直到退出循环，则返回true
 *
 * @author ：stone
 * @date ：Created in 2020/2/4 11:00
 */
public class HappyNumber {
    public boolean isHappyNumber(int n) {
        //List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        while (n != 1) {
            int result = 0; //每个数计算一个和
            while (n != 0) {
                result += Math.pow(n%10, 2); //取个位数求平方和
                n = n / 10;
            }

            if (set.contains(result)) {
                return false;
            }
            set.add(result);
            n = result;
        }
        return true;
    }
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet();
        set.add(12);
        for (int i:set) {
            System.out.println(set);
        }
    }
}
