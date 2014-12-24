// you can also use imports, for example:
// import java.util.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

class MinPerimeterRectangle {
    public int solution(int N) {
        if (N == 1)
            return 4;
            
        int a = 1;
        int b;
        int perm = Integer.MAX_VALUE;
        while (a*a <= N) {
            
            if (N % a == 0) {
                b = N / a;
                perm = Math.min(perm, 2*(a+b));
            }
            a++;
            
        }
        return perm;
    }
}
