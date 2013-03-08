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
     * crée un
     * <code>fifo</code> vide
     */
    public Fifo() {
        items = (E[]) new Object[MAX_ITEMS];
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

        items[count] = item;
        count++;
    }

    /**
     * supprime le premier élément du fifo
     *
     * @todo finir la méthode. Si on supprim l'élém à l'index 0 ça fout le bordel...
     * @return l'élément supprimé
     */
    @Override
    public E remove() {
        if (count == 0) {
            throw new EmptyStackException();
        }

        
       return null;
    }

    /**
     * Retourn le premier élément du fifo sans l'enlever
     *
     * @return le premier élément du fifo
     */
    @Override
    public E item() {
        return (E) items[0];
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