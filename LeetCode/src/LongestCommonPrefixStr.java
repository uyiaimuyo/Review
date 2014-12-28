import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by Aysar on 12/27/2014.
 *
 * Write a function to find the longest common prefix string amongst an array of strings.
 */
public class LongestCommonPrefixStr {

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        if (strs.length == 1)
            return strs[0];

        HashMap<String, Integer> s = new HashMap<String, Integer>();
        int d = 1;
        int max = 0;
        int minsb = 100;
        String maxsb = "";

        while(d <= minsb) {
            for (int i = 0; i < strs.length; i++) {
                if (strs[i].length() == 0)
                    continue;
                if (strs[i].length() < minsb)
                    minsb = strs[i].length();

                String sb = strs[i].substring(0,d);
                if (s.containsKey(sb)) {
                    int m = s.get(sb) + 1;
                    s.put(sb, m);

                    if (m >= max && maxsb.length() < sb.length()) {
                        max = m;
                        maxsb = sb;
                    }
                } else {
                    s.put(sb, 1);
                }
            }
            d++;
        }
        return maxsb;
    }

    public static void main(String[] args) {
        String[] s = {"aa","aa"};
        System.out.println(longestCommonPrefix(s));
    }
}
