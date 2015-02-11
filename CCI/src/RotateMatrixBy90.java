/**
 * Created by Aysar on 2/11/2015.
 *
 * Given an image represented by an NxN matrix, where each pixel in the image is 4
 * bytes, write a method to rotate the image by 90 degrees. Can you do this in place?
 *
 * Basically a transpose
 */
public class RotateMatrixBy90 {

    //inplace solution
    public static void rotate(int[][] m) {
        int rLength = m.length;
        int layer = 0;
        while(layer < (rLength / 2)) {
            int len = rLength - 1 - layer;
            // do all 4 corners in each iteration
            // while starting from outer most layer and going in
            for(int c=layer; c < len; c++) {
                int offset = c-layer;
                int tr = m[layer+offset][len];
                m[layer+offset][len] = m[layer][c];

                int br = m[len][len-offset];
                m[len][len-offset] = tr;

                int bl = m[len-offset][layer];
                m[len-offset][layer] = br;

                m[layer][c] = bl;
            }
            layer++;
        }
    }

    public static void main(String[] args) {
        int[][] m = {{1,2,3},{4,5,6},{7,8,9}};
        rotate(m);
        for(int i=0; i<m.length;i++){
            for(int j=0; j<m[i].length;j++) {
                System.out.print(m[i][j]);
            }
            System.out.println();
        }
    }
}
