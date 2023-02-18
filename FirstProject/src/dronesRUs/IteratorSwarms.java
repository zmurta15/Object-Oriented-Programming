package dronesRUs;

/**
 * The swarm's iterator
 * 
 * @author Jose Murta & Diogo Ramos
 *
 */
public class IteratorSwarms implements IteratorSwarmsInterface {
	
	/**
	 * Drone's array
	 */
	private Drones[] drones;
	
	/**
	 * The drone's counter
	 */
	private int counter;
	
	/**
	 * The current drone that is being visit
	 */
	private int currentSwarms;
	
	/**
	 * @pre: drones != null && counter < drones.length
	 * 
	 * Creates a new swarm's iterator
	 * 
	 * @param drones - the drone's array
	 * @param counter - the drone's counter
	 */
	public IteratorSwarms(Drones[] drones, int counter) {
		this.drones = drones;
		this.counter = counter;
		currentSwarms = 0;
	}

	public boolean hasNext() {
		return currentSwarms < counter;
	}

	public Drones next() {
		return drones[currentSwarms++];

	}

}

