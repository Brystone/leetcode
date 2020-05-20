package jianzhioffer.sort;


//找到数组超过一半的数的索引
public class MoreThanHalf {
    public int moreThanHalf(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int[] p = partition(arr, 0, arr.length - 1);
        int res= p[1] - p[0] + 1;
        if (res > arr.length / 2) {
            return p[0];
        }
        return -1;
    }

    private int[] partition(int[] array, int L, int R) {
        int less = L - 1;
        int more = R;
        int num = array[R]; // 以最后一个数为基准

        while (L < more) {
            if (array[L] < num) {
                swap(array, ++less, L++);
            } else if (array[L] > num) {
                swap(array, L, --more);
            } else {
                L++;
            }
        }
        swap(array, more, R); //将基准归位
        return new int[] {less+1, more}; //等于区域的范围索引
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}


