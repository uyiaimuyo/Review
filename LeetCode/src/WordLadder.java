import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by Aysar on 11/15/2014.
 *
 * Given two words (start and end), and a dictionary, find the length of shortest
 * transformation sequence from start to end, such that:
 Only one letter can be changed at a time
 Each intermediate word must exist in the dictionary
 For example, Given:
 start = "hit"
 end = "cog"
 dict = ["hot","dot","dog","lot","log"]
 As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 return its length 5.
 Note: Return 0 if there is no such transformation sequence.
 All words have the same length.
 All words contain only lowercase alphabetic characters.
 */
public class WordLadder {
    public static void main(String []args) {
        String start = "hit";
        String end = "cog";
        Set<String> dict = new HashSet<String>();
        dict.add("hot");
        dict.add("dot");
        dict.add("dog");
        dict.add("lot");
        dict.add("log");
        System.out.println(shortestTransformationLength(start, end, dict));
    }

    private static int shortestTransformationLength(String start, String end, Set<String> dict) {
        LinkedList<String> words = new LinkedList<String>();
        LinkedList<Integer> wordDiffLengths = new LinkedList<Integer>();
        words.add(start);
        wordDiffLengths.add(1);
        dict.add(end);

        while(!words.isEmpty()) {
            String currentStr = words.pop();
            int currentWordDiffLength = wordDiffLengths.pop();

            if (currentStr.equals(end)) {
                return currentWordDiffLength;
            }

            for (int i=0; i<currentStr.length(); i++) {
                char []current = currentStr.toCharArray();
                for(char c='a'; c<='z'; c++) {
                    current[i] = c;
                    String newCurrent = String.valueOf(current);
                    if (dict.contains(newCurrent)) {
                        words.add(newCurrent);
                        wordDiffLengths.add(currentWordDiffLength + 1);
                        dict.remove(newCurrent);
                    }
                }
            }
        }
        return 0;
    }

    private static int shortestTransformationLengthBruteForceNotRight(String start, String end, Set<String> dict) {

        int minDiff = 0;//getDiff(start, end);
        String current = start;

        while (!current.equals(end)) {
            int minC = Integer.MAX_VALUE;
            for (String w : dict) {
                int c = getDiff(current, w);
                if (c < minC) {
                    minC = c;
                    current = w;
                }
            }
            minDiff++;
            if (getDiff(current,end) < minC) {
                minDiff++;
                current = end;
            } else {
                dict.remove(current);
            }
        }
        return minDiff;
    }

    private static int getDiff(String start, String end) {
        int c = 0;
        for (int i=0; i<start.length(); i++) {
            if (start.charAt(i) != end.charAt(i))
                c++;
        }
        return c;
    }
}
