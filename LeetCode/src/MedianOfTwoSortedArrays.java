import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by Aysar on 11/15/2014.
 */
public class MedianOfTwoSortedArrays {
    public static void main(String []args) {
        int[] a = {1,2};
        int[] b = {1,2,3};
        System.out.println(getMedian(a,b));
    }

    private static double getMedian(int[] A, int[] B) {
        int n,m;
        if (A.length > B.length) {
            m = A.length;
            n = B.length;
            if (n == 0) {
                if (A.length % 2 == 0)
                    return (A[(A.length / 2)-1] + A[A.length / 2]) / 2.0;
                else
                    return A[A.length / 2];
            }
        } else {
            m = B.length;
            n = A.length;

            if (n == 0)
                if (B.length % 2 == 0)
                    return (B[(B.length / 2)-1] + B[B.length / 2]) / 2.0;
                else
                    return B[B.length / 2];
            int [] swap = A;
            A = B;
            B = swap;
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(); //contains largest elements we've seen
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(m+n, Collections.reverseOrder()); // smallest el we see
        int i = 0;
        for(; i<n; i++) {
            if (A[i] > B[i]) {
                minHeap.add(A[i]);
                maxHeap.add(B[i]);
            } else if (A[i] == B[i]) {
                minHeap.add(A[i]);
            } else {
                maxHeap.add(A[i]);
                minHeap.add(B[i]);
            }
        }
        for (int j=i; j<m; j++) {
            if (!maxHeap.isEmpty()) {
                if (A[j] > maxHeap.peek())
                    minHeap.add(A[j]);
                else
                    maxHeap.add(A[j]);
            } else {
                maxHeap.add(A[j]);
            }
        }

        m = minHeap.size();
        n =  maxHeap.size();
        if ((m + n) % 2 != 0) {
            if (m > n)
                return minHeap.element();
            else
                return maxHeap.element();
        } else {
            return (minHeap.element() + maxHeap.element()) / 2.0;
        }
    }
}
