import java.util.Scanner;

/**
 * Created by Aysar on 8/13/2014.
 *
 * Fibonacci Sequence - Enter a number and have the program generate the
 * Fibonacci sequence to that number or to the Nth number.
 *
 * Recursive 3 liner
 */
public class FibonnacciSeq {
    private static int f(int n) {
        if (n == 2 || n == 1)
            return 1;
        return f(n-1) + f(n-2);
    }

    public static void main(String args[]) {
        System.out.println("Enter a # to generate a Fibonacci sequence to that #:\n");
        Scanner in = new Scanner (System.in);
        while (in.hasNext()) {
            int n = in.nextInt();

            for (int i=1; i<=n; i++) {
                System.out.print(f(i)+", ");
            }
        }
    }
}

