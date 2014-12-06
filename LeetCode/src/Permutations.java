import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aysar on 12/5/2014.
 *
 * Below are the permutations of string ABC.
 ABC, ACB, BAC, BCA, CAB, CBA
 */
public class Permutations {
    public static void permute(String s, int i, int j) {
        if (i == j) {
            System.out.println(s);
            return;
        }
        char[] sc = s.toCharArray();
        for(int k=i; k <= j; k++) {
            char sci = sc[i];
            sc[i] = sc[k];
            sc[k] = sci;
            permute(new String(sc), i+1, j);
            sci = sc[i];
            sc[i] = sc[k];
            sc[k] = sci;
        }
    }

    public static void main(String[] args) {
        permute("ABC", 0, 2);
    }
}
