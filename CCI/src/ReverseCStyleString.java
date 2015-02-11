import java.util.Arrays;

/**
 * Created by Aysar on 2/11/2015.
 *
 * Write code to reverse a C-Style String.
 * (C-String means that “abcd” is represented as five characters,
 * including the null character.)
 */
public class ReverseCStyleString {

    public static String reverse(String str) {
        char[] a = str.toCharArray();
        for(int i=0; i< (a.length/2); i++) {
            char t = a[(a.length-1)-i];
            a[(a.length-1)-i] = a[i];
            a[i] = t;
        }
        return Arrays.toString(a);
    }

    public static void main(String[] args) {
        System.out.println(reverse("abc\0"));
        System.out.println(reverse("abcd\0"));
    }
}
