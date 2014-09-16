class PermCheck {
    public int solution(int[] A) {
        
        int[] a_count = new int[A.length+1];
        for (int i=0; i<A.length; i++) {
            if (A[i] > A.length)
                return 0;
            if (a_count[A[i]] == 0) {
                a_count[A[i]] = 1;
            } else {
              return 0;    
            }
        }
        return 1;
    }
}
