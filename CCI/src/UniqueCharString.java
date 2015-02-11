import java.util.HashSet;
import java.util.Set;

/**
 * Created by Aysar on 2/11/2015.
 *
 * Implement an algorithm to determine if a string has all unique characters.
 * What if you can not use additional data structures?
 */
public class UniqueCharString {

    public static boolean isUniqueChar(String str) {
        Set<Character> s = new HashSet<Character>();
        for(int i=0; i<str.length(); i++) {
            if(s.contains(str.charAt(i))){
                return false;
            } else {
                s.add(str.charAt(i));
            }
        }
        return true;
    }

    public static boolean isUniqueCharFast(String str) {
        boolean[] charset = new boolean[256];
        for(int i=0; i<str.length(); i++) {
            int c = str.charAt(i);
            if (charset[c]) return false;
            charset[c] = true;
        }
        return true;
    }

    public static boolean isUniqueCharSlow(String str) {
        for(int i=0; i<str.length(); i++) {
            for(int j=i+1; j<str.length(); j++) {
                if (str.charAt(i) == str.charAt(j))
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isUniqueCharFast("abcdef"));
        System.out.println(isUniqueCharFast("abcc"));
        System.out.println(isUniqueCharFast("abcdaef"));
        System.out.println(isUniqueCharFast(""));
    }
}
