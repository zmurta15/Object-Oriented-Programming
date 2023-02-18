package Show;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * The season that has a number and a list of episodes associated
 * 
 * @author P8: Jose Murta 55226 && Diogo Rodrigues 56153
 *
 */
public class SeasonClass implements Season {
	/**
	 * Season of this number
	 */
	private int seasonNumber;
	/**
	 * List of episodes from the season
	 */
	private List<Episode> episodes;
	
	/**
	 * Create a new season with season's number
	 * @param seasonNumber - season's number
	 */
	public SeasonClass(int seasonNumber) {
		this.seasonNumber = seasonNumber;
		episodes = new LinkedList<Episode>();
	}
	
	public int getNumberOfEpisodes() {
		return episodes.size();
	}
	
	public int getSeasonNumber() {
		return seasonNumber;
	}
	public void addEpisode(String episodeName) {
		Episode episode = new EpisodeClass(episodeName, getNumberOfEpisodes() +1);
		episodes.add(episode);
	}
	
	public Iterator<Episode> listEpisodes() {
		return episodes.iterator();
	}
	//------------------------------------------------------------------------
	public Episode getEpisode (int episodeNumber) {
		Episode episode = null;
		Iterator<Episode> it= episodes.iterator();
		while(it.hasNext()) {
			Episode tmp =it.next();
			if(tmp.getEpisodeNumber() ==episodeNumber)
				episode = tmp;
		}
		return episode;
	}
	
	public boolean hasEpisode(int episodeNumber) {
		boolean has = false;
		Iterator<Episode> it = episodes.iterator();
		while (it.hasNext()) {
			Episode tmp = it.next();
			if(tmp.getEpisodeNumber() == episodeNumber) {
				has = true;
			}
		}
		return has;
	}
}
