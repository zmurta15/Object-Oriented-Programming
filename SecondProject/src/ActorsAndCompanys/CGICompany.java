package ActorsAndCompanys;

import Characters.CgiCharacter;

/**
 * An CGI Company that has a list of virtual characters associated
 * 
 * @author P8: Jose Murta 55226 && Diogo Rodrigues 56153
 *
 */
public interface CGICompany {
	
	/**
	 * Get the CGI company name
	 * @return - the company name
	 */
	String getCompanyName();
	
	/**
	 * Add a cgi character to the company
	 * @param cgi - cgi character
	 */
	void addCGI(CgiCharacter cgi);
	
	/**
	 * Get the total revenue of the CGICompany
	 * 
	 * @return - the total revenue of the CGICompany
	 */
	int getTotal();
	
	/**
	 * Get the number of virtual characters owned by the CGICompany
	 * @return - the number of virtual characters owned by the CGICompany
	 */
	int numberCharacters ();
	
}
