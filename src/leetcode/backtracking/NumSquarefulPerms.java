package leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author stone
 * @version 1.0
 * @ClassName AquarefulPerms
 * @Description 996. 正方形数组的数目 H
 * @date 2020/5/15 22:58
 */
public class NumSquarefulPerms {
    public static int aquarefulPerms(int[] A) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[A.length];
        Arrays.sort(A);
        backtrack(A, res, new ArrayList<>(), visited);
        return res.size();
    }
    //找出所有组合，并且每一个判断 
    public static void backtrack(int[] A, List<List<Integer>> res, List<Integer> temp, boolean[] visited) {
        if (temp.size() == A.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0; i<A.length; i++) {
            //判断集合中是否存在此元素
            if (visited[i] == true) continue;
            if (i > 0 && A[i] == A[i-1] && visited[i-1] == true) continue;
            if (temp.size() >0 && !isSqrtNum(temp.get(temp.size() - 1) + A[i])) continue; //这里判断用List末尾的元素 和当前元素相加判断
            visited[i] = true;
            temp.add(A[i]);
            backtrack(A, res, temp, visited);
            temp.remove(temp.size() - 1);
            visited[i] = false;
        }
    }

    //判断一个数是完全平方数
    public static boolean isSqrtNum(int i) {
        return (double)Math.sqrt(i) == (int)Math.sqrt(i);
    }

    public static void main(String[] args) {
        int[] a = new int[] {1, 17, 8};
        System.out.println(aquarefulPerms(a));
    }
}
