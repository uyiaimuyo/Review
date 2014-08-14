import java.util.Scanner;

/**
 * Created by Aysar on 4/8/2014.
 */
public class BinarySearchST <Key extends Comparable<Key>, Value> {
    private static final int INIT_CAPACITY = 2;
    private Key[] keys;
    private Value[] values;
    private int n;

    public BinarySearchST() { this(INIT_CAPACITY); }
    public BinarySearchST(int c) {
        keys = (Key[]) new Comparable[c];
        values = (Value[]) new Object[c];
        n = 0;
    }

    public void resize(int c) {
        Key[] tempk = (Key[]) new Comparable[c];
        Value[] tempv = (Value[]) new Object[c];

        for (int i=0; i<n; n++) {
            tempk[i] = keys[i];
            tempv[i] = values[i];
        }
        keys = tempk;
        values = tempv;
    }

    public boolean contains(Key k) {
        return get(k) != null;
    }

    public Value get(Key k) {
        if (isEmpty())
            return null;
        int i = rank(k);
        if (i < n && keys[i].compareTo(k) == 0) return values[i];
        return null;
    }

    // returns the # of keys that are less than given key
    public int rank(Key k) {
        int lo = 0, hi = n-1;
        while (lo <= hi) {
            int mid = lo + (hi-lo)/2;
            if (keys[mid].compareTo(k) < 0) { // search left
                hi = mid - 1;
            } else if (keys[mid].compareTo(k) > 0) { // search right
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return lo;
    }

    public void put(Key k,Value v) {
        if (v == null) { delete(k); return;}
        int i = rank(k);

        if (i<n && keys[i].compareTo(k) == 0) {
            values[i] = v;
            return;
        }

        if (n == keys.length) resize(2*n);
        keys[i] = k;
        values[i] = v;
        n++;
    }

    public void delete(Key k) {
        if (isEmpty()) return;

        int i = rank(k);
        if (i >= n || keys[i].compareTo(k) !=0) { // key not in table
            return;
        }

        keys[i] = null;
        values[i] = null;

        n--;
        if (n>0 && n == keys.length/4) resize(n/2);
    }

    public int size() { return n; }
    public boolean isEmpty() { return n==0; }

    public static void main(String[] args) {
        BinarySearchST<String, Integer> bsst = new BinarySearchST<String, Integer>();
        Scanner stdin = new Scanner(System.in);
        int i =0;
        while(!stdin.nextLine().equals("end")) {
            bsst.put(stdin.nextLine(), i);
            i++;
        }
        for (String s: bsst.keys) {
            System.out.println(s + " " + bsst.get(s));
        }
    }
}
