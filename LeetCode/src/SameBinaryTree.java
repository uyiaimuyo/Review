/**
 * Created by Aysar on 12/26/2014.
 * Given two binary trees, write a function to check if they are equal or not.
 * Two binary trees are considered equal if they are structurally identical and
 * the nodes have the same value.
 */
public class SameBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // traverse both trees simultaneously in postorder
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p != null && q != null) {
            if (isSameTree(p.left, q.left) && isSameTree(p.right, q.right) && p.val == q.val)
                return true;
        }
        return false;
    }
}
