package Show;

import java.util.LinkedList;
import java.util.List;

import Characters.Character;

/**
 * The event that has a title, a season, a episode and list of characters associated
 * 
 * @author P8: Jose Murta 55226 && Diogo Rodrigues 56153
 *
 */
public class EventClass implements Event{
	/**
	 * Event title
	 */
	private String eventTitle;
	/**
	 * Season of the event
	 */
	private Season season;
	/**
	 * Episode of the event
	 */
	private Episode episode;
	/**
	 * List of the characters in the event
	 */
	private List<Character> characters;

	/**
	 * Creates a event with a title, in a episode that is in a season
	 * @param eventTitle - The Event title
	 * @param s - Season given by argument
	 * @param e - Episode given by argument
	 */
	public EventClass(String eventTitle, Season s, Episode e) {
		this.eventTitle = eventTitle;
		this.season = s;
		this.episode = e;
		characters = new LinkedList<Character>();
	}
	public void addCharacter(Character c) {
		characters.add(c);
	}
	public String getEventTitle() {
		return eventTitle;
	}
	public Season getSeason() {
		return season;
	}
	public Episode getEpisode() {
		return episode;
	}
	
}
