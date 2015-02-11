/**
 * Created by Aysar on 2/11/2015.
 *
 * 3 Design an algorithm and write code to remove the duplicate characters in a string
 without using any additional buffer. NOTE: One or two additional variables are fine.
 An extra copy of the array is not.
 */
public class RemoveDupesFromString {

    public static String removeDuplicates(String str) {
        char[] a = str.toCharArray();
        int len = a.length;
        if (len < 2)
            return str;

        // we use the [0,eouIndex) as holding area for unique chars
        int eouIndex = 1;
        for (int i=1; i<len; i++) {
            int j;
            // iterate over unique chars part of array and check
            // if current ith char is unique
            // its unique if it passes thru with no break
            for(j=0; j<eouIndex; j++) {
                if (a[i] == a[j]) break;
            }
            //if we didn't break then we found a new unique char
            if (j==eouIndex) {
                a[eouIndex] = a[i];
                eouIndex++;
            }
        }
        str = "";
        for(int k=0; k<eouIndex; k++) {
            str += a[k];
        }
        return str;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates("aab"));
        System.out.println(removeDuplicates("ab"));
        System.out.println(removeDuplicates("absdagb"));
        System.out.println(removeDuplicates("bbbbbbbbba"));
    }
}
