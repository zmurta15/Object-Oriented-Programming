package Characters;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import Show.Event;
import Show.Quote;

/**
 * The abstract class that is a character with family relationships and romances associated
 * 
 * @author P8: Jose Murta 55226 && Diogo Rodrigues 56153
 *
 */
public abstract class AbstractCharacterClass implements Character{
	
	/**
	 * List of parents of the character
	 */
	private List<Character> parents;
	/**
	 * List of kids of the character
	 */
	private List<Character> children;
	
	/**
	 * List of romantic relationships of the character
	 */
	private List<Character> romance;
	
	/**
	 * List of events of the character
	 */
	private List<Event> events;
	
	/**
	 * List of siblings of the character
	 */
	private List<Character> siblings;
	
	/**
	 * List of the number of the seasons where the character is
	 */
	private List<Integer> seasons;
	
		
	/**
	 * Creates a character.
	 */
	public AbstractCharacterClass() {
		parents = new LinkedList<Character>();
		children = new LinkedList<Character>();
		romance = new LinkedList<Character>();
		events = new LinkedList<Event>();
		siblings = new LinkedList<Character>();
		seasons = new LinkedList<Integer>();
		
	}
	
	@Override
	public void addParent(Character parent) {
		parents.add(parent);
		assert parents.contains(parent);
	}

	@Override
	public void addKid(Character kid) {
		children.add(kid);
		this.addSiblings(kid);
		assert children.contains(kid);
		}
	
	/**
	 * Add a sibling to all the children of the character parent
	 * @param kid - Character kid
	 */
	private void addSiblings (Character kid) {
		assert kid!=null;
		Iterator<Character> it = children.iterator();
		while (it.hasNext()) {
			Character c = it.next();
			if (kid != c && !c.hasSiblingOf(kid)) {
					c.addSibling(kid);
					kid.addSibling(c);
			}	
			assert c.hasSiblingOf(kid);
		}
		assert siblings.contains(kid);
	}
	@Override
	public int numberParents() {
		return parents.size();
	}

	@Override
	public int numberKids() {
		return children.size();
	}
	
	public void addRomance(Character ca) {
		romance.add(ca);
	}
	
	public void addEvent (Event e) {
		events.add(e);
	}
	
	public void addSibling (Character c) {
		siblings.add(c);
	}
	
	public Iterator<Character> listKids () {
		return children.iterator();
	}
	public Iterator<Character> listParents() {
		return parents.iterator();
	}
	public Iterator<Character> listSiblings() {
		return siblings.iterator();
	}
	public Iterator<Character> listRomance() {
		return romance.iterator();
	}
	public Iterator<Event> listEvents() {
		return events.iterator();
	}
	public boolean hasParents() {
		return parents.size() > 0;
	}
	public boolean hasKids() {
		return children.size() >0;
	}
	public boolean hasRomance() {
		return romance.size() >0;
	}
	public boolean hasSiblings() {
		return siblings.size() >0;
	}
	
	public boolean hasSiblingOf(Character c) {
		boolean has = false;
		Iterator<Character> it = siblings.iterator();
		while(it.hasNext()) {
			Character tmp = it.next();
			if(tmp.equals(c))
				has = true;
		}
		return has;
	}
	
	public void addSeason (int season) {
		seasons.add(season);
	}
	
	public int nSeasons () {
		return seasons.size();
	}
	
	public int nRomances () {
		return romance.size();
	}
	
	
 	
	
	
	//________________________________________________________________________________
	public boolean hasParent (Character parent) {
		boolean has = false;
		Iterator<Character> it = parents.iterator();
		while (it.hasNext()) {
			Character tmp = it.next();
			if(tmp.equals(parent)) {
				has = true;
			}
		}
		return has;
	}
	
	public boolean hasChild (Character child) {
		boolean has = false;
		Iterator<Character> it = children.iterator();
		while (it.hasNext()) {
			Character tmp = it.next();
			if(tmp.equals(child)) {
				has = true;
			}
		}
		return has;
	}
	
	public boolean hasRomance(Character c) {
		boolean has = false;
		Iterator<Character> it = romance.iterator();
		while (it.hasNext()) {
			Character tmp = it.next();
			if(tmp.equals(c)) {
				has = true;
			}
		}
		return has;
	}
	
	public boolean hasEventWithSeason(Event e) {
		boolean has = false;
		Iterator<Integer> it = seasons.iterator();
		while (it.hasNext()) {
			int i = it.next();
			if (i == e.getSeason().getSeasonNumber()) {
				has = true;
			}
		}
		return has;
	}
	
	public boolean hasQuoteWithSeason (Quote q) {
		boolean has = false;
		Iterator<Integer> it = seasons.iterator();
		while (it.hasNext()) {
			int i = it.next();
			if (i == q.getSeason().getSeasonNumber()) {
				has = true;
			}
		}
		return has;
	}
	

	

}
