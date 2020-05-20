package jianzhioffer.hashtable;

import org.junit.Assert;
import org.junit.Test;

/*
给定0-n一个数组，找出第一个重复的数字 {}

思路： 0-n之间的数，排完序后每个位置应该对应索引的值
 */
public class FindDuplication {
    public int findDuplication(int[] num, int[] dup) {
        int size = num.length; //数组，长度是属性

        //遍历数组
        for (int i=0; i<size; i++) {
            //判断是否有非法值
            if (num[i] <0 || num[i] > size-1) {
                return -1;
            }
        }

        //遍历数组、和对应位置的值比较
        for (int i=0; i<size; i++) {
            while (num[i] != 0) { //排序
                if (num[i] == num[num[i]]) { // 0-n之间的数，排完序后每个位置应该对应索引的值
                    dup[i] = num[i]; //重复的使用新数组存储
                }
                swap(num, i, num[i]);
            }
        }
        return dup[0];
    }
    //交换一个数组的两个值
    private void swap(int[] arr, int p, int q) {
        int temp = arr[p];
        arr[p] = arr[q];
        arr[q] = temp;
    }

    @Test
    public void findDuplication() {
        int[] ints1 = new int[]{1, 2, 3, 4, 5, 2};
        int[] num = new int[10];
        //System.out.println(FindDuplication.findDuplication(ints1, num));
        Assert.assertEquals(2, findDuplication(ints1, num));
    }

}
