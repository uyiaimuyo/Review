/**
 * Created by Aysar on 12/27/2014.
 *
 * Determine whether an integer is a palindrome. Do this without extra space.
 *
 * Could negative integers be palindromes? (ie, -1)

 If you are thinking of converting the integer to string, note the restriction of using extra space.

 You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. How would you handle such case?

 There is a more generic way of solving this problem.
 */
public class PalindromeNumber {

    // 123321
    // 11, 12
    public static boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        if (x <= 9 && x >= 0)
            return true;
        if (x%10 == 0)
            return false;

        int n = x;
        int dCount = 0;
        while (n > 0 || n < 0) {
            n = n / 10;
            dCount++;
        }
        return check(x, dCount);
    }

    static boolean check(int n, int dCount) {
        if (dCount <= 1)
            return true;
        int m = (int) Math.pow(10, dCount-1);
        if (n%10 == n/m) {
            n = (n % m) / 10;
            return check(n, dCount-2);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(1000110001));
    }
}
