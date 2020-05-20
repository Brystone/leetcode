package leetcode.array;

/**
 * 题目：48. Rotate Image 顺时针旋转数组
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 * 思路：上下交换,再沿主对角线交换
 *
 * @author ：stone
 * @date ：Created in 2020/3/15 20:28
 */
public class RotateImage {
    public void rotate(int[][] matrix) {
        int rows = matrix.length; //行列数
        int cols = matrix[0].length;
        //中间一层不用交换 上-->下
        for (int i = 0; i < rows / 2; i++) {
            for (int j = 0; j < cols; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[rows - i - 1][j];
                matrix[rows - i - 1][j] = tmp;
            }
        }

        //沿主对角线换
        for (int i = 0; i < rows; i++) {
            for (int j = i + 1; j < cols; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }

    public static void main(String[] args) {
    }
}