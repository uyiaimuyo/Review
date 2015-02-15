/* You have two numbers represented by a linked list, where each node 
* contains a sin- gle digit The digits are stored in reverse order, 
* such that the 1’s digit is at the head of the list Write a function
* that adds the two numbers and returns the sum as a linked list
*
* EXAMPLE
* Input: (3 -> 1 -> 5), (5 -> 9 -> 2) 
* Output: 8 -> 0 -> 8
* 1
* 513
* 295
* 808
*/

public class AddLinkedListNumbers {
	
	public Node<Integer> sum(Node<Integer>h1, Node<Integer>h2) {
		if (h1 ==null && h2==null) return null;
		if (h1 == null) return h2;
		if (h2 == null) return h1;

		Node<Integer> rHead = null;
		Node<Integer> rEnd = r;
		Node<Integer> c1 = h1;
		Node<Integer> c2 = h2;
		int carry = 0;
		int r = 0;
		while(c1 != null && c2 !=null) {
			r = c1.data + c2.data + carry;

			if (r <= 9) {
				carry = 0;
			} else {
				r %= 10;
				carry = 1;
			}

			c1 = c1.next;
			c2 = c2.next;
			if (rHead == null) {
				rHead = new Node(r);
				rEnd = rHead;
			} else {
				Node<Integer> oldrEnd = rEnd;
				rEnd = new Node(r);
				oldrEnd.next = rEnd;
			}
		}

		while (c1 != null) {
			r = c1.data + carry;

			if (r <= 9) {
				carry = 0;
			} else {
				r %= 10;
				carry = 1;
			}

			c1 = c1.next;
			Node<Integer> oldrEnd = rEnd;
			rEnd = new Node(r);
			oldrEnd.next = rEnd;
		}

		while (c2 != null) {
			r = c2.data + carry;

			if (r <= 9) {
				carry = 0;
			} else {
				r %= 10;
				carry = 1;
			}

			c2 = c2.next;
			Node<Integer> oldrEnd = rEnd;
			rEnd = new Node(r);
			oldrEnd.next = rEnd;
		}

		return rHead;
	}

}