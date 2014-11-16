import java.util.Arrays;

/**
 * Created by Aysar on 11/15/2014.
 *
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 */
public class MergeSortedArray {

    public static void main(String[] args){
        int[] A = {1,0};
        int[] B = {2};
        merge(A,2,B,B.length);
        System.out.println(Arrays.toString(A));
    }

    private static void merge(int[] A, int m, int[] B, int n) {
        for (int i=0, j=0; i<A.length; i++) {
            if (j == n)
                break;
            if (A[i] > B[j]) {
                int l = m + j;
                while(l > i) {
                    A[l] = A[l-1];
                    l--;
                }
                A[i] = B[j];
                j++;
            } else if (A[i] == 0) {
                A[i] = B[j];
                j++;
            }
        }
    }
}
