package dronesRUs;

/**
 * Swarms that will be formed by sociable drones
 * 
 * @author Jose Murta & Diogo Ramos
 *
 */
public interface Swarms extends SociableDrones,GroupDrones {
	
	/**
	 * Initializes the iterator of the drones that are inside of a swarm
	 * 
	 * @return - the iterator of the drones that are inside of a swarm
	 */
	IteratorDrones swarmComponents();
	
	
}
