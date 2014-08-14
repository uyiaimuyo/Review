import java.util.Scanner;

/**
 * Created by Aysar on 8/13/2014.
 * Greedy algorithm example
 */
public class ChangeReturn {

    final static double Q = 0.25;
    final static double D = 0.10;
    final static double N = 0.05;
    final static double P = 0.01;

    public static void main(String args[]){
        System.out.println("Enter the amount:");
        Scanner in = new Scanner (System.in);
        while (in.hasNext()) {
            double n = in.nextDouble();
            double change = n % 1;
            int numOfQ = 4 * (int) n;
            int numOfD = 0, numOfN = 0, numOfP = 0;
            while (change > 0) {
                if (change >= Q) {
                    change -= Q;
                    numOfQ++;
                } else if (change >= D) {
                    change -= D;
                    numOfD++;
                } else if (change >= N) {
                    change -= N;
                    numOfN++;
                } else {
                    change -= P;
                    numOfP++;
                }
            }
            System.out.println(numOfQ+" quarters, "+numOfD+" dimes, "+numOfN+" nickles and "+numOfP+" pennies.");
        }
    }
}
