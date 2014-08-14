/**
 * Created by Aysar on 4/8/2014.
 */
public class ClockwiseMatrix {

    public static void printMatrixClockwise(int [][]a, int width) {
        int start_row=0, start_col=0;
        int end_row=width, end_col=width;

        while(start_col < end_col && start_row < end_col ) {
            int r=start_row ,c =start_col;

            while (c < end_col) {
                System.out.print(" " + a[r][c]+ " ");
                c++;
            }
            c--;
            r++;
            while (r < end_row) {
                System.out.println("\n"+a[r][c]);
                r++;
            }
            r--;
            c--;
            while (c >= start_col) {
                System.out.print(" "+a[r][c]+" ");
                c--;
            }
            c++;
            r--;
            while (r > start_row) {
                System.out.println("\n"+a[r][c]);
                r--;
            }
            start_row++;
            start_col++;
            end_row--;
            end_col--;
        }
    }
    public static void main(String[] args) {
        int [] a = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
        int width = 4;
        // turn it into a 2d matrix first
        int [][] a2d = new int[width][width];
        for (int r=0; r<width;r++) {
            for (int c=0; c<width; c++) {
                a2d[r][c] = a[c%width+r*width];
            }
        }
        printMatrixClockwise(a2d, width);
    }
}
