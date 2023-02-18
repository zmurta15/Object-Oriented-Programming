package dronesRUs;

/**
 * Drones that will work in bases with actions associated to them
 * 
 * @author Jose Murta & Diogo Ramos
 *
 */

public abstract class AbstractDrones implements Drones {

	/**
	 * Drone's identifier
	 */
	private String droneId;

	/**
	 * Drone's capacity
	 */
	private int capacity;

	/**
	 * Drone's range
	 */
	private int range;

	/**
	 * @pre:droneId != null && capacity>0 && range >=10
	 * 
	 *              Drone's constructor that receives the drone's identifier,
	 *              capacity and range
	 * 
	 * @param droneId  - the drone's identifier
	 * @param capacity - the drone's capacity
	 * @param range    - the drone's range
	 */
	public AbstractDrones(String droneId, int capacity, int range) {
		this.droneId = droneId;
		this.capacity = capacity;
		this.range = range;
	}

	public String getDroneId() {
		return this.droneId;
	}

	public int capacity() {
		return this.capacity;
	}

	public int range() {
		return this.range;
	}

	public double subRange(double distance) {
		return range = (int) -distance;
	}

}
