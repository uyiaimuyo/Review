/* Imagine a (literal) stack of plates If the stack gets too high, 
it might topple Therefore, in real life, we would likely start a 
new stack when the previous stack exceeds some threshold. Implement a
data structure SetOfStacks that mimics this SetOfStacks should be 
composed of several stacks, and should create a new stack once the 
previous one exceeds capacity SetOfStacks push() and SetOfStacks 
pop() should behave identically to a single stack (that is, pop() 
should return the same values as it would if there were just a single stack)

FOLLOW UP
Implement a function popAt(int index) which performs a pop operation on a specific sub-stack
*/

public class SetOfStacks {

	int threshold;
	ArrayList<Stack<Integer>> s = new ArrayList<Stack<Integer>>();
	int size;

	public SetOfStack(int t) {
		threshold = t;
		size = 0;
		s.add(new Stack<Integer>(threshold));
	}

	public void push(int i){
		Stack st = s.get(getStackIndex());
		if (st.getSize() < threshold) {
			st.push(i);
		} else {
			st = new Stack<Integer>(threshold);
			st.push(i);
			s.add(st);
		}
		size++;
	}

	public int pop() {
		Stack st = s.get(getStackIndex());
		if (st.getSize() == 0) {
			s.remove(getStackIndex());
			st = s.get(getStackIndex());
		}
		size--;
		return st.pop();
	}

	private int getStackIndex() {
		if (size == 0) return 0;
		return (size / threshold);
	}

	public int popAt(int index) {
		size--;
		return s.get(index).pop();
	}

}
