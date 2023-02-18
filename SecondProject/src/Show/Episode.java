package Show;

import java.util.Iterator;

/**
 * The episode that has a name, a number and a list of events associated
 * 
 * @author P8: Jose Murta 55226 && Diogo Rodrigues 56153
 *
 */
public interface Episode {
	
	/**
	 * Get the name of the episode.
	 * @return the episode's name
	 */
	String getName (); 
	
	/**
	 * Check the episode number
	 * @return the episode number
	 */
	int getEpisodeNumber();
	
	/**
	 * Add an event to the episode
	 * @param e - Event
	 */
	void addEvent(Event e);
	
	/**
	 * Iterator to the events of the episode
	 * @return a iterator to the events of the episode
	 */
	Iterator<Event> listEvents();

}
