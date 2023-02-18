package JUnitTest;

import static org.junit.jupiter.api.Assertions.*;
import Show.*;
import ActorsAndCompanys.*;
import Characters.*;
import Characters.Character;
import DataBase.*;

class Test {

	@org.junit.jupiter.api.Test
	void test() throws Exception {
		DataBase db = new DataBaseClass();
		db.addShow("show1");
		db.addEpisode(1, "First episode.");
		db.addEpisode(1, "Second episode.");
		db.addSeason();
		db.addEpisode(2, "First episode from second season");
		assertEquals(3, db.getCurrentShow().totalEpisodes());
		assertEquals(true, db.getCurrentShow().hasSeason(2));
		assertEquals(false, db.getCurrentShow().hasSeason(3));
		db.addCharacter("virtual", "oscar", "ze", 1000000000);
		assertEquals(true, db.getCurrentShow().hasCaracter("oscar"));
		db.addCharacter("virtual", "dt", "diogo", 1);
		db.addSeason();
		db.addQuote(1, 1, "oscar", "poo e incrivel!");
		db.addEvent("evento1", 1, 2, new String[] {"dt"});
		db.addQuote(2, 1, "dt", "tudo bem");
		assertEquals(1, db.getCurrentShow().getCharacter("oscar").nSeasons());
		assertEquals(2, db.getCurrentShow().getCharacter("dt").nSeasons());
		assertEquals(3, db.getCurrentShow().getNumberOfSeasons());
	}

}
