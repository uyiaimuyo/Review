import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by Aysar on 4/8/2014.
 */
public class Adder {

    public static void main(String[] args)throws java.io.IOException {
        Scanner stdin = new Scanner (System.in);
        String lineA = stdin.nextLine();
        String lineB = stdin.nextLine();

        StringTokenizer st = new StringTokenizer(lineA);
        st.nextElement();
        int a = Integer.parseInt(st.nextElement().toString());

        st = new StringTokenizer(lineB);
        st.nextElement();
        int b = Integer.parseInt(st.nextElement().toString());
        System.out.println(a+b);

        int ch;
        System.out.print ("Enter some text: ");
        while ((ch = System.in.read()) != '\n')
            System.out.print (ch);
    }
}
