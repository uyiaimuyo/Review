/* Given a sorted array of strings which is interspersed with empty strings, write a 
* method to find the location of a given string
* Example: find “ball” in [“at”, “”, “”, “”, “ball”, “”, “”, “car”, “”, “”, “dad”, “”, “”]
* will return 4 
* Example: find “ballcar” in [“at”, “”, “”, “”, “”, “ball”, “car”, “”, “”, “dad”, “”, “”] 
* will return -1
*/

public class StringArrayBinarySearch {
	public int search(String str, String[] a, int lo, int hi) {
		if (lo > hi)
			return -1;

		int mid = ((hi-lo) / 2)+lo;
		while(a[mid] == "" && mid < hi)
			mid++;

		if (a[mid] == "")
			return search(str, a, lo, mid-1);

		if (a[mid].compareTo(str) == 0)
			return mid;
		else if (a[mid].compareTo(str) < 0)
			return search(str, a, lo, mid-1);
		else 
			return search(str, a, mid+1, hi);
		
	}

	publci static void main(String[] args) {
		String[] s = {“at”, “”, “”, “”, “ball”, “”, “”, “car”, “”, “”, “dad”, “”, “”}
		System.out.println(search("ball", s, 0, s.length-1));
	}
}