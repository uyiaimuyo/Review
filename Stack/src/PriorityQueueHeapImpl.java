import java.util.NoSuchElementException;

/**
 * Created by Aysar on 4/7/2014.
 */
public class PriorityQueueHeapImpl <Item extends Comparable<Item>> {
    private Node<Item>[] pq;
    private int n;

    public class Node<Item> {
        private Item item;
        private int k;
        public Node(int k, Item i){
            this.k = k;
            this.item = i;
        }
    }

    private boolean less(int i, int j) {
        return (pq[i].item.compareTo(pq[j].item) < 0);
    }

    public PriorityQueueHeapImpl(int c) {
        pq = (Node<Item>[]) new Comparable[c]; // TODO: bug here due to Java generics limitations :/
        n = 0;
    }

    public Node<Item> max() {
        if (isEmpty()) throw new NoSuchElementException();
        return pq[1];
    }

    public void insert(int k,Item item) {
        Node<Item> newItem = new Node<Item>(k,item);
        n++;
        pq[n] = newItem;
        swim(n);
    }

    private void swim(int n) {
        while(n > 1) {
            if (less(n/2,n)) {
                Node<Item> swap = pq[n/2];
                pq[n/2] = pq[n];
                pq[n] = swap;
            }else  {
                break;
            }
            n = n/2;
        }
    }

    public Node<Item> delMax() {
        if (isEmpty()) throw new NoSuchElementException();

        Node<Item> removed = pq[1];
        pq[1] = pq[n-1];
        sink(1);
        n--;
        return removed;
    }

    private void sink(int k) {
        while(k*2 <= n) {
            if (pq[k*2].item.compareTo(pq[k].item) > pq[k*2+1].item.compareTo(pq[k].item)) { // left child is greater
                Node<Item> swap = pq[k];
                pq[k] = pq[k*2];
                pq[k*2] = swap;

                k=k*2;
            } else if (pq[k*2].item.compareTo(pq[k].item) < pq[k*2+1].item.compareTo(pq[k].item)) { // right child
                Node<Item> swap = pq[k];
                pq[k] = pq[k*2+1];
                pq[k*2+1] = swap;

                k=k*2+1;
            } else {
                break;
            }
        }
    }

    public boolean isEmpty() { return n == 0;}

    public static void main(String[] args) {
        String[] strings = { "it", "was", "the", "best", "of", "times", "it", "was", "the", "worst" };

        PriorityQueueHeapImpl<String> pq = new PriorityQueueHeapImpl<String>(9);
        for (int i = 0; i < strings.length; i++) pq.insert(i, strings[i]);

        for (int i=0;i<strings.length; i++) {
            System.out.println(i + " " + strings[i]);
        }

        // delete and print each key
        while (!pq.isEmpty()) {
            int key = pq.max().k;
            String i = pq.delMax().item;
            System.out.println(i + " " + key);
        }
    }
}
