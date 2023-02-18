package Exceptions;

@SuppressWarnings("serial")
/**
 * The excpetion that checks if the actor's fee is negative
 * 
 * @author P8: Jose Murta 55226 && Diogo Rodrigues 56153
 *
 */
public class NegativeActorFeeException extends Exception{ 
	
	/**
	 * Check if the fee to the actor is negative.
	 */
	public NegativeActorFeeException() {
		super();
	}

}
