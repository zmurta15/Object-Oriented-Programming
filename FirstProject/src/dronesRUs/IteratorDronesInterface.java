package dronesRUs;

/**
 * The drone's iterator
 * 
 * @author Jose Murta & Diogo Ramos
 *
 */
public interface IteratorDronesInterface {
	
	/**
	 * Checks if there are more drones to visit
	 * 
	 * @return true, if there are more drones to visit; false, otherwise
	 */
	boolean hasNext ();
	
	/**
	 * Returns the next drone in the drone's array
	 * 
	 * @return the next drone
	 */
	Drones next ();
}
