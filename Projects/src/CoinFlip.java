import java.util.Random;
import java.util.Scanner;

/**
 * Created by Aysar on 8/14/2014.
 *
 * Coin Flip Simulation - Write some code that simulates flipping a
 * single coin however many times the user decides. The code should
 * record the outcomes and count the number of tails and heads.
 *
 */
public class CoinFlip {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the # of times to flip a coin: ");
        while(in.hasNext()) {
            int t = in.nextInt();

            Random r = new Random();
            int tails = 0; int heads = 0;
            for (int i=1; i<=t; i++) {
                int f = r.nextInt(2); // 0 = tails , 1 = heads
                if (f == 0)
                    tails++;
                else
                    heads++;
            }
            System.out.println(tails +" tails and "+heads+" heads.");
        }
    }
}
