package dronesRUs;

/**
 * Bases that dictate what the drones will do
 * 
 * @author Jose Murta & Diogo Ramos
 *
 */
public interface Bases {

	/**
	 * Consults the base's latitude
	 * 
	 * @return the base's latitude
	 */
	int getLatitude();

	/**
	 * Consults the base's longitude
	 * 
	 * @return the base's longitude
	 */
	int getLongitude();

	/**
	 * Consults the base's identifier
	 * 
	 * @return the base's identifier
	 */
	String getBaseId();

	/**
	 * @pre: droneId != null && range>=10 && capacity>0
	 * 
	 *       Adds a new hermit drone to the base
	 * 
	 * @param droneId  - the hermit drone's identifier
	 * @param capacity - the hermit drone's capacity
	 * @param range    - the hermit drone's range
	 */
	void addHermitDrone(String droneId, int capacity, int range);

	/**
	 * @pre: droneId != null && range >=10 && capacity>0
	 * 
	 *       Adds a new sociable drone to the base
	 * 
	 * @param droneId  - the sociable drone's identifier
	 * @param capacity - the sociable drone's capacity
	 * @param range    - the sociable drone's range
	 */
	void addSociableDrone(String droneId, int capacity, int range);

	/**
	 * @pre: droneId != null
	 * 
	 *       Checks if there is a drone with the identifier in the base
	 * 
	 * @param droneId - the drone's identifier
	 * @return true, if there is a drone with the identifier in the base; false,
	 *         otherwise
	 */
	boolean sameDroneId(String droneId);

	/**
	 * Initializes the drone's iterator
	 * 
	 * @return the drone's iterator;
	 */
	IteratorDrones initializeDrones();

	/**
	 * @pre: droneId != null
	 * 
	 *       Sends the drone to the service bay
	 * 
	 * @param droneId - the drone's identifier
	 */
	void sendToService(String droneId);

	/**
	 * Initializes the service drone's iterator
	 * 
	 * @return the service drone's iterator
	 */
	IteratorDrones initializeServiceDrones();

	/**
	 * @pre: droneId != null
	 * 
	 *       Verifies if the drone is hermit
	 * 
	 * @param droneId - the drone's identifier
	 * @return true, if the drone is hermit; false, otherwise
	 */
	boolean isHermit(String droneId);

	/**
	 * @pre: droneId != null
	 * 
	 *       Sends the drone to the a swarm
	 * 
	 * @param droneId - the drone's identifier
	 */
	void newInSwarm(String droneId);

	/**
	 * Verifies if the base has drones associated
	 * 
	 * @return true, if the base has drones associated; false, otherwise
	 */
	boolean hasDrones();

	/**
	 * @pre: swarmId != null && capacity>0 && range>=10 && nInitialDrones >=2 &&
	 * 
	 *       Creates a new swarm with the swarm's identifier, capacity, range,
	 *       number of initial drones has arguments
	 * 
	 * @param swarmId        - the swarm's identifier
	 * @param capacity       - the swarm's capacity
	 * @param range          - the swarm's range
	 * @param nInitialDrones - the swarm's number of initial drones
	 * @param social         - array of drones
	 */
	void newSwarm(String swarmId, int capacity, int range, int nInitialDrones, Drones social[]);

	/**
	 * @pre: droneId != null
	 * 
	 *       Gets the drone by its identifier
	 * 
	 * @param droneId - the drone's identifier
	 * @return the drone that has the wanted drone identifier
	 */
	Drones getDrone(String droneId);

	/**
	 * @pre: droneId !=null
	 * 
	 *       Removes the drone that has the drone identifier mentioned
	 * 
	 * @param droneId - the drone's identifier
	 */
	void removeDrone(String droneId);

	/**
	 * @pre: droneId != null
	 * 
	 *       Adds a drone to the drone's array
	 * 
	 * @param droneId - the drone
	 */
	void addDrone(Drones droneId);

	/**
	 * @pre: orderId != null && dimension >0
	 * 
	 *       Adds a new order to a base, with the order's identifier, dimension,
	 *       latitude and longitude as arguments
	 * 
	 * @param orderId   - the order's identifier
	 * @param dimension - the order's dimension
	 * @param latitude  - the order's latitude
	 * @param longitude - the order's longitude
	 */
	void addOrder(String orderId, int dimension, int latitude, int longitude);

	/**
	 * @pre: orderId != null
	 * 
	 *       Verifies if the base has the order with the order's identifier given
	 *       has argument
	 * 
	 * @param orderId - order's identifier
	 * @return true, if the base has the order that has the given order identifier;
	 *         false, otherwise
	 */
	boolean hasOrder(String orderId);

	/**
	 * Initializes the order's iterator
	 * 
	 * @return the order's iterator
	 */
	IteratorOrders initializeOrders();

	/**
	 * @pre: orderId != null
	 * 
	 *       Gets the order by its identifier
	 * 
	 * @param orderId - the order's identifier
	 * @return the order that has the given order identifier
	 */
	Orders getOrders(String orderId);

	/**
	 * @pre: droneId != null
	 * 
	 *       Sends the drones flying to complete the mission given, and receives the
	 *       drone's identifier as argument
	 * 
	 * @param droneId - the drone's identifier
	 */
	void sendToInTransit(String droneId);

	/**
	 * @pre: orderId != null
	 * 
	 *       Sends the order with the order identifier given as argument to the
	 *       delivered order's array
	 * 
	 * @param orderId - the order's identifier
	 */
	void sendToDeliveredOrders(String orderId);

	/**
	 * Initializes the delivered order's iterator
	 * 
	 * @return the delivered order's iterator
	 */
	IteratorOrders initializeDeliveredOrders();

	/**
	 * @pre: swarmId != null
	 * 
	 *       Gets the swarm by its identifier
	 * 
	 * @param swarmId - the swarm's identifier
	 * @return the swarm that has the given itenfier
	 */
	Swarms getSwarms(String swarmId);

	/**
	 * @pre: droneId != null
	 * 
	 *       Removes the drone with the given identifier from the swarm
	 * 
	 * @param droneId - the drone's identifier
	 */
	void removeFromSwarm(String droneId);

	/**
	 * @pre: swarmId != null
	 * 
	 *       Removes the swarm that has the swarm identifier given has argument
	 * 
	 * @param swarmId - the swarm's identifier
	 */
	void removeSwarm(String swarmId);

	/**
	 * Initializes the in transit order's iterator
	 * 
	 * @return - the in transit order's iterator
	 */
	IteratorOrders initializeInTransitOrders();

	/**
	 * @pre: orderId != null
	 * 
	 *       Sends the order to the in transit orde's array
	 * 
	 * @param orderId - the order's identifier
	 */
	void sendToInTransitOrders(String orderId);

	/**
	 * @pre: droneId != null
	 * 
	 *       Sends the drones that were in transit back to the hangar
	 * 
	 * @param droneId - the drone's identifier
	 */
	void sendToHangar(String droneId);

	/**
	 * @pre: droneId != null
	 * 
	 *       Sends the drones that were in the service bay back to the hangar
	 * 
	 * @param droneId - the drone's identifier
	 */
	void serviceReturn(String droneId);
	
	/**
	 * Initializes the in transit drone's iterator
	 * 
	 * @return the in transit drone's iterator
	 */
	IteratorDrones initializeInTransitDrones();

}
