/* Name of the class has to be "Main" only if the class is public. */
public class Leader
{
	public static void main (String[] args) throws java.lang.Exception
	{
		int[] A = {4,6,6,6,6,8,8};
		int size = 0;
		int value = 0;
		
		// find the element that occurs most, not necessarily occurs > n/2 times
		for (int i=0; i<A.length; i++) {
			if (size == 0) {
				size++;
				value =  A[i];
			} else {
				if (value != A[i])
					size--;
				else
					size++;
			}
		}
		
		// confirm the leader
		int count = 0;
		for (int j=0; j<A.length; j++) {
			if (A[j] == value)
				count++;
		}
		if (count > (A.length/2))
			System.out.println(value);
		else
			System.out.println(-1);
	}
}
