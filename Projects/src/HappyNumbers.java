import java.util.ArrayList;

/**
 * Created by Aysar on 8/14/2014.
 *
 * Happy Numbers - A happy number is defined by the following process. Starting with
 * any positive integer, replace the number by the sum of the squares of its digits,
 * and repeat the process until the number equals 1 (where it will stay), or it loops
 * endlessly in a cycle which does not include 1. Those numbers for which this process
 * ends in 1 are happy numbers, while those that do not end in 1 are unhappy numbers.
 * Display an example of your output here. Find first 8 happy numbers.
 *
 * 10 line recursive solution :)
 *
 */
public class HappyNumbers {
    public static void main(String args[]){
        int n=1;
        while (n<=100) {
            ArrayList <Integer> a = new ArrayList<Integer>();
            if (!notHappy(n ,a))
                System.out.println(n);
            n++;
        }
    }

    private static boolean notHappy(int n, ArrayList <Integer> a) {
        if (n == 1)
            return false;
        else if (a.contains(n))
            return true;
        a.add(n);
        return notHappy(squareSum(n), a);
    }

    private static int squareSum(int n) {
        if (n == 0)
            return 0;
        return (n % 10)*( n % 10) + squareSum(n/10);
    }
}
