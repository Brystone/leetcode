package leetcode.dp;

/*
485 easy 找出数组中最长的1的个数，数组只有0和1 非top100
 */
public class FindMaxConsecutiveOnes {

    private static int findMaxConsecutiveOnes(int[] arr) {
        if (arr.length == 0 || arr == null) {
            return -1;
        }
            int cur = 0;
            int max = 0;

            for (int i = 0; i < arr.length; i++) {
                cur = arr[i] == 0 ? 0 : cur + 1; //一个指针向前找到1.并自增，然后和最大值进行比较
                max = Math.max(cur, max);
            }
            return max;
        }



    public static void main(String[] args) {
        int[] arr = {1};
        System.out.println(findMaxConsecutiveOnes(arr));
    }
}
