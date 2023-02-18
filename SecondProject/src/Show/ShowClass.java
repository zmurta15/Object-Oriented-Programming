package Show;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import Characters.Character;

/**
 * The show that has a name, a list of characters, seasons and quotes associated
 * 
 * @author P8: Jose Murta 55226 && Diogo Rodrigues 56153
 *
 */
public class ShowClass implements Show{
	
	/**
	 * Name of show
	 */
	private String showName;
	
	/**
	 * List of seasons of the show
	 * 
	 */
	private List<Season> seasons;
	
	/**
	 * Counter to seasons
	 */
	private int seasonCounter;
	
	/**
	 * List of characters in the show
	 */
	private List<Character> characters;
	
	/**
	 * List of quotes in the show
	 */
	private List<Quote> quotes;
	
	
	/**
	 * Create a new show with this show's name.
	 * @param showName - show's name
	 */
	public ShowClass(String showName) {
		this.showName = showName;
		seasons = new LinkedList<Season>(); 
		seasonCounter = 1; 
		Season season = new SeasonClass(seasonCounter);
		seasons.add(season);
		characters = new LinkedList<Character>();
		quotes = new LinkedList<Quote>();;
	}
	
	public String getShowName() {
		return showName;
	}
	
	public int getNumberOfSeasons() {
		return seasonCounter;
	}
	public int getNumberOfEpisodesInSeason(int seasonNumber) {
		return getSeason(seasonNumber).getNumberOfEpisodes();
	}
	
	public int totalEpisodes() {
		Iterator<Season> it = seasons.iterator();
		int numberEpisodes = 0;
		while(it.hasNext()) {
			Season tmp = it.next();
			numberEpisodes += tmp.getNumberOfEpisodes();
		}
		return numberEpisodes;
 	}
	
	public void addSeason(){
		seasonCounter++;
		Season season = new SeasonClass(seasonCounter);
		seasons.add(season);
	}
	
	public void addCharacter (Character character) {
		characters.add(character);
	}
	
	public void addQuote(Quote q) {
		quotes.add(q);
	}
	
	public Iterator<Season> listSeasons() {
		return seasons.iterator();
	}
	
	//----------------------------------------------------------------------------------------------------
	
	public Season getSeason (int seasonNumber) {
		Season season = null;
		Iterator<Season> it= seasons.iterator();
		while(it.hasNext()) {
			Season tmp =it.next();
			if(tmp.getSeasonNumber()==seasonNumber)
				season = tmp;
		}
		return season;
	}
	
	public boolean hasSeason(int seasonNumber) {
		boolean has = false;
		Iterator<Season> it = seasons.iterator();
		while (it.hasNext()) {
			Season tmp = it.next();
			if(tmp.getSeasonNumber()==seasonNumber) {
				has = true;
			}
		}
		return has;
	}
	
	public Character getCharacter(String characterName) {
		Character c = null;
		Iterator<Character> it = characters.iterator();
		while(it.hasNext()) {
			Character tmp = it.next();
			if(tmp.getName().equals(characterName))
				c = tmp;
		}
		return c;
	}
	
	public boolean hasCaracter(String characterName) {
		boolean has = false;
		Iterator<Character> it = characters.iterator();
		while(it.hasNext()) {
			Character tmp = it.next();
			if(tmp.getName().equals(characterName)) {
				has = true;
			}
		}
		return has;
	}
	
	public Quote getQuote(String quote) {
		Quote q = null;
		Iterator<Quote> it = quotes.iterator();
		while(it.hasNext()) {
			Quote tmp = it.next();
			if(tmp.getQuote().equals(quote)) 
				q = tmp;
		}
		return q;
	}
	
	public boolean hasQuote(String quote) {
		boolean has = false;
		Iterator<Quote> it = quotes.iterator();
		while(it.hasNext()) {
			Quote tmp = it.next();
			if(tmp.getQuote().equals(quote)) {
				has = true;
			}
		}
		return has;
	}
	
	public boolean hasRomanceInShow() {
		boolean hasRomance = false;
		Iterator<Character> it = characters.iterator();
		while(it.hasNext()) {
			Character tmp = it.next();
			if(tmp.hasRomance()) {
				hasRomance = true;
			}
		}
		return hasRomance;
	}

	@Override
	public int compareTo(Show s) {
		return this.getShowName().compareTo(s.getShowName());
	}
	

	
}
