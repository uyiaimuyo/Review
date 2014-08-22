import java.util.Arrays;

/**
 * Created by Aysar on 8/16/2014.
 */
public class QuickSort {

    public static void main(String []args) {
        int[] a = {5,3,6,1,2};
        sort(a, 0 , a.length-1);
        System.out.println(Arrays.toString(a));
    }

    private static void sort(int[] a, int l, int r) {
        if (l > r)
            return ;
        int p = a[l];
        int s, i=l, j=r;
        while (i < j) {
            while (a[++i] < p)
                if (i == r) break;
            while (a[--j] > p)
                if (j == l) break;
            if (i>=j) break;
            s = a[j];
            a[j] = a[i];
            a[i] = s;
        }
        a[l] = a[j];
        a[j] = p;

        sort (a, l, j-1);
        sort (a, j+1, r);
    }
}
