package jianzhioffer.find;

/**
 * 数字在排序数组中出现的次数
 *
 */
public class FindNumInSortedMatrix {

    /*
    大：下面的数不用看； 小：左边的数不用看
     */

    public static boolean isContain(int num, int[][] matrix) {
        //从第一行最后一个数开始
        int row = 0;
        int col = matrix[0].length - 1; //

        //边界是行和列
        while (row < matrix.length - 1 && col > -1) {
            if (matrix[row][col] == num) {
                return true;
            } else if (matrix[row][col] > num) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }

    //二维矩阵的写法
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{0, 1, 2, 3, 4, 5, 6},// 0
                {10, 12, 13, 15, 16, 17, 18},// 1
                {23, 24, 25, 26, 27, 28, 29},// 2
                {44, 45, 46, 47, 48, 49, 50},// 3
                {65, 66, 67, 68, 69, 70, 71},// 4
                {96, 97, 98, 99, 100, 111, 122},// 5
                {166, 176, 186, 187, 190, 195, 200},// 6
                {233, 243, 321, 341, 356, 370, 380} // 7
        };

        int k = 20;
        boolean flag = isContain(k, matrix);//静态方法内可以直接调用
        System.out.println(flag);
    }
}
