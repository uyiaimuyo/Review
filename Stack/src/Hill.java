import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Aysar on 4/9/2014.
 */
public class Hill {

    private static List<Integer> asc = new ArrayList<Integer>();
    public static void findMin(int[] a) {
        if (a.length < 2) {
            System.out.println(a);
            return;
        }
        int[] aux = a.clone();
        sort(aux, 0, aux.length-1);

        if (aux.equals(a)) {
            System.out.println(aux[0]);
            return;
        }

        for (int i=0; i<aux.length; i++) {
            asc.clear();
             if (diff(aux[i], a)) {
                System.out.println(aux[i]);
                return ;
            }
        }
    }

    public static boolean diff(int difference, int[] a) {
        if (a.length == 1)  return true;
        int len = a.length-1;
        for (int i=0; i<=len ; i++) {
            if (diff(difference, Arrays.copyOfRange(a, i,len))) {
                for (int j=-1*Math.abs(difference); j<=difference; j++) {
                    for (int k=-1*Math.abs(difference); k<=difference; k++) {
                        if ((a[a.length-1]+j > a[a.length-2]+k) &&
//                                ((Collections.binarySearch(asc, a[a.length - 2] + k) == -1) &&
                                ((Collections.binarySearch(asc,a[a.length-1]+j) < 0))) {
                            if (a.length-2 == 0) // only do this for first element
                                asc.add(a[a.length-2]+k);
                            asc.add(a[a.length-1]+j);
                            return true;
                        }
                    }
                }
//                asc = new int[]{};
                return false;
            }
            return false;
        }
        return false;
    }

    public static void sort(int[] a, int lo, int hi) {
        if (lo >= hi) return;
        int p = a[lo];
        int i=lo, j=hi+1;

        while(true) {
            while(a[++i] < p) {
                if (i == hi) break;
            }
            while(a[--j] > p) {
                if (j == lo) break;
            }
            if (i>=j) break;
            int swap = a[i];
            a[i] = a[j];
            a[j] = swap;
        }
        int swap_p = a[lo];
        a[lo] = a[j];
        a[j] = swap_p;

        sort(a, lo, j-1);
        sort(a, j+1, hi);

    }

    public static void main(String[] args) {
        findMin(new int[]{5,4,3,2,8});
    }
}
