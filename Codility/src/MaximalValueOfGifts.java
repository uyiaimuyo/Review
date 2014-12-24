/**
 * Created by Aysar on 11/12/2014.
 * A board has n*m cells, and there is a gift with some value (value is greater than 0) in every
 * cell. You can get gifts starting from the top-left cell, and move right or down in each step,
 * and finally reach the cell at the bottom-right cell. What’s the maximal value of gifts you can
 * get from the board?
 */
public class MaximalValueOfGifts {

    public static void main(String[] ags) {
        int[][] g = {{1, 10, 3, 8},{12,2,9,6},{5,7,4,11},{3,7,16,5}};
        System.out.println(maximalValue(g));
    }

    private static int maximalValue(int[][] g) {
        int rows = g.length;
        int cols = g[0].length;
        int[][] maxGiftCells = new int[rows][cols];

        for (int i = 0;i<rows; i++) {
            for (int j=0; j<cols; j++) {
                int above = 0;
                int left = 0;
                if (i>0)
                    above = maxGiftCells[i-1][j];
                if (j>0)
                    left = maxGiftCells[i][j-1];
                maxGiftCells[i][j] = Math.max(above,left) + g[i][j];
            }
        }
        return maxGiftCells[rows-1][cols-1];
    }
}
