package Exceptions;

@SuppressWarnings("serial")
/**
 * The exception that checks if the interval between seasons given is invalid, that is if at least one of the season does not exist
 * 
 * @author P8: Jose Murta 55226 && Diogo Rodrigues 56153
 *
 */
public class InvalidSeasonsIntervalException extends Exception {
	
	/**
	 * Check if the interval of the seasons are invalid
	 */
	public InvalidSeasonsIntervalException() {
		super();
	}
}
