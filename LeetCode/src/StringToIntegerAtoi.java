/**
 * Created by Aysar on 11/15/2014.
 *
 */
public class StringToIntegerAtoi {

    public static void main(String [] args) {
        String a = "123";
        String b = "+123";
        String c = "-123";
        String f = "a123";
        System.out.println(atoi(f.trim()));
    }

    public static int atoi(String str) {
        long num = 0;
        int tenth = 1;
        int neg = 1;
        for (int i = str.length()-1; i >= 0; i--) {
            if (Character.isDigit(str.charAt(i))) {
                num += (str.charAt(i) - '0') * tenth;
            } else if (str.charAt(i) == '-') {
                neg = -1;
            } else {
                break;
            }
            tenth *= 10;
        }

        if (num > Integer.MAX_VALUE || num < Integer.MIN_VALUE)
            return 0;
        return (int) num * neg;
    }
}
