package newcoder;
import java.util.Arrays;

public class MergeSort {

    /*
        排序的时候，数组长度为空和1都不需要排序
        将整个数组进行排序
     */

    // 静态方法 在类内的方法中可以互相调用
    public static int[] mergeSort(int[] arr) {

        if (arr == null || arr.length < 2) {
            return arr;
        }
        processSort(arr,0, arr.length-1);
        return arr;
    }


    /*
    1.先分成两边， 对左边排序，对右边排序，再对整个数组排序、
    2.写出对整个数组排序的功能
    */

    public static void processSort(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }
        int mid = l + (r - l) / 2;

        processSort(arr, l, mid);
        processSort(arr, mid + 1, r);
        merge(arr, l, r);
}

    /*
    定义辅助数组
    定义指针
    开始比较

    局部变量:形参和函数体内部定义的变量
     */
    public static void merge(int[] arr, int l, int r) {
        int mid = l + (r-l) / 2;
        int i = 0;
        int p1 = l; //归并的两个数组的指针开头
        int p2 = mid + 1;

        int[] help = new int[arr.length];

        while (p1 < mid && p2 < r) { //边界
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }

        if (l <= mid) {
            help[i++] = arr[p1++];
        } else {
            help[i++] = arr[p2++];
        }

        for (int j = 0; j < help.length; j++) {
            arr[l+j] = help[j];
        }
    }

    /*
        准备数组对数器
        1.随机样本发生器
        2.准备一个绝对正确方法，不用管复杂度
        3.将随机生成的数组拷贝出来，进行测试
        4.将随机产生的数组和写的方法的数组进行比较
     */
    //发生器产生随机数组,产生两个随机数组相减

    public static int[] generatorRandomArray(int maxsize, int maxValue) {
        int[] arr = new int[(int) ((maxsize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxsize + 1) * Math.random()) - (int) ((maxValue + 1) * Math.random());
        }
        return arr;//返回的是数组
    }

    public static void rightMethod(int[] arr) {
        Arrays.sort(arr);
    }

    public static int[] copyArray(int[] arr) {
        int[] res = new int[arr.length];
        if (arr == null) {
            return null;
        }
        //逐元素比较
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    public static boolean isEqual(int[] arr, int[] res) {
        //数组的长度是否相等
        if ((arr == null && res != null) || (arr != null && res == null)) {
            return false;
        }

        if (arr == null && res == null) {
            return true;
        }

        //逐元素是否相等
        for (int i = 0; i < arr.length; i++) {
            //判断两个数组的元素是否相等，
            if (arr[i] == res[i]) {
                return true;
            }
        }
        return true;
    }

    //为什么要打印数组
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    //main方法进行测试
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean suceeded = true; //是否排序成功的标记

        for (int i=0; i<testTime; i++) {
            //得到随机数组
            int[] arr1 = generatorRandomArray(maxSize, maxValue);
            //得到拷贝数组
            int[] arr2 = copyArray(arr1);

            mergeSort(arr1);
            rightMethod(arr2);

            //测试结果不对，打印出来，直接观察
            if (!isEqual(arr1, arr2)) {
                suceeded = false;
                printArray(arr1);
                printArray(arr2); //为什么打印两次
                break;
            }
        }
        //利用三目运算符
        System.out.println(suceeded ? "测试成功" : "测试失败");
    }

}




