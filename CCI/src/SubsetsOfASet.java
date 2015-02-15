// Write a method that returns all subsets of a set

// [1,2] => [],[1,2],[1],[2]
// [1,2,3] => 2^3 => [],[1],[2],[3],[1,2],[1,3],[2,3],[1,2,3]

// take one element
// recursively solve for element + rest of array

public class SubsetsOfASet {

	// 2^n complexity	
	public ArrayList<Integer> findSubset(ArrayList<Integer> a, int index) {
		if (index == a.size()) {
			return new ArrayList<Integer>();
		}
		
		all.add(a.get(index));
		ArrayList<Integer> rest = findSubset(a, index+1);
		
		ArrayList<Integer> all = new ArrayList<Integer>();
		all.add(Arrays.asList(a.get(index)));
		all.add(rest);

		for(Integer i: rest) {
			ArrayList<Integer> n = new ArrayList<Integer>();
			n.add(a.get(index));
			n.add(i);
			all.add(n);	
		}

		return all;
	}

	public static void main(String[] args) {
		int[] a = {1,2};
		findSubset(a, 0);
	}
}