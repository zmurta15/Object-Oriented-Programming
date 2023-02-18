package dronesRUs;

/**
 * The order's iterator
 * 
 * @author Jose Murta & Diogo Ramos
 *
 */
public class IteratorOrders implements IteratorOrdersInterface {

	/**
	 * Order's array
	 */
	private Orders[] orders;

	/**
	 * The order's counter
	 */
	private int counter;

	/**
	 * The current order that is being visit
	 */
	private int currentOrders;

	/**
	 * @pre: orders != null && counter < orders.length
	 * 
	 *       Creates a new order's iterator
	 * 
	 * @param orders  - the order's array
	 * @param counter - the order's counter
	 */
	public IteratorOrders(Orders[] orders, int counter) {
		this.orders = orders;
		this.counter = counter;
		currentOrders = 0;
	}

	public boolean hasNext() {
		return currentOrders < counter;
	}

	public Orders next() {
		return orders[currentOrders++];

	}

}
