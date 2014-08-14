/**
 * Created by Aysar on 4/5/2014.
 */
public class PalindromeChecker {
    public static void make(String[] words) {
        for (int i=0; i<words.length; i++) {
            String word = words[i];

            // sort the word so its much easier to detect a
            // palindrome possibility and build it easier
            char[] aux = word.toCharArray();
            sort(aux,0,aux.length-1);
            word = String.valueOf(aux);
            word = word.substring(0) + " ";

            int k=0;
            StringBuilder odd = new StringBuilder();
            boolean b =false;
            StringBuilder repeated = new StringBuilder();
            for (int j=1; j<word.length(); j++) {
                if (word.charAt(j) != word.charAt(k)) {
                    if ((j-k) % 2 != 0) {
                        if (odd.length() > 0 && odd.charAt(0) != word.charAt(j-1)) {
                            System.out.println("-1");
                            b=true;
                            break;
                        }
                        odd.append(word.charAt(j-1));
                    }
                    for (int l=0; l<(j-k)/2;l++) {
                        repeated.append(word.charAt(k));
                    }
                    k=j;
                }
            }
            if (!b) {
                String x = repeated.toString();
                System.out.println(x + odd + repeated.reverse().toString());
            }
        }
    }

    public static void sort(char[] word, int lo,int hi) {
        if (lo>=hi) return;
        char p = word[lo];
        int i=lo, j=hi+1;
        while(true) {
            while(word[++i] < p)
                if (i == hi) break;
            while(word[--j] > p)
                if (j == lo) break;
            if (i>=j)
                break;
            char swap = word[i];
            word[i] = word[j];
            word[j] = swap;
        }
        char swap = word[lo];
        word[lo] = word[j];
        word[j] = swap;

        sort(word, lo,j-1);
        sort(word, j+1,hi);
    }

    public static void main(String[] args) {

        make(new String[]{"ivcci", "oyotta", "cecarar", "bbb", "babbb"});


//        String str = "A MAN, A PLAN, A CANAL - PANAMA";
//        QueueImpl<Character> q = new QueueImpl<Character>();
//        Stack<Character> s = new Stack<Character>();
//        for (int i=0; i<str.length(); i++) {
//            if (Character.isAlphabetic(str.charAt(i))) {
//                q.enqueue(str.charAt(i));
//                s.push(str.charAt(i));
//            }
//        }
//        for (int i=0; i<q.size(); i++) {
//            if (q.dequeue() != s.pop()) {
//                System.out.println("false");
//                System.exit(-1);
//            }
//        }
//        System.out.println("true");

    }
}
