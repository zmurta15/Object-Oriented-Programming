package DataBase;

import Show.*;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import ActorsAndCompanys.Actor;
import ActorsAndCompanys.ActorClass;
import ActorsAndCompanys.CGICompany;
import ActorsAndCompanys.CGICompanyClass;
import Characters.CgiCharacter;
import Characters.CgiCharacterClass;
import Characters.Character;
import Characters.RealCharacter;
import Characters.RealCharacterClass;
import Exceptions.*;

/**
 * The DataBase that controls all the application, that has a list of shows, actors and CGIcompanys associated
 * 
 * @author P8: Jose Murta 55226 && Diogo Rodrigues 56153
 *
 */
public class DataBaseClass implements DataBase {
	private static final String VIRTUAL = "virtual";
	private static final String REAL = "real";
	/**
	 * Show selected by the user
	 */
	private Show currentShow;
	/**
	 * List of shows in DataBase
	 */
	private List<Show> shows;
	/**
	 * List of actors in DataBase
	 */
	private List<Actor> actors;

	/**
	 * List of CGI companys in DataBase
	 */
	private List<CGICompany> companys;

	/**
	 * Creates a dataBase.
	 */
	public DataBaseClass() {
		this.currentShow = null;
		shows = new LinkedList<Show>();
		actors = new LinkedList<Actor>();
		companys = new LinkedList<CGICompany>();
	}

	public void addShow(String showName) throws HasAlreadyShowException {
		if (hasShowWithName(showName)) {
			throw new HasAlreadyShowException();
		} else {
			Show show = new ShowClass(showName);
			shows.add(show);
			currentShow = show;
		}
	}

	public Show getCurrentShow() throws NoShowSelectedException {
		if (currentShow == null) {
			throw new NoShowSelectedException();
		} else {
			return currentShow;
		}
	}

	public Show getCurrentShow1() {
		return currentShow;
	}

	public Show switchToShow(String showName) throws ShowDoesNotExistException {
		Show show = getShow(showName);
		if (!hasShowWithName(showName)) {
			throw new ShowDoesNotExistException();
		} else {
			currentShow = show;
		}
		return currentShow;
	}

	public void addSeason() throws NoShowSelectedException {
		if (currentShow == null) {
			throw new NoShowSelectedException();
		} else {
			currentShow.addSeason();
		}
	}

	public void addEpisode(int seasonNumber, String episodeName) throws NoShowSelectedException, NoSeasonException {
		if (currentShow == null) {
			throw new NoShowSelectedException();
		} else if (!currentShow.hasSeason(seasonNumber)) {
			throw new NoSeasonException();
		} else {
			Season s = currentShow.getSeason(seasonNumber);
			s.addEpisode(episodeName);
		}
	}

	public void addCharacter(String type, String characterName, String actorOrCompany, int feeOrCost)
			throws NoShowSelectedException, InvalidTypeCharacterException, HasAlreadyCharacterException,
			NegativeActorFeeException {
		if (currentShow == null) {
			throw new NoShowSelectedException();
		} else if (!validType(type)) {
			throw new InvalidTypeCharacterException();
		} else if (currentShow.hasCaracter(characterName)) {
			throw new HasAlreadyCharacterException();
		} else if (feeOrCost < 0) {
			throw new NegativeActorFeeException();
		} else {
			if (type.equals(REAL)) {
				if (!hasActorWithName(actorOrCompany)) {
					Actor actor = new ActorClass(actorOrCompany);
					actors.add(actor);
				}
				Actor ac = getActor(actorOrCompany);
				RealCharacter rc = new RealCharacterClass(characterName, ac, feeOrCost);
				ac.addCharacter(currentShow, rc);
				currentShow.addCharacter(rc);
			}
			if (type.equals(VIRTUAL)) {
				if (!hasCompanyWithName(actorOrCompany)) {
					CGICompany cgic = new CGICompanyClass(actorOrCompany);
					companys.add(cgic);
				}
				CGICompany cgi = getCompany(actorOrCompany);
				CgiCharacter cg = new CgiCharacterClass(characterName, feeOrCost); // talvez passar tambem a company
				cgi.addCGI(cg);
				currentShow.addCharacter(cg);
			}
		}
	}

