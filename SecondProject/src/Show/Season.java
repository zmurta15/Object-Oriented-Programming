package Show;

import java.util.Iterator;

/**
 * The season that has a number and a list of episodes associated
 * 
 * @author P8: Jose Murta 55226 && Diogo Rodrigues 56153
 *
 */
public interface Season {
	
	/**
	 * Number of episodes of the season
	 * @return the number of episodes of the season
	 */
	int getNumberOfEpisodes();
	
	/**
	 * Number of season
	 * @return the season number
	 */
	int getSeasonNumber();
	 
	/**
	 * Add a episode to the season
	 * @param episodeName - episode's name
	 */
	void addEpisode(String episodeName);
	
	/**
	 * Iterator to the episodes of the season
	 * @return a iterator to the episodes of the season
	 */
	Iterator<Episode> listEpisodes();
	
	/**
	 * Return the episode with episode number
	 * @param episodeNumber - episode Number
	 * @return the episode number
	 */
	Episode getEpisode (int episodeNumber);
	
	/***
	 * Check if there is episode with episode number
	 * @param episodeNumber - episode number
	 * @return true, if the episode exists
	 */
	boolean hasEpisode(int episodeNumber);

}
