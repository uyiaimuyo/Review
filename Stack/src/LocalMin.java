import java.util.Arrays;

/**
 * Created by Aysar on 4/7/2014.
 */
public class LocalMin {

    public static int localMinArray(int[] a) {
        int min = Integer.MIN_VALUE;
        for (int i=0; i<a.length; i+=2) {
            if (a[i] < min) {
                min = a[i];
            } else if (i == 0) {
                if (a[i] < a[i+1]) min = a[i];
            } else if (i == a.length) {
                if (a[i] < a[i-1]) min = a[i];
            } else if (a[i] < a[i-1] && a[i] < a[i+1]) {
                min =  a[i];
            }
        }
        return min;
    }

    public static int localMinMatrix(int [][] m) {
        int min = Integer.MIN_VALUE;
        for (int r=1; r<m.length; r+=2) {
            for (int c=1; c<m[r].length; c+=2) {
                if (m[r][c] < min) {

                } else if (m[r][c] < m[r-1][c] && m[r][c] < m[r][c-1] &&
                        m[r][c] < m[r+1][c] && m[r][c] < m[r][c+1]) {
                    min = m[r][c];
                }
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] a = {2,5,6,1,3,0,9,68,25,10,348,4,22,34,51,-5,9};
        int[][] m = { {2,5,6,1,3},
                      {0,9,68,25,10},
                      {-5,348,4,22,34},
                      {51,5,9,99,39},
                      {13,58,92,77,12}};

        System.out.println(localMinArray(a));
        System.out.println(localMinMatrix(m));
    }
}
