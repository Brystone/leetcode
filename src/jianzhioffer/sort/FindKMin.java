package jianzhioffer.sort;

//找到数组中最小的k个数,熟悉优先的队列的用法，排序算法时间复杂度nlogk 适用于海量数据 T = O(n)

import java.util.*;

public class FindKMin {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        // 默认是小根堆，实现大根堆需要重写一下比较器。
        Queue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        //只是获取元素不对数据做修改考虑用 增强for循环
        for (int num: arr) {
            if (pq.size() < k) {
                pq.offer(num);
            } else if (num < pq.peek()) {
                pq.poll();
                pq.offer(num);
            }
        }

        // 返回堆中的元素
        int[] res = new int[pq.size()];
        int idx = 0;
        for(int num: pq) {
            res[idx++] = num;
        }
        return res;
    }

    public ArrayList<Integer> findKMin1(int[] arr, int k) {
        if (arr.length == 0) {
            return null;
        }
        int j = select(arr, k);
        ArrayList<Integer> list = new ArrayList<>();
        for (int i=0; i<arr.length; i++) {
            list.add(arr[i]);
        }
        return list;
    }

    public int select(int[] arr, int k) {
        int low = 0;
        int high = arr.length - 1;
        int idx = -1;
        while (low < high) {
            int[] m = partion(arr, low, high);
            if (m[0] == k-1) {
                idx = m[0];
                break;
            } else if (m[0] < k-1) {
                low = m[0]+1; //向右继续划分
            } else {
                high = m[0]-1; // 向左
            }
        }
        return idx;
    }

    public int[] partion(int[] arr, int L, int R) {
        int less = L-1;
        int more = R;
        int num = arr[R];

        while (L<more) {
            if (arr[L] < arr[more]) {
                swap(arr, ++less, L++);
            } else if (arr[L] > arr[more]) {
                swap(arr, L, --more);
            } else {
                L++;
            }
        }
        swap(arr, more, L);
        return new int[] {less++, more};
    }

    public int[] swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return arr;
    }
}
