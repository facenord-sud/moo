/*
 * IdGenerator.java
 *
 * Created on 4. octobre 2001, 14:34
 */

package shapes;

/**
 *
 * @author Andreas Ruppen
 */
public final class IdGenerator {

	private static IdGenerator INSTANCE = new IdGenerator();
	private static int lastId = 0;
    
    /** Creates new IdGenerator */
    public IdGenerator() {
    }
    /**
     * Returns the instance of the ServiceLocator class.
     */
    public static IdGenerator getUniqueInstance() {
        return INSTANCE;
    }

    public int nextId() {
        lastId++;
        return lastId;
    }

	/**
	 * 
	 * @uml.property name="lastId"
	 */
	public void setLastId(int l) {
		lastId = l;
	}

    
}
