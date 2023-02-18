package Exceptions;

@SuppressWarnings("serial")
/**
 * The exception that checks if there is already a show with the given name
 * 
 * @author P8: Jose Murta 55226 && Diogo Rodrigues 56153
 *
 */
public class HasAlreadyShowException extends Exception{
	
	/**
	 * Create an exception to check if there is already a show 
	 */
	public HasAlreadyShowException() {
		super();
	}
}
