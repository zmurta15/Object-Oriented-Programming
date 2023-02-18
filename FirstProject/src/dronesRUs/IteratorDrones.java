package dronesRUs;

/**
 * The drone's iterator
 * 
 * @author Jose Murta & Diogo Ramos
 *
 */
public class IteratorDrones implements IteratorDronesInterface{
	
	/**
	 * The drone's array
	 */
	private Drones [] drones;
	
	/**
	 * The drone's counter
	 */
	private int counter;
	
	/**
	 * The current drone that is being visit
	 */
	private int currentDrones;
	
	/**
	 * @pre: drones != null && counter < drones.length
	 * 
	 * Creates a new drone's iterator
	 * 
	 * @param drones - drone's array
	 * @param counter - the drone's counter
	 */
	public IteratorDrones (Drones[] drones, int counter) {
			this.drones = drones;
			this.counter = counter;
			currentDrones = 0;
		}
		
	public boolean hasNext () {
			return currentDrones < counter;
		}
		
	public Drones next () {
			return drones [currentDrones++];
			
		}
		
			
	}

