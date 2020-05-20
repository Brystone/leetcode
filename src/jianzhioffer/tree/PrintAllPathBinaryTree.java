package jianzhioffer.tree;

import java.util.ArrayList;

/*
每条路径都可以和目标值比较--深度优先搜索(DFS)
路径需要先输出根节点，使用树的前序遍历，每遍历一个结点就存放起来
可以用ArrayList存储结点并输出
 */

/**
 * 113. 路径总和 II
 */
public class PrintAllPathBinaryTree {
        private ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
        private ArrayList<Integer> list = new ArrayList<Integer>(); //并不是每次递归都要创建一个集合

        public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
            if(root == null) return listAll;
            list.add(root.val);
            target -= root.val;
            if(target == 0 && root.left == null && root.right == null)
                listAll.add(new ArrayList<Integer>(list));
            FindPath(root.left, target);
            FindPath(root.right, target);
            list.remove(list.size()-1);
            return listAll;
    }
}

