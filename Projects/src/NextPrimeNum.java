import java.util.Scanner;

/**
 * Created by Aysar on 8/13/2014.
 *
 * Next Prime Number - Have the program find prime numbers
 * until the user chooses to stop asking for the next one.
 *
 * Stops when you terminate :)
 */
public class NextPrimeNum {

    private static boolean isPrime(int n) {
        if (n < 2)
            return false;
        for (int i=2;i<n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        int n = 0;
        while (true) {
            if (isPrime(n))
                System.out.println(n);
            n++;
        }
    }
}
