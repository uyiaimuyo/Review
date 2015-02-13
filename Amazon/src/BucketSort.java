/ *
* Bucketsort uses 'buckets' to store # of times a number exists in input array
* must know max value in array ahead of time, to set number of buckets to get O(n) time 
* /

import java.util.*;

public class BucketSort {
	
	public static void sort(int[] a, int maxValue) {
		int[] b = new int[maxValue+1];

		for(int i=0; i<a.length; i++) {
			b[a[i]]++;
		}

		int aIndex = 0;
		for(int i=0; i<b.length; i++) {
			for(int j=0; j<b[i]; j++) {
				a[aIndex++] = i;
			}
		}
	}

	public static void main(String[] args) {
		int[] a = {0,0,2,4,5,1,3,3,4,4};
		sort(a,5);
		System.out.println(Arrays.toString(a));
	}

}