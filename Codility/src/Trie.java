import java.util.*;

/**
 * Created by Aysar on 12/7/2014.
 *
 * Tries are great for information reTRIEval, the following is an alphabet
 * trie impl.  Tries provide optimal search complexity (o(n)) when looking for a key/string
 * amongst a large set of strings or looking for substring in a large string of length n.
 */
public class Trie {

    private final int ALPHABET_SIZE = 26;
    public class Node {
        int value; //denotes leaf or not
        Node[] children;

        public Node() {
            this.value = 0;
            this.children =new Node[ALPHABET_SIZE];
        }
    }

    Node root;
    int count;

    public Trie() {
        this.root =  new Node();
        this.count = 0;
    }

    public void add(String key) {
        key = key.toLowerCase();
        Node curr = root;
        this.count++;
        for(int i=0; i<key.length(); i++) {
            int c = key.charAt(i) - 'a';
            if (curr.children[c] == null) {
                Node n = new Node();
                curr.children[c] = n;
            }
            curr = curr.children[c];
        }
        curr.value = count;
    }

    public boolean search(String key) {
        key = key.toLowerCase();
        Node curr = root;
        this.count++;
        for (int i=0; i<key.length(); i++) {
            int c = key.charAt(i) - 'a';
            if (curr.children[c] == null)
                return false;
            curr = curr.children[c];
        }
        return (curr.value != 0);
    }

    // level order/preorder print
    public String toString(Node r, String indent, char letter) {
        String s = "";

        String newIndent;
        if (indent.equals("")) {
            newIndent = "  ";
        } else {
            newIndent = "  " + indent;
        }

        if (r.value != 0) {
            s = s + indent + letter + ":" + r.value + "\n";
        } else {
            s = s + indent + letter + "\n";
        }
            for (int i = 0; i < ALPHABET_SIZE; i++) {
                if (r.children[i] != null)
                    s = s + toString(r.children[i], newIndent, (char) ('a' + i));
            }
        return s;
    }

    public static void main(String[]args) {
        Trie t = new Trie();
        String[] keys = { "A", "ans", "and", "Pineapple"};
        for(int i =0; i<keys.length; i++) {
            t.add(keys[i]);
        }
        System.out.println(t.toString(t.root, "", 'r'));
        System.out.println(t.search("pineapple"));
    }
}
