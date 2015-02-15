//Implement an algorithm to print all valid (e g , properly opened and closed) 
// combi- nations of n-pairs of parentheses
// input: 3
// output: ()()(), ((())), ()(()), (())()
// input 2: ()(), (())
// input 1: ()
// input 4: ()()()(),(((()))), ((()))(), ()((())), (())(()), (()(())), ((())())

// 3: ((())), (()) , ((, ( 
//   2: ((+, +( 
//     1:  (

public class NPairsParantheses {

	// working solution, o(2^(2*n))
	// we keep count of # of left parantheses and right parantheses
	// we try a left or right and decrement the count until we run out
	// do this recursively to try all possibilities and with no dupes
	public void generateParantheses(int l, int r, char[] str, int c) {
		if (l < 0 || r < 0)
			return ; // invalid parantheses
		if (l == 0 && r == 0) {
			System.out.println(Arrays.toString(str));
		} else {
			if (l > 0) {
				str[c] = '(';
				generateParantheses(l-1, r, str, c+1);
			}
			if (r > 0) {
				str[c] = ')';
				generateParantheses(l,r-1,str,c+1);
			}
		}
	}

	// not done
	public ArrayList<String> generateStarterParanthesesNotDone(int n) {
		if (n == 1) {
			return new ArrayList<String>("(");
		}
		ArrayList<String> rest = generatePairs(n-1);
		ArrayList<String> all = new ArrayList<String>();

		for (String s: rest) {
			all.add(s);
			all.add("("+s);
		}

		return all;
	}
	
	public static void main(String[] args) {
		int n = 3;
		char[] c = new char[n*3];
		generateParantheses(n,n,c,0);
	}	
}