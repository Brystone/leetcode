import java.util.HashMap;
/**
 * 题目：
 * 思路：
 *
 * @author ：stone
 * @date ：Created in 2020/4/23 10:27
 */

//找出出现次数大于n/2的数字
public class Main {
    public int findsumInArr(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i])+1);
            }
            map.put(arr[i], 1);
        }
        for (int i:map.keySet()) {
            if (map.get(i) >= (arr.length /2)) return i;
        }
        return -1;
    }
}
