import java.util.Arrays;

/**
 * Created by Aysar on 11/15/2014.
 * NOT COMPLETE
 */
public class SetMatrixZeros {

    public static void main(String[] args) {
        int[][] m =
               {{0,0,0,5},
                {4,3,1,4},
                {0,1,1,4},
                {1,2,1,3},
                {0,0,1,1}};
        setZeros(m);
        for(int i = 0; i < m.length; i++)
        {
            for(int j = 0; j < m[i].length; j++)
            {
                System.out.print(m[i][j]);
                if(j < m[i].length - 1) System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void setZeros(int[][] matrix) {

        for(int r=0; r<matrix.length; r++) {
            for(int c=0; c<matrix[r].length; c++) {
                if (matrix[r][c] == 0) {
                    if (c < matrix[r].length-1) {
                        int cf = c + 1;
                        while (cf < matrix[r].length) {
                            matrix[r][cf] = 0;
                            cf++;
                        }
                    }
                    if (c > 0) {
                        int cr = c - 1;
                        while (cr >= 0) {
                            matrix[r][cr] = 0;
                            cr--;
                        }
                    }
                    if (r < matrix.length-1) {
                        int rf = r + 1;
                        while (rf < matrix.length) {
                            matrix[rf][c] = 0;
                            rf++;
                        }
                    }
                    if (r > 0) {
                        int rr = r - 1;
                        while (rr >= 0) {
                            matrix[rr][c] = 0;
                            rr--;
                        }
                    }
                    r++;
                }
            }
        }
    }
}
