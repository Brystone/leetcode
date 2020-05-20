package jianzhioffer.sort;

public class ReOrderArr {
    private void reOrderArr(int[] arr) {
        if (arr.length == 0){
            return;
        }
        int len = arr.length;
        int[] temp = new int[len];
        int p = 0;

        //存入奇数
        for (int i=0; i<len; i++) {
            if (isOdd(arr[i])) {
                temp[p++] = arr[i];
            }
        }

        //存入偶数
        for (int i=0; i<len; i++) {
            if (!isOdd(arr[i])) {
                temp[i++] = arr[i];
            }
        }

        for (int i=0; i<len; i++) {
            arr[i] = temp[i];
        }
    }

    private boolean isOdd(int i) {
        return (i & 1) == 1; //与运算判断叫奇偶数
    }
}
