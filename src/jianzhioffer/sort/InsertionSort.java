package jianzhioffer.sort;

/*
插入排序，{3，5，1，7，2} 和数据状况有关
 */
public class InsertionSort {
   private void insertionSort(int[] arr) {
       for (int i=1; i<arr.length; i++) { //i 为要插入的数
           for (int j=i-1; j>=0 && arr[j]>arr[j+1]; j-- ) { //j为要插入的一个数
                swap(arr[j], arr[j+1]);
           }
       }
   }
    public void swap(int a, int b) {
        int temp =  a;
        a = b;
        b = temp;
    }
}
