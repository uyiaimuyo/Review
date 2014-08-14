/**
 * Created by Aysar on 4/9/2014.
 */
public class ProjectEuler {

    public static void multiplesOf3and5() {
        int s =0;
        for (int i=1; i<1000;i++) {
            if (((i%3) ==0) || ((i%5) == 0)) {
                s += i;
                System.out.println(" + "+i);
            }
        }
        System.out.println(" = "+s);
    }

    public static void main(String[] args) {
        multiplesOf3and5();
    }
}
