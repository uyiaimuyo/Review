/**
 * Created by Aysar on 8/22/2014.
 *
 * Uses the contraction algorithm
 */
public class MinimumCut {

    public static void main(String args[]) {
        Graph g = new Graph(4, false);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,2);
        g.addEdge(1,3);
        g.addEdge(2,3);
        System.out.println(determine(g));
    }

    private static Graph determine(Graph g) {
        for (int i=0; i<g.V(); i++) {
            if (g.adj(i).size() > 0) {
                int m = g.adj(i).root();
                if (g.getAll().contains(g.adj(m))) {
                    g.mergeV(i, m);
                }
            }
        }
        return g;
    }
}
