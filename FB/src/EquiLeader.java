// you can also use imports, for example:
import java.util.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        
        int size = 0;
        int value = 0;
        for (int i=0; i<A.length; i++) {
            if (size == 0) {
                size++;
                value = A[i];
            } else {
                if (A[i] == value)
                    size++;
                else 
                    size--;
            }
        }
        
        
        int count = 0;
        
        for (int j=0; j<A.length; j++) {
            if (A[j] == value) {
                 count++;
            }
        }
        
        if (count <= (A.length/2)) {
            return 0;    
        } else {
            int indices = 0;
            size = 0;
            for (int k=0; k<A.length-1; k++) {
                if (A[k] == value){ 
                    count--;
                    size++;
                }
                if ((size > ((k+1)/2)) && (count > (A.length-(k+1))/2 )) {
                    indices++;
                }
            }
            return indices;
        }
    }
}
