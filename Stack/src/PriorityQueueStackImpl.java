/**
 * Created by Aysar on 4/7/2014.
 */
public class PriorityQueueStackImpl <Item extends Comparable<Item>> {
    private Item[] q;
    private int n;

    public PriorityQueueStackImpl(int capacity){
        q = (Item[]) new Comparable[capacity];
        n = 0;
    }

    public boolean isEmpty(){ return n == 0;}
    public int size() { return n; }
    public void insert(Item i){
        q[n++] = i;
    }
    public Item deleteMax() {
        int max =0;
        for (int i=1; i<n-1; i++) {
            if (less(max,i)){
                max = i;
            }
        }
        Item swap = q[max];
        q[max] = q[n-1];
        q[n-1] = swap;
        n--;
        return swap;
    }

    private boolean less(int i, int j) {
        return (q[i].compareTo(q[j]) < 0);
    }

    public static void main(String[] args) {
        PriorityQueueStackImpl<String> pq = new PriorityQueueStackImpl<String>(10);
        pq.insert("this");
        pq.insert("is");
        pq.insert("a");
        pq.insert("test");
        while (!pq.isEmpty())
            System.out.println(pq.deleteMax());
    }

}
