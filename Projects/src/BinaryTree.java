
/**
 * Created by Aysar on 8/25/2014.
 */
public class BinaryTree <Key extends Comparable<Key>, Value> {
    private Node<Key, Value> root;

    private class Node<Key, Value> {
        private Key key;
        private Value value;
        private int size;
        private Node<Key,Value> parent;
        private Node<Key,Value> left;
        private Node<Key,Value> right;

        public Node() {
            value = null;
            parent = null;
            left = null;
            right = null;
            size = 0;
        }

        public void size(int change) {
            size += change;
            if (parent != null)
                parent.size(change);
        }
    }

    public BinaryTree() {
        root = null;
    }

    public Node<Key,Value> search(Key key) {
        if (root == null) throw new RuntimeException("Null root");
        Node<Key,Value> current = root;
        while (current != null) {
            if (key.compareTo(current.key) == 0) {
                return current;
            } else if (key.compareTo(current.key) < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return current;
    }

    public void insert(Key key) {
        Node<Key,Value> current = root;
        Node<Key,Value> newItem = new Node<Key,Value>();
        newItem.key = key;
        newItem.parent = null;
        while (current != null) {
            if (key.compareTo(current.key) < 0) {
                if (current.left == null) {
                    current.left = newItem;
                    newItem.parent = current;
                    current.size(1);
                    newItem.size = 1;
                    return;
                }
                current = current.left;
            } else if (key.compareTo(current.key) > 0) {
                if (current.right == null) {
                    current.right = newItem;
                    newItem.parent = current;
                    current.size(1);
                    newItem.size = current.size - 1;
                    return;
                }
                current = current.right;
            } else {
                return;
            }
        }
        root = newItem;
        root.size++;
    }

    public void remove(Node<Key,Value> current) {
        if (current == null) throw new RuntimeException("no such element");
        Node<Key,Value> parent = current.parent;
        if (current.left == null && current.right == null) {
            current.size(-1);
            if (parent.left == current)
                parent.left = null;
            else
                parent.right = null;
        } else if (current.left == null && current.right != null) {
            current.key = current.right.key;
            current.left = current.right.left;
            current.right = current.right.right;
            current.size(-1);
        } else if (current.left != null && current.right == null) {
            current.key = current.left.key;
            current.left = current.left.left;
            current.right = current.left.right;
            current.size(-1);
        } else {
            Node<Key,Value> p = predecessor(current.key);
            current.key = p.key;
            remove(p);

        }
    }

    public int height (Node<Key,Value> node) {
        if (node == null) return -1;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    public String output(Node<Key,Value> node) {
        if (node == null) return "";
        return output(node.left) + ", " + node.key + ", " + output(node.right);
    }

    public Node<Key,Value> predecessor(Key key) {
        Node<Key,Value> node = search(key);
        if (node == null) return null;
        if (node.left != null) {
            node = node.left;
            while (node.right != null) {
                node = node.right;
            }
        } else {
            node = node.parent;
            while (node.key.compareTo(key) > 0) {
                node = node.parent;
            }
        }
        return node;
    }

    public Key min() {
        Node<Key,Value> current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current.key;
    }

    public Key max() {
        Node<Key,Value> current = root;
        while (current.right != null) {
            current = current.right;
        }
        return current.key;
    }

    public int size(Node<Key,Value> node){
        return node.size;
    }

    public Node<Key,Value> root(){
        return root;
    }

    public Node<Key,Value> select(Node<Key,Value> node, int i) {
        if (node == null) return null;
        if (node.left != null) {
            if (node.left.size == (i - 1)) {
                return root;
            } else if (node.left.size >= i) {
                return select(node.left, i);
            }
        }
            if (i == 1) {
                return root;
            } else {
                return select(node.right, i - node.left.size - 1);
            }
    }

    public static void main(String args[]){
        BinaryTree<Integer, Integer> bst = new BinaryTree<Integer, Integer>();
        bst.insert(3);
        bst.insert(1);
        bst.insert(5);
        bst.insert(2);
        bst.insert(4);
        bst.insert(26);
        bst.insert(99);
        bst.insert(19);
        bst.insert(100);
        bst.remove(bst.search(99));
        bst.remove(bst.search(3));
        System.out.println(bst.output(bst.root));
        System.out.println("Height: "+bst.height(bst.root));
        System.out.println("Size: "+bst.size(bst.root));
        System.out.println("Min: "+bst.min());
        System.out.println("Max: "+bst.max());
        System.out.println("Predecessor to root: "+bst.predecessor(bst.root.key).key);
        System.out.println("Select: "+bst.select(bst.root, 3).key);
    }

}
