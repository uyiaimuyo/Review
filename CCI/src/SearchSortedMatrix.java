/* 
* Given a matrix in which each row and each column is sorted, write a method to find an element in it
*
*/

public class SearchSortedMatrix {
	public boolean search(int s, int[][] m) {
		len = m.length;
		int c = m[0].length-1;
		for(int r=0; r<len && c>=0; r++) {
			if (s < m[r][c]) {
				c--;
			} else if (s == m[r][c]) {
				return true;
			} 
		}
		return false;
	}

	public static void main(String[] args) {
		int[][] m = {{1,1,1,4},
					 {3,3,4,7},
					 {7,7,9,10},
					 {11,12,13,14}};
		System,out.println(search(5,m));
	}
}