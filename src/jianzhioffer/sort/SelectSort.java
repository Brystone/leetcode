package jianzhioffer.sort;
/*
选择排序：O(n^2)，将最小的数放在最前面
 */
public class SelectSort {
    private void selectSort(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i=0; i<arr.length; i++) {   //遍历一次排好一个数
            int minIndex = i;
            for (int j = i+1; j<arr.length; j++) { //遍历一轮找到最小值
                arr[minIndex] = arr[minIndex] < arr[j] ? minIndex : j;  //确定
            }
            swap(arr[i], arr[minIndex]);
        }
    }
    public void swap(int a, int b) {
        int temp =  a;
        a = b;
        b = temp;
    }
}
