package Show;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * The episode that has a name, a number and a list of events associated
 * 
 * @author P8: Jose Murta 55226 && Diogo Rodrigues 56153
 *
 */
public class EpisodeClass implements Episode {
	
	/**
	 * Episode name
	 */
	private String episodeName;
	/**
	 * Episode number
	 */
	private int episodeNumber;
	/**
	 * List of events in the episode
	 */
	private List<Event> events;
	
	/**
	 * Create a new episode.
	 * @param episodeName - episode's name
	 */
	public EpisodeClass(String episodeName, int episodeNumber) {
		this.episodeName = episodeName;
		this.episodeNumber = episodeNumber;
		events = new LinkedList<Event>();
	}
	
	public String getName () {
		return episodeName;
	}
	public int getEpisodeNumber() {
		return episodeNumber;
	}
	public void addEvent(Event e) {
		events.add(e);
	}
	public Iterator<Event> listEvents() {
		return events.iterator();
	}


}
