package Characters;

import java.util.Iterator;

import Show.Event;
import Show.Quote;

/**
 * The interface for the characters that have family relationships and romances associated
 * 
 * @author P8: Jose Murta 55226 && Diogo Rodrigues 56153
 *
 */
public interface Character extends Comparable<Character> {
	
	/**
	 * Get the character's name
	 * @return
	 */
	String getName();
	
	/**
	 * Add a parent to the character.
	 * @param parent - character parent
	 */
	void addParent(Character parent);
	
	/**
	 * Add a kid to the character
	 * @param kid - character kid
	 */
	void addKid(Character kid);
	
	/**
	 * Get number of parents of the character
	 * @return the number of parents
	 */
	int numberParents();
	
	/**
	 * Get number of kids of the character
	 * @return the number of kids
	 */
	int numberKids();
	
	/**
	 * Add a romance with character ca
	 * @param ca - character 
	 */
	void addRomance(Character ca);
	
	/**
	 * Add a event to the character
	 * @param e - Event e
	 */
	void addEvent (Event e);
	
	/**
	 * Add a sibling to the character.
	 * @param c - Character sibling
	 */
	void addSibling (Character c);
	
	/**
	 * Iterator to the kids of the character
	 * @return a iterator to th kids of the character
	 */
	Iterator<Character> listKids ();
	
	/**
	 * Iterator to the parents of the character
	 * @return a iterator to the parents of the character
	 */
	Iterator<Character> listParents();
	
	/**
	 * Iterator to the siblings of the character
	 * @return a iterator to the siblings of the character
	 */
	Iterator<Character> listSiblings();
	
	/**
	 * Iterator to he romances of the character
	 * @return a iterator to the romances of the character
	 */
	Iterator<Character> listRomance();
	
	/**
	 * Iterator to the events of the character
	 * @return  iterator to the events of the character
	 */
	Iterator<Event> listEvents();
	
	/**
	 * Check if the character has any parent
	 * @return true, if the character has at least one parent
	 */
	boolean hasParents();
	
	/**
	 * Check if the character has any kid
	 * @return true, if the character has at least one kid
	 */
	boolean hasKids();
	
	/**
	 * Check if the character has any romance
	 * @return true, if the character has at least one romance
	 */
	boolean hasRomance();
	
	/**
	 * Check if the character has any sibling
	 * @return true, if the character has at least one sibling
	 */
	boolean hasSiblings();
	
	/**
	 * Check if the character has already this parent
	 * @param parent - character parent
	 * @return true, if the character has already the character
	 */
	boolean hasParent (Character parent);
	
	/**
	 * Check if the character has already this child
	 * @param child character child
	 * @return true, if the character has already the character 
	 */
	boolean hasChild (Character child);
	
	/**
	 * Check if the romance already exists with the character c
	 * @param c - character c
	 * @return true, if the romance already exists.
	 */
	boolean hasRomance(Character c);
	
	/**
	 * Adds a new season to the character
	 */
	void addSeason (int season);
	
	/**
	 * Gets the number of seasons where the character participate
	 * @return - the number of seasons where the character participate
	 */
	int nSeasons ();
	
	/**
	 * Get the number of romances of the character
	 * @return the number of romances of the character
	 */
	int nRomances ();
	
	/**
	 * Check if the character has already sibling c 
	 * @param c - Character c
	 * @return true, if the character has this sibling
	 */
	boolean hasSiblingOf(Character c);
	
	/**
	 * Check if the character has already present in the season of the Event e
	 * @param e - Event's name
	 * @return true, if the character is already present in the season
	 */
	boolean hasEventWithSeason(Event e);
	
	/**
	 * Check if the character has already present in the season of the Quote q
	 * @param q - Quote's name
	 * @return true, if the character is already present in the season
	 */
	boolean hasQuoteWithSeason (Quote q);
	
}
