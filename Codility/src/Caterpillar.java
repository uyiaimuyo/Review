
public class Caterpillar {

  public boolean find_s(int[] A, int s) {
    int front = 0;
    int total = 0;
    
    for (int back= 0; back<A.length; back++) {
      while ((front < A.length) && (total + A[front] <= s)) {
        total += A[front];
        front++;
      }
      if (total == s)
        return true;
      total -= A[back];
    }
    return false;
  }

}
