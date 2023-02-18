package dronesRUs;

/**
 * Swarms that will be formed by sociable drones
 * 
 * @author Jose Murta & Diogo Ramos
 *
 */
public class SwarmsClass extends GroupDronesClass implements Swarms  {
	
	/**
	 * The array of drones that are inside a swarm 
	 */
	Drones drones[];
	
	/**
	 * The number of drones inside a swarm
	 */
	int nDrones;
	
	/**
	 * The swarm's constructor that receive the swarm's identifier, capacity, range, number of initial drones
	 * 
	 * @param swarmId - the swarm's identifier
	 * @param capacity - the swarm's capacity
	 * @param range - the swarm's range
	 * @param nDrones - the number of initial drones inside the swarm
	 * @param drones - the array of drones inside the swarm
	 */
	public SwarmsClass(String swarmId, int capacity, int range, int nDrones, Drones drones[]) {
		super(swarmId, capacity, range);
		this.drones=drones;
		this.nDrones=nDrones;
	
		
	}
	public IteratorDrones swarmComponents() {
		return new IteratorDrones(drones, nDrones);
	}



}
