import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * Created by Aysar on 4/5/2014.
 */
public class DoublyLinkedList<Item> implements Iterable<Item> {
    private Node<Item> head;
    private Node<Item> last;
    private int n;

    public class Node<Item> {
        private Item item;
        private Node<Item> next;
        private Node<Item> prev;
    }

    public DoublyLinkedList() {
        head = new Node<Item>();
        last = new Node<Item>();
        head.next = last;
        last.prev = head;
    }

    public void add (Item item) {
        Node<Item> newNode = new Node<Item>();
        newNode.item = item;
        newNode.next = null;
        newNode.prev = last;
        last.next = newNode;
        last = newNode;
        n++;
    }

    public Item remove(int e) {
        if (isEmpty()) throw new NoSuchElementException();
        // 3 cases to cover
        Item removed = null;
        if (e == 0) {
            removed = head.item;
            head.next.prev = null;
            head = head.next;
            return removed;
        } else if (e == n-1) {
            removed = last.item;
            last.prev.next = null;
            last = last.prev;
            return removed;
        } else {
            Node<Item> current = head.next;
            for (int i=1; i<n-1; i++) {
                if (i == e) {
                    removed = current.item;
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                current = current.next;
            }
        }
        return removed;
    }

    public Iterator<Item> iterator() {
        return new ListIterator<Item>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Item next() {
                return null;
            }

            @Override
            public boolean hasPrevious() {
                return false;
            }

            @Override
            public Item previous() {
                return null;
            }

            @Override
            public int nextIndex() {
                return 0;
            }

            @Override
            public int previousIndex() {
                return 0;
            }

            @Override
            public void remove() {

            }

            @Override
            public void set(Item item) {

            }

            @Override
            public void add(Item item) {

            }
        };
    }
    public int size() {return n;}
    public boolean isEmpty() { return n==0;}
    public String toString(){
        StringBuilder s = new StringBuilder();
        for (Item item: this) {
            s.append(item + " ");
        }
        return s.toString();
    }

}
