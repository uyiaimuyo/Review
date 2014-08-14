/**
 * Created by Aysar on 4/5/2014.
 */
import java.util.*;

public class Stack<Item> implements Iterable<Item> {
    private int size;
    private Node<Item> root;

    public static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    public Stack() {
        root = null;
        size = 0;
    }

    public Stack(Stack<Item> s) {
        root = null;
        size = 0;

        Stack<Item> temp = new Stack<Item>();
        while(s.isEmpty())
            temp.push(s.pop());
        while(temp.isEmpty())
            this.push(temp.pop());
    }

     public void push(Item item) {
         Node<Item> pushed = new Node<Item>();
         pushed.item = item;
         pushed.next = root;
         root = pushed;
         size++;
     }

    public Item pop() {
        if (isEmpty()) throw new NoSuchElementException();
        Node<Item> poppedItem = root;
        root = root.next;
        size--;
        return poppedItem.item;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public Item peek() {
        return root.item;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item: this)
            s.append(item + " ");
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
        public void remove() { throw new UnsupportedOperationException();}
        public boolean hasNext() {
            return current != null;
        }
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args) {
        Stack<String> s = new Stack<String>();
        s.push("0");
        s.push("1");
        s.push("2");
        s.push("3");
        s.push("4");
        s.push("5");
        s.push("6");
        s.push("7");
        s.push("8");
        s.push("9");
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
    }
}
