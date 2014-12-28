/**
 * Created by Aysar on 12/27/2014.
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like
 * this: (you may want to display this pattern in a fixed font for better legibility)

 P   A   H   N
 A P L S I I G
 Y   I   R
 And then read line by line: "PAHNAPLSIIGYIR"
 Write the code that will take a string and make this conversion given a number of rows:

 string convert(string text, int nRows);
 convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 */
public class ZigZagConversion {
    public static String convert(String s, int nRows) {
        if (s.length() < nRows)
            return s;
        if (nRows <= 1)
            return s;

        StringBuilder sb = new StringBuilder();
        // quick solution for 2 rows, just skip every other element
        if (nRows == 2) {
            for (int i=0; i<s.length(); i+=2) {
                sb.append(s.charAt(i));
            }
            for (int i=1; i<s.length(); i+=2) {
                sb.append(s.charAt(i));
            }
            return sb.toString();
        }

        int r = 1;
        int c = 0;

        String[] sba = new String[nRows+1];
        // pre init array
        for (int k=1; k<sba.length;k++)
            sba[k] = "";

        while (r <= nRows) {
            // find amount we need to skip
            int skip = ((nRows - r) * 2 - 1);

            // special case for last row, it resets to first row
            if (skip < 0)
                skip = ((nRows - 1) * 2 - 1);

            boolean topZig = false;
            while (c < s.length()) {
                sba[r] = sba[r] + s.charAt(c);

                // special case to take care of the top zig part /
                if (topZig && (r != 1) && (r != nRows)) {
                    int skip2 = ((r - 1) * 2 - 1);
                    c = c + skip2 + 1;
                    if (c < s.length())
                        sba[r] = sba[r] + s.charAt(c);
                }
                c = c + skip + 1;
                topZig = true;
            }

            r++;
            c = r-1;
        }

        for (int j=1; j< sba.length; j++) {
            sb.append(sba[j]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 4));
    }
}
