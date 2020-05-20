package jianzhioffer.tree;

//给定一个序列，判断是否二叉搜索树的的后序遍历结果
public class IsResOfSearchBST {
    public boolean isResOfSearchBST(int[] seq) {
        if (seq==null || seq.length == 0) {
            return false;
        }
        return isSearchBST(seq, 0, seq.length-1);
    }


    public boolean isSearchBST(int[] seq, int begin, int end) {
        if (begin >= end) {
            return true;
        }
        int i = begin;
        while (i<end && seq[i] < seq[end]) {
            i++;
        }
        int boundary = i;
        while (i<end) {
            if (seq[i] > seq[end]) {  //右子树中还存在比根节点值小的
                return false;
            }
            i++;
        }
        return isSearchBST(seq, 0, boundary-1) &&
                isSearchBST(seq, boundary,seq.length-1);
    }
}
