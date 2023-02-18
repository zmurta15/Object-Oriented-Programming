package dronesRUs;

/**
 * Orders that will be handle by the bases, with some actions associated
 * 
 * @author Jose Murta & Diogo Ramos
 *
 */
public class OrdersClass implements Orders {
	/**
	 * Order's identifier
	 */
	private String orderId;

	/**
	 * Order's latitude
	 */
	private int latitude;

	/**
	 * Order's longitude
	 */
	private int longitude;

	/**
	 * Order's dimension
	 */
	private int dimension;

	/**
	 * Order's constructor that receives the order's identifier, dimension, latitude
	 * and longitude
	 * 
	 * @param orderId   - order's identifier
	 * @param dimension - order's dimension
	 * @param latitude  - order's latitude
	 * @param longitude - order's longitude
	 */
	public OrdersClass(String orderId, int dimension, int latitude, int longitude) {
		this.orderId = orderId;
		this.latitude = latitude;
		this.longitude = longitude;
		this.dimension = dimension;
	}

	public String getOrderId() {
		return orderId;
	}

	public int getLatitude() {
		return latitude;
	}

	public int getLongitude() {
		return longitude;
	}

	public int getDimension() {
		return dimension;
	}

}
