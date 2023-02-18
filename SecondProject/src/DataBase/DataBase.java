package DataBase;

import java.util.Iterator;

import ActorsAndCompanys.Actor;
import ActorsAndCompanys.CGICompany;
import Characters.Character;
import Exceptions.*;
import Show.*;

/**
 * Interface for the Database that controls all the application, that has a list of shows, actors and CGIcompanys associated
 * 
 * @author P8: Jose Murta, 55226 && Diogo Rodrigues 56153
 *
 */
public interface DataBase {

	/**
	 * Add a show to DataBase
	 * 
	 * @param showName - show's name
	 * @throws HasAlreadyShowException - if there is already a show with showName
	 */
	void addShow(String showName) throws HasAlreadyShowException;

	/**
	 * Return the currentShow selected by user
	 * 
	 * @return - current show selected
	 * @throws NoShowSelectedException - if there isn't a current show.
	 */
	Show getCurrentShow() throws NoShowSelectedException;
	
	/**
	 * Return the currentShow selected by the user.
	 * @return - currentshow selected
	 */
	Show getCurrentShow1();

	/**
	 * Switch the current show to a new one.
	 * 
	 * @param showName - new current show's name
	 * @return - the new current show
	 * @throws ShowDoesNotExistException - if there isn't a show with showName
	 */
	Show switchToShow(String showName) throws ShowDoesNotExistException;

	/**
	 * Add a new season to the current show.
	 * 
	 * @throws NoShowSelectedException - if there isn't a current show.
	 */
	void addSeason() throws NoShowSelectedException;

	/**
	 * Add a episode to a season from the current show.
	 * 
	 * @param seasonNumber - season's number to add a episode
	 * @param episodeName  - epsiode's name
	 * @throws NoShowSelectedException - if there isn't a current show
	 * @throws NoSeasonException       - if the show does not have the seasonNumber
	 */
	void addEpisode(int seasonNumber, String episodeName) throws NoShowSelectedException, NoSeasonException;

	/**
	 * Add a character to the current show.
	 * 
	 * @param type           - type of character
	 * @param characterName  - character's name
	 * @param actorOrCompany - Actor's name or company's name
	 * @param feeOrCost      - Real actor's fee by episode or Cgi character's cost
	 *                       per season
	 * @throws NoShowSelectedException       - if there isn't a current show
	 * @throws InvalidTypeCharacterException - if type isn't valid
	 * @throws HasAlreadyCharacterException  - if the character already exists
	 * @throws NegativeActorFeeException     - if the fee for the character is
	 *                                       negative integer
	 */
	public void addCharacter(String type, String characterName, String actorOrCompany, int feeOrCost)
			throws NoShowSelectedException, InvalidTypeCharacterException, HasAlreadyCharacterException,
			NegativeActorFeeException;

	/**
	 * Get the number of roles of the actor
	 * 
	 * @param actorName - the actor's name
	 * @return the number of roles
	 */
	int getActorRoles(String actorName);

	/**
	 * Add a family relationship between two characters.
	 * 
	 * @param parentName   - parent's name
	 * @param childrenName - children's name
	 * @throws NoShowSelectedException            - if there isn't a current show
	 * @throws SameCharacterRelationshipException - if the character is parent and
	 *                                            kid at the same time
	 * @throws CharacterDoesNotExistException1    - if the character parent does not
	 *                                            exist
	 * @throws CharacterDoesNotExistException2    - if the character kid does not
	 *                                            exist
	 * @throws HasAlreadyRelationshipException    - if the relationship already
	 *                                            exists
	 */
	void addRelationship(String parentName, String childrenName)
			throws NoShowSelectedException, SameCharacterRelationshipException, CharacterDoesNotExistException1,
			CharacterDoesNotExistException2, HasAlreadyRelationshipException;

	/**
	 * Add a romance between two characters.
	 * 
	 * @param first  - Name of character 1
	 * @param second - Name of character 2
	 * @throws NoShowSelectedException            - if there is not a show selected
	 *                                            by the user
	 * @throws SameCharacterRelationshipException - if a character is character 1
	 *                                            and 2 at the same time
	 * @throws CharacterDoesNotExistException1    - if the character 1 does not
	 *                                            exist
	 * @throws CharacterDoesNotExistException2    - if the character 2 does not
	 *                                            exist
	 * @throws HasAlreadyRomanceException         - if the romance already exists
	 */
	void addRomance(String first, String second) throws NoShowSelectedException, SameCharacterRelationshipException,
			CharacterDoesNotExistException1, CharacterDoesNotExistException2, HasAlreadyRomanceException;

