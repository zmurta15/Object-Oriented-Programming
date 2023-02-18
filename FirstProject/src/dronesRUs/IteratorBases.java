package dronesRUs;

/**
 * The base's iterator
 * 
 * @author Jose Murta & Diogo Ramos
 *
 */
public class IteratorBases implements IteratorBasesInterface {
	/**
	 * Base's array
	 */
	private Bases[] bases;

	/**
	 * The base's counter
	 */
	private int counter;

	/**
	 * The current base that is being visited
	 */
	private int currentbases;

	/**
	 * @pre: bases != null && counter <bases.length
	 * 
	 *       Creates a new base's iterator
	 * 
	 * @param bases   - base's array
	 * @param counter - the base's counter
	 */
	public IteratorBases(Bases[] bases, int counter) {
		this.bases = bases;
		this.counter = counter;
		currentbases = 0;
	}

	public boolean hasNext() {
		return currentbases < counter;
	}

	public Bases next() {
		return bases[currentbases++];

	}

}
