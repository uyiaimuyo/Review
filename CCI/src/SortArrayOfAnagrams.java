/**
*	Write a method to sort an array of strings so that all the anagrams are next to each other
*
*	["iceman", "odor", "cinema","door"]
*	easy approach is change the Arrays.sort comparator to account for sorted string
*	another approach:
*	bucket sort into length of string buckets
*	sort each bucket based on validity of anagram
**/

import java.utils.*;

public class SortArrayOfAnagrams {

	public class AnagramComparator implements Comparator<String> {
		@Override
		public int compare(String s1, String s2) {
			return sort(s1).compareTo(sort(s2));
		}
		public String sort(String s) {
			char[] c = s.toCharArray();
			Arrays.sort(c);
			return new String(c);
		}
	}

	public static void main(String[] args) {
		String[] s = {"iceman", "odor", "cinema","door"};
		Arrays.sort(s, new AnagramComparator());
		System.out.println(Arrays.toString(s));
	}

	
}