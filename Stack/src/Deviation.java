import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by Aysar on 4/9/2014.
 */
public class Deviation {

    public static void getDeviations(int[] v, int d) {
        PriorityQueue<Integer> h = compute(v, d);
        System.out.println(h.remove());
    }
    public static  PriorityQueue<Integer> compute(int[] v, int d) {
        PriorityQueue<Integer> h = new PriorityQueue<Integer>(20, Collections.reverseOrder());
        if (v.length == d) { // basecase
            Arrays.sort(v);
            h.add(v[d-1] - v[0]);
            return h;
        }

        for(int i=0; i<(v.length-d+1); i++) {
            h.add(compute(Arrays.copyOfRange(v, i, i + d), d).remove());
        }
        return h;
    }
    public static void main(String[] args) {
        getDeviations(new int[]{6,9,4,7,4,1,9,2,5},3);
    }
}