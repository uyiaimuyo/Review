import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Aysar on 8/21/2014.
 */
public class Bag <Item> implements Iterable<Item> {

    private static class Node<Item> {
        private Item item;
        private Node<Item> next;

        private Node(Item item) {
            this.item = item;
        }
    }

    private int size;
    private Node<Item> root;

    public Bag() {
        size = 0;
        root = null;
    }

    public void add(Item item) {
        Node<Item> newNode = new Node<Item>(item);
        newNode.next = root;
        root = newNode;
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item r: this) {
            s.append(r+", ");
        }
        return s.toString();
    }

    public Iterator<Item> iterator() {
        return new ListIterator<Item>(root);
    }

    private class ListIterator<Item> implements Iterator<Item> {
        private Node<Item> current;
        public ListIterator(Node<Item> root) {
            current = root;
        }
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
        public boolean hasNext() { return current != null; }
        public void remove() { throw new UnsupportedOperationException();}
    }

    public static void main(String args[]) {
        Bag<Integer> b = new Bag<Integer>();
        b.add(1);
        b.add(2);
        b.add(3);

        for (Integer s : b ) {
            System.out.println(s);
        }
    }
}
