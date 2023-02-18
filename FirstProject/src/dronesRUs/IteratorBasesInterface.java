package dronesRUs;

/**
 * The base's iterator
 * 
 * @author Jose Murta & Diogo Ramos
 *
 */
public interface IteratorBasesInterface {
	
	/**
	 * Checks if there are more bases to visit
	 * 
	 * @return true, if there are more bases to visit; false, otherwise
	 */
	boolean hasNext();
	
	/**
	 * Returns the next base in the base's array
	 * 
	 * @return the next base
	 */
	Bases next();

}
