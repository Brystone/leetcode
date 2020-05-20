package leetcode.findAsort;

import java.util.*;

/**
 * 题目：347. Top K Frequent Elements 前k个高频元素
 *
 * [1, 1, 1, 2, 2, 3] k=2 --> [1, 2]
 * 思路：
 *
 * @author ：stone
 * @date ：Created in 2020/3/14 18:31
 */
public class TopKFrequent {

    public static List<Integer> topKFrequent(int[] nums, int k) {
        /*
        //<值，频数>
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        //桶数组索引是频数，相同频数的元素用链表链上桶
        List<Integer>[] bucket = new List[nums.length + 1];
        //遍历map的键得到频数放入桶中,每个桶中存放的频数相同的数
        for (int n : map.keySet()) {
            int freq = map.get(n);
            if (bucket[freq] == null) {
                bucket[freq] = new LinkedList<>();
            }
            bucket[freq].add(n);
        }

        //每个桶数组长度都是7，从7往前遍历，在freq出有值
        ArrayList<Integer> res = new ArrayList<>();
        for (int i=bucket.length-1; i>0 && k>0; i--) {
            if (bucket[i] != null) {
                List<Integer> list =  bucket[i];
                res.addAll(list);
                k -= list.size();
            }
        }
        return res;
    }
    */
        //map统计个数
        HashMap<Integer, Integer> map = new HashMap();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        // 遍历map，用最小堆保存频率最大的k个元素
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override //比较规则
            public int compare(Integer a, Integer b) {
                return map.get(a) - map.get(b);
            }
        });
        //遍历key,
        for (Integer key : map.keySet()) {
            if (pq.size() < k) {
                pq.add(key);
            } else if (map.get(key) > map.get(pq.peek())) {
                pq.poll();
                pq.add(key);
            }
        }
        // 取出最小堆中的元素
        List<Integer> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            res.add(pq.poll());
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1, 1, 2, 2, 2, 3};
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(4, 2);
        map.put(3, 3);
        System.out.println(topKFrequent(arr, 2));
    }
}
