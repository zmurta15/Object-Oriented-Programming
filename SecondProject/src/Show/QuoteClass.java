package Show;

import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

import Characters.Character;

/**
 * The quote that has text, a season and a set of characters associated
 * 
 * @author P8: Jose Murta 55226 && Diogo Rodrigues 56153
 *
 */
public class QuoteClass implements Quote{
	/**
	 * Text of the quote
	 */
	private String quote;
	
	/**
	 * Season of the quote
	 */
	private Season season;
	
	/**
	 * Set of the characters organized by alphabetic order
	 */
	private SortedSet<Character> characters;
	
	/**
	 * Create a new quote.
	 * @param quote - text of the quote
	 */
	public QuoteClass(String quote, Season s) {
		this.quote = quote;
		characters = new TreeSet<Character>(); 
		this.season = s;
	}
	
	public void addCharacter (Character e) {
		characters.add(e);
	}
	public String getQuote() {
		return quote;
	}
	public Iterator<Character> famous() {
		return characters.iterator();
	}
	
	public Season getSeason () {
		return season;
	}

}
