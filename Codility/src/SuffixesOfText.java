import java.util.Arrays;

/**
 * Created by Aysar on 12/7/2014.
 */
public class SuffixesOfText {

    public static String[] generate(String str, String[] a) {
        if (str.length() == 0)
            return a;
        String[] b = new String[a.length+1];
        String [] strA = {str};
        System.arraycopy(a, 0, b, 0, a.length);
        System.arraycopy(strA, 0, b, 0, 1);
        return generate(str.substring(1), b);
    }

    public static void main(String[] args) {
        String s = "banana";
        String[] a = new String[1];
        System.out.println(Arrays.toString(generate(s, a)));

        // build a suffix trie from the suffixes
        // then search
    }
}
