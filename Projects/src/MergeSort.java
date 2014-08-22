import java.util.Arrays;

/**
 * Created by Aysar on 8/15/2014.
 */
public class MergeSort {

    public static void main(String args[]) {
        int[] a = {2,1230,90,10,1,23,5,34240,9,11};
        System.out.println(Arrays.toString(sort(a)));
    }

    private static int[] sort(int[] a) {
        if (a.length == 1)
            return a;

        int []b = sort(Arrays.copyOfRange(a, 0, a.length/2));
        int []c = sort(Arrays.copyOfRange(a, a.length/2, a.length));
        int [] d = new int[a.length];

        int j=0, k=0;
        for (int i =0; i<a.length; i++) {
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
            }
        }
        return d;
    }


}
