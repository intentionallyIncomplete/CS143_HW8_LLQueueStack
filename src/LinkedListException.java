
/**
 * Class Description:
 * @author Ian Bryan
 * @version Nov 25th, 2018
 * 
 * The LinkedListException class is a custom exception class that is thrown for different
 * types of exceptions in the Stack and Queue class. This is used in place of other
 * exceptions and is very basic.
 */
public class LinkedListException extends Exception{

	/**
	 * @param msg - A custom String message passed in after the clause is caught.
	 */
	public LinkedListException(String msg) {
		super(msg);
	}
}
