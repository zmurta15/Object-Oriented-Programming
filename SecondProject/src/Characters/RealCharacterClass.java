package Characters;

import ActorsAndCompanys.Actor;

/**
 * The real character that is played by an actor and has a name and a fee per episode associated
 * 
 * @author P8: Jose Murta 55226 && Diogo Rodrigues 56153
 *
 */
public class RealCharacterClass extends AbstractCharacterClass implements RealCharacter  {
	/**
	 * Fee by episode of the character
	 */
	private int feeEpisode;
	/**
	 * Character's name
	 */
	private String characterName;
	/**
	 * Actor who does the character
	 */
	private Actor actor;
	
	/**
	 * Creates a real character with character name.
	 * @param actor - actor who play the role
	 * @param characterName - character's name
	 * @param feeEpisode - fee per episode
	 */
	public RealCharacterClass (String characterName, Actor actor, int feeEpisode) {
		super();
		this.characterName = characterName;
		this.actor = actor;
		this.feeEpisode = feeEpisode;
	
	}

	
	public String getName() {
		return characterName;
	}
	
	@Override
	public int getFeeEpisode() {
		return feeEpisode;
		}

	@Override
	public Actor getActor() {
		return actor;
	}


	@Override
	public int compareTo(Character o) {
		return this.getName().compareTo(o.getName());
	}


	
}
