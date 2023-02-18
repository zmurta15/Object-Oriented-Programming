package dronesRUs;

/**
 * Orders that will be handle by the bases, with some actions associated
 * 
 * @author Jose Murta & Diogo Ramos
 *
 */
public interface Orders {

	/**
	 * Consults the order's identifier
	 * 
	 * @return the order's identifier
	 */
	String getOrderId();

	/**
	 * Consults the order's latitude
	 * 
	 * @return the order's latitude
	 */
	int getLatitude();

	/**
	 * Consults the order's longitude
	 * 
	 * @return the order's longitude
	 */
	int getLongitude();

	/**
	 * Consults the order's dimension
	 * 
	 * @return the order's dimension
	 */
	int getDimension();

}
