/**
 * Created by Aysar on 12/29/2014.
 *
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 For example:
 1 -> A
 2 -> B
 3 -> C
 ...
 26 -> Z
 27 -> AA
 28 -> AB
 */
public class ExcelSheetColumnTitle {
    public static String convertToTitle(int n) {
        if (n == 0)
            return "";
        --n;
        String lastLetter = Character.toString((char)('A' + (n % 26)));
        return convertToTitle( n / 26) + lastLetter;
    }

    public static void main(String[] args) {
        System.out.println(convertToTitle(25));
        System.out.println(convertToTitle(26));
        System.out.println(convertToTitle(27));
        System.out.println(convertToTitle(51));
        System.out.println(convertToTitle(52));
        System.out.println(convertToTitle(53));
        System.out.println(convertToTitle(1020));
    }
}
