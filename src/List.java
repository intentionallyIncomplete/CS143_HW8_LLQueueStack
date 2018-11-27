/**
 * Class Description:
 * @author Ian Bryan
 * @version November 25th 2018
 * 
 * The List class is implemented by other child classes such as Stack and Queue for
 * use of its methods. Comparison between Node objects is done with memory addresses,
 * searching always begins with setting the current position to the head, and
 * end of List is indicated by a reference of null.
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
		 * @param newData Some data to hold in this Node.
		 * @param newLink An a Node object with a value of the the 
		 * 
		 * Constructor takes two parameters to construct
		 * a single Node with new data.
		 * */
		public Node(Object newData, Node newLink) {
			data = newData;
			link = newLink;
		}
		
		/**
		 * @param newData - Some piece of data to store at the Node.
		 * 
		 * Constructor that takes only 1 parameter
		 * */
		public Node(Object newData) {
			data = newData;
			link = null;
		}
	} //end inner class

	/**
	 * Class data members
	 * */
	private Node head;

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
		if(this.isEmpty()) {
			head = new Node(next,head);
		}else if(this.size() == 1) {
			Node temp = head;
			temp.link = new Node(next,null);
		}else if(this.size() >= 2 && index <= this.size()) {
			Node prev = head;
			for(int i=0;i < index-1;i++) { // Move to the position 1 before the amendment point
				prev = prev.link;
			}
			Node post = prev.link;
			Node newNode = new Node(next,post);
			prev.link = newNode;
		}else {
			System.out.println("Inside the 'else' statement of insert()");
		}
	}

	/**
	 * @param index - The specified index of the object to be removed from the List.
	 * @return - Returns Node at the specified index.
	 * */
	public Object remove(int index) {
		Node prev = head;
		if(this.isEmpty()) {
			System.out.println("List is empty");
		}else if(this.size() == 1) {
			head = head.link;
		}else if(this.size() >= 2) {
			
			for(int i=0;i<index-1;i++) {
				prev = prev.link;
			}
			Node toBeRemoved = prev.link;
			Node post = toBeRemoved.link;
			prev.link = post;
		}else {
			System.out.println("Inside the 'else' statement of remove()");
			return null;
		}
		return head;
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
			currNode = currNode.link;
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

	/**
	 * Overrides the generic toString method of String class.
	 * Builds a big String with values of each Node's memory address.
	 * */
	@Override
	public String toString() {
		Node nodeValue = head;
		String retVal = "";
		while(nodeValue != null) {
			retVal = nodeValue.data.toString() + "\n";
			nodeValue = nodeValue.link;
		}
		return retVal;
	}

	/**
	 * @param target - An object of type Node with some value.
	 * 
	 * @return - Returns an integer value that represents the index, or position,
	 * of the found item. If not found, returns -1. This method works on the function
	 * of comparing memory addresses.
	 * */
	public int indexOf(Object target) {
		Node tempNode = head; // Always start at the "front", or head position.
		int index = 0;
		while(tempNode != null) {
			index++;
			if(tempNode.toString().equals(target.toString())){
				return index; 
			}else {
				tempNode = tempNode.link;
				index = -1;
			}
		}
		return index;
	}

	/**
	 * @param obj - A Node with some data.
	 * 
	 * Adds new Node to the end of the List by moving to the last Link,
	 * set marker for end of List, then set next position which is null
	 * to new Node with values of Object obj which is casted as Node type
	 * in parameter arguments before passed to constructor.
	 */
	public void append(Object obj){
		if (head == null) {
			head = new Node(obj, null);
		}

		while ((head.link != null)) {
			head = head.link;
		}

		head.link = new Node(obj, null);
}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List empty = new List();
		List one = new List();
		List multiple = new List();

		one.insert("this is the head and only node", 1);
		
		System.out.println("List 'empty' has " + empty.size() + " elements");
		System.out.println("List 'empty' contains --> " + empty.toString());
		
		System.out.println("List 'one' has " + one.size() + " elements");
		System.out.println("List 'one' contains --> " + one.toString());
		
		/*Adding some elements to the 'multiple' List*/
		multiple.insert("this is some data1", 0);
		multiple.insert("this is some data2", 0);
		System.out.println("List 'multiple' has " + multiple.size() + " elements");
		System.out.println("List 'multiple' contains --> " + multiple.toString());
	}
}
