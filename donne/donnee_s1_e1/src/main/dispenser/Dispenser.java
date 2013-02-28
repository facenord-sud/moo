package dispenser;

/**
 * The <code>Dispenser</code> interface represents a data structure holding a
 * collegtion of items.
 * 
 * @author Andreas Ruppen
 */
public interface Dispenser<E> {

	/**
	 * Puts an item into this dispenser.
	 * 
	 * @param item the item to be put into this dispenser.
	 */
	public void put(E item);

	/**
	 * Removes an item from this dispenser.
	 * 
	 * @return the item that was removed.
	 */
	public E remove();

	/**
	 * Returns an item of this dispenser without removing it.
	 * 
	 * @return the item to be returned.
	 */
	public E item();

	/**
	 * Tests if this dispenser is empty.
	 * 
	 * @return <code>true</code> if and only if the dispenser has no items;
	 *         <code>false</code> otherwise.
	 */
	public boolean isEmpty();
}