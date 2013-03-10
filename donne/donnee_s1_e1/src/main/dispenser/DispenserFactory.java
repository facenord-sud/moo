package dispenser;

import dispenser.stack.ArrayStack;
import dispenser.queue.Fifo;

/**
 * A factory that creates a dispenser implemented as a stack or a queue.
 * 
 * @author Andreas Ruppen
 */
public class DispenserFactory {
	
	/**
	 * Creates and returns a dispenser implemented as a stack.
	 * 
	 * @return the created stack
	 */
	public static Dispenser createStack() {
		//return new LinkedListStack();
		return new ArrayStack();
	}
	
	/**
	 * Creates and returns a dispenser implemented as a queue.
	 * 
	 * @return the created queue
	 */
	public static Dispenser createQueue() {
		return new Fifo();
	}
}
