package dronesRUs;

/**
 * The company that manages the all aplicacion, dictating what the bases do
 * 
 * @author Jose Murta & Diogo Ramos
 *
 */
public interface Company {

	/**
	 * @pre: baseId != null
	 * 
	 *       Regists a new base with the given identifier in the given latitude
	 *       latitude and longitude
	 * 
	 * @param latitude  - the base's latitude
	 * @param longitude - the base's longitude
	 * @param baseId    - the base's identifier
	 */
	void registBase(int latitude, int longitude, String baseId);

	/**
	 * @pre: id != null
	 * 
	 *       Checks if there is a base with the given identifier in the company
	 * 
	 * @param id - the base's identifier
	 * @return true, if there is a base with the identifier in the company; false,
	 *         otherwise
	 */
	boolean sameBaseId(String id);

	/**
	 * Checks if there is a base with the given latitude and longitude in the
	 * company
	 * 
	 * @param latitude  - base's latitude
	 * @param longitude - base's longitude
	 * @return true, if there is a base with the given coordinates in the company;
	 *         false, otherwise
	 */
	boolean sameBaseCoords(int latitude, int longitude);

	/**
	 * @pre: droneId != null
	 * 
	 *       Checks if there is a drone with the identifier
	 * 
	 * @param droneId - the drone's identifier
	 * @return true, if there is a drone with the given identifier; false, otherwise
	 */
	boolean sameDroneId(String droneId);

	/**
	 * @pre: baseId != null && droneId != null && capacity>0 && range>=10
	 * 
	 *       Creates a new hermit drone with the drone's identifier, capacity and
	 *       range in the base that has the given identifier
	 * 
	 * @param baseId   - the base's identifier
	 * @param droneId  - the drone's identifier
	 * @param capacity - the drone's capacity
	 * @param range    - the drone's range
	 */
	void addHermitDrone(String baseId, String droneId, int capacity, int range);

	/**
	 * @pre: baseId != null && droneId != null && capacity>0 && range>=10
	 * 
	 *       Creates a new sociable drone with the drone's identifier, capacity and
	 *       range in the base that has the given identifier
	 * 
	 * @param baseId   - the base's identifier
	 * @param droneId  - the drone's identifier
	 * @param capacity - the drone's capacity
	 * @param range    - the drone's range
	 */
	void addSociableDrone(String baseId, String droneId, int capacity, int range);

	/**
	 * Initializes the base's iterator
	 * 
	 * @return the base's iterator
	 */
	IteratorBases iteratorbases();

	/**
	 * @pre: baseId != null
	 * 
	 *       Initializes the iterator of drones that are in the given base
	 * 
	 * @param baseId - base's identifier
	 * @return the iterator of drones that are in the given base
	 */
	IteratorDrones iterateDrone(String baseId);

	/**
	 * @pre: baseId != null && droneId != null
	 * 
	 *       Sends the drone with the given identifier to the service bay
	 * 
	 * @param baseId  - base's identifier
	 * @param droneId - the drone's identifier
	 */
	void service(String baseId, String droneId);

	/**
	 * @pre: baseId != null
	 * 
	 *       Initializes the iterator of drones that are in the service bay of the
	 *       given base
	 * 
	 * @param baseId - the base's identifier
	 * @return - the iterator of drones that are in service
	 */
	IteratorDrones iterateServiceDrones(String baseId);

	/**
	 * @pre: baseId != null
	 * 
	 *       Gets the base by its identifier
	 * 
	 * @param baseId - the base's identifier
	 * @return the base that has the given identifier
	 */
	Bases getBases(String baseId);

	/**
	 * Initializes the iterator of all the drones of all bases
	 * 
	 * @return the iterator of all the drones of all bases
	 */
	IteratorDrones listDrones();

	/**
	 * @pre: baseId != null && orderId != null && dimension >0
	 * 
	 *       Adds a new order to be handle by the given base
	 * 
	 * @param baseId    - the base's identifier
	 * @param orderId   - the order's identifier
	 * @param latitude  - the order's latitude
	 * @param longitude - the order's longitude
	 * @param dimension - the order's dimension
	 */
	void addOrder(String baseId, String orderId, int latitude, int longitude, int dimension);

	/**
	 * Checks if there was any order registered
	 * 
	 * @return true, if there is orders registered; false otherwise
	 */
	boolean hasOrders();

	/**
	 * @pre: orderId != null && baseId != null
	 * 
	 *       Calculates the distance between the base given and the order given
	 * 
	 * @param orderId - the order's identifier
	 * @param baseId  - the base's identifier
	 * @return
	 */
	double calculateDistance(String orderId, String baseId);

	/**
	 * @pre: orderId != null
	 * 
	 *       Removes the order to send it to the delivered orders
	 * 
	 * @param orderId - the order's identifier
	 */
	void sendToDelivered(String orderId);

	/**
	 * @pre: baseId != null && droneId != null
	 * 
	 *       Checks if the drone is hermit
	 * 
	 * @param baseId  - the base's identifier
	 * @param droneId - the drone's identifier
	 * @return true, if the drone is hermit; false, otherwise
	 */
	boolean addingHermit(String baseId, String droneId);

	/**
	 * @pre: baseId != null && droneId != null
	 * 
	 *       Checks if the drone is available in the base
	 * 
	 * @param baseId  - the base's identifier
	 * @param droneId - the drone's identifier
	 * @return true, if the drone is available in the base; false, otherwise
	 */
	boolean hasDroneAvailableInBase(String baseId, String droneId);
	
	/**
	 * @pre: swarmId != null && nInitialDrones >1 && baseId != null
	 * 
	 * Creates a new swarm with the given identifier and the given drones
	 * 
	 * @param swarmId - the swarm's identifier
	 * @param dronesIds - the array with the identifiers of the drones
	 * @param nInitialDrones - the number of initial drones
	 * @param baseId - the base's identifier
	 */
	public void newSwarm(String swarmId, String[] dronesIds, int nInitialDrones, String baseId);
	
	/**
	 * Checks if there are drones registered 
	 * 
	 * @return true, if there are drones registered; false, otherwise
	 */
	boolean hasDrones();
}
