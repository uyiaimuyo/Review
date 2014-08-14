import java.util.*;

/**
 * Created by Aysar on 4/9/2014.
 */
public class Ngram {

    public static void mostFrequencyNgram(String words, int ngram, TreeMap<String, Integer>set) {
        if (words.length() < ngram)
            return ;
        for (int i=0;i<ngram; i++) {
            if (words.charAt(i) == ' ') {
                mostFrequencyNgram(words.substring(i+1), ngram, set);
                return ;
            }
        }
        Integer count = set.get(words.substring(0, ngram));
        if (count == null) {
            set.put(words.substring(0,ngram), 1);
        } else {
            set.put(words.substring(0,ngram), count+1);
        }
        mostFrequencyNgram(words.substring(1), ngram, set);
    }

    public static void main(String[] args) {
        final int ngram = 3;
        TreeMap<String, Integer> set = new TreeMap<String, Integer>(new Comparator<String>(){
            public int compare(String o1, String o2) {
                int k = 0;
                while (k < ngram) {
                    char c1 = o1.charAt(k);
                    char c2 = o2.charAt(k);
                    if (c1 != c2) {
                        if (Character.isAlphabetic(o1.charAt(k))) {
                            if (Character.isAlphabetic(o2.charAt(k)))
                                return c1-c2;
                            return -1;
                        } else if (Character.isAlphabetic(o2.charAt(k))) {
                                return 1;
                        } else {
                            return c1 - c2;
                        }
                    }
                    k++;
                }
                return 0;
            }
        });

        mostFrequencyNgram("aaaab a0a baaab c", ngram, set);
        for (String s: set.keySet()) {
            System.out.println(s + " = " + set.get(s));
        }

    }
}
