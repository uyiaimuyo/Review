/**
 * Created by Aysar on 9/12/2014.
 *
 * A non-empty zero-indexed array A consisting of N integers is given. Array A represents numbers on a tape.
 Any integer P, such that 0 < P < N, splits this tape into two non-empty parts: A[0], A[1], ..., A[P − 1] and A[P], A[P + 1], ..., A[N − 1].
 The difference between the two parts is the value of: |(A[0] + A[1] + ... + A[P − 1]) − (A[P] + A[P + 1] + ... + A[N − 1])|
 In other words, it is the absolute difference between the sum of the first part and the sum of the second part.
 */
public class TapeEquilibrium {
    public int solution(int[] A) {
        if (A.length == 2)
            return Math.abs(A[0] - A[1]);

        int sum = 1000000;
        for (int i=0; i<A.length-1; i++) {
            int s1=0, s2=0;
            for (int j=0; j<=i; j++) {
                s1 += A[j];
            }
            for (int k=A.length-1; k>i; k--) {
                s2 += A[k];
            }
            s1 = Math.abs(s1-s2);
            System.out.println(s1);
            if (s1 < sum)
                sum = s1;
        }
        return sum;
    }
}
