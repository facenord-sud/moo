package dispenser.stack;

import dispenser.Dispenser;

/**
 * The
 * <code>ArrayStack</code> class represents a last-in-first-out (LIFO) stack
 * implemented with an array.
 *
 * @author Andreas Ruppen
 */
public class ArrayStack<E> implements Dispenser<E> {

    /**
     * A constant holding the maximum number of items a stack can have.
     */
    public static int MAX_ITEM = 100;
    /**
     * The array that holds the items.
     */
    private Object[] items;
    /**
     * The current number of items in the stack.
     */
    private int count;

    /**
     * Creates an empty
     * <code>ArrayStack</code>.
     */
    public ArrayStack() {
        items = (E[]) new Object[MAX_ITEM];
        count = 0;
    }

    /**
     * Puts an item onto the top of this stack.
     *
     * @param item the item to be put onto this stack.
     */
    @Override
    public void put(E item) {
        if (count >= MAX_ITEM) {
            // TODO throw a StackOverflowException
        }
        items[count++] = item;
    }

    /**
     * Removes the item at the top of this stack.
     *
     * @return the item that was removed.
     */
    @Override
    public E remove() {
        if (count == 0) {
            // TODO throw an EmptyStackException
        }
        Object oldItem = items[count - 1];
        items[--count] = null; // Will be garbage collected...

        return (E) oldItem;
    }

    /**
     * Returns the item at the top of this stack without removing it.
     *
     * @return the item at the top of this stack.
     */
    @Override
    public E item() {
        if (count == 0) {
            // TODO throw an EmptyStackException
        }
        return (E) items[count - 1];
    }

    /**
     * Tests if this stack is empty.
     *
     * @return <code>true</code> if and only if the stack has no items;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean isEmpty() {
        return count == 0;
    }
}
