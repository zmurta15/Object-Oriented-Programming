package dronesRUs;

/**
 * Bases that dictate what the drones will do
 * 
 * @author Jose Murta & Diogo Ramos
 *
 */
public class BasesClass implements Bases {

	private static final int DEFAULT_SIZE = 100;

	/**
	 * Base's latitude
	 */
	private int latitude;

	/**
	 * Base's longitude
	 */
	private int longitude;

	/**
	 * Base's baseId
	 */
	private String baseId;

	/**
	 * All drone's array
	 */
	private Drones[] drones;

	/**
	 * The number of drones in all drone's array
	 */
	private int nDrones;

	/**
	 * The drone's array that are in the service bay
	 */
	private Drones[] service;

	/**
	 * The number of drones in the service bay
	 */
	private int nService;

	/**
	 * The swarm's array
	 */
	private Drones[] swarms;

	/**
	 * The number of swarms
	 */
	private int nSwarms;

	/**
	 * The drone's that can form swarms array
	 */
	private Drones[] socialDrones;

	/**
	 * The number of drones that can form swarms
	 */
	private int nSocialDrones;

	/**
	 * The flying drone's array
	 */
	private Drones[] inTransitDrones;

	/**
	 * The number of drones that are flying
	 */
	private int nInTransit;

	/**
	 * The order's array that save the orders that are in transit
	 */
	private Orders[] inTransitOrders;

	/**
	 * The number of orders that are in transit
	 */
	private int nInTransitOrders;

	/**
	 * The all order's array
	 */
	private Orders[] orders;

	/**
	 * The number of orders
	 */
	private int nOrders;

	/**
	 * The delivered order's array
	 */
	private Orders[] deliveredOrders;

	/**
	 * The number of delivered orders
	 */
	private int nDelivered;

	/**
	 * The base's constructor that receives the base's latitude, longitude and
	 * identifier as arguments
	 * 
	 * @param latitude  - the base's latitude
	 * @param longitude - the base's longitude
	 * @param baseId    - the base's identifier
	 */
	public BasesClass(int latitude, int longitude, String baseId) {
		this.latitude = latitude;
		this.longitude = longitude;
		this.baseId = baseId;
		drones = new Drones[DEFAULT_SIZE];
		nDrones = 0;
		service = new Drones[DEFAULT_SIZE];
		nService = 0;
		swarms = new Drones[DEFAULT_SIZE];
		nSwarms = 0;
		socialDrones = new Drones[DEFAULT_SIZE];
		nSocialDrones = 0;
		inTransitDrones = new Drones[DEFAULT_SIZE];
		nInTransit = 0;
		orders = new Orders[DEFAULT_SIZE];
		nOrders = 0;
		deliveredOrders = new Orders[DEFAULT_SIZE];
		nDelivered = 0;
		inTransitOrders = new Orders[DEFAULT_SIZE];
		nInTransitOrders = 0;

	}

	public int getLatitude() {
		return this.latitude;
	}

	public int getLongitude() {
		return this.longitude;
	}

	public String getBaseId() {
		return this.baseId;
	}

	/**
	 * Auxiliar method to search swarms
	 * 
	 * @param swarmId - the swarm's identifier
	 * @return the swarm's index or -1 if the method doesn't found the swarm
	 */
	private int searchSwarm(String swarmId) {
		int result = -1;
		int i = 0;
		while (i < nSwarms && result == -1) {
			if (swarms[i].getDroneId().equals(swarmId))
				result = i;
			else
				i++;
		}
		return result;
	}

	public boolean sameSwarmId(String swarmId) {
		return searchSwarm(swarmId) != -1;
	}

	/**
	 * Auxiliar method to search the drones
	 * 
	 * @param droneId - the drone's identifier
	 * @return the drone's index or -1 if the method doesn't found the drone
	 */
	private int searchDrone(String droneId) {
		int result = -1;
		int i = 0;
		while (i < nDrones && result == -1) {
			if (drones[i].getDroneId().equals(droneId))
				result = i;
			else
				i++;
		}
		return result;
	}

