import java.util.HashSet;
import java.util.Set;

/**
 * Created by Aysar on 4/8/2014.
 */
public class Anagram {

    public static void isAnagram(String[] a, String[] b) {
        for(int i=0; i<a.length; i++) {
            if (a[i].length() != b[i].length()) {
                System.out.print("-- 0 \n");
            } else {
                // sort both words
                char[] aux1 = a[i].toCharArray();
                sort(aux1, 0, a[i].length() - 1);
                System.out.println("Sort aux1: " + String.valueOf(aux1));
                char[] aux2 = b[i].toCharArray();
                sort(aux2, 0, b[i].length() - 1);
                System.out.println("Sort aux2: " + String.valueOf(aux2));
                // compare sorted

                if (String.valueOf(aux1).equals(String.valueOf(aux2))) {
                    System.out.print("-- 1 \n");
                } else {
                    System.out.print("-- 0 \n");
                }
            }
        }
    }

    public static void sort(char[] word, int lo, int hi) {
        //"test" => "estt"
        if (lo >= hi) return;
        int i =lo, j = hi+1;
        char p = word[lo];
        while (true) {
            while(word[++i] < p) {
                if (i==hi) break;
            }

            while(word[--j] > p) {
                if (j==lo) break;
            }
            if (i >= j) break;

            // swap i and j
            char swap = word[i];
            word[i] = word[j];
            word[j] = swap;
        }
        char swap = word[lo];
        word[lo] = word[j];
        word[j] = swap;

        sort(word, lo, j-1);
        sort(word, j+1, hi);
    }
//
//    public static void permutation(String input, String sofar) {
//        if (input.equals("")) {
//            System.out.printf("%s,", sofar);
//        }
//        for (int i = 0; i < input.length(); i++) {
//            char c = input.charAt(i);
//            if (input.indexOf(c, i + 1) != -1)
//                continue;
//            permutation(input.substring(0, i) + input.substring(i + 1), sofar+c);
//        }
//    }

    public static void permutation(Set<String> set, String input, String building) {
        if (input.equals("")) {
            set.add(building);
        }
        for (int i=0; i<input.length(); i++) {
            char c = input.charAt(i);

            // we need to build a seperate string (building) and concaenate new char to it
            // we also need to remove this character from our input string so that we know
            // we have already dealt with it
            permutation(set, input.substring(0,i) + input.substring(i+1), building+c);
        }
    }

    public static void main(String[] args) {
//        long st = System.currentTimeMillis();
//        isAnagram(new String[]{"cinema", "host", "aba", "train"}, new String[]{"iceman", "shot", "bab", "rain"});
//        System.out.println(System.currentTimeMillis() - st);
//
//        System.out.println("\n----------------------------\n");

        String input = "abb";
        Set<String> set = new HashSet<String>();
        permutation(set , input, "");
        for(String i: set) {
            System.out.println(i);
        }
    }
}
