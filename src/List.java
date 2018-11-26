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
		 * @param newLink An integer to reference the position of the Node
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
		if(this.isEmpty()) {
			head = new Node(next, head);
		}else if(this.size() == 1) {
			head = new Node(next,head.link);
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
	public void append(Object obj) {
		Node tail = head;
		while(head != null) {
			tail = tail.link;
		}
		tail = new Node((Node)obj, null);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List empty = new List();
		List one = new List();
		List multiple = new List();

//		one.append(5);
//		multiple.append(10);
//		multiple.append (20);
//		multiple.append (30);

		one.insert("test", 0);

		System.out.println("Empty:"+empty);
		System.out.println("One:"+one);
		System.out.println("Multiple:"+ multiple);	

		one.remove(0);
		multiple.remove(1);
		System.out.println("One (upon remove):"+one);
		System.out.println("Multiple (upon remove):"+ multiple);

		//one.append(600, 1);
		//multiple.append(400, 2);
		//System.out.println("One (on append):"+one);
		//System.out.println("Multiple(on append):"+ multiple);

	}
}
