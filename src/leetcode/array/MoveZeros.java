package leetcode.array;


/*
283 essy 用一个指针，首先将非0元素存储，然后将0元素存到数组结尾
 */
public class MoveZeros {
    public static void moveZeros(int[] arr) {
        int idx = 0;

        for (int i: arr) {
            if (i != 0) {
                arr[idx] = i;
                idx++;
            }
        }

        //边界是数组的长度，条件是idx的增量范围
        while (idx < arr.length) {
            arr[idx] = 0;
            idx++;
        }
    }

    public static void main(String[] args) {
        int[] arr = {0,1,0,3,12};
        moveZeros(arr);
        for (int i=0; i<arr.length; i++) {
            System.out.println(arr[i]);}
    }
}

