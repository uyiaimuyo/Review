/**
 * Created by Aysar on 12/22/2014.
 *
 * Given two sorted arrays A, B of size m and n respectively. Find the k-th smallest
 * element in the union of A and B. You can assume that there are no duplicate elements.
 */
public class KthSmallestElementTwoSortedArrays {

    int findKthSMallest(int[] A, int[] B, int k) {
        int a_offset = 0, b_offset = 0;
        if (A.length + B.length < k) return -1;

        // traverse both arrays at same time, the pointer with smaller value goes next element
        // quit once we have make k steps
        while (true) {
            if (a_offset < A.length) {
                while (b_offset == B.length ||
                        A[a_offset] <= B[b_offset]) {
                    a_offset++;
                    if (a_offset + b_offset == k) return A[a_offset];
                }
            }
            if (b_offset < B.length) {
                while (a_offset == A.length ||
                        A[a_offset] >= B[b_offset]) {
                    b_offset++;
                }
                if (a_offset + b_offset == k) return B[b_offset];
            }
        }
    }
}
