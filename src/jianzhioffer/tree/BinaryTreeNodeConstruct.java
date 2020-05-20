package jianzhioffer.tree;
import java.util.Arrays;

/**
 * 重建二叉树
 */
public class BinaryTreeNodeConstruct {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 && inorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        for (int i=0; i<inorder.length; i++) {
            if(preorder[0] == inorder[i]) {
                //复制范围：[ )，不包含0右边
                root.left = buildTree(Arrays.copyOfRange(preorder, 1, i+1),
                        Arrays.copyOfRange(inorder, 0, i));
                root.right = buildTree(Arrays.copyOfRange(preorder, i+1, preorder.length),
                        Arrays.copyOfRange(inorder, i+1, preorder.length));
            }
        }
        return root;
    }
}