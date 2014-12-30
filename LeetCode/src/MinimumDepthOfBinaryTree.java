/**
 * Created by Aysar on 12/28/2014.
 *
 * Given a binary tree, find its minimum depth.

 The minimum depth is the number of nodes along the shortest
 path from the root node down to the nearest leaf node.
 */
public class MinimumDepthOfBinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;
        return get(root);
    }

    public static int get(TreeNode node) {
        if (node == null)
            return 0;
        if (node.left != null && node.right == null)
            return 1 + get(node.left);
        if (node.left == null && node.right != null)
            return 1 + get(node.right);
        return 1 + Math.min(get(node.left), get(node.right));
    }

    public static void main(String[]args) {
        TreeNode r = new TreeNode(1);
        TreeNode t = new TreeNode(2);
        TreeNode s = new TreeNode(3);
        TreeNode u = new TreeNode(4);
        TreeNode v = new TreeNode(5);
        r.left = t;
        r.right = s;
        t.left = u;
        s.right = v;
        System.out.println(minDepth(r));
    }
}
