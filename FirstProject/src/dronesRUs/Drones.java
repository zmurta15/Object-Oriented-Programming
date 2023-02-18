package dronesRUs;

/**
 * Drones that will work in bases with actions associated to them
 * 
 * @author Jose Murta & Diogo Ramos
 *
 */
public interface Drones {

	/**
	 * Consults the drone's identifier
	 * 
	 * @return the drone's identifier
	 */
	String getDroneId();

	/**
	 * Consults the drone's capacity
	 * 
	 * @return the drone's capacity
	 */
	int capacity();

	/**
	 * Consults the range that the drone can fly without maintenance
	 * 
	 * @return the drone's range
	 */
	int range();

	/**
	 * Subtracts the distance covered by the drone to the drone's range
	 * 
	 * @param - the distance covered
	 * @return the drone's range left
	 */
	double subRange(double d);

}
