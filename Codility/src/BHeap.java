import java.io.*;
import java.util.NoSuchElementException;
import java.util.Arrays;
import java.util.Scanner;

public class BHeap {
    public static void main(String args[] ) throws Exception {
        Scanner in = new Scanner(System.in);
        String type_str = in.next();

        BinaryHeap heap;
        boolean type = false;
        if (type_str.substring(0,type_str.indexOf("-")).equalsIgnoreCase("max")) {
            type = true;
        }

        String p = in.next();
        boolean intFlag = false;
        boolean doubleFlag = false;
        try {
            int intP = Integer.parseInt(p);
            heap = new BinaryHeap<Integer>(type);
            heap.insert(intP);
            intFlag = true;
        } catch (NumberFormatException e) {
            try {
                double doubleP = Double.parseDouble(p);
                heap = new BinaryHeap<Double>(type);
                heap.insert(doubleP);
                doubleFlag = true;
            } catch (NumberFormatException e2) {
                heap = new BinaryHeap<String>(type);
                heap.insert(p);
            }
        }

        while(in.hasNext()) {
            p = in.next();
            if (intFlag) {
                heap.insert(Integer.parseInt(p));
            } else if (doubleFlag) {
                heap.insert(Double.parseDouble(p));
            } else {
                heap.insert(p);
            }
        }

        while(!heap.isEmpty()) {
            System.out.println(heap.remove());
        }
    }
}

/*
  *   Uses an Array to implement a heap, where parent i's children
  *   are at 2i (left), 2i+1 (right)
  *   It can be configured to be a max heap by setting type
  *   property to true, otherwise its a min heap (default)
  */
class BinaryHeap <T extends Comparable<T>> {
    private static final int DEFAULT_CAPACITY = 12;
    private T[] A;
    private int n;
    private boolean type;

    public BinaryHeap(boolean type) {
        A = (T[]) new Comparable[DEFAULT_CAPACITY];
        n = 0;
        this.type = type;
    }

    public void insert(T item) {
        if (n >= (A.length -1)) {
            A = resize();
        }
        n++;
        A[n] = item;
        swim(n);
    }

    private void swim(int pos) {
        while (pos > 1) {
            if (compare(pos/2, pos)) {
                swap(pos/2, pos);
            } else {
                break;
            }
            pos = pos/2;
        }
    }

    public T remove() {
        if (isEmpty()) throw new IllegalStateException();
        T result = peek();
        A[1] = A[n];
        A[n] = null;
        n--;
        sink(1);
        return result;
    }

    private void sink(int pos) {
        while (2*pos <= n) {
            int smallerChild = 2*pos;
            if (((2*pos) + 1) <= n && compare(2*pos, (2*pos) + 1)) {
                smallerChild = (2*pos) + 1;
            }
            if (compare(pos, smallerChild)) {
                swap(pos, smallerChild);
            } else {
                break;
            }
            pos = smallerChild;
        }
    }

    public T peek() {
        if (isEmpty()) throw new NoSuchElementException();
        return A[1];
    }

    public boolean isEmpty() {
        return n == 0;
    }

    private void swap(int i, int j) {
        T tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    private boolean compare(int i, int j) {
        if (type) {
            return (A[i].compareTo(A[j]) < 0);
        } else {
            return (A[i].compareTo(A[j]) > 0);
        }
    }

    private T[] resize() {
        return Arrays.copyOf(A, A.length * 2);
    }
}