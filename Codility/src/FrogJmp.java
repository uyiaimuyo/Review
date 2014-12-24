/**
 * Created by Aysar on 9/12/2014.
 *
 * A small frog wants to get to the other side of the road.
 * The frog is currently located at position X and wants to get
 * to a position greater than or equal to Y. The small frog always
 * jumps a fixed distance, D. Count the minimal number of jumps that the
 * small frog must perform to reach its target.
 */
public class FrogJmp {
    public int solution(int X, int Y, int D) {
        if (X == Y)
            return 0;
        Y -= X;
        int s = Y / D;
        if ((s*D) < Y)
            s += ((Y % D) / D) + 1;
        System.out.println(s);
        return s;
    }

    public static void main(String args[]) {

    }
}
