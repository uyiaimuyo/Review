import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Aysar on 4/9/2014.
 */
public class UniqueChar {

    public static void isUnique(String s) {
        Queue<Character> q = new LinkedList<Character>();
        for (int i=0; i<s.length(); i++) {
            if (!q.contains(s.charAt(i))) {
                q.add(s.charAt(i));
            } else {
                q.remove(s.charAt(i));
            }
        }
        System.out.println(q.remove());
    }

    public static void main(String[] args) {
        isUnique("abj2cbZ2daZ");
    }
}
