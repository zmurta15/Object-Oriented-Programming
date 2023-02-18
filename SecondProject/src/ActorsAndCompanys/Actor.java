package ActorsAndCompanys;


import java.util.Iterator;

import Characters.RealCharacter;
import Show.Show;

/**
 * The actor that has a list of real characters and shows that he participated in associated
 * 
 * @author P8: Jose Murta 55226 && Diogo Rodrigues 56153
 *
 */
public interface Actor extends Comparable<Actor> {
	
	/**
	 * Get the actor's name
	 * @return actor's name
	 */
	String getActorName();
	
	/**
	 * Add a character to the characters made by the actor.
	 * @param show - show show
	 * @param rc - Character to add
	 */
	void addCharacter (Show show, RealCharacter rc);
	
	/**
	 * Get the number of roles of the actor.
	 * @return the number of roles.
	 */
	int numberRoles ();
	
	/**
	 * Iterator to the shows of the actor
	 * @return a iterator to the shows of the actor
	 */
	Iterator<Show> listShows();
	
	/**
	 * Checks if at least one character of the actor has romantic relationships
	 * @return - true, if the actor has at least one character with romantic relationships; false, otherwise
	 */
	boolean hasRomances();
	
	/**
	 * Check the number of romances of the actor
	 * @return the number of romances of the actor
	 */
	int nRomances ();
	
	/**
	 * Check the number of shows of the actor
	 * @return the number of shows of the actor
	 */
	int nShows ();
	
	/**
	 * Check the number of shows with romances of the actor
	 * @return the number of shows with romances of the actor
	 */
	int nshowsRomance ();

}
