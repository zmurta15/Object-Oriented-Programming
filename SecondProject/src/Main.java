import java.util.Iterator;
import java.util.Scanner;

import ActorsAndCompanys.Actor;
import ActorsAndCompanys.CGICompany;
import Characters.Character;
import DataBase.*;
import Exceptions.*;
import Show.*;

public class Main {
	
	/**
	 * Outputs for the user
	 */
	private static final String THIS_IS_A_REAL_THING_THIS_IS_ART = "This is a real thing, this is art!";
	private static final String LOVE_IS_NOT_IN_THE_AIR = "Love is not in the air. :-(";
	private static final String STRING8 = " ";
	private static final String IS_PLAYED_BY_A_VIRTUAL_ACTOR = " is played by a virtual actor!";
	private static final String FIRST_TIME_I_HEAR_THAT = "First time I hear that!";
	private static final String THESE_CHARACTERS_ARE_NOT_RELATED = "These characters are not related!";
	private static final String LIKE_YOU_KNOW_THEY_ARE_THE_SAME_CHARACTER_DUUUUH = "Like... you know, they are THE SAME character! duuuuh...";
	private static final String STRING7 = "; ";
	private static final String ROMANTIC_RELATIONSHIPS = "Romantic relationships: ";
	private static final String SIBLINGS = "Siblings: ";
	private static final String KIDS2 = "Kids: ";
	private static final String NONE = "None.";
	private static final String STRING6 = ", ";
	private static final String PARENTS = "Parents: ";
	private static final String INVALID_SEASONS_INTERVAL = "Invalid seasons interval!";
	private static final String EP2 = " EP";
	private static final String S = "S";
	private static final String QUOTE_ADDED = "Quote added.";
	private static final String DOES_NOT_HAVE_EPISODE = " does not have episode ";
	private static final String STRING5 = "!";
	private static final String DOES_NOT_HAVE_SEASON = " does not have season ";
	private static final String EVENT_ADDED = "Event added.";
	private static final String CANNOT_BE_IN_A_SINGLE_PERSON_ROMANTIC_RELATIONSHIP = " cannot be in a single person romantic relationship!";
	private static final String ARE_NOW_A_COUPLE = " are now a couple.";
	private static final String AND = " and ";
	private static final String WHAT_ELSE_IS_NEW_WE_ALREADY_KNOW_ABOUT_THOSE_TWO = "What else is new? We already know about those two...";
	private static final String STRING4 = "?";
	private static final String WHO_IS = "Who is ";
	private static final String CANNOT_BE_PARENT_AND_CHILD_AT_THE_SAME_TIME = " cannot be parent and child at the same time!";
	private static final String PARENT_S = " parent(s).";
	private static final String KIDS = " kids. ";
	private static final String HAS_NOW = " has now ";
	private static final String SLAVERY_IS_LONG_GONE_AND_THIS_IS_OUTRAGEOUS = "Slavery is long gone and this is outrageous!";
	private static final String DUPLICATE_CHARACTER_NAMES_ARE_NOT_ALLOWED = "Duplicate character names are not allowed!";
	private static final String UNKNOWN_ACTOR_CATEGORY = "Unknown actor category!";
	private static final String THIS_IS_A_VIRTUAL_ACTOR = "This is a virtual actor.";
	private static final String STRING3 = ".";
	private static final String ROLE = " role ";
	private static final String THIS_IS = "This is ";
	private static final String REAL = "real";
	private static final String STRING2 = ". ";
	private static final String IS_NOW_PART_OF = " is now part of ";
	private static final String UNKNOWN_SEASON = "Unknown season!";
	private static final String STRING = ": ";
	private static final String EP = ", Ep";
	private static final String S2 = " S";
	private static final String UNKNOWN_SHOW = "Unknown show!";
	private static final String SHOW_ALREADY_EXISTS = "Show already exists!";
	private static final String CREATED = " created.";
	private static final String EPISODES = " Episodes: ";
	private static final String SEASONS = ". Seasons: ";
	private static final String NO_SHOW_IS_SELECTED = "No show is selected!";
	private static final String EXIT_TERMINATES = "exit - terminates the execution of the program";
	private static final String HELP_SHOWS = "help - shows the available commands";
	private static final String KING_OF_CGI_HELP = "kingOfCGI - find out which company has earned more revenue with their CGI virtual actors";
	private static final String MOST_ROMANTIC_HELP = "mostRomantic - find out who is at least as romantic as X";
	private static final String ALSO_APPEARS_HELP = "alsoAppearsOn - which other shows and roles is the same actor on?";
	private static final String FAMOUS_QUOTES_HELP = "famousQuotes - find out which character(s) said a particular quote";
	private static final String HOW_ARE_THESE_TWO_RELATED_HELP = "howAreTheseTwoRelated - find out if and how two characters may be related";
	private static final String CHARACTER_RESUME_HELP = "characterResume - outline the main information on a specific character";
	private static final String SEASONS_OUTLINE_HELP = "seasonsOutline - outline the contents of the selected seasons for the selected show";
	private static final String ADD_QUOTE_HELP = "addQuote - add a new quote to a character";
	private static final String ADD_EVENT_HELP = "addEvent - add a significant event involving at least one character";
	private static final String ADD_ROMANCE_HELP = "addRomance - add a romantic relationship between characters";
	private static final String ADD_RELATIONSHIP_HELP = "addRelationship - add a family relationship between characters";
	private static final String ADD_CHARACTER_HELP = "addCharacter - add a new character to a show";
	private static final String ADD_EPISODE_HELP = "addEpisode - add a new episode to a particular season of the current show";
	private static final String ADD_SEASON_HELP = "addSeason - add a new season to the current show";
	private static final String SWITCH_TO_SHOW_HELP = "switchToShow - change the context to a particular show";
	private static final String ADD_SHOW_HELP = "addShow - add a new show";
	private static final String CURRENT_SHOW_HELP = "currentShow - show the current show";
	private static final String PROMPT = "> ";
	private static final String BYE = "Bye!";
	private static final String UNKNOWN_COMMAND = "Unknown command. Type help to see available commands.";
	
