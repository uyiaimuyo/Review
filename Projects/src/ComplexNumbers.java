import java.util.Scanner;

/**
 * Created by Aysar on 8/14/2014.
 *
 * Complex Number Algebra - Show addition, multiplication, negation, and
 * inversion of complex numbers in separate functions. (Subtraction and
 * division operations can be made with pairs of these operations.)
 * Print the results for each operation tested.
 */
public class ComplexNumbers {
    public static int[] multiply(int []ab1, int []ab2) {
        int[] ab =new int [2];
        ab[0] = (ab1[0] * ab2[0])-(ab1[1] * ab2[1]);
        ab[1] = (ab1[0] * ab2[1])+(ab2[0] * ab1[1]);
        return ab;
    }

    public static int[] getTerms(String c) {
        int [] terms = new int[2];
        if (c.indexOf('+') != -1) {
            terms[0] = Integer.parseInt(c.substring(0, c.indexOf('+')).trim());
            terms[1] = Integer.parseInt(c.substring(c.indexOf('+') + 1, c.indexOf('i')).trim());
        } else {
            terms[0] = Integer.parseInt(c.substring(0, c.indexOf('-')).trim());
            terms[1] = Integer.parseInt(c.substring(c.indexOf('-'), c.indexOf('i')).trim());
        }
        return terms;
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        while (true){
            System.out.println("Enter the first complex # (a + bi): ");
            String c1 = in.next();
            System.out.println("Enter the second complex # (a + bi): ");
            String c2 = in.next();

            System.out.println("Enter operation (+ - * /): ");
            char o = in.next().charAt(0);

            int []ab1= getTerms(c1);
            int []ab2= getTerms(c2);
            int []ab= new int[2]; int[]bot=new int[2];
            switch (o) {
                case '+':
                    ab[0] = ab1[0] + ab2[0];
                    ab[1] = ab1[1] + ab2[1];
                    break;
                case '-':
                    ab[0] = ab1[0] - ab2[0];
                    ab[1] = ab1[1] - ab2[1];
                    break;
                case '*':
                    ab = multiply(ab1,ab2);
                    break;
                case '/':
                    int [] conj = new int[2];
                    conj[0]=ab2[0]; conj[1]= -1*ab2[1];
                    ab = multiply(ab1,conj);
                    bot = multiply(ab2,conj);
                    break;
            }
            System.out.println(ab[0]+" + "+ab[1]+"i");
            if (o=='/') {
                System.out.println("-------");
                System.out.println(bot[0]);
            }
        }
    }
}
