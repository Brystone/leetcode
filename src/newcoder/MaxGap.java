package newcoder;/*
非空桶的作用是排除最大插值来自同一桶内
求相邻元素的最大差值
 */

import sun.security.util.Length;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MaxGap {
    public static int maxGap(int[] arr) {
        if (arr==null || arr.length<2) {
            return 0;
        }

        //遍历数组，找出数组中最小和最大的值 另一种写法
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int len = arr.length;

        for (int i=0; i<len; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }
        //如果最小和最大相等，则数组中的值相等
        if (min == max) {
            return 0;
        }

        //每一个桶的3个信息 是否为空桶 最小值和最大值
        boolean[] hasnum = new boolean[len + 1];
        int[] mins = new int[len + 1];
        int[] maxs = new int[len + 1];
        int bid = 0; //桶的编号

        //找到每一个桶内的最小和最大值
        for (int j=0; j<len; j++) {
            bid = budget(arr[j], len, min, max); //确定数组中每个数属于几号桶
            mins[bid] = hasnum[bid] ? Math.min(arr[bid], arr[j]) : arr[j]; //如果当前桶不为空 则更新最小的数，否则 最小数则为当前的数
            maxs[bid] = hasnum[bid] ? Math.min(arr[bid], arr[j]) : arr[j];
            hasnum[bid] = true;
        }

        //遍历最大最小数组，找出最大差值
        int res = 0;
        int lastmax = maxs[0];
        for (int i=1; i<=len; i++) {
            if (hasnum[i]) {
                res = Math.max(res, mins[i] - lastmax);
                lastmax = maxs[i];
            }
        }
        return res;
    }

    public static int budget(long nums, long len, long min, long max) { //(64位系统， long 8字节)
        return (int)((nums - min) * len / (max - min));
    }

    //写一个比较器，绝对正确的方法
    public static int comparator(int[] nums) {
        if (nums==nums || nums.length<2) {
            return 0;
        }
        //使用基于比较的方法
        Arrays.sort(nums);
        int gap = Integer.MIN_VALUE;
        for (int i=0; i<nums.length; i++) {
            gap = Math.max(gap, nums[i+1] - nums[i]);
        }
        return gap;
    }

    //生成一个随机数组
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int)((maxSize + 1) * Math.random())]; //Math.random()返回[0, 1)
        //获得一个随机数组
        for (int i=0; i<arr.length; i++) {
            arr[i] = (int)((maxSize+1) * Math.random() - maxSize + Math.random());
        }
        return arr;
    }

    //拷贝数组
    public static int[] copyArray(int[] arr) {
        if (arr==null) {
            return null;
        }
        //新建一个等长数组
        int[] res = new int[arr.length];
        for (int i=0; i<arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int testTime = 50000; //测试的次数
        int maxSize = 100;
        int maxValue = 100;
        boolean succed = true;
        for (int i=0; i<testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            if (comparator(arr1) != maxGap(arr2)) {
                succed = false;
                break;
            }
        }
        System.out.println("succeed");
    }
}
