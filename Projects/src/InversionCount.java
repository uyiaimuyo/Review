import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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

    public static void main(String args[]) throws IOException {
//        int [] f = new int[100000];
//        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Aysar\\IdeaProjects\\Review\\Projects\\src\\IntegerArray.txt"));
//        try {
//            String line = br.readLine();
//            int i=0;
//            f[i] = Integer.parseInt(line.trim());
//            while (line != null) {
//                i++;
//                line = br.readLine();
//                if (line == null) {
//                    System.out.println("Null line");
//                } else {
//                    f[i] = Integer.parseInt(line.trim());
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            br.close();
//        }
        int [] a = {1,6,3,2,4,5};
        System.out.println(countInversions(a));
    }

    private static double countInversions(int[] a) {
        if (a.length == 1)
            return 0.0;

        int [] b= Arrays.copyOfRange(a, 0, a.length / 2);
        double x = countInversions(b);
        Arrays.sort(b);
        int [] c= Arrays.copyOfRange(a, a.length / 2, a.length);
        double y = countInversions(c);
        Arrays.sort(c);

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
                System.out.println(c[k]);
                k++;
                z += b.length - j;
            }
        }
        return x + y + z;
    }
}
