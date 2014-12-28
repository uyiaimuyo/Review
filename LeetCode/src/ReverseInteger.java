/**
 * Created by Aysar on 12/27/2014.
 *
 * Reverse digits of an integer.

 Example1: x = 123, return 321
 Example2: x = -123, return -321
 */
public class ReverseInteger {

    public int reverse(int x) {

        boolean isNegative = false;
        int n = x;
        if (x<0) {
            isNegative = true;
            n *= -1;
        }

        long y = 0;
        int digits = 1;
        int first = n % 10;
        while (n > 0) {
            y = (n % 10) + (y*10);
            n = n / 10;
            digits++;
        }

        if (y > Integer.MAX_VALUE || y < Integer.MIN_VALUE)
            return 0;

        if (isNegative)
            y *= -1;

        return (int) y;
    }
}
