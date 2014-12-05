import java.util.*;

/**
 * Created by Aysar on 12/5/2014.
 *
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support
 * the following operations: get and set.

 get(key) - Get the value (will always be positive) of the key if the key exists in the cache,
 otherwise return -1.
 set(key, value) - Set or insert the value if the key is not already present. When the cache
 reached its capacity, it should invalidate the least recently used item before inserting a new item.
 */
public class LRUCache {

    private Map<Integer, DLLNode> blocks = new HashMap<Integer, DLLNode>();
    private DLLNode head;
    private DLLNode tail;
    private int capacity;
    private int length;

    class DLLNode {
        DLLNode prev;
        DLLNode next;
        int data;
        int key;
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.length = 0;
        this.head = null;
        this.tail = null;
    }

    public int get(int key) {
        DLLNode node = blocks.get(key);
        if (node != null) {
            remove(node);
            addToHead(node);
            return node.data;
        }
        return -1;
    }

    private void remove(DLLNode node) {
        DLLNode prev = node.prev;
        DLLNode next = node.next;

        if (prev != null) {
            prev.next = next;
        } else {
            head = next;
        }

        if (next != null) {
            next.prev = prev;
        } else {
            tail = prev;
        }
    }

    private void addToHead(DLLNode node) {
        node.prev = null;
        node.next = head;
        if (head != null) {
            head.prev = node;
        }
        head = node;
        if (tail == null)
            tail = node;
    }

    public void set(int key, int value) {
        DLLNode node = new DLLNode();
        node.data = value;
        node.key = key;
        if (blocks.containsKey(key)) {
            remove(blocks.get(key));
            blocks.put(key, node);
        } else {
            if (length >= capacity) {
                blocks.remove(tail.key);
                tail = tail.prev;
                if (tail != null)
                    tail.next = null;
                length--;
            }

            length++;
            blocks.put(key, node);
        }
        addToHead(node);
    }

    public static void main(String[] args) {
        LRUCache c = new LRUCache(1);
        c.set(2,1);
        System.out.println(c.get(2));
        c.set(3,2);
        System.out.println(c.get(2));
        System.out.println(c.get(3));
    }
}