	/**
	 * Add a event to a episode
	 * 
	 * @param eventTitle    - event title
	 * @param seasonNumber  - Season number
	 * @param episodeNumber - Episode number
	 * @param characters    - character(s)' name(s)
	 * @throws NoShowSelectedException         - if there is not a show selected by
	 *                                         the user.
	 * @throws NoSeasonException               - if there is no season with season
	 *                                         number in the show
	 * @throws NoEpisodeException              - if there is not a episode with
	 *                                         episode number in season number on
	 *                                         the show.
	 * @throws CharacterDoesNotExistException1 - if the character does not exist, or
	 *                                         one of the characters does not exist
	 * @throws RepeatedCharactersException - if ate least one of the characters is repeated
	 */
	void addEvent(String eventTitle, int seasonNumber, int episodeNumber, String[] characters)
			throws NoShowSelectedException, NoSeasonException, NoEpisodeException, CharacterDoesNotExistException1, RepeatedCharactersException;
	/**
	 * Add a quote to the show.
	 * @param seasonNumber - season number
	 * @param episodeNumber - episode number
	 * @param characterName - character name
	 * @param quote - quote text
	 * @throws NoShowSelectedException if there isn't a current show.
	 * @throws NoSeasonException if there is no season with season number
	 * @throws NoEpisodeException if there is no episode in the season with episode number
	 * @throws CharacterDoesNotExistException1 - if the character does not exist
	 */
	void addQuote(int seasonNumber, int episodeNumber, String characterName, String quote)
			throws NoShowSelectedException, NoSeasonException, NoEpisodeException, CharacterDoesNotExistException1;
	
	/**
	 * Lists the Seasons of the show.
	 * 
	 * @param firstSeason - first season number
	 * @param lastSeason - last season number
	 * @return a iterator to the seasons of the show
	 * @throws NoShowSelectedException - if there isn't a current show
	 * @throws InvalidSeasonsIntervalException - if the interval of the seasons is invalid
	 */
	Iterator<Season> seasonsOutline(int firstSeason, int lastSeason) throws NoShowSelectedException, InvalidSeasonsIntervalException;
	
	/**
	 *Lists the character's information
	 * 
	 * @param characterName - character
	 * @return the character's information
	 * @throws NoShowSelectedException - if there isn't a current show
	 * @throws CharacterDoesNotExistException1 - if the character given does not exist
	 */
	Character characterResume (String characterName) throws NoShowSelectedException, CharacterDoesNotExistException1;
	
	/**
	 *Lists the ancestors and descendants between two characters
	 * 
	 * @param character1 - the first character to search for ancestors or descendants 
	 * @param character2 - the second character to search for ancestors or descendants
	 * @return the name of the characters that are ancestors or descendants of the two characters
	 * @throws NoShowSelectedException - if there isn't a current show
	 * @throws CharacterDoesNotExistException1 - if the first character given does not exist
	 * @throws CharacterDoesNotExistException2 - if the second character given does not exist
	 * @throws SameCharacterRelationshipException - if the two characters given are the same
	 * @throws CharactersNotRelatedException - if the two characters are not related 
	 */
	Iterator<Character> howAreTheseTwoRelated(String character1, String character2) throws NoShowSelectedException, CharacterDoesNotExistException1, CharacterDoesNotExistException2, SameCharacterRelationshipException, CharactersNotRelatedException;
	
	/**
	 * Give the CGICompany with the highest revenue
	 * 
	 * @return - the CGICompany with the highest revenue
	 * @throws NoVirtualCharacterException - if there are not any virtual character already created
	 */
	CGICompany kingOfCGI() throws NoVirtualCharacterException;
	
	
	/**
	 * List the characters who have said a quote.
	 * @param quote - text of the quote
	 * @return a iterator to the characters of the quote
	 * @throws NoShowSelectedException if there isn't a current show
	 * @throws NoOneSaidQuoteException - if the quote doesn't exist
	 */
	Iterator<Character> famousQuotes(String quote) throws NoShowSelectedException, NoOneSaidQuoteException;
	
	/**
	 * List the shows where the actor of the character with character name is included.
	 * @param characterName - character's name
	 * @return a iterator to the shows of the actor
	 * @throws NoShowSelectedException - if there isn't a show selected by the user
	 * @throws CharacterDoesNotExistException1 - if the character with character name does not exist
	 * @throws CgiCharacterException - if the character is a cgi character
	 */
	Iterator<Show> alsoAppears (String characterName) throws NoShowSelectedException, CharacterDoesNotExistException1, CgiCharacterException;

	/**
	 * Check if the the string of the characters name already exist in DataBase and
	 * return a positive number if one of them does not exist.
	 * 
	 * @param characters - character(s)' name(s)
	 * @return -1 if all exist, a positive number if one does not exist.
	 */
	public int HaveCharacter(String[] characters);
	
	/**
	 * Iterator to the most romantic characters 
	 * @param actorName - actor's name
	 * @return a iterator to the most romantic characters
	 * @throws ActorDoesNotExistException - if the actor does not exist in DataBase
	 * @throws NoRomanticRelationshipsException - if there is no romantic relationships in DataBase    
	 */
	Iterator<Actor> mostRomantic(String actorName) throws ActorDoesNotExistException, NoRomanticRelationshipsException;
	
	/**
	 * Give the actor with the actor name 
	 * @param actorName - actor's name
	 * @return the Actor actor with actor name
	 */
	Actor getActor(String actorName);

}
