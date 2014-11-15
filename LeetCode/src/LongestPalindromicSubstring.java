import java.util.HashMap;
import java.util.Map;

/**
 * Created by Aysar on 11/14/2014.
 *
 * Given a string S, find the longest palindromic substring in S. You may assume that
 * the maximum length of S is 1000, and there exists one unique longest palindromic substring.
 * Palindrome = same frontwards and backwards
 */
public class LongestPalindromicSubstring {

    public static void main (String args []) {
//        System.out.println(longestPalBruteForce("abaa"));
        System.out.println(longestPalDP("abb"));
    }

    private static String longestPalDP(String str) {
        if (str.isEmpty())
            return null;
        if (str.length() == 1)
            return str;

        // use a 2d matrix, p, where cols are indicies from i->j of string
        // and value is true if that substring (i->j) is a palindrome
        // basecase: p(i,i) = true (a one letter string is always a palindrome)
        // basecase: p(i,i+1) = true iff Si = Si+1
        // therefore p(i,j) = true iff p(i+1,j-1)=true AND Si=Sj is true
        boolean[][] p = new boolean[str.length()][str.length()];

        String longestPal = "";

        // solving for the basecases
        for (int i=0; i<str.length();i++) {
            p[i][i] = true;
            if ((i+1 < str.length()) && (str.charAt(i) == str.charAt(i+1))) {
                p[i][i+1] = true;
                longestPal = str.substring(i, i+2);
            }
        }

        for(int len = 3; len<=str.length();len++) {
            for(int i=0; i<str.length(); i++) {
                int j = i+(len-1);
                if ((j < str.length()) && (str.charAt(i) == str.charAt(j))) {
                    if (p[i+1][j-1]) {
                        p[i][j] = true;
                        longestPal = str.substring(i, j+1);
                    }
                }
            }
        }
        return longestPal;
    }

    private static String longestPalBruteForce(String str) {
        if (str.isEmpty())
            return null;
        if (str.length() == 1)
            return str;

        Map<Integer, String> set =  new HashMap<Integer, String>();

        // check palindromes from substrings frontwards
        for (int i=0; i<(str.length()-1); i++) {
            String substr = str.substring(i);
            int p = 0;
            for (int j=substr.length()-1; j>=0; j--) {
                if (substr.charAt(p) == substr.charAt(j)){
                    int palLength = (p % str.length()) * 2;
                    if (p > j) {
                        set.put(palLength, str.substring(i,i+palLength));
                        break;
                    } else if (p == j) {
                        set.put(palLength+1, str.substring(i,i+palLength+1));
                        break;
                    }
                    p++;
                } else {
                    p = 0;
                }
            }
        }

        // check palindromes from substrings backwards
        for (int i=(str.length()-1); i>0; i--) {
            String substr = str.substring(0,i);
            int p = 0;
            for (int j=substr.length()-1; j>=0; j--) {
                if (substr.charAt(p) == substr.charAt(j)){
                    int palLength = (p % str.length()) * 2;
                    int i_start = 0;
                    if (p > j) {
                        set.put(palLength, str.substring(i_start,i_start+palLength));
                        break;
                    } else if (p == j) {
                        set.put(palLength+1, str.substring(i_start,i_start+palLength+1));
                        break;
                    }
                    p++;
                } else {
                    p = 0;
                }
            }
        }

        int max = 0;
        for (Integer size: set.keySet()) {
            if (size > max)
                max = size;
        }
        return set.get(max);
    }
}
