import java.util.HashSet;
import java.util.Set;

/**
 * Created by Aysar on 11/15/2014.
 * Given a string queue and a dictionary of words dict, determine if queue can be segmented
 * into a space-separated sequence of one or more dictionary words.
 For example, given
 queue = "leetcode",
 dict = ["leet", "code"].
 Return true because "leetcode" can be segmented as "leet code".
 */
public class WordBreak {

    public static void main(String []args) {
        String s = "programcreek";
        Set<String> dict = new HashSet<String>();
        dict.add("programcree");
        dict.add("program");
        dict.add("creek");
        System.out.println(isWordBreak(s, dict));
    }

    private static boolean isWordBreak(String s, Set<String> dict) {
        if (s.isEmpty())
            return true;

        boolean [] e = new boolean[s.length()+1];
        e[0] = true;
        for (int i =0; i<s.length();i++) {
            if (!e[i])
                continue;
            for (String w: dict) {
                int end = i+w.length();
                if (end > s.length())
                    continue;
                if (e[end])
                    continue;
                if (s.substring(i, end).equals(w))
                    e[end] = true;
            }
        }
        return e[s.length()];
    }
}