	/**
	 * Auxiliar method to search the drones that are in the service bay
	 * 
	 * @param droneId - the drone's identifier
	 * @return the drone's index or -1 if the method doesn't found the drone
	 */
	private int searchServiceDrone(String droneId) {
		int result = -1;
		int i = 0;
		while (i < nService && result == -1) {
			if (service[i].getDroneId().equals(droneId))
				result = i;
			else
				i++;
		}
		return result;
	}

	/**
	 * Auxiliar method to search the drones that are in transit
	 * 
	 * @param droneId - the drone's identifier
	 * @return the drone's index or -1 if the method doesn't found the drone
	 */
	private int searchInTransitDrone(String droneId) {
		int result = -1;
		int i = 0;
		while (i < nInTransit && result == -1) {
			if (inTransitDrones[i].getDroneId().equals(droneId))
				result = i;
			else
				i++;
		}
		return result;
	}

	/**
	 * Auxiliar method to search the drones that can form swarms
	 * 
	 * @param droneId - the drone's identifier
	 * @return the drone's index or -1 if the method doesn't found the drone
	 */
	private int searchSocialDrone(String droneId) {
		int result = -1;
		int i = 0;
		while (i < nSocialDrones && result == -1) {
			if (socialDrones[i].getDroneId().equals(droneId))
				result = i;
			else
				i++;
		}
		return result;
	}

	public boolean hasDrones() {
		return nDrones + nService + nSwarms > 0;
	}

	public boolean sameDroneId(String droneId) {
		return searchDrone(droneId) != -1;
	}

	public void addHermitDrone(String droneId, int capacity, int range) {
		if (isDronesFull())
			resize();
		drones[nDrones++] = new HermitDronesClass(droneId, capacity, range);
	}

	public void addSociableDrone(String droneId, int capacity, int range) {
		if (isDronesFull())
			resize();
		drones[nDrones++] = new SociableDronesClass(droneId, capacity, range);
	}

	public void addOrder(String orderId, int dimension, int latitude, int longitude) {
		orders[nOrders++] = new OrdersClass(orderId, dimension, latitude, longitude);
	}

	/**
	 * Auxiliar method that search the orders
	 * 
	 * @param orderId - the order's identifier
	 * @return the order's index or -1 if the method doesn't found the order
	 */
	private int searchOrder(String orderId) {
		int result = -1;
		int i = 0;
		while (i < nOrders && result == -1) {
			if (orders[i].getOrderId().equals(orderId))
				result = i;
			else
				i++;
		}
		return result;
	}

	public boolean hasOrder(String orderId) {
		return searchOrder(orderId) != -1;
	}

	public IteratorOrders initializeOrders() {
		return new IteratorOrders(orders, nOrders);
	}

	public IteratorDrones initializeInTransitDrones() {
		return new IteratorDrones(inTransitDrones, nInTransit);
	}

	public IteratorDrones initializeDrones() {
		return new IteratorDrones(drones, nDrones);
	}

	public IteratorDrones initializeServiceDrones() {
		return new IteratorDrones(service, nService);
	}

	public void sendToService(String droneId) {
		Drones tmp = drones[searchDrone(droneId)];
		for (int i = searchDrone(droneId); i < nDrones; i++) {
			drones[i] = drones[i + 1];
		}
		nDrones--;
		service[nService++] = tmp;
	}

	public void serviceReturn(String droneId) {
		Drones tmp = service[searchDrone(droneId)];
		for (int i = searchServiceDrone(droneId); i < nService; i++) {
			service[i] = service[i + 1];
		}
		nService--;
		drones[nDrones++] = tmp;
	}

	public void sendToInTransit(String droneId) {
		Drones tmp = drones[searchDrone(droneId)];
		for (int i = searchDrone(droneId); i < nDrones; i++) {
			drones[i] = drones[i + 1];
		}
		nDrones--;
		inTransitDrones[nInTransit++] = tmp;
	}

	public void sendToHangar(String droneId) {
		Drones tmp = inTransitDrones[searchInTransitDrone(droneId)];
		for (int i = searchInTransitDrone(droneId); i < nInTransit; i++) {
			inTransitDrones[i] = inTransitDrones[i + 1];
		}
		nInTransit--;
		drones[nDrones++] = tmp;
	}