	/**
	 * Commands to the user
	 */
	public static final String EXIT = "EXIT";
	public static final String HELP = "HELP";
	public static final String CURRENT_SHOW = "CURRENTSHOW";
	public static final String ADD_SHOW = "ADDSHOW";
	public static final String SWITCH_SHOW = "SWITCHTOSHOW";
	public static final String ADD_SEASON = "ADDSEASON";
	public static final String ADD_EPISODE = "ADDEPISODE";
	public static final String ADD_CHARACTER = "ADDCHARACTER";
	public static final String ADD_RELATIONSHIP = "ADDRELATIONSHIP";
	public static final String ADD_ROMANCE = "ADDROMANCE";
	public static final String ADD_EVENT = "ADDEVENT";
	public static final String ADD_QUOTE = "ADDQUOTE";
	public static final String SEASONS_OUTLINE = "SEASONSOUTLINE";
	public static final String CHARACTER_RESUME = "CHARACTERRESUME";
	public static final String TWO_RELATED = "HOWARETHESETWORELATED";
	public static final String FAMOUS_QUOTE = "FAMOUSQUOTES";
	public static final String ALSO_APPEARS = "ALSOAPPEARSON";
	public static final String MOST_ROMANTIC = "MOSTROMANTIC";
	public static final String KING_CGI = "KINGOFCGI";

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		DataBase db = new DataBaseClass();
		String comm = getCommand(in);
		while (!comm.equals(EXIT)) {
			switch (comm) {
			case HELP:
				help();
				break;
			case CURRENT_SHOW:
				currentShow(db);
				break;
			case ADD_SHOW:
				addShow(in, db);
				break;
			case SWITCH_SHOW:
				switchToShow(in, db);
				break;
			case ADD_SEASON:
				addSeason(db);
				break;
			case ADD_EPISODE:
				addEpisode(in, db);
				break;
			case ADD_CHARACTER:
				addCharacter(in, db);
				break;
			case ADD_RELATIONSHIP:
				addRelationship(in, db);
				break;
			case ADD_ROMANCE:
				addRomance(in, db);
				break;
			case ADD_EVENT:
				addEvent (in, db);
				break;
			case ADD_QUOTE:
				addQuote(in, db);
				break;
			case SEASONS_OUTLINE:
				seasonsOutline(in, db);
				break;
			case CHARACTER_RESUME:
				characterResume(in, db);
				break;
			case TWO_RELATED:
				howAreTheseTwoRelated(in, db);
				break;
			case FAMOUS_QUOTE:
				famousQuotes(in, db);
				break;
			case ALSO_APPEARS:
				alsoAppearsOn(in, db);
				break;
			case MOST_ROMANTIC:
				mostRomantic(in, db);
				break;
			case KING_CGI:
				kingOfCGI(db);
				break;
			default:
				System.out.println(UNKNOWN_COMMAND);
			}
			comm = getCommand(in);
		}
		System.out.println(BYE);
		in.close();
	}
	
	/**
	 * Command written by the user
	 * @param in - Scanner's name
	 * @return command 
	 */
	private static String getCommand(Scanner in) {
		System.out.print(PROMPT);
		String input = in.nextLine().toUpperCase().trim();
		return input;
	}
	
	/**
	 * Print all the options to user
	 */
	private static void help() {
		System.out.println(CURRENT_SHOW_HELP);
		System.out.println(ADD_SHOW_HELP);
		System.out.println(SWITCH_TO_SHOW_HELP);
		System.out.println(ADD_SEASON_HELP);
		System.out.println(ADD_EPISODE_HELP);
		System.out.println(ADD_CHARACTER_HELP);
		System.out.println(ADD_RELATIONSHIP_HELP);
		System.out.println(ADD_ROMANCE_HELP);
		System.out.println(ADD_EVENT_HELP);
		System.out.println(ADD_QUOTE_HELP);
		System.out.println(SEASONS_OUTLINE_HELP);
		System.out.println(CHARACTER_RESUME_HELP);
		System.out.println(HOW_ARE_THESE_TWO_RELATED_HELP);
		System.out.println(FAMOUS_QUOTES_HELP);
		System.out.println(ALSO_APPEARS_HELP);
		System.out.println(MOST_ROMANTIC_HELP);
		System.out.println(KING_OF_CGI_HELP);
		System.out.println(HELP_SHOWS);
		System.out.println(EXIT_TERMINATES);
	}
	
	/**
	 * Print the show that is selected by the user.
	 * @param db - DataBases' name
	 */
	private static void currentShow(DataBase db) {
		try {
			Show s = db.getCurrentShow();
			System.out.println(s.getShowName()+SEASONS+s.getNumberOfSeasons()+ EPISODES+s.totalEpisodes());
		}
		catch(NoShowSelectedException e) {
			System.out.println(NO_SHOW_IS_SELECTED);
		}
	}
	
	/**
	 * Add a show to DataBase
	 * @param in - Scanner's name
	 * @param db - DataBase's name
	 */
	private static void addShow(Scanner in, DataBase db) {
		String showName = in.nextLine();
		try {
			db.addShow(showName);
			System.out.println(showName + CREATED);
		}
		catch(HasAlreadyShowException e) {
			System.out.println(SHOW_ALREADY_EXISTS);
		}
	}
	
	/**
	 * Switch the current show.
	 * @param in - Scanner's name
	 * @param db - DataBases' name
	 */
	private static void switchToShow(Scanner in, DataBase db) {
		String showName = in.nextLine();
		try {
			Show s = db.switchToShow(showName);
			System.out.println(s.getShowName()+SEASONS+s.getNumberOfSeasons()+ EPISODES+s.totalEpisodes());
		}
		catch(ShowDoesNotExistException e) {
			System.out.println(UNKNOWN_SHOW);
		}
	}
	
	/**
	 * Add a season to the current show.
	 * @param db - DataBases' name
	 */
	private static void addSeason(DataBase db) {
		try {
			db.addSeason();
			Show s = db.getCurrentShow();
			System.out.println(s.getShowName()+SEASONS+s.getNumberOfSeasons()+ EPISODES+s.totalEpisodes());
		}
		catch(NoShowSelectedException e) {
			System.out.println(NO_SHOW_IS_SELECTED);
		}
	}
	
	/**
	 * Add a episode to a season from the current show
	 * @param in - Scanner's name
	 * @param db - DataBases' name
	 */
	private static void addEpisode(Scanner in, DataBase db) {
		int seasonNumber = in.nextInt();
		String episodeName = in.nextLine().trim();
		try {
			db.addEpisode(seasonNumber, episodeName);
			Show s = db.getCurrentShow();
			int episodeNumber = s.getNumberOfEpisodesInSeason(seasonNumber);
			System.out.println(s.getShowName()+S2+seasonNumber+EP+episodeNumber+STRING+episodeName+STRING3);
		}
		catch(NoShowSelectedException a) {
			System.out.println(NO_SHOW_IS_SELECTED);
		}
		catch(NoSeasonException b) {
			System.out.println(UNKNOWN_SEASON);
		}
	}
	
	/**
	 * Add a character to the current show.
	 * @param in - Scanner's in
	 * @param db - DataBases' name
	 */
	private static void addCharacter(Scanner in, DataBase db) {
		String type = in.nextLine();
		String characterName = in.nextLine();
		String actorOrCompany = in.nextLine();
		int feeOrCost = in.nextInt();
		in.nextLine();
		try {
			db.addCharacter(type, characterName, actorOrCompany, feeOrCost);
			System.out.print(characterName + IS_NOW_PART_OF+ db.getCurrentShow().getShowName()+ STRING2);
			if (type.equals(REAL)) {
				System.out.println(THIS_IS + actorOrCompany + ROLE + db.getActorRoles(actorOrCompany)  + STRING3);
			} else {
				System.out.println(THIS_IS_A_VIRTUAL_ACTOR);
			}
		} catch (NoShowSelectedException a) {
			System.out.println(NO_SHOW_IS_SELECTED);
		} catch (InvalidTypeCharacterException b) {
			System.out.println(UNKNOWN_ACTOR_CATEGORY);
		} catch (HasAlreadyCharacterException c) {
			System.out.println(DUPLICATE_CHARACTER_NAMES_ARE_NOT_ALLOWED);
		} catch (NegativeActorFeeException d) {
			System.out.println(SLAVERY_IS_LONG_GONE_AND_THIS_IS_OUTRAGEOUS);
		}
	}
	
	/**
	 * Add a relationship between two characters from the current show. 
	 * @param in - Scanner's name
	 * @param db - DataBases' name
	 */
	private static void addRelationship(Scanner in, DataBase db) {
		String parentName = in.nextLine();
		String childName = in.nextLine();
		try {
			db.addRelationship(parentName, childName);
			int numberOfKids = db.getCurrentShow().getCharacter(parentName).numberKids();
			int numberOfParents = db.getCurrentShow().getCharacter(childName).numberParents();
			System.out.println(parentName + HAS_NOW+numberOfKids+KIDS+childName+HAS_NOW+numberOfParents+ PARENT_S);
		}
		catch(NoShowSelectedException a) {
			System.out.println(NO_SHOW_IS_SELECTED);
		} catch (SameCharacterRelationshipException b) {
			System.out.println(parentName+CANNOT_BE_PARENT_AND_CHILD_AT_THE_SAME_TIME);
		} catch (CharacterDoesNotExistException1 c) {
			System.out.println(WHO_IS+parentName+STRING4);
		} catch(CharacterDoesNotExistException2 d) {
			System.out.println(WHO_IS+childName+STRING4);
		} catch(HasAlreadyRelationshipException e) {
			System.out.println(WHAT_ELSE_IS_NEW_WE_ALREADY_KNOW_ABOUT_THOSE_TWO);
		}
	}
	
	/**
	 * Add a romance between two characters.
	 * @param in - Scanner's name
	 * @param db - DataBases' name
	 */
	private static void addRomance(Scanner in, DataBase db) {
		String first = in.nextLine();
		String second = in.nextLine();
		try {
			db.addRomance(first, second);
			System.out.println(first+AND+second+ARE_NOW_A_COUPLE);
		}
		catch(NoShowSelectedException a) {
			System.out.println(NO_SHOW_IS_SELECTED);
		} catch(SameCharacterRelationshipException b) {
			System.out.println(first+CANNOT_BE_IN_A_SINGLE_PERSON_ROMANTIC_RELATIONSHIP);
		} catch (CharacterDoesNotExistException1 c) {
			System.out.println(WHO_IS+first+STRING4);
		} catch(CharacterDoesNotExistException2 d) {
			System.out.println(WHO_IS+second+STRING4);
		} catch(HasAlreadyRomanceException e) {
			System.out.println(WHAT_ELSE_IS_NEW_WE_ALREADY_KNOW_ABOUT_THOSE_TWO);
		}
	}
	
	/**
	 * Add a event to a episode.
	 * @param in - Scanner's name
	 * @param db - Databases' name
	 */
	private static void addEvent(Scanner in, DataBase db) {
		String eventTitle = in.nextLine();
		int seasonNumber = in.nextInt();
		int episodeNumber = in.nextInt();
		int numberCharacters = in.nextInt();
		in.nextLine();
		String [] characters = new String[numberCharacters];
		for(int i = 0; i<numberCharacters; i++) {
			characters[i] = in.nextLine();
		}
		try {
			db.addEvent(eventTitle, seasonNumber, episodeNumber, characters);
			System.out.println(EVENT_ADDED);
		} catch(NoShowSelectedException a) {
			System.out.println(NO_SHOW_IS_SELECTED);
		} catch (NoSeasonException b) {
			System.out.println(db.getCurrentShow1().getShowName() +DOES_NOT_HAVE_SEASON+seasonNumber+STRING5);
		} catch (NoEpisodeException c) {
			System.out.println(db.getCurrentShow1().getShowName()+S2+seasonNumber+DOES_NOT_HAVE_EPISODE+episodeNumber+STRING5);
		} catch(CharacterDoesNotExistException1 d) {
			System.out.println(WHO_IS+ characters[db.HaveCharacter(characters)] + STRING4);
		} catch(RepeatedCharactersException e) {
			System.out.println(DUPLICATE_CHARACTER_NAMES_ARE_NOT_ALLOWED);
		}
	}
	
	/**
	 * Add a quote to the current show.
	 * @param in - Scanner's name
	 * @param db - DataBases' name
	 */
	private static void addQuote(Scanner in, DataBase db) {
		int seasonNumber = in.nextInt();
		int episodeNumber = in.nextInt();
		in.nextLine();
		String characterName = in.nextLine();
		String quote = in.nextLine().trim();
		try {
			db.addQuote(seasonNumber, episodeNumber, characterName, quote);
			System.out.println(QUOTE_ADDED);
		}
		catch(NoShowSelectedException a) {
			System.out.println(NO_SHOW_IS_SELECTED);
		} catch (NoSeasonException b) {
			System.out.println(db.getCurrentShow1().getShowName() +DOES_NOT_HAVE_SEASON+seasonNumber+STRING5);
		} catch (NoEpisodeException c) {
			System.out.println(db.getCurrentShow1().getShowName()+S2+seasonNumber+DOES_NOT_HAVE_EPISODE+episodeNumber+STRING5);
		} catch(CharacterDoesNotExistException1 d) {
			System.out.println(WHO_IS+characterName+STRING4);
		}
	}
	
	/**
	 * List the information of the season of the interval given by the user.
	 * @param in - Scanner's name
	 * @param db - Databases' name
	 */
	private static void seasonsOutline(Scanner in, DataBase db) {
		int firstSeason = in.nextInt();
		int lastSeason = in.nextInt();
		in.nextLine();
		try {
			Iterator<Season> itSeason = db.seasonsOutline(firstSeason, lastSeason);
			System.out.println(db.getCurrentShow().getShowName());
			while(itSeason.hasNext()) {
				Season tmpSeason = itSeason.next();
				if(tmpSeason.getSeasonNumber() >= firstSeason && tmpSeason.getSeasonNumber() <= lastSeason) {
					Iterator<Episode> itEpisode = tmpSeason.listEpisodes();
					while (itEpisode.hasNext()) {
						Episode tmpEpisode = itEpisode.next();
						System.out.println(S+ tmpSeason.getSeasonNumber()+EP2+tmpEpisode.getEpisodeNumber()+STRING+tmpEpisode.getName());
						Iterator<Event> itEvent = tmpEpisode.listEvents();
						while(itEvent.hasNext()) {
							Event tmpEvent = itEvent.next();
							System.out.println(tmpEvent.getEventTitle());
						}
					}
				}
			}
		}
		catch(NoShowSelectedException a) {
			System.out.println(NO_SHOW_IS_SELECTED);
		} catch (InvalidSeasonsIntervalException b) {
			System.out.println(INVALID_SEASONS_INTERVAL);
		}
	}
	
	/**
	 * Lists the character's information, like relationships and events
	 * @param in - Scanner's name
	 * @param db - DataBase's name
	 */
	public static void characterResume(Scanner in, DataBase db) {
		String characterName = in.nextLine().trim();
		try {
			Character c = db.characterResume(characterName);
			Iterator<Character> itParents = c.listParents();
			System.out.print(PARENTS);
			if (c.hasParents()) {
				while(itParents.hasNext()) {
					Character parent = itParents.next();
					if(itParents.hasNext()) 
						System.out.print(parent.getName() +STRING6);
					if(!itParents.hasNext()) 
						System.out.println(parent.getName());
				}
			} else {
				System.out.println(NONE);
			}
			Iterator<Character> itKids = c.listKids();
			System.out.print(KIDS2);
			if(c.hasKids()) {
				while(itKids.hasNext()) {
					Character kid = itKids.next();
					if(itKids.hasNext())
						System.out.print(kid.getName() +STRING6);
					if(!itKids.hasNext())
						System.out.println(kid.getName());
				}
			}
			else {
				System.out.println(NONE);
			}
			Iterator<Character> itSiblings = c.listSiblings();
			System.out.print(SIBLINGS);
			if(c.hasSiblings()) {
				while(itSiblings.hasNext()) {
					Character sibling = itSiblings.next();
					if(itSiblings.hasNext())
						System.out.print(sibling.getName() +STRING6);
					if(!itSiblings.hasNext())
						System.out.println(sibling.getName());
				}
			}
			else {
				System.out.println(NONE);
			}
			Iterator<Character> itRomance = c.listRomance();
			System.out.print(ROMANTIC_RELATIONSHIPS);
			if(c.hasRomance()) {
				while(itRomance.hasNext()) {
					Character romantic = itRomance.next();
					if(itRomance.hasNext())
						System.out.print(romantic.getName() +STRING6);
					if(!itRomance.hasNext())
						System.out.println(romantic.getName());
				}
			}
			else {
				System.out.println(NONE);
			}
			Iterator<Event> itEvents = c.listEvents();
			int lastSeason = 0;
			int lastEpisode = 0;
			while(itEvents.hasNext()) {
				Event e = itEvents.next();
				if(e.getSeason().getSeasonNumber() == lastSeason && e.getEpisode().getEpisodeNumber() == lastEpisode) {
					System.out.println(e.getEventTitle());
				} else {
					System.out.println(S + e.getSeason().getSeasonNumber() + EP2 + e.getEpisode().getEpisodeNumber() + STRING + e.getEpisode().getName());
					System.out.println(e.getEventTitle());
					lastSeason = e.getSeason().getSeasonNumber();
					lastEpisode = e.getEpisode().getEpisodeNumber();
				}
			}
			
			
		}
		catch(NoShowSelectedException a) {
			System.out.println(NO_SHOW_IS_SELECTED);
		} catch (CharacterDoesNotExistException1 b) {
			System.out.println(WHO_IS+characterName+STRING4);
		}
	}
	
	/**
	 * Lists the ancestors and descendants between two characters given by argument
	 * 
	 * @param in - Scanner's name
	 * @param db - DataBase's name
	 */
	private static void howAreTheseTwoRelated(Scanner in, DataBase db) {
		String character1 = in.nextLine();
		String character2 = in.nextLine();
		try {
			Iterator<Character> it = db.howAreTheseTwoRelated(character1, character2);
			while(it.hasNext()) {
				Character tmp = it.next();
				if(it.hasNext()) {
					System.out.print(tmp.getName() +STRING7);
				}
				if(!it.hasNext()) {
					System.out.println(tmp.getName());
				}
			}
		}
		catch(NoShowSelectedException a) {
			System.out.println(NO_SHOW_IS_SELECTED);
		} catch (CharacterDoesNotExistException1 b) {
			System.out.println(WHO_IS+character1+STRING4);
		} catch (CharacterDoesNotExistException2 c) {
			System.out.println(WHO_IS+character2+STRING4);
		} catch (SameCharacterRelationshipException d) {
			System.out.println(LIKE_YOU_KNOW_THEY_ARE_THE_SAME_CHARACTER_DUUUUH);
		} catch (CharactersNotRelatedException e) {
			System.out.println(THESE_CHARACTERS_ARE_NOT_RELATED);
		}
	}
	
	/**
	 * List the characters who have said a quote
	 * @param in - Scanner's name
	 * @param db - DataBases' name
	 */
	private static void famousQuotes(Scanner in, DataBase db) {
		String quote = in.nextLine().trim();
		try {
			Iterator<Character> it = db.famousQuotes(quote);
			while(it.hasNext()) {
				Character tmp = it.next();
				if(it.hasNext()) {
					System.out.print(tmp.getName() +STRING6);
				}
				if(!it.hasNext()) {
					System.out.println(tmp.getName());
				}
			}
		}
		catch(NoShowSelectedException a) {
			System.out.println(NO_SHOW_IS_SELECTED);
		} catch(NoOneSaidQuoteException b) {
			System.out.println(FIRST_TIME_I_HEAR_THAT);
		}
	}
	
	/**
	 * List the shows that the actor of the character with character name are in.
	 * @param in - Scanner's in 
	 * @param db - DataBase's name
	 */
	private static void alsoAppearsOn(Scanner in, DataBase db) {
		String characterName = in.nextLine();
		try {
			Iterator<Show> it = db.alsoAppears(characterName);
			while(it.hasNext()) {
				Show tmp = it.next();
				System.out.println(tmp.getShowName());
			}
		}
		catch(NoShowSelectedException a) {
			System.out.println(NO_SHOW_IS_SELECTED);
		} catch(CharacterDoesNotExistException1 b) {
			System.out.println(WHO_IS+characterName+STRING4);
		} catch(CgiCharacterException c) {
			System.out.println(characterName+IS_PLAYED_BY_A_VIRTUAL_ACTOR);
		}
	}
	
	/**
	 * Prints the list of the actors who are most romantic than the actor given
	 * @param in - Scanner's name
	 * @param db - DataBases' name
	 */
	private static void mostRomantic(Scanner in, DataBase db) {
		String actorName = in.nextLine();
		boolean found = false;
		try {
			Iterator<Actor> it =db.mostRomantic(actorName);
			Actor a = db.getActor(actorName);
			while(it.hasNext() && found == false) {
				Actor b = it.next();
				System.out.println(b.getActorName() + STRING8 + b.nRomances());
				if (a == b) {
					found = true;
				}
		}
	} catch(ActorDoesNotExistException a) {
			System.out.println(WHO_IS+actorName+STRING4);
	} catch (NoRomanticRelationshipsException b) {
			System.out.println(LOVE_IS_NOT_IN_THE_AIR);
	}
}
	
	/**
	 * Prints the CGICompany with the highest revenue
	 * @param db - DataBase's name
	 */
	private static void kingOfCGI(DataBase db) {
		try {
			CGICompany c = db.kingOfCGI();
			System.out.println(c.getCompanyName() + STRING8 + c.getTotal());
		}
		catch(NoVirtualCharacterException a) {
			System.out.println(THIS_IS_A_REAL_THING_THIS_IS_ART);
		}
	}
	
}
