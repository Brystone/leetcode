package jianzhioffer.sort;
/*
冒泡排序 O(n) = n^2，最大的数沉底
 */

public class BubbleSort {
    private void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        //范围在缩减
        for (int end=arr.length-1; end>0; end--) {
            //数组中位置的比较
            for (int i=0; i<arr.length; i++) {
                if (arr[i] > arr[i+1]) {
                    swap(arr[i], arr[i+1]);
                }
            }
        }
    }

    public void swap(int a, int b) {
        int temp =  a;
        a = b;
        b = temp;
    }
}
