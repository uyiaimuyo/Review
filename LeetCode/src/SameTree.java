/**
 * Created by Aysar on 12/5/2014.
 *
 * Given two binary trees, write a function to check if they are equal or not.

 Two binary trees are considered equal if they are structurally identical and the
 nodes have the same value.
 */
public class SameTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    // do a preorder traversal, root->left->right
//    public boolean isSameTree(TreeNode p, TreeNode q) {
//        if (p.val == q.val) {
//
//        } else {
//
//        }
//    }
}