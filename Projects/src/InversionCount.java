import java.util.Arrays;

/**
 * Created by Aysar on 8/15/2014.
 *
 * Given an array, A, count the # of inversions = # of pairs (i,j) of array
 * such that i,j indices are i<j but A[i] > A[j]
 * 
 * Following is an nlogn solution, bruteforce is n^2
 */
public class InversionCount {

    public static void main(String args[]) {
        int [] a = {1,3,5,2,4,6};
        System.out.println(countInversions(a));
    }

    private static int countInversions(int[] a) {
        if (a.length == 1)
            return 0;

        int [] b= Arrays.copyOfRange(a,0,a.length/2);
        int x = countInversions(b);
        int [] c= Arrays.copyOfRange(a, a.length / 2, a.length);
        int y = countInversions(c);

        int[] d = new int [a.length];
        int  j=0, k=0, z=0;
        for(int i=0; i<a.length; i++) {
            if (j == b.length) {
                d[i] = c[k];
                k++;
            } else if (k == c.length) {
                d[i] = b[j];
                j++;
            } else if (b[j] <= c[k]) {
                d[i] = b[j];
                j++;
            } else {
                d[i] = c[k];
                k++;
                z += b.length - j;
            }
        }
        return x + y + z;
    }
}