	public void addRelationship(String parentName, String childrenName)
			throws NoShowSelectedException, SameCharacterRelationshipException, CharacterDoesNotExistException1,
			CharacterDoesNotExistException2, HasAlreadyRelationshipException {
		if (currentShow == null) {
			throw new NoShowSelectedException();
		} else if (parentName.equals(childrenName)) {
			throw new SameCharacterRelationshipException();
		} else if (!currentShow.hasCaracter(parentName)) {
			throw new CharacterDoesNotExistException1();
		} else if (!currentShow.hasCaracter(childrenName)) {
			throw new CharacterDoesNotExistException2();
		} else if (currentShow.getCharacter(parentName).hasChild(currentShow.getCharacter(childrenName))) {
			throw new HasAlreadyRelationshipException();
		} else {
			currentShow.getCharacter(parentName).addKid(currentShow.getCharacter(childrenName));
			currentShow.getCharacter(childrenName).addParent(currentShow.getCharacter(parentName));
		}
	}

	public void addRomance(String first, String second)
			throws NoShowSelectedException, SameCharacterRelationshipException, CharacterDoesNotExistException1,
			CharacterDoesNotExistException2, HasAlreadyRomanceException {
		if (currentShow == null) {
			throw new NoShowSelectedException();
		} else if (first.equals(second)) {
			throw new SameCharacterRelationshipException();
		} else if (!currentShow.hasCaracter(first)) {
			throw new CharacterDoesNotExistException1();
		} else if (!currentShow.hasCaracter(second)) {
			throw new CharacterDoesNotExistException2();
		} else if (currentShow.getCharacter(first).hasRomance(currentShow.getCharacter(second))) {
			throw new HasAlreadyRomanceException();
		} else {
			Character c = currentShow.getCharacter(first);
			Character c1 = currentShow.getCharacter(second);
			c.addRomance(currentShow.getCharacter(second));
			c1.addRomance(currentShow.getCharacter(first));
		}
	}

	public void addEvent(String eventTitle, int seasonNumber, int episodeNumber, String[] characters)
			throws NoShowSelectedException, NoSeasonException, NoEpisodeException, CharacterDoesNotExistException1,
			RepeatedCharactersException {
		if (currentShow == null) {
			throw new NoShowSelectedException();
		} else if (!currentShow.hasSeason(seasonNumber)) {
			throw new NoSeasonException();
		} else if (!currentShow.getSeason(seasonNumber).hasEpisode(episodeNumber)) {
			throw new NoEpisodeException();
		} else if (HaveCharacter(characters) != -1) {
			throw new CharacterDoesNotExistException1();
		} else if (hasRept(characters)) {
			throw new RepeatedCharactersException();
		} else {
			Event e = new EventClass(eventTitle, currentShow.getSeason(seasonNumber),
					currentShow.getSeason(seasonNumber).getEpisode(episodeNumber));
			for (int i = 0; i < characters.length; i++) {
				if (!currentShow.getCharacter(characters[i]).hasEventWithSeason(e)) {
					currentShow.getCharacter(characters[i]).addSeason(seasonNumber);
				}
				e.addCharacter(currentShow.getCharacter(characters[i]));
				currentShow.getCharacter(characters[i]).addEvent(e);

			}
			currentShow.getSeason(seasonNumber).getEpisode(episodeNumber).addEvent(e);

		}
	}

	public void addQuote(int seasonNumber, int episodeNumber, String characterName, String quote)
			throws NoShowSelectedException, NoSeasonException, NoEpisodeException, CharacterDoesNotExistException1 {
		if (currentShow == null) {
			throw new NoShowSelectedException();
		} else if (!currentShow.hasSeason(seasonNumber)) {
			throw new NoSeasonException();
		} else if (!currentShow.getSeason(seasonNumber).hasEpisode(episodeNumber)) {
			throw new NoEpisodeException();
		} else if (!currentShow.hasCaracter(characterName)) {
			throw new CharacterDoesNotExistException1();
		} else {
			if (!currentShow.hasQuote(quote)) {
				Quote q = new QuoteClass(quote, currentShow.getSeason(seasonNumber));
				if (!currentShow.getCharacter(characterName).hasQuoteWithSeason(q)) {
					currentShow.getCharacter(characterName).addSeason(seasonNumber);
				}
				q.addCharacter(currentShow.getCharacter(characterName));
				currentShow.addQuote(q);
			} else {
				Quote q = currentShow.getQuote(quote);
				q.addCharacter(currentShow.getCharacter(characterName));
			}

		}
	}

	public Iterator<Season> seasonsOutline(int firstSeason, int lastSeason)
			throws NoShowSelectedException, InvalidSeasonsIntervalException {
		if (currentShow == null) {
			throw new NoShowSelectedException();
		} else if (!validSeason(firstSeason, lastSeason)) {
			throw new InvalidSeasonsIntervalException();
		} else {
			return currentShow.listSeasons();
		}
	}