	public void sendToInTransitOrders(String orderId) {
		Orders tmp = orders[searchOrder(orderId)];
		for (int i = searchOrder(orderId); i < nOrders; i++) {
			orders[i] = orders[i + 1];
		}
		nOrders--;
		inTransitOrders[nInTransitOrders++] = tmp;
	}

	public void sendToDeliveredOrders(String orderId) {
		Orders tmp = orders[searchOrder(orderId)];
		for (int i = searchOrder(orderId); i < nOrders; i++) {
			orders[i] = orders[i + 1];
		}
		nOrders--;
		deliveredOrders[nDelivered++] = tmp;
	}

	public IteratorOrders initializeDeliveredOrders() {
		return new IteratorOrders(deliveredOrders, nDelivered);
	}

	public IteratorOrders initializeInTransitOrders() {
		return new IteratorOrders(inTransitOrders, nInTransitOrders);
	}

	public Drones getDrone(String droneId) { // ver os casos em que pudera ser melhor
		Drones drone = null;
		for (int i = 0; i < nDrones; i++) {
			if (drones[i].getDroneId().equals(droneId))
				drone = drones[i];

		}
		return drone;
	}

	public Swarms getSwarms(String swarmId) {
		Swarms swarm = null;
		System.out.println("nDrones= " + nDrones);
		for (int i = 0; i < nSocialDrones; i++) {
			System.out.println("FOR -> swarmId = " + drones[i].getDroneId());
			if (socialDrones[i].getDroneId().equals(swarmId)) {
				System.out.println("entrouuuu");
				swarm = (Swarms) socialDrones[i];
			}

		}
		return swarm;
	}

	public Orders getOrders(String orderId) { // ver os casos em que pudera ser melhor
		Orders order = null;
		for (int i = 0; i < nOrders; i++) {
			if (orders[i].getOrderId().equals(orderId))
				order = orders[i];

		}
		return order;
	}

	public boolean isHermit(String droneId) {
		return drones[searchDrone(droneId)] instanceof HermitDrones;
	}

	public boolean droneAvailable(String droneId) {
		return searchDrone(droneId) != -1;
	}

	public void newInSwarm(String droneId) {
		Drones tmp = drones[searchDrone(droneId)];
		for (int i = searchDrone(droneId); i < nDrones - 1; i++) { // acho que devia tirar o -1
			drones[i] = drones[i + 1];
		}
		nDrones--;
		socialDrones[nSocialDrones++] = tmp;
	}

	public void newSwarm(String swarmId, int capacity, int range, int nInitialDrones, Drones social[]) {
		drones[nDrones++] = new SwarmsClass(swarmId, capacity, range, nInitialDrones, social);

	}

	public void removeFromSwarm(String droneId) {
		Drones tmp = socialDrones[searchSocialDrone(droneId)];
		for (int i = searchSocialDrone(droneId); i < nSocialDrones - 1; i++) {
			socialDrones[i] = socialDrones[i + 1];
		}
		nSocialDrones--;
		drones[nDrones++] = tmp;

	}

	public void removeSwarm(String swarmId) {
		for (int i = searchDrone(swarmId); i < nDrones - 1; i++) {
			drones[i] = drones[i + 1];
		}
		nDrones--;
	}

	public void removeDrone(String droneId) {
		int pos = searchDrone(droneId);
		drones[pos] = drones[nDrones - 1];
		nDrones--;
	}

	public void addDrone(Drones droneId) { // nao funciona pois ele nao esta na originbase
		drones[nDrones++] = droneId;
	}

	/**
	 * Consults if the drone's array is full
	 * 
	 * @return true, if the drone's array is full; false otherwise
	 */
	private boolean isDronesFull() {
		return nDrones == drones.length;
	}

	/**
	 * @pre: drone's array is full
	 * 
	 *       Auxiliar method to duplicate the length of the drone's array
	 */
	private void resize() {
		Drones[] tmp = new Drones[2 * nDrones];
		for (int i = 0; i < nDrones; i++)
			tmp[i] = drones[i];
		drones = tmp;
	}

}
