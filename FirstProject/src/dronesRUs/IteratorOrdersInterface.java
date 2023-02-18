package dronesRUs;

/**
 * The order's iterator
 * 
 * @author Jose Murta & Diogo Ramos
 *
 */
public interface IteratorOrdersInterface {
	
	/**
	 * Checks if there are more drones to visit
	 * 
	 * @return true, if there are more orders to visit; false, otherwise
	 */
	boolean hasNext();
	
	/**
	 * Returns the next order in the order's array
	 * 
	 * @return the next order
	 */
	Orders next();
	
	
}
