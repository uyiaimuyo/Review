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
            return Math.abs(A[0]-A[1]);

        int [] s1 = new int[A.length-1];
        s1[0] = A[0];
        for (int i=1;i<A.length-1;i++) {
            s1[i] = s1[i-1] + A[i];
        }

        int [] s2 = new int[A.length-1];
        s2[A.length-2] = A[A.length-1];
        for (int i=A.length-3;i>=0;i--) {
            s2[i] = s2[i+1] + A[i+1];
        }

        int finalSum = Integer.MAX_VALUE;
        for (int j=0;j<s1.length;j++) {
            int sum = Math.abs(s1[j]-s2[j]);
            if (sum < finalSum)
                finalSum = sum;
        }
        return finalSum;
    }
}
