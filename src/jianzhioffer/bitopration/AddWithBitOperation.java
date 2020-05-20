package jianzhioffer.bitopration;

/*
不用加减乘除做加法,用位运算
 */
public class AddWithBitOperation {
    private int add(int num1, int num2) {

        while (num2 != 0) {
            //异或：不进位的加法
            int sum = num1 ^ num2;
            //左移一位
            int carry = (num1 & num2) >> 1;
            // 这两个赋值是让上一步的sum+carry，下面加上进位
            num1 = sum;
            num2 = carry;
        }
        return num1;
    }
}
