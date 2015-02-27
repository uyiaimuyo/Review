// Write code to remove duplicates from an unsorted linked list 
// FOLLOW UP
// How would you solve this problem if a temporary buffer is not allowed?
//
// iterate thru list
// check if element is part of unique part of list
// if unique: last unique element pter.next goes to it
// if not unqiue: do nothing
// [1,2,3,4,5,6]

// o(n*k), where n is size of orig list, k is # of unique elements
public class RemoveDupeLinkedList {
	
	public Node<Integer> remove(Node<Integer> head) {
		Node<Integer> curr = head;

		Node<Integer> firstUnique = new Node(head.data);
		Node<Integer> lastUnique = new Node(head.data);

		while(curr != null) {
			//check if unique
			Node<Integer> ui = firstUnique;
			while(ui.next != null && (ui.data != curr.data)) {
				ui = ui.next;
			}
			// its unique bc we reached end of unique index
			if (ui.next == null && (ui.data != curr.data)) {
				Node<Integer> p = lastUnique;
				lastUnique = new Node(curr.data);
				p.next = lastUnique;
			}
			curr = curr.next;
		}		
		return firstUnique;
	}

}