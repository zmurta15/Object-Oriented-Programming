package Show;

import Characters.Character;

/**
 * The event that has a title, a season, a episode and list of characters associated
 * 
 * @author P8: Jose Murta 55226 && Diogo Rodrigues 56153
 *
 */
public interface Event {
	
	/**
	 * Add a character to the event
	 * @param c - character
	 */
	void addCharacter(Character c);
	
	/**
	 * Check the event description
	 * @return the event description
	 */
	String getEventTitle();
	
	/**
	 * Check the season where the event happens
	 * @return the season of the event
	 */
	Season getSeason();
	
	/**
	 * Check the episode where the event happens
	 * @return the episode of the event
	 */
	Episode getEpisode();
}
