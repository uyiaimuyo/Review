import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aysar on 12/6/2014.
 * This is a solution for when you have nondistinct pairs that can be counted for
 */
public class FindPairsOfSum {

    public static void findPair(int[] arr, int sum) {
        if (arr.length==0)
            return;

        List<Integer> h = new ArrayList<Integer>();

        for(int i=0; i<arr.length; i++) {
            h.add(arr[i]);
        }

        int second = 0;
        for(int i=0; i<arr.length; i++) {
            second = sum - arr[i];
            if (h.contains(second)) {
                h.remove(h.indexOf(second));
                if (h.contains(arr[i])) {
                    System.out.println("(" + arr[i] + "," + second + ")");
                    return;
                }
                h.add(second);
            }
        }
        System.out.println("None");
        return;
    }

    public static void main(String[] args) {
        int[] arr = {5,3,5,9,10};
        findPair(arr, 12);
        findPair(arr, 6);
        findPair(arr, 5);
        findPair(arr, 19);
        findPair(arr, 7);
        findPair(arr, 10);
        findPair(arr, -5);
    }
}
