import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Aysar on 12/26/2014.
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values.
 * (ie, from left to right, level by level from leaf to root).
 */
public class BinaryTreeBottomUpLevelOrderTraversal {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x) { val = x;}
    }

    static LinkedList<List<Integer>> queue = new LinkedList<List<Integer>>();

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<Integer> v = new ArrayList<Integer>();
        int level = 0;
        int max = getHeight(root);
        while (level < max) {
            queue.push(v);
            traversalToLevel(root, level, level);
            level++;
        }
        return queue;
    }

    public static int getHeight(TreeNode node) {
        if (node == null)
            return 0;
        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }

    public static void traversalToLevel(TreeNode node, int level, int actualLevel) {
        if (node == null)
            return;
        if (level == 0) {

            if (queue.peek().isEmpty()) {
                queue.pop();
                List<Integer> t = new ArrayList<Integer>();
                t.add(node.val);
                queue.push(t);
            } else {
                List<Integer> u = queue.pop();
                u.add(node.val);
                queue.push(u);
            }
        } else {
            traversalToLevel(node.left, level - 1, level);
            traversalToLevel(node.right, level - 1, level);

        }
    }

    public static void main(String[] args) {
        TreeNode n = new TreeNode(3);
        n.left = new TreeNode(9);
        TreeNode m = new TreeNode(20);
        m.left = new TreeNode(15);
        m.right = new TreeNode(7);
        n.right = m;

        List<List<Integer>> x = levelOrderBottom(n);
        for (List<Integer> t: x) {
            System.out.println("[");
            for (Integer u: t)
                System.out.println(u + " ");
            System.out.print("] ,");
        }
    }
}
