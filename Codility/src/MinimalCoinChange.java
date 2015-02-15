/**
 * Created by Aysar on 11/12/2014.
 * Problem: Please implement a function which gets the minimal number of coins, whose value
 * is v1, v2, …, vn, to make change for an amount of money with value t. Any coin with value
 * vi may duplicate for any times to make change.
 *
 * For example, the minimal number of coins to make change for 15 out of a set of coins with
 * value 1, 3, 9, 10 is 3. We can choose two coins with value 3 and a coin with value 9. The
 * number of coins for other choices should be greater than 3.
 */
public class MinimalCoinChange {

    public static void main(String[] args) {
        int [] v = {1,5,10,25};
        System.out.println(leastChange(v, 15));
    }
     public static int leastChange(int[] v, int amount) {
         int [] countOfCoins = new int[amount+1];
         countOfCoins[0] = 0; //amount of coins for $0 is 0

         // lets find out how many counts it takes for $1, 2, 3..all the way to the amount
         // by the time we get to the amount, we will use our solutions for smaller amounts
         // to find the optimal minimum amount of coins
         for (int i=1; i<=amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int val: v) {
                if (i >= val) {
                    min = Math.min(countOfCoins[i-val], min);
                }
            }
            countOfCoins[i] = min+1;
         }
         return countOfCoins[amount];
     }
}
