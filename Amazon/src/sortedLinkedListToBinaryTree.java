/**
 * Created by Aysar on 12/22/2014.
 *
 * Given a singly linked list where elements are sorted in ascending order, convert
 * it to a height balanced BST.
 */
public class sortedLinkedListToBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

     public class ListNode {
             int val;
             ListNode next;
             ListNode(int x) { val = x; next = null; }
     }

    public TreeNode sortedListToBST(ListNode head) {
        // first get number of elements in list
        int i=0;
        ListNode node = head;
        while (node!=null) {
            node = node.next;
            i++;
        }
        return buildBST(new ListNode[]{head}, 0, i);
    }

    // recursively build parents and children BOTTOM-UP approach
    public TreeNode buildBST(ListNode[] head, int i, int j) {
        if (j==i) return null;

        int mid = (i+j)/2;

        TreeNode left = buildBST(head, i, mid);
        TreeNode root = new TreeNode(head[0].val);
        head[0] = head[0].next;
        TreeNode right = buildBST(head, mid+1, j);
        root.left = left;
        root.right = right;

        return root;
    }
}
