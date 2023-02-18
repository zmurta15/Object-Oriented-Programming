package Show;

import java.util.Iterator;

import Characters.Character;

/**
 * The show that has a name, a list of characters, seasons and quotes associated
 * 
 * @author P8: Jose Murta 55226 && Diogo Rodrigues 56153
 *
 */
public interface Show extends Comparable<Show>{
	
	/**
	 *Get the show's name
	 * @return show's name
	 */
	String getShowName();
	
	/**
	 * Get the number of seasons
	 * @return number of seasons.
	 */
	 int getNumberOfSeasons();
	 
	 /**
	  * Get the number total of episodes.
	  * @return the number total of episodes.
	  */
	 int totalEpisodes();
	 
	 /**
	  * Add a season to the show
	  */
	 void addSeason();
	 
	 /**
	  * Add a character to the show.
	  * @param character - character Character
	  */
	 void addCharacter (Character character);
	 
	 /**
	  * Iterator to the seasons of the show
	  * @return a iterator of the seasons of the show.
	  */
	 Iterator<Season> listSeasons();
	 
	 /**
	  * Get the season number seasonNumber
	  * @param seasonNumber - season's number
	  * @return Season with seasonNumer
	  */
	 Season getSeason (int seasonNumber);
	 
	 /**
	  * Check if there is a season with seasonNumber
	  * @param seasonNumber - season's number
	  * @return true, if there is a season with seasonNumber
	  */
	 boolean hasSeason(int seasonNumber);
	 
	 /**
	  * Get the number of episodes from season seasonNumber
	  * @param seasonNumber - season's number
	  * @return the number of episodes from season seasonNumber
	  */
	 int getNumberOfEpisodesInSeason(int seasonNumber);
	 
	 /**
	  * Check if there is a character in the show with characterName
	  * @param characterName - character's name
	  * @return true, if the character already exists.
	  */
	 boolean hasCaracter(String characterName);
	 
	 /**
	  * Get the character in the show with characterName
	  * @param characterName - character's name
	  * @return - the character with character's name
	  */
	 Character getCharacter(String characterName);
	 
	 /**
	  * Get the quote quite the string quote
	  * @param quote - text of the quote
	  * @return - the quote with the string quote
	  */
	 Quote getQuote(String quote);
	 
	 /**
	  * Check if there is a quote with the string quote
	  * @param quote - text of the quote
	  * @return true, if the quote already exists
	  */
	 boolean hasQuote(String quote);
	 
	 /**
	  * Add a quote to the show
	  * @param q - quote q
	  */
	 void addQuote(Quote q);
	 
	 /**
	  * Check if there at least one romance in the show
	  * @return true, if there at least one romance in the show
	  */
	 boolean hasRomanceInShow();
	 
}
