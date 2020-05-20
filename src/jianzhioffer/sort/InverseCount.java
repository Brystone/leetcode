package jianzhioffer.sort;

/**
 * 题目：数组中的逆序对
 * 思路：
 *
 * @author ：stone
 * @date ：Created in 2020/2/7 15:02
 */
public class InverseCount {
        int count;
        public int  inverseCount(int[] arr) {
            count = 0;
            if (arr== null || arr.length == 0) {
                return 0;
            }
            divide(arr, 0, arr.length-1);
            return count;
        }

        public void divide(int[] arr, int L, int R) {
            if (L == R) {
                return;
            }
            int mid = L + (R - L)/2;
            divide(arr, 0, mid);
            divide(arr, mid+1, R);
            merge1(arr, L, R, mid);
        }

        public void merge1(int[] arr, int L, int R, int mid) {
            int[] help = new int[arr.length];
            int i = 0;
            int p1 = L;
            int p2 = R;

            while (p1<=mid  && p2 <= R) {
                //help[i++] = arr[p1] < arr[p2] ? arr[p1++] :arr[p2++];
                if (arr[p1] > arr[p2]) {
                    help[i++] = arr[p2++];
                    count = mid - p1 + 1;
                } else {
                    help[i++] = arr[p1++];
                }
            }


            while (p1<=mid) {
                help[i++]  = arr[p1];
            }
            while (p2<=R) {
                help[i++] = arr[p2];
            }

            //覆盖原数组
            for (i = 0; i < help.length; i++)
                arr[L + i] = help[i];
        }
}
