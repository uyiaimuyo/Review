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

        int[] final_array = new int[a.length];
        int[] a_fh = sort(Arrays.copyOfRange(a,0,a.length/2));
        int[] a_sh = sort(Arrays.copyOfRange(a,a.length/2,a.length));
        int j=0, k=0;
        for (int i=0; i < final_array.length; i++) {
            if (a_fh[k] < a_sh[j]) {
                final_array[i] = a_fh[k];
                if (k == (a_fh.length-1)) {
                    final_array = concat(final_array, i+1, a_sh, j);
                    break;
                }
                k++;
            } else {
                final_array[i] = a_sh[j];
                if  (j == (a_sh.length-1)) {
                    final_array = concat(final_array,i+1, a_fh, k);
                    break;
                }
                j++;
            }
        }
        return final_array;
    }

    private static int[] concat(int[] final_array, int start_index, int[] a2, int a2_start_index) {
        int j = a2_start_index;
        for (int i=start_index;i< final_array.length ;i++ ) {
            final_array[i] = a2[j];
            j++;
        }
        return final_array;
    }
}
