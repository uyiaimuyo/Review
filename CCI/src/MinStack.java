/*
* How would you design a stack which, in addition to push and pop, 
* also has a function min which returns the minimum element? 
* Push, pop and min should all operate in O(1) time
*
* approach: have 2 stacks, 1 main stack, other stack
* keeps track of minimum element so far, for every element
* 
*/

public class MinStack {

	int[] main;
	int[] min;
	int size;
	int topIndex;

	public MinStack() {
		main = new int[10];
		min = new int[10];
		size = 0;
		topIndex = -1;
	}

	public void push(int i) {
		if (topIndex == -1) {
			topIndex = 0;
			main[topIndex] = i;
			min[topIndex] = i;
		} else {
			main[topIndex] = i;
			if (i < min[topIndex]) {
				min[topIndex] = i;
			}
			topIndex++;
		}
		size++;
	}

	public int pop() {
		if(size == 0)
			throw new NullPointerException();

		size--;
		return main[topIndex--];
	}

	public int min() {
		if (size == 0)
			throw new NullPointerException();
		return min[topIndex];
	}

}