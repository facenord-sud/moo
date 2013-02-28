package dispenser.queue;

import dispenser.Dispenser;

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
     * crée un <code>fifo</code> vide
     */
    public Fifo() {
    }
    
    /**
     * ajoute l'élément passé en paramètre au fifo
     *
     * @param item l'élément que l'on veut ajouter au fifo
     */
    @Override
    public void put(Object item) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * supprime l'élément à la fin du stack
     *
     * @return l'élément supprimé
     */
    @Override
    public E remove() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Retourn le premier élément du fifo sans l'enlever
     *
     * @return le premier élément du fifo
     */
    @Override
    public E item() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     *test si le fifo est vide ou non
     * 
     * @return <code>true</code> si et seulement si le fifo est vide.
     * sinon <code>false</code>
     */
    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
