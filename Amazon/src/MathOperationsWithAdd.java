// Write a method to implement *, - , / operations You should use only the + operator

public class MathOperationsWithAdd {

	public int negate(int m) {
		int d;
		
		if (m<0)
			d = 1;
		else
			d = -1;
		
		int n = 0;
		while(m!=0) {
			n += d;
			m += d;
		}
		return n;
	}
	
	public int multiple(int m, int n) {
		for(int i=0; i<n; i++) {
			m += m;
		}
		return m;
	}

	public int subtract(int m, int n) {
		return m + negate(n);
	}

	public int divide(int m, int n) {
		int c = 0;
		while(m >= 0) {
			m += negate(n);
			c++;
		}
		return c;	
	}

}