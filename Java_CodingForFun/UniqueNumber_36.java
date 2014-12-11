package codingForFun;

// Write, efficient code for extracting unique elements from a sorted list of array. e.g. (1, 1, 3, 3, 3, 5, 5, 5, 9, 9, 9, 9)-> (1, 3, 5, 9).
public class UniqueNumber_36 {

	public Node extractUnique(Node head) {
		if (head == null) {
			return head;
		}
		Node n = head;
		while (n.next != null) {
			if (n.val == n.next.val) {
				n = n.next.next;
			}
			else {
				n = n.next;
			}
		}
		return head;
	}
}

class Node {
	Node next;
	int val;
	Node(int val) {
		this.val = val;
		next = null;
	}
}