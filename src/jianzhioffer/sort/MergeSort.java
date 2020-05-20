package jianzhioffer.sort;

//归并排序，O(N*logN) 思想：先切分，然后分别排序 ，最后合并，空间 O(N)

public class MergeSort {
    private void  mergeSort(int[] arr) {
        if (arr== null || arr.length < 2) {
            return;
        }
        sortProcess(arr, 0, arr.length-1);
    }

    //对拆分的数组分别排序
    private void sortProcess(int[] arr, int L, int R) {
        if (L < R) { // 停止排序条件
            int mid = L + (R - L) / 2;//
            sortProcess(arr, 0, mid);
            sortProcess(arr, mid + 1, arr.length);
            merge(arr, L, mid, R);
        }
    }

    //将两边有序的数组合并成有序的数组
    private void merge(int[] arr, int L, int mid, int R) {
        //用辅助数组
        int[] help = new int[arr.length];
        int i = 0;
        int p1 = L;
        int p2 = mid + 1;

        while (p1 <= mid && p2 <= R) {
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++]; //取小的
        }

        //p2越界，右边的数组已经全都排在辅助数组，把左边数组剩下的放在辅助数组
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }

        //p1越界，左边数组已经全都排好，把右边数组剩下的数放入辅助数组
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
    }



    public void  mergeSort1(int[] arr) {
        if (arr== null || arr.length == 0) {
            return;
        }
        sortProcess1(arr, 0, arr.length-1);
    }

    public void sortProcess1(int[] arr, int L, int R) {
       if (L == R) {
           return;
       }
       int mid = L + (R - L)/2;
       sortProcess(arr, 0, mid);
       sortProcess(arr, mid+1, R);
       merge(arr, L, R, mid);
    }

    public void merge1(int[] arr, int L, int R, int mid) {
        int count = 0;
        int[] help = new int[arr.length];
        int i = 0;
        int p1 = L;
        int p2 = R;

        while (p1<=mid  && p2 <= R) {
            //help[i++] = arr[p1] < arr[p2] ? arr[p1++] :arr[p2++];
            if (arr[p1] > arr[p2]) {
                count = mid - i + 1;
                help[i++] = arr[p2++];
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
    }
}
