import java.util.Stack;

/**
 * Created by Aysar on 8/22/2014.
 */
public class DepthFirstSearch {

    public static void main(String args[]) {
        Graph g = new Graph(7, false);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,3);
        g.addEdge(2,4);
        g.addEdge(2,3);
        g.addEdge(3,5);
        g.addEdge(4,5);
        System.out.println("The adjacent nodes are: "+search(g, 0, 0));

        Graph g2 = new Graph(4, true);
        g2.addEdge(0,1);
        g2.addEdge(0,2);
        g2.addEdge(1,3);
        g2.addEdge(2,3);
        System.out.println("The topological order is: ");
        topologicalSort(g2);
    }

    private static void topologicalSort(Graph g) {
        int currentNode = g.V()-1;
        for (int i=currentNode; i>=0; i--) {
            Bag<Integer> v = g.adj(i);
            if (!v.isFound()) {
                //do a DFS
                v.setFound();
                Stack<Bag<Integer>> stack = new Stack<Bag<Integer>>();
                stack.push(v);
                while( !stack.isEmpty()) {
                    Bag<Integer> x = stack.pop();
                    for (Integer j: x) {
                        Bag<Integer> y = g.adj(j);
                        if (!y.isFound()) {
                            y.setFound();
                            stack.push(y);
                        }
                    }
                    System.out.println("Node "+g.getVertex(x)+" is at "+currentNode);
                    currentNode--;
                }
            }
        }
    }

    private static Bag<Integer> search(Graph g, int i, int t) {
        Bag<Integer> v = g.adj(i);
        Bag<Integer> x = g.adj(t);
        v.setFound();
        Stack<Bag<Integer>> stack = new Stack<Bag<Integer>>();
        stack.push(v);
        while (!stack.isEmpty()) {
            Bag<Integer> b = stack.pop();
            if (b.equals(x)) return b;
            for (Integer s : b) {
                Bag<Integer> c = g.adj(s);
                if (!c.isFound()) {
                    c.setFound();
                    stack.push(c);
                }
            }
        }
        return null;
    }

}
