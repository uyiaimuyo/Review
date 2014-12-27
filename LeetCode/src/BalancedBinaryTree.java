/**
 * Created by Aysar on 12/27/2014.
 *
 * Given a binary tree, determine if it is height-balanced.
 For this problem, a height-balanced binary tree is defined as a binary tree in which
 the depth of the two subtrees of every node never differ by more than 1.
 */
public class BalancedBinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x) { val = x;}
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        if (Math.abs(getHeight(root.left) - getHeight(root.right)) > 1)
            return false;
        return isBalanced(root.left) & isBalanced(root.right);
    }

    public int getHeight(TreeNode node) {
        if (node == null)
            return 0;
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }
}
