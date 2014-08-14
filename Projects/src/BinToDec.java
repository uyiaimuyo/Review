import java.util.Scanner;

/**
 * Created by Aysar on 8/13/2014.
 *
 * Binary to Decimal and Back Converter - Develop a converter to convert a
 * decimal number to binary or a binary number to its decimal equivalent.
 *
 * TODO: fix binary to dec conversion bug
 */
public class BinToDec {

    private static String intToBinary(int n) {
        String bin = "";
        int w = n;
        while (w > 0) {
            if (w % 2 == 0)
                bin = "0" + bin;
            else
                bin = "1" + bin;
            w /= 2;
        }
        return bin;
    }

    private static String doubleToBinary(double n) {
        String bin = "";
        double w = n;
        while ((w % 1) > 0) {
            w *= 2;
            if (((int) w) == 0) {
                bin = bin + "0";
            } else {
                bin = bin + "1";
            }
            w %= 1;
        }
        return bin;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        System.out.println("Enter a 'd' for decimal # of 'b' for binary #: ");
        String c = in.nextLine();
        System.out.println("Enter the #: ");
        while (in.hasNext()) {
            double n = in.nextDouble();
            int w = (int) n;
            double d = n % 1;
            if (c.equalsIgnoreCase("d")) { // decimal
                System.out.println(intToBinary(w) + "." + doubleToBinary(d));
            } else { // binary
                String strw = Double.toString(n) ;
                d = 0;
                for (int i=strw.length()-1; i>=0;i--) {
                    if (strw.charAt(i) != '.') {
                        double power = Math.pow(2.0, strw.length() - 2 - i);
                        d += power * (strw.charAt(i) - '0');
                    }
                }
                System.out.println(d);
            }
        }
    }
}
