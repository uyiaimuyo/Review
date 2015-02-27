/* Given a circular linked list, implement an algorithm which 
* returns node at the begin- ning of the loop
* 
* DEFINITION
* Circular linked list: A (corrupt) linked list in which a
* node’s next pointer points to an earlier node, so as to make a loop in the linked list
*
* EXAMPLE
* input: A -> B -> C -> D -> E -> C [the same C as earlier]
* output: C
* 
* 1 approach: have 2 pointers, 1 outer pointer iterates thru each element
* inner pointer goes ahead and iterates thru entire list check for matching element
* this is o(n^2) complexity, o(1) space
*
* 2nd approach:
* iterate thru list, and have a hashset that contains nodes seen so far
* for each element, check if exists in hash 
* o(n) time, o(n) space
*
* 3rd approach:
* o(n) time, constant space use pointers
* have 2 pointers, 1 (n1) goes 1 step at a time, the other (n2) goes 2 steps at a time 
* first find the meeting point at which they'll both be
* then start n1 back at head, and keep n2 at meeting pointer
* start both of them one step at a time.  the next time they meet
* will be the start of the circular linked list
* 
*/

public class CircularLinkedList {
	
	public class Node<T> {
		T data;
		Node<T> next;
	}

	public static Node<Character> findLoopStartNode(Node<Character> head) {

		Node<Character> n1 = head;
		Node<Character> n2 = head;
		while(n2.next != null) {
			n1 = n1.next;
			n2 = n2.next.next;
			if (n1 == n2)
				break;
		}

		if (n2.next == null)
			return null;

		n1 = head;
		while(n2 != n1) {
			n1 = n1.next;
			n2 = n2.next;
		}

		return n1;
	}

	public static void main(String[] args) {

	}
}