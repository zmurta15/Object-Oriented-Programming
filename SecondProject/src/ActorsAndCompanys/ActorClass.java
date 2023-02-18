package ActorsAndCompanys;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import Characters.RealCharacter;
import Show.Show;

/**
 * The actor that has a list of real characters and shows that he participated in associated
 * 
 * @author P8: Jose Murta 55226 && Diogo Rodrigues 56153
 *
 */
public class ActorClass implements Actor{
	
	/**
	 * Actor's name
	 */
	private String actorName;
	/**
	 * List of characters that the actor does.
	 */
	private List<RealCharacter> characters;
	/**
	 * Map of shows related to the characters.
	 */
	/**
	 * Sorted set of shows by alphabetic order
	 */
	private SortedSet<Show> actorShows;
	
	/**
	 * Create a new actor with actor name.
	 * @param actorName - actor's name
	 */
	public ActorClass(String actorName) {
		this.actorName = actorName;
		characters = new ArrayList<RealCharacter>();
		actorShows = new TreeSet<Show>();
	}
	
	public String getActorName() {
		return actorName;
	}
	
	public void addCharacter (Show show, RealCharacter rc) {
		characters.add(rc);
		actorShows.add(show);
	}
	
	public int numberRoles () {
		return characters.size();
	}
	
	public Iterator<Show> listShows() {
		return actorShows.iterator();
	}
	
	public boolean hasRomances() {
		boolean romances = false;
		Iterator<RealCharacter> it = characters.iterator();
		while(it.hasNext()) {
			RealCharacter rc = it.next();
			if(rc.hasRomance()) {
				romances = true;
			}
		}
		return romances;
	}
	
	public int nRomances () {
		int total = 0;
		Iterator<RealCharacter> it = characters.iterator();
		while (it.hasNext()) {
			RealCharacter c = it.next();
			total += c.nRomances();
		}
		return total;
	}
	
	public int nShows () {
		return actorShows.size();
	}
	
	public int nshowsRomance () {
		int nshowsRomance = 0;
		Iterator<Show> it = actorShows.iterator();
		while (it.hasNext()) {
			Show s = it.next();
			if (s.hasRomanceInShow()) {
				nshowsRomance++;
			}
		}
		return nshowsRomance;
	}

	

	@Override
	public int compareTo(Actor o) {
		int value = 3;
		if (this.nRomances() == o.nRomances()) {
			if (this.nShows() == o.nShows()) {
				if (this.nshowsRomance() == o.nshowsRomance()) {
					if (this.getActorName().compareTo(o.getActorName()) > 0) {
						value = 1;
					} else {
						value = -1;
					}
				}
				if (this.nshowsRomance() > o.nshowsRomance()) {
					value = 1;
				} else {
					value = -1;
				}
			}
			if (this.nShows() < o.nShows()) {
				value = 1;
			} else {
				value = -1;
			}
		}
		if (this.nRomances() < o.nRomances()) {
			value = 1;
		} else {
			value = -1;
		}
		return value;
	}
	
	
	
	
	
	
	
}
