package ActorsAndCompanys;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import Characters.CgiCharacter;

/**
 * An CGI Company that has a list of virtual characters associated
 * 
 * @author P8: Jose Murta 55226 && Diogo Rodrigues 56153
 *
 */
public class CGICompanyClass implements CGICompany {
	/**
	 * Company's name
	 */
	private String companyName;
	/**
	 * List of CGI character's in the company
	 */
	private List<CgiCharacter> cgis;
	
	/**
	 * Creates a new company with company name.
	 * @param companyName - company's name
	 */
	public CGICompanyClass(String companyName) {
		this.companyName = companyName;
		cgis = new LinkedList<CgiCharacter>();
	}
	
	public String getCompanyName() {
		return companyName;
	}
	
	public void addCGI(CgiCharacter cgi) {
		cgis.add(cgi);
	}
	
	public int getTotal() {
		int total = 0;
		Iterator<CgiCharacter> it = cgis.iterator();
		while (it.hasNext()) {
			CgiCharacter c = it.next();
			total += c.costSeason()*c.nSeasons();
		}
		return total;
	}
	
	public int numberCharacters () {
		return cgis.size();
	}

	
	
}
