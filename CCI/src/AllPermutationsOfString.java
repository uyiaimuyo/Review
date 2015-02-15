// Write a method to compute all permutations of a string
//
// given "abc", then return abc, bac, bca, acb, cab, cba
// 3! results

// a + bc, a + [bc, cb] => [abc, bac, bca, acb, cab, cba]
//   b + c, [bc,cb]
//     c

public class AllPermutationsOfString {

	// n! complexity
	public ArrayList<String> permutate(String str) {
		if (str.length == 1) {
			return new ArrayList<String>(str);
		}

		ArrayList<String> rest = permutate(str.substring(1));
		ArrayList<String> all = new ArrayList<String>();

		for(String s: rest) {
			for (int i=0; i<=s.length; i++) {
				all.add(s.substring(0,i) + str.charAt(0) + s.substring(i));
			}
		}
		return all;
	}
	
}