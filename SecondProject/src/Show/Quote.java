package Show;

import java.util.Iterator;

import Characters.Character;

/**
 * The quote that has text, a season and a set of characters associated
 * 
 * @author P8: Jose Murta 55226 && Diogo Rodrigues 56153
 *
 */
public interface Quote{

	/**
	 * Add a character to the quote
	 * @param e - character e
	 */
	public void addCharacter (Character e);
	
	/**
	 * Check the text of the quote
	 * @return the text of the quote
	 */
	String getQuote();
	
	/**
	 * Iterator to the characters of the quote
	 * @return a iterator to the characters
	 */
	Iterator<Character> famous();
	
	/**
	 * Get the season of the quote.
	 * @return the Season of the quote
	 */
	Season getSeason ();
}
