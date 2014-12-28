/**
 * Created by Aysar on 11/15/2014.
 *
 */
public class StringToIntegerAtoiWithRecursiveDescent {
    // Using Recursive descent algorithm
    public static int next; // the next token in string
    public static char[] a;
    public static int isNeg;
    public static int atoi(String str) {
        str = str.trim() + '\0';
        a = str.toCharArray();
        isNeg = 1;
        next = 0;
        if (a.length == 0)
            return 0;
        if (T())
            return 0;
        if (E()) {
            int tenth = 1;
            long num = 0;
            int c = 0;
            for (int i = a.length-2; i >= 0; i--) {
                if ((a[i] >= 48) && (a[i] <= 57)) {
                    num += (a[i] - '0') * tenth;
                    tenth *= 10;
                    c++;
                } else if (a[i] != '+' && a[i] != '-') {
                    num = 0;
                    tenth = 1;
                    c = 0;
                }
            }
            num *= isNeg;
            if (num > Integer.MAX_VALUE || (c > 10 && isNeg == 1))
                return Integer.MAX_VALUE;
            if (num < Integer.MIN_VALUE || (c > 10 && isNeg == -1))
                return Integer.MIN_VALUE;
            return (int) num;
        }
        return 0;
    }

    // CFG productions are:
    // nonterminal -> terminal
    // E -> +int | -int | int | T
    // T -> stringT | e
    // Where e = epsilon (empty), int = a digit, string = a character.
    static boolean E() {
        int save = next;
        if (E1()) return true;
        next = save; if (E2()) return true;
        next = save; if (E3()) return true;
        next = save; if (E4()) return true;
        next = save;
        return false;
    }
    static boolean E1() { return term('+') && term('0'); }
    static boolean E2() {
        if (term('-') && term('0')) {
            isNeg = -1;
            return true;
        }
        return false;
    }
    static boolean E3() { return term('0'); }
    static boolean E4() { return T(); }

    static boolean T() {
        int save = next;
        if (T1()) return true;
        next = save;
        if (T2()) return true;
        next = save;
        return false;
    }
    static boolean T1() { return term('A') && T(); }
    static boolean T2() { return term('\0'); }

    static boolean term(char tok) {
        if (tok == '0')
            return Character.isDigit(a[next++]);
        if (tok == 'A')
            return Character.isAlphabetic(a[next++]);
        return a[next++] == tok;
    }

    public static void main(String [] args) {
        String a = "1";
        String b = "+123";
        String c = "-1";
        String d = "+-123";
        String e = "abc";
        String f = "a123";
        String g = "-2abc";
        String h = " -11919730356x";
        System.out.println(atoi(a));
        System.out.println(atoi(b));
        System.out.println(atoi(c));
        System.out.println(atoi(d));
        System.out.println(atoi(e));
        System.out.println(atoi(f));
        System.out.println(atoi(g));
        System.out.println(atoi(h));
    }
}
