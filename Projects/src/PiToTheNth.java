import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Aysar on 8/13/2014.
 * Find PI to the Nth Digit - Enter a number and have the program generate
 * PI up to that many decimal places. Keep a limit to how far the program will go.
 */
public class PiToTheNth {

    public static void main(String args[]) throws IOException {
        System.out.println("Enter a number (max is 15 decimal places): ");
        Scanner stdin = new Scanner (System.in);

        while (true) {
            int ch = stdin.nextInt();
           double piDigits = Math.floor((Math.PI % 1) * (Math.pow(10.0,ch)));

           System.out.println(( 3 + (piDigits / Math.pow(10,ch)) ) +"\n");
        }
    }
}
