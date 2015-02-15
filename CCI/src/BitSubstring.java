/* You are given two 32-bit numbers, N and M, and two bit positions,
i and j Write a method to set all bits between i and j in N equal
to M (e g , M becomes a substring of N located at i and starting at j)
EXAMPLE:
Input: N = 10000000000, M = 10101, i = 2, j = 6
Output: N = 10001010100
*/

public class BitSubstring {
	
	public int substr(int n, int m, int i, int j) {

		// unset all bits from i->j
		int nij = ~((n << (11-j)) >> i);
		int unsetN = n & (nij << i);
		return unsetN | (m << i);
	}

}