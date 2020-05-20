package jianzhioffer.sort;

public class MaxSumOfSerialSubOfArray {
    private int maxSumOfSerialSubOfArray(int[] arr) {
        if (arr == null || arr.length <0) {
            return -1;
        }
        int maxSum = arr[0];
        int curSum = arr[0];

        for (int i=1; i<arr.length; i++) {
            //判断当前和是否为负，负的则移动到下一个元素
            if (curSum < 0) {
                curSum = arr[i];
            } else {
                curSum += arr[i];
            }
            //两个最大值比较，取最大的
            if (curSum>maxSum) {
                maxSum = curSum;
            }
        }
        return maxSum;
    }
}
