package dronesRUs;

/**
 * The swarm's iterator
 * 
 * @author Jose Murta & Diogo Ramos
 *
 */
public interface IteratorSwarmsInterface {
	
	/**
	 * Checks if there are more swarms to visit
	 * 
	 * @return true, if there are more swarms to visit; false, otherwise
	 */
	boolean hasNext();
	
	/**
	 * Returns the next swarm in the drone's array
	 * 
	 * @return the next swarm
	 */
	Drones next();
}
