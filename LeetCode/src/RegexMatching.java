/**
 * Created by Aysar on 11/15/2014.
 *
 * '?' Matches any single character.
 '*' Matches any sequence of characters (including the empty sequence).

 The matching should cover the entire input string (not partial).

 The function prototype should be:
 bool isMatch(const char *queue, const char *p)
 Some examples:
 isMatch("aa","a") → false
 isMatch("aa","aa") → true
 isMatch("aaa","aa") → false
 isMatch("aa", "*") → true
 isMatch("aa", "a*") → true
 isMatch("ab", "?*") → true
 isMatch("aab", "c*a*b") → false
 */
public class RegexMatching {

    public static void main(String []args) {
        System.out.println(isMatch("aab", "c*a*b"));
    }

    private static boolean isMatch(String s, String p) {
        int i=0, j = 0;
        int star_i = -1, star_j = -1;
        while(i<s.length()) {
            // basically a greedy approach, leave * to the end to be evaluated
            if (j < p.length() && s.charAt(i) == p.charAt(j)) {
                i++; j++;
                continue;
            }
            if (j < p.length() && p.charAt(j) == '?') {
                i++; j++;
                continue;
            }
            if (j < p.length() && p.charAt(j) == '*') {
                star_i = i;
                star_j = j;
                j++;
                continue;
            }
            if (star_j != -1) {
                i = star_i++;
                j = star_j + 1;
                continue;
            }
            return false;
        }
        while (j < p.length() && p.charAt(j) == '*') {
            j++;
        }

        return j == p.length();
    }
}
