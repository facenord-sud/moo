package dispenser.queue;

import dispenser.Dispenser;
import java.util.EmptyStackException;

/**
 *
 * @author leo
 */
public class Fifo<E> implements Dispenser<E> {

    /**
     * le tableau d'objets qui constituent le fifo
     */
    private Object[] items;
    /**
     * le nombre maxiamle d'objet que peut contenir le fifo
     */
    public static int MAX_ITEMS = 100;
    /**
     * le nombre d'objets mis dans le tableau
     */
    private int count;
    /**
     * l'avant de la queue
     */
    private int front;
    /**
     * l'arrière de la queue
     */
    private int rear;
        
    /**
     * crée un
     * <code>fifo</code> vide
     */
    public Fifo() {
        items = (E[]) new Object[MAX_ITEMS];
        front = 0;
        rear = -1;
        count = 0;
    }

    /**
     * ajoute l'élément passé en paramètre au fifo
     *
     * @param item l'élément que l'on veut ajouter au fifo
     */
    @Override
    public void put(E item) {
        if (count >= MAX_ITEMS) {
            throw new StackOverflowError();
        }

        items[++rear] = item;
        count++;
    }

    /**
     * supprime le premier élément du fifo
     *
     * 
     * @return l'élément supprimé
     */
    @Override
    public E remove() {
        if (count == 0) {
            throw new EmptyStackException();
            
        }
        
        Object temp = items[front++];
        count--;
        return (E) temp;
    }

    /**
     * Retourn le premier élément du fifo sans l'enlever
     *
     * @return le premier élément du fifo
     */
    @Override
    public E item() {
        return (E) items[front];
    }

    /**
     * test si le fifo est vide ou non
     *
     * @return <code>true</code> si et seulement si le fifo est vide. * * *
     * sinon <code>false</code>
     */
    @Override
    public boolean isEmpty() {
        return count == 0;
    }
}
