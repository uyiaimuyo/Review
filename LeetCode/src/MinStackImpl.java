/**
 * Created by Aysar on 12/27/2014.
 *
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

 push(x) -- Push element x onto stack.
 pop() -- Removes the element on top of the stack.
 top() -- Get the top element.
 getMin() -- Retrieve the minimum element in the stack.

 */
public class MinStackImpl {

    int[] a = new int[1000];
    int top = -1; // stores the array index of top element
    int[] min = new int[1000]; // stores elements in order of minimum
    int minIndex = -1;
    int size = 0;

    public void push(int x) {
        top++;
        a[top] = x;
        size++;
        if (minIndex == -1 || x < min[minIndex]) {
            minIndex++;
            min[minIndex] = x;
        } else {
            min[minIndex+1] = min[minIndex];
            minIndex++;
        }
    }

    public void pop() {
        if (size == 0)
            throw new ArrayIndexOutOfBoundsException();
        a[top] = 0;
        top--;
        size--;

        min[minIndex] = 0;
        minIndex--;
    }

    public int top() {
        if (size == 0)
            throw new ArrayIndexOutOfBoundsException();
        return a[top];
    }

    public int getMin() {
        if (size == 0)
            throw new ArrayIndexOutOfBoundsException();
        return min[minIndex];
    }
}
