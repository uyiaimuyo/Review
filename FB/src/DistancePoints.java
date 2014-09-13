/**
 * Created by Aysar on 9/12/2014.
 *
 * Given a large (i.e. millions) set of 2D points and a small (i.e. hundreds)
 * integer k, write a function to return the k points closest to the point (0, 0).
 */
public class DistancePoints {

// Commented it out, because this was a 'rough idea' solution, not actual impl
// o(nlog(k))
//1. build a heap of first k points from n - o(k)
//2. (keep taking next points k+1, compare with heap root - logk) - n-k comparisons
/*    private HashSet<Point> large_set;

    public class Node<Item> {
        private int index;
        private Item distance;
        public Node(int index, Item distance) {
            this.index = index;
            this.distance = distance;
        }
    }

    public static void main(String args[]) {
        int k = 100; // input

        Heap<Node<Integer>> k_points = new Heap<Node<Integer>>(k);
        int distance = 0;
        for(int i=0; i<k; i++) {
            Point p = large_set.get(i);
            distance = Math.sqrt(p.x*p.x + p.y*p.y);
            Node<Integer> n = new Node<Integer>(i, distance);
            k_points.insert(n);
        }

        int large_set_size = large_set.size();
        for(int j = k+1; j<large_set_size; j++) {
            Point p = large_set.get(j);
            distance = Math.sqrt(p.x*p.x + p.y*p.y);
            if (distance <  k_points.extract_max()) {
                k_points.delete_max();
                Node<Integer> n = new Node<Integer>(j, distance);
                k_points.insert(n);
            }
        }
        System.out.println(k_points.toString());
    }*/
}
