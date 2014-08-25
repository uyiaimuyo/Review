import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aysar on 8/18/2014.
 *
 * Graph data structure impl using adjacency list
 */
public class Graph {

    private int e;
    private List<Bag<Integer>> list;
    private boolean directed;

    public Graph(int v, boolean directed) {
        this.e = 0;
        this.directed = directed;
        list = new ArrayList<Bag<Integer>>(v);
        for (int i=0; i<v; i++) {
            list.add(i,new Bag<Integer>());
        }
    }

    public void addEdge(int v, int w) {
        if (!directed)
            list.get(w).add(v);
        list.get(v).add(w);
        e++;
    }

    public void removeEdge(int v, int w) {
        if (!directed)
            list.get(w).remove(v);
        list.get(v).remove(w);
        e--;
    }

    public void mergeV(int v, int w) {
        Bag<Integer> b = list.get(w);
        for (int i : b) {
            addEdge(v, i);
            removeEdge(w,i);
        }
    }

    public List<Bag<Integer>> getAll() {
        return list;
    }

    public int getVertex(Bag<Integer> v) {
        return list.indexOf(v);
    }

    public void addVertex(int v) {
        if (v < list.size()) return;
        list.add(v, new Bag<Integer>());
    }

    public Bag <Integer> adj(int v) {
        return list.get(v);
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        String NEWLINE = System.getProperty("line.separator");
        int i=0;
        for (Bag<Integer> b: list) {
            s.append(i+" : ");
            for (Integer x: b) {
                s.append(x+" ");
            }
            s.append(NEWLINE);
            i++;
        }
        return s.toString();
    }

    public int V() { return list.size(); }
    public int E() { return e; }

    public static void main(String[] args) {
        Graph g = new Graph(3, false);
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addVertex(3);
        System.out.println(g.toString());
    }
}