import java.util.Scanner;

/**
 * Created by Aysar on 8/14/2014.
 *
 * Factorial Finder - The Factorial of a positive integer, n,
 * is defined as the product of the sequence n, n-1, n-2, ...1 and
 * the factorial of zero, 0, is defined as being 1. Solve this using both loops and recursion.
 *
 * Recusrive 3-liner
 */
public class FactorialFinder {

    public static void main(String args[]) {
        System.out.println("Enter a # to find its factorial: ");
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            System.out.println(factorial(n));
        }
    }

    private static int factorial(int n) {
        if (n == 0 || n == 1)
            return 1;
        return n * factorial(n-1);
    }

}