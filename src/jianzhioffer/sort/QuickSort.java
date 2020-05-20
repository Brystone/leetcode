package jianzhioffer.sort;

/**
 * T = O(nlogn) 平均 空间复杂度 O(nlogn)
 */
public class QuickSort {

    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSorted(arr, 0, arr.length - 1);
    }

    public static void quickSorted(int[] arr, int L, int R) {
        if (L >= R) return;//这里加了判断
        int[] p = partition(arr, L, R); //返回数组中相等元素的位置
        quickSorted(arr, L, p[0] - 1);
        quickSorted(arr, p[0] + 1, R); //这会不执行

    }

    //返回等于区域的范围
    public static int[] partition(int[] arr, int L, int R) {
        int less = L - 1; // 当前左边元素
        int more = R;
        int num = arr[R]; //定值

        while (L < more) { //这个判定条件
            if (arr[L] < num) {
                swap(arr, ++less, L++); //小于区域的下一个位置和当前区域互换, 小于区域扩一下位置  ++less 是加完后的值和cur交换，两个都加1
            } else if (arr[L] > num) {    //cur = cur+1
                swap(arr, --more, L); //大于区域位置也要移动
            } else {
                L++; //相等移动到下一个位置
            }
        }

        swap(arr, more, R);
        return new int[]{less + 1, more}; // 如果没有相等的数那么返回的是 基准在数组中的位置
    }



    public static int[] swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {4,5,1,6,2,7,3,8};

        quickSort(arr);
        for (int i=0; i<arr.length; i++) {
            System.out.println(arr[i]);
        }

        int[] p = partition(arr, 0, arr.length-1);
        //System.out.println(p[0]);

    }
}
