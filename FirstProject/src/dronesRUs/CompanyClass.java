package dronesRUs;

/**
 * he company that manages the all aplicacion, dictating what the bases do
 * 
 * @author Jose Murta & Diogo Ramos
 *
 */
public class CompanyClass implements Company {

	private static final int DEFAULT_SIZE = 100;

	/**
	 * All base's array
	 */
	private Bases[] bases;

	/**
	 * The number of bases in the base's array
	 */
	private int counter;

	/**
	 * All drone's array
	 */
	private Drones[] drones;

	/**
	 * The number of drones in all drone's array
	 */
	private int nDrones;

	/**
	 * All orders array
	 */
	private Orders[] orders;

	/**
	 * The number of orders in all order's array
	 */
	private int nOrders;

	/**
	 * The company constructor
	 */
	public CompanyClass() {
		bases = new Bases[DEFAULT_SIZE];
		counter = 0;
		drones = new Drones[DEFAULT_SIZE];
		nDrones = 0;
		orders = new Orders[DEFAULT_SIZE];
		nOrders = 0;

	}

	public void registBase(int latitude, int longitude, String baseId) {
		if (isBasesFull())
			resize();
		bases[counter++] = new BasesClass(latitude, longitude, baseId);
	}

	public boolean sameBaseId(String id) {
		return searchIndexWithId(id) != -1;
	}

	public boolean sameBaseCoords(int latitude, int longitude) {
		return searchIndexWithCoord(latitude, longitude) != -1;
	}

	public Bases getBases(String baseId) { // ver os casos em que pudera ser melhor
		Bases base = null;
		for (int i = 0; i < counter; i++) {
			if (bases[i].getBaseId().equals(baseId))
				base = bases[i];

		}
		return base;
	}

	public void addHermitDrone(String baseId, String droneId, int capacity, int range) {
		bases[searchIndexWithId(baseId)].addHermitDrone(droneId, capacity, range);
		drones[nDrones++] = new HermitDronesClass(droneId, capacity, range);
	}

	public void addSociableDrone(String baseId, String droneId, int capacity, int range) {
		bases[searchIndexWithId(baseId)].addSociableDrone(droneId, capacity, range);
		drones[nDrones++] = new SociableDronesClass(droneId, capacity, range);
	}

	public void addOrder(String baseId, String orderId, int dimension, int latitude, int longitude) {
		bases[searchIndexWithId(baseId)].addOrder(orderId, dimension, latitude, longitude);
		orders[nOrders++] = new OrdersClass(orderId, dimension, latitude, longitude);
	}

	/**
	 * Auxiliar method to search orders
	 * 
	 * @param orderId - the order's identifier
	 * @return the order's index or -1 if the method doesn't found the order
	 */
	private int searchOrderWithId(String orderId) {
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

	public void sendToDelivered(String orderId) {
		for (int i = searchOrderWithId(orderId); i < nOrders; i++) {
			orders[i] = orders[i + 1];
		}
		nOrders--;
	}

	public IteratorDrones listDrones() {
		return new IteratorDrones(drones, nDrones);
	}

	public boolean hasOrders() {
		return nOrders > 0;
	}

	public boolean sameDroneId(String droneId) {
		boolean result = false;
		for (int i = 0; i < counter; i++) {
			if (bases[i].sameDroneId(droneId))
				result = true;
			else
				i++;
		}
		return result;
	}

	public boolean hasDroneAvailableInBase(String baseId, String droneId) {
		boolean result = false;
		if (bases[searchIndexWithId(baseId)].sameDroneId(droneId)) {
			result = true;
		}
		return result;
	}
	
	/**
	 * @pre: baseId != null
	 * 
	 * Auxiliar method to search bases by their identifier
	 * 
	 * @param baseId - the base's identifier
	 * @return the base's index or -1 if the method doesn't found the base
	 */
	private int searchIndexWithId(String baseId) {
		int result = -1;
		int i = 0;
		while (i < counter && result == -1) {
			if (bases[i].getBaseId().equals(baseId))
				result = i;
			else
				i++;
		}
		return result;
	}
	
	/**
	 * Auxiliar method to search bases by their latitude and longitude
	 * 
	 * @param latitude - the base's latitude
	 * @param longitude - the base's longitude
	 * @return the base's index or -1 if the method doesn't found the base
	 */
	private int searchIndexWithCoord(int latitude, int longitude) {
		int result = -1;
		int i = 0;
		while (i < counter && result == -1) {
			if (bases[i].getLatitude() == latitude && bases[i].getLongitude() == longitude)
				result = i;
			else
				i++;
		}
		return result;
	}
	
	/**
	 * Consults if the base's array is full
	 * 
	 * @return true, if the base's array is full; false, otherwise
	 */
	private boolean isBasesFull() {
		return counter == bases.length;
	}
	
	/**
	 * @pre: base's array is full
	 * 
	 * Auxiliar method to duplicate the length of the base's array
	 */
	private void resize() {
		Bases[] tmp = new Bases[2 * counter];
		for (int i = 0; i < counter; i++)
			tmp[i] = bases[i];
		bases = tmp;
	}

	public IteratorBases iteratorbases() {
		return new IteratorBases(bases, counter);
	}

	public IteratorDrones iterateDrone(String baseId) {
		return bases[searchIndexWithId(baseId)].initializeDrones();
	}

	public void service(String baseId, String droneId) {
		bases[searchIndexWithId(baseId)].sendToService(droneId);
	}

	public IteratorDrones iterateServiceDrones(String baseId) {
		return bases[searchIndexWithId(baseId)].initializeServiceDrones();
	}

	public boolean hasDrones() {
		boolean drones = false;
		for (int i = 0; i < counter; i++) {
			if (bases[i].hasDrones()) {
				drones = true;
				break;
			}
		}
		return drones;
	}

	public double calculateDistance(String orderId, String baseId) {
		int baseLatitude = bases[searchIndexWithId(baseId)].getLatitude();
		int baseLongitude = bases[searchIndexWithId(baseId)].getLongitude();
		int orderLatitude = bases[searchIndexWithId(baseId)].getOrders(orderId).getLatitude();
		int orderLongitude = bases[searchIndexWithId(baseId)].getOrders(orderId).getLongitude();
		double distance = Math
				.sqrt(Math.pow(baseLatitude - orderLatitude, 2) + Math.pow(baseLongitude - orderLongitude, 2));
		return distance;
	}

	public double subtractRange(String orderId, String baseId, String droneId) {
		return bases[searchIndexWithId(baseId)].getDrone(droneId).subRange(calculateDistance(droneId, baseId));
	}

	public boolean addingHermit(String baseId, String droneId) {
		return bases[searchIndexWithId(baseId)].isHermit(droneId);
	}

	public void newSwarm(String swarmId, String[] dronesIds, int nInitialDrones, String baseId) {
		Drones[] social = new Drones[nInitialDrones];
		int nSocial = 0;
		int range = 0;
		int capacity = 0;
		double minRange = Double.POSITIVE_INFINITY;
		for (int i = 0; i < nInitialDrones; i++) {
			social[nSocial++] = getBases(baseId).getDrone(dronesIds[i]);
			capacity = capacity + getBases(baseId).getDrone(dronesIds[i]).capacity();
			if (getBases(baseId).getDrone(dronesIds[i]).range() < minRange) {
				minRange = getBases(baseId).getDrone(dronesIds[i]).range();
			}
			range = (int) minRange;
			getBases(baseId).newInSwarm(dronesIds[i]);
		}
		getBases(baseId).newSwarm(swarmId, capacity, range, nInitialDrones, social);
	}

}
