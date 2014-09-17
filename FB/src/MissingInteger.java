class Solution {
    public int solution(int[] A) {
        
        int[] c = new int[A.length+1];
        
        for(int i=0; i<A.length; i++) {
            if ((A[i] >= 1) && (A[i] < A.length+1))
                c[A[i]] = 1;
        }
        int r = 0;
        for(int i=1; i<c.length; i++) {
            if (c[i] != 1)
                return i;
        }
        
        return -1;
    }
}
