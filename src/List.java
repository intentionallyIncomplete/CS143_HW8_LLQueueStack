/**
 * Class Description:
 * @author Ian Bryan
 * @version November 25th 2018
 * 
 * The List class is implemented by other child classes such as Stack and Queue for
 * use of its methods. 
 */
public class List {
	/**
	 * Class Description:
	 * @author Ian Bryan
	 * @version November 25th, 2018
	 * 
	 * Inner class is private and represents a single Node in the LinkedList.
	 * Contains only two data items and a single overloaded constructor.
	 */
	private class Node{
		/**
		 * Private inner class data members
		 * data = some data of the Node
		 * link = reference to the next link in the chain
		 * */
		private Object data;
		private Node link;

		/**
		 * Constructor that takes no argument.
		 * Sets reference and data to null. Basically creates
		 * an empty Linked List.
		 * */
		public Node() {
			data = null;
			link = null;
		}

		/**
		 * @param data - Some data to hold in this Node
		 * @param link - An integer to reference the position of the Node
		 * in the List.
		 * 
		 * Constructor takes two parameters to construct
		 * a single Node with new data.
		 * */
		public Node(Object newData, Node newLink) {
			data = newData;
			link = newLink;
		}
	} //end inner class

	/**
	 * Class data members
	 * */
	private Node head = null;

	/**
	 * Constructor takes no arguments and sets head to null.
	 * Establishes an empty list.
	 * */
	public List() {
		head = null;
	}

	/**
	 * @param next
	 * @param index
	 * 
	 * Creates new Object of type Node and adds new Node to List
	 * after some condition is satisfied. Cast to Node is required.
	 */
	public void insert(Object next, int index) {
		Node nextNode = (Node) next;
		if(isEmpty()) {
			head = new Node(nextNode, head);
		}
	}

	/**
	 * @return Returns count of number of elements before
	 * the reference to the next is equal to null.
	 */
	public int size() {
		int count = 0;
		Node currNode = head;
		while(currNode != null) {
			count++;
			currNode = head.link;
		}
		return count;
	}
	
	
	/**
	 * @return - Returns true if the list is empty (i.e - the head is null).
	 * 
	 * Since garbage collection removes inaccessible Nodes from memory, an
	 * empty list is defined after setting head to null.
	 */
	public boolean isEmpty() {
		if(head == null) {	return true;	}
		else {	return false;	}
	}
}
