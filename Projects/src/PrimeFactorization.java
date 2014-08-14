import java.util.Scanner;

/**
 * Created by Aysar on 8/13/2014.
 * Prime Factorization - Have the user enter a number and find all
 * Prime Factors (if there are any) and display them.
 */
public class PrimeFactorization {

    public static boolean isPrime(int n) {
        if (n < 2)
          return false;

        for (int i=2; i<n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
    public static void main(String args[]) {
        System.out.println("Enter a # to get all its prime factors:");
        Scanner in = new Scanner (System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            if (isPrime(n)) {
                System.out.println(n + " is itself a prime!  No prime factors! \n");
            } else {
                int j=n;
                for (int i=2;i<n;i++) {
                    if (isPrime(i) && (j % i == 0)) {
                        j = j / i;
                        System.out.print(i+" * ");
                        i--;
                    }
                }
            }
        }
    }
}
