/**
 * Class Description:
 * @author Ian Bryan
 * @version November 27th, 2018
 *
 * A class that implements the structure of a FIFO operation. Also known as a Queue.
 * Extends from List for being able to utilize the insert and remove methods.
 */
public class Queue extends List{
	/**
	 * @param data - Some data to enqueue at the end of the list.
	 */
	public void enqueue(Object data){
		super.append(data);
	}

	/**
	 * @return - Returns the First element in the queue.
	 */
	public Object dequeue(){
		return super.remove(0);
	}
}
