/**
 * Created by Aysar on 12/27/2014.
 *
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 *
 * For example, the following two linked lists:

 A:          a1 → a2
                     ↘
                      c1 → c2 → c3
                     ↗
 B:     b1 → b2 → b3
 begin to intersect at node c1.
 */
public class IntersectionOfTwoLinkedLists {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        // traverse from A only and keep count of # of elements in it
        ListNode curr = headA;
        int sizeA = 0;
        while (curr.next != null) {
            curr = curr.next;
            sizeA++;
        }

        // traverse from B only and keep count of # of elements in it
        curr = headB;
        int sizeB = 0;
        while (curr.next != null) {
            curr = curr.next;
            sizeB++;
        }

        // adjust the start pointer of one of lists based on difference in size
        int d = Math.abs(sizeA - sizeB);
        int countD = 0;
        curr = headA;
        ListNode currB = headB;
        if (sizeA > sizeB) {
            while (countD < d) {
                curr = curr.next;
                countD++;
            }
        } else if (sizeA < sizeB) {
            curr = headB;
            while (countD < d) {
                curr = curr.next;
                countD++;
            }
            currB = headA;
        }
        // traverse both of them at same time and compare
        while (!curr.equals(currB)) {
            curr = curr.next;
            currB = currB.next;
            if (curr == null && currB == null)
                return null;
        }
        return curr;

    }
}
