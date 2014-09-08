import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Aysar on 9/8/2014.
 */
public class NumberLetters {

    public static void main(String args[]) {
        int input = 1123;
        String inputStr = String.valueOf(input);

        if (inputStr.length() == 1) {
            System.out.println(1);
            return;
        }

        HashSet letters = new HashSet();
        for (int i=0, j=1;j<inputStr.length(); i++,j++) {
            letters.add(inputStr.charAt(i));
            letters.add(inputStr.charAt(j));

            String c = inputStr.substring(i,j+1);
            if (Integer.parseInt(c) <= 26) {
                letters.add(c);
            }
        }

        System.out.println(letters.size());
    }
}