	public Character characterResume(String characterName)
			throws NoShowSelectedException, CharacterDoesNotExistException1 {
		if (currentShow == null) {
			throw new NoShowSelectedException();
		} else if (!currentShow.hasCaracter(characterName)) {
			throw new CharacterDoesNotExistException1();
		} else {
			return currentShow.getCharacter(characterName);
		}
	}

	public Iterator<Character> howAreTheseTwoRelated(String character1, String character2)
			throws NoShowSelectedException, CharacterDoesNotExistException1, CharacterDoesNotExistException2,
			SameCharacterRelationshipException, CharactersNotRelatedException {
		if (currentShow == null) {
			throw new NoShowSelectedException();
		} else if (!currentShow.hasCaracter(character1)) {
			throw new CharacterDoesNotExistException1();
		} else if (!currentShow.hasCaracter(character2)) {
			throw new CharacterDoesNotExistException2();
		} else if (character1.equals(character2)) {
			throw new SameCharacterRelationshipException();
		} else if (currentShow.getCharacter(character1).hasSiblingOf(currentShow.getCharacter(character2))) {
			throw new CharactersNotRelatedException();
		} 
		else {
			Character c = currentShow.getCharacter(character1);
			Character c1 = currentShow.getCharacter(character2);
			List<Character> tmp = new LinkedList<Character>();
			tmp = checkRelated(c, c1, tmp);
			if (!tmp.contains(c1)) {
				tmp = checkRelated (c1,c,new LinkedList<Character>());
			}
			if((!tmp.contains(c))) {
				throw new CharactersNotRelatedException();
			}
			return tmp.iterator();
		}
	}
	

	public Iterator<Character> famousQuotes(String quote) throws NoShowSelectedException, NoOneSaidQuoteException {
		if (currentShow == null) {
			throw new NoShowSelectedException();
		} else if (!currentShow.hasQuote(quote)) {
			throw new NoOneSaidQuoteException();
		} else {
			return currentShow.getQuote(quote).famous();
		}
	}

	public Iterator<Show> alsoAppears(String characterName)
			throws NoShowSelectedException, CharacterDoesNotExistException1, CgiCharacterException {
		if (currentShow == null) {
			throw new NoShowSelectedException();
		} else if (!currentShow.hasCaracter(characterName)) {
			throw new CharacterDoesNotExistException1();
		} else if (currentShow.getCharacter(characterName) instanceof CgiCharacter) {
			throw new CgiCharacterException();
		} else {
			RealCharacter s = (RealCharacter) currentShow.getCharacter(characterName);
			Actor a = s.getActor();
			return a.listShows();
		}
	}

	public Iterator<Actor> mostRomantic(String actorName)
			throws ActorDoesNotExistException, NoRomanticRelationshipsException {
		if (!hasActorWithName(actorName)) {
			throw new ActorDoesNotExistException();
		} else if (!hasRomanticActors()) {
			throw new NoRomanticRelationshipsException();
		} else {
			SortedSet<Actor> tmp = new TreeSet<Actor>();
			Iterator<Actor> it = actors.iterator();
			while (it.hasNext()) {
				Actor a = it.next();
				tmp.add(a);
			}
			return tmp.iterator();
		}
	}

	public CGICompany kingOfCGI() throws NoVirtualCharacterException {
		CGICompany king = null;
		if (companys.size() == 0) {
			throw new NoVirtualCharacterException();
		} else {
			Iterator<CGICompany> it = companys.iterator();
			while (it.hasNext()) {
				CGICompany c = it.next();
				if (king == null) {
					king = c;
				} else {
					if (king.getTotal() == c.getTotal()) {
						if (king.numberCharacters() == c.numberCharacters()) {
							if (king.getCompanyName().compareTo(c.getCompanyName()) > 0) {
								king = c;
							}
						}
						if (king.numberCharacters() > c.numberCharacters()) {
							king = c;
						}
					}
					if (king.getTotal() < c.getTotal()) {
						king = c;
					}
				}
			}
		}
		return king;

	}

	// -----------------------------------------------------------------------------------------------------------------------
	public Show getShow(String showName) {
		Show show = null;
		Iterator<Show> it = shows.iterator();
		while (it.hasNext()) {
			Show tmp = it.next();
			if (tmp.getShowName().equals(showName))
				show = tmp;
		}
		return show;
	}

	/**
	 * Check if there is a show with showName
	 * 
	 * @param showName - show's name
	 * @return true, if there is already a show
	 */
	private boolean hasShowWithName(String showName) {
		boolean has = false;
		Iterator<Show> it = shows.iterator();
		while (it.hasNext()) {
			Show tmp = it.next();
			if (tmp.getShowName().equals(showName)) {
				has = true;
			}
		}
		return has;
	}

