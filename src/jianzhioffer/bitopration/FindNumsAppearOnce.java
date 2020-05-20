package jianzhioffer.bitopration;

public class FindNumsAppearOnce {
    public void finaNumsAppearOnce(int[] array, int[] num1, int[] num2) {
        if (array == null || array.length < 2) {
            return;
        }
        //找到两个不同数的异或值
        int res =0;
        for (int i=0; i<array.length; i++) {
            res ^= array[i];
        }
        int FirstIndexOfOne = findFirstIndexOfOne(res);
        //对数组里面所有值进行异或，找出两个不相同的值
        for (int i=0; i<array.length; i++) {
            //判断数字的二进制第index位是否为1
            if (isIndexOne(array[i], FirstIndexOfOne)) {
                num1[0] ^= array[i];
            } else {
                num2[0] ^= array[i];
            }
        }
    }

    public int findFirstIndexOfOne(int value) {
        int index = 0;
        //遍历
        while (value != 0) {
            if ((value & 1) == 1) { //移到最后一位
                return index;
            }
            value  = value >> 1; //右移一位，索引加1
            index++;
        }
        return -1; //跳出循环，则表示字节里没有1
    }

    public boolean isIndexOne(int value, int index) {
        value = value >> index; //右移index位判断值是否还位1
        return (value & 1) == 1;
    }
}
