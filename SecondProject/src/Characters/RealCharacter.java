package Characters;

import ActorsAndCompanys.Actor;

/**
 * The real character that is played by an actor and has a name and a fee per episode associated
 * 
 * @author P8: Jose Murta 55226 && Diogo Rodrigues 56153
 *
 */
public interface RealCharacter extends Character {
	
	/**
	 * Get the fee by episode of the character
	 * @return fee by episode
	 */
	int getFeeEpisode();
	
	/**
	 * Get the actor who play the role.
	 * @return actor who plays the character
	 */
	Actor getActor();
	
	/**
	 * Return the name of the character
	 */
	String getName();
	
}