	public Actor getActor(String actorName) {
		Actor actor = null;
		Iterator<Actor> it = actors.iterator();
		while (it.hasNext()) {
			Actor tmp = it.next();
			if (tmp.getActorName().equals(actorName))
				actor = tmp;
		}
		return actor;
	}

	/**
	 * Check if there is a actor with actorName
	 * 
	 * @param actorName - actor's name
	 * @return true, if the actor exists.
	 */
	private boolean hasActorWithName(String actorName) {
		boolean has = false;
		Iterator<Actor> it = actors.iterator();
		while (it.hasNext()) {
			Actor tmp = it.next();
			if (tmp.getActorName().equals(actorName)) {
				has = true;
			}
		}
		return has;
	}

	public CGICompany getCompany(String companyName) {
		CGICompany company = null;
		Iterator<CGICompany> it = companys.iterator();
		while (it.hasNext()) {
			CGICompany tmp = it.next();
			if (tmp.getCompanyName().equals(companyName))
				company = tmp;
		}
		return company;
	}

	/**
	 * Check if there is already a company with companyName
	 * 
	 * @param companyName - company's name
	 * @return true, if the company already exists.
	 */
	private boolean hasCompanyWithName(String companyName) {
		boolean has = false;
		Iterator<CGICompany> it = companys.iterator();
		while (it.hasNext()) {
			CGICompany tmp = it.next();
			if (tmp.getCompanyName().equals(companyName)) {
				has = true;
			}
		}
		return has;
	}

	/**
	 * Check if the type of character is valid
	 * 
	 * @param type - character's type
	 * @return true, if the type is valid
	 */
	private boolean validType(String type) {
		boolean found = false;
		if (type.equals(REAL)) {
			found = true;
		}
		if (type.equals(VIRTUAL)) {
			found = true;
		}
		return found;
	}

	public int getActorRoles(String actorName) {
		Actor a = getActor(actorName);
		return a.numberRoles();
	}

	public int HaveCharacter(String[] characters) {
		boolean found = false;
		int z = -1;
		for (int i = 0; i < characters.length && found == false; i++) {
			if (!currentShow.hasCaracter(characters[i])) {
				found = true;
				z = i;
			}
		}
		return z;
	}

	/**
	 * Check if the characters in the string vector are repeated.
	 * 
	 * @param characters - character's names
	 * @return true if the names are repeated
	 */
	private boolean hasRept(String[] characters) {
		boolean yes = false;
		for (int i = 0; i < characters.length; i++) {
			for (int j = i + 1; j < characters.length; j++) {
				if (characters[i].equals(characters[j])) {
					yes = true;
				}
			}
		}
		return yes;
	}

	/**
	 * Check if the interval of the season are valid.
	 * 
	 * @param seasonInit - initial season
	 * @param seasonEnd  - end season
	 * @return true, if the season is valid
	 */
	private boolean validSeason(int seasonInit, int seasonEnd) {
		boolean valid = false;
		if (seasonInit > 0 && seasonEnd > 0 && seasonEnd >= seasonInit && currentShow.hasSeason(seasonInit)
				&& currentShow.hasSeason(seasonEnd)) {
			valid = true;
		}
		return valid;
	}

	/**
	 * Check if there is at least one romantic relationship
	 * 
	 * @return true, if there is at least one romantic relationship
	 */
	private boolean hasRomanticActors() {
		boolean romances = false;
		Iterator<Actor> it = actors.iterator();
		while (it.hasNext()) {
			Actor tmp = it.next();
			if (tmp.hasRomances()) {
				romances = true;
			}
		}
		return romances;
	}
	
	/**
	 * Checks if two characters are related, making  a list of the ancestors or descendants
	 * 
	 * @param c - the first character to search for ancestors or descendants
	 * @param c1 - the second character to search for ancestors or descendants
	 * @param l - the list that will be filled with the ancestors and descendants between the two characters 
	 * @return the list with the ancestors and descendants between the two characters 
	 */
	private List<Character> checkRelated (Character c, Character c1, List<Character> l) {
		List<Character> y =l;
		if (c.hasChild(c1)) {
			y.add(c);
			y.add(c1);
			return y;
		} else {
			Iterator<Character> it = c.listKids();
			while (it.hasNext()) {
				Character kid = it.next();
				if (!y.contains(c)) {
					y.add(c);
				}
				Iterator <Character> it1 = kid.listSiblings();
				while (it1.hasNext()) {
					Character sibling = it1.next();
					if (!sibling.hasChild(c1) && y.contains(sibling)) {
						y.remove(sibling);
					}
				}
				y = checkRelated (kid, c1, y);
			}
			return y;
		}
	}

}
