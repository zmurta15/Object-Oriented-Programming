package Characters;

/**
 * The interface for the CGICharacter that has a cost per season associated 
 * 
 * @author P8: Jose Murta 55226 && Diogo Rodrigues 56153
 *
 */
public interface CgiCharacter extends Character {
	
	/**
	 *Get cost per season of the character to the company
	 * @return cost per season of the character.
	 */
	int costSeason();
	
	/**
	 * Get the name of the character
	 */
	String getName();
	
	
}
