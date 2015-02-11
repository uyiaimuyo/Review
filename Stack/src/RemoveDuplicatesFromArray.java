import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by Aysar on 1/5/2015.
 */
public class RemoveDuplicatesFromArray {

    public int[] removeDupes(int[] a) {
        HashSet<Integer> h = new HashSet<Integer>();

        for (int i=0; i<a.length;i++) {
            h.add(a[i]);
        }
        int [] b = new int[h.size()];
        int j = 0;
        for (Integer k: h) {
            b[j] = k;
            j++;
        }
        return b;
    }

    public int[] removeDuplicates(int[] a) {
        if (a.length < 2)
            return a;

        int i=0;
        int j=1;
        while( j < a.length ) {
            if (a[i] == a[j])  {
                j++;
            } else {
                i++;
                a[i] = a[j];
                j++;
            }
        }

        int [] b = Arrays.copyOf(a, i + 1);
        return b;
    }
}
