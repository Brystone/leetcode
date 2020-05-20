package jianzhioffer.StackAndQuene;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
（优先队列）使用最大堆， 熟悉堆方法的使用
 */
public class MaxInWindows {
    public static ArrayList<Integer> maxInWindows(int[] arr, int size) {
        //动态数组存储最大值
        ArrayList<Integer> list = new ArrayList<>();
        PriorityQueue<Integer> maxHeap =  new PriorityQueue<>(Comparator.reverseOrder());

        if (arr == null || size < 0 || arr.length < size) {
            return null;
        }
        int j = 0;
        for (int i=0; i<arr.length; i++) {
            maxHeap.offer(arr[i]); //堆有容量限制使用offer方法

            if (maxHeap.size() >= size) {
                list.add(maxHeap.peek()); // 得到队列的最大值
                maxHeap.remove(arr[j++]); //具体的元素
            }
        }
        return list; //返回类型一致
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 2, 6, 2, 5, 1};
        ArrayList<Integer> res = maxInWindows(arr, 3);
        for (Integer list: res) { //数据类型
            System.out.println(list);
        }
    }
}
