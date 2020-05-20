package leetcode.findAsort;

/**
 * 题目：75. Sort Colors 数组里面只有 0 1 2  顺序排好
 * [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * 思路：扫描一遍，将0放到左边，2放到右边 1 不动
 *
 * @author ：stone
 * @date ：Created in 2020/3/16 13:11
 */
public class SortColors {
    public void sortColors(int[] nums) {
        //两个指针指向首尾
        int low = 0;//索引
        int high = nums.length - 1;
        //遍历数组交换
        for (int i=low; i < high;) {

            if (nums[i] == 2)  { //swap i high
                int tmp = nums[i];
                nums[i] = nums[high--];
                nums[high--] = tmp;
                //交换完后i位置可能还为2，high--，继续向前扫描
            } else if (nums[i] == 0) { //swap i low
                int tmp = nums[i++];
                nums[i++] = nums[low++];
                nums[low++] = tmp;
            } else {
                i++;
            }
        }
    }
}
