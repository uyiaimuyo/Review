//
// Given an infinite number of quarters (25 cents), dimes (10 cents), 
// nickels (5 cents) and pennies (1 cent), write code to calculate 
// the number of ways of representing n cents
//
// 15 => (5,5,5),(10,5),(1..1), (1..1,5)
// 
// 5 => (5),(1,1,1,1,1)
// 
//    1,   2,  3,  4,   5      10
//  1 1  1,1           1x5      10
//  5                   1       2
//  10  						1
// p(10,any) = p(n-1,any) + some d OR some d alone
// p(n,d) = p(n-1,d*) + some d

public class RepresentNCents {
	
	enum Money {
		25,10,5,1;
	}

	public int getFor(int n) {

		int[][] p = new int[4][n+1];

		// base case
		p[0][1] = 0;

		int counter = 0;
		for (int i=2; i<=n; i++) {
			for(int j : Money.values()) {
				if (p[j][i-1] != 0) {
					if (i == (p[j][i-1] + j)) {
						p[j][i] = p[j][i-1] + j;

						if (i ==  n)
							count++;
						break;
					}
				} else if (i == j){
						p[j][i] = v;
						if (i ==  n)
							count++;
					}
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		
	}


}