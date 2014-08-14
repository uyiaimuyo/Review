import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Aysar on 4/5/2014.
 */
public class QueueImpl<Item> implements Iterable<Item> {
    private int size;
    private Node<Item> first;
    private Node<Item> last;

    public class Node<Item> {
        private Item item;
        private Node<Item> next;
    }
    public QueueImpl() {
        first = null;
        last = null;
        size = 0;
    }

    public void enqueue(Item item) {
        Node<Item> oldLast = last;
        last = new Node<Item>();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        size++;
    }

    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException();
        Item item = first.item;
        first = first.next;
        size--;
        return item;

    }

    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException();
        return last.item;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item: this) {
            s.append(item + " ");
        }
        return s.toString();
    }

    public Iterator<Item> iterator() {
        return new ListIterator<Item>(first);
    }

    public class ListIterator<Item> implements Iterator<Item> {
        private Node<Item> current;
        public ListIterator(Node<Item> first){
            current = first;
        }
        public boolean hasNext() { return current != null; }
        public void remove() { throw new UnsupportedOperationException();}
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args) {
        QueueImpl<Integer> q = new QueueImpl<Integer>();
        QueueImpl<Integer> e = new QueueImpl<Integer>();
        int m = 2;
        int n = 7;

        for (int i=0; i<=n; i++) {
            q.enqueue(i);
        }

        for (int j=0; j<=n; j++) {
            if (j % m == 0) { // person is eliminated
                e.enqueue(q.dequeue());
            } else {
                q.dequeue();
            }
        }

        for (int i : e) {
            System.out.print(i+ " ");
        }
    }
}
