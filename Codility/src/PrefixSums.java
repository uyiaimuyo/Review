public class PrefixSums {
  
  public int[] p_sum(int[] A) {
    int []p = new int[A.length+1];
    p[0] = 0;
    for (int i=1; i<A.length; i++) {
      p[i] = p[i-1] + A[i-1];
    }
    return p;
  }

}
