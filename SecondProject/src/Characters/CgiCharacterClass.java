package Characters;

/**
 * The interface for the CGICharacter that has a cost per season associated 
 * 
 * @author P8: Jose Murta 55226 && Diogo Rodrigues 56153
 *
 */
public class CgiCharacterClass extends AbstractCharacterClass implements CgiCharacter {
	
	/**
	 * Character's name
	 */
	private String characterName;
	/**
	 * Cost per season
	 */
	private int costSeason;
	
	
	/**
	 * Creates a new CGI character with characterName and cost per season.
	 * @param characterName - character's name
	 * @param costSeason - cost per season
	 */
	public CgiCharacterClass (String characterName, int costSeason) {
		super();
		this.characterName = characterName;
		this.costSeason = costSeason;
	}
	
	
	public String getName() {
		return characterName;
	}
	
	
	@Override
	public int costSeason() {
		return costSeason;
	}


	@Override
	public int compareTo(Character e) {
		return this.getName().compareTo(e.getName());
	}

}
