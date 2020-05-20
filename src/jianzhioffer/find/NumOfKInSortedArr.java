package jianzhioffer.find;

/*
在排好序的数组中找到k出现的次数 {1, 2, 3, 3, 3, 3, 4, 5}   O(n) =  O(logn)
 */
public class NumOfKInSortedArr {
    private int rank(int[] arr, double k) {   // k = 2.5 low = 2，在数组中的位置为2
        if (arr == null) {                      // k = 3.5 low = 6, 在数组中的位置为6
            return -1;
        }
        int low = 0;
        int high = arr.length - 1;
        while (low < high) {
            int mid = low + (high -low) / 2;
            if (mid > k) {
                high = mid - 1;
            }
            if (mid < k) {
                low = mid + 1;
            }
        }
        return low;  //返回的是low位置
    }
    // k = 3
    private int numOfKInSortedArr(int[] arr, double k) {
        return rank(arr, k + 0.5) - rank(arr, k - 0.5);
    }
}
