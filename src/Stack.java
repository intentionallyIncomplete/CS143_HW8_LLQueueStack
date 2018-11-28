/**
 * Class Description:
 * @author Ian Bryan
 * @version Nov 27th, 2018
 * 
 * A class that implements the structure of a LIFO operation. Also known as a Stack.
 * Extends from List for being able to utilize the insert and remove methods.
 */
public class Stack extends List{
	/**
	 * @param data
	 * Will call super class method append(param) to add an object
	 * at the beginning of the list (head). All links will shift to the right
	 * when adding at the front of the list.
	 */
	public void push(Object data){
		super.append(data);
	}
	
	/**
	 * @return - Uses the overloaded remove() method from the super class
	 * List to remove a Node off the top of the stack of Nodes.
	 */
	public Object pop(){
		return super.remove(0);
	}

	public static void main(String[] args) {
		Stack empty = new Stack();
		Stack one = new Stack();
		List multiple = new List();
		
		one.append(5);
		multiple.append(10);
		multiple.append (20);
		multiple.append (30);
	
		
		System.out.println("Empty:"+empty);
		System.out.println("One:"+one);
		System.out.println("Multiple:"+ multiple);	
		
		one.remove(0);
		multiple.remove(1);
		System.out.println("One (upon remove):"+one);
		System.out.println("Multiple (upon remove):"+ multiple);
		
		//one.append(600, 1);
		multiple.append(400);
		System.out.println("One (on append):"+one);
		System.out.println("Multiple(on append):"+ multiple);

	}

}