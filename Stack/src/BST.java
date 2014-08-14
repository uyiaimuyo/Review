/**
 * Created by Aysar on 4/8/2014.
 */
public class BST <Key extends Comparable<Key>,Value>  {
    private Node root;
    public class Node {
        private Key key;
        private Value value;
        private int n;
        private Node left, right;

        public Node(Key k, Value v, int n) {
            key = k;
            value = v;
            this.n = n;
        }
    }

    public Value get(Node x, Key k) {
        if (x == null) return null;
        if(k.compareTo(x.key) < 0) {
            return get(x.left, k);
        } else if(k.compareTo(x.key) > 0) {
            return get(x.right, k);
        } else {
            return x.value;
        }
    }

    public void put(Node x, Key k, Value v) {
        if (x == null) {
            return;
        }
        if (k.compareTo(x.key) < 0) {
            put(x.left, k, v);
            x.left = new Node(k, v, 1);
        } else if (k.compareTo(x.key) > 0) {
            put(x.right, k, v);
            x.right = new Node(k, v, 1);
        } else {
            x.value = v;
        }
    }

    public boolean isEmpty() { return size(root) == 0;}
    public int size() { return size(root); }
    public int size(Node node) {
        if (node == null) return 0;
        return node.n;
    }
}
