import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Aysar on 8/18/2014.
 */
public class BreadthFirstSearch {

    public static void main(String args[]) {
        Graph g = new Graph(7, false);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,3);
        g.addEdge(2,4);
        g.addEdge(2,3);
        g.addEdge(3,5);
        g.addEdge(4,5);
        System.out.println("The adjacent nodes are: "+search(g, 0, 4));

        Graph g2 = new Graph(7, false);
        g2.addEdge(0,1);
        g2.addEdge(0,2);
        g2.addEdge(1,3);
        g2.addEdge(2,4);
        g2.addEdge(2,3);
        g2.addEdge(3,5);
        g2.addEdge(4,5);
        System.out.println("The node is at a distance of "+dist(g2, 0, 5)+" from the source node.");

        Graph g3 = new Graph(7, false);
        g3.addEdge(0,1);
        g3.addEdge(0,2);
        g3.addEdge(1,3);
        g3.addEdge(2,4);
        g3.addEdge(2,3);
        g3.addEdge(3,5);
        g3.addEdge(4,5);
        System.out.println("The node is at a distance of "+dist(g3, 1, 3)+" from the source node.");

        Graph g4 = new Graph(10, false);
        g4.addEdge(0,2);
        g4.addEdge(0,4);
        g4.addEdge(2,4);
        g4.addEdge(4,6);
        g4.addEdge(4,8);

        g4.addEdge(1,3);

        g4.addEdge(5,7);
        g4.addEdge(7,9);
        g4.addEdge(5,9);
        System.out.println("There are "+ determineUnconnected(g4)+" unconnected clusters.");
    }

    private static int determineUnconnected(Graph g4) {
        int c = 0;
        for (int i =0 ; i<g4.V(); i++) {
            Bag<Integer> s = g4.adj(i);
            if (!s.isFound()) {
                c++;
                s.setFound();
                Queue<Bag<Integer>> q = new LinkedList<Bag<Integer>>();
                q.add(s);
                while (!q.isEmpty()) {
                    Bag<Integer> v = q.remove();
                    for (Integer j : v) {
                        Bag<Integer> x = g4.adj(j);
                        if (!x.isFound()) {
                            x.setFound();
                            q.add(x);
                        }
                    }
                }
            }
        }
        return c;
    }

    private static Bag<Integer> search(Graph g, int s, int t) {
        Bag<Integer> v = g.adj(s);
        Bag<Integer> x = g.adj(t);
        v.setFound();
        Queue<Bag<Integer>> q = new LinkedList<Bag<Integer>>();
        q.add(v);
        while (!q.isEmpty()) {
            v = q.remove();
            if (v.equals(x)) return v;
            for (Integer i: v) {
                Bag<Integer> w = g.adj(i);
                if (!w.isFound()) {
                    w.setFound();
                    q.add(w);
                }
            }
        }
        return null;
    }

    private static int dist(Graph g, int s, int t) {
        Bag<Integer> v = g.adj(s);
        Bag<Integer> x = g.adj(t);
        v.setFound();
        int[] layer = new int[g.V()];
        layer[s] = 0;
        Queue<Bag<Integer>> q = new LinkedList<Bag<Integer>>();
        q.add(v);
        while (!q.isEmpty()) {
            v = q.remove();
            if (v == x) return layer[t];
            for (Integer i: v) {
                Bag<Integer> w = g.adj(i);
                if (!w.isFound()) {
                    w.setFound();
                    q.add(w);
                    layer[i] = layer[g.getVertex(v)] + 1;
                }
            }
        }
        return -1;
    }
}
