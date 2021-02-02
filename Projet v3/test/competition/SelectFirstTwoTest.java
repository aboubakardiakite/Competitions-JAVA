package competition;
import competition.methode.*;
import java.util.*;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class SelectFirstTwoTest {

	private Competitor c1;
	private Competitor c2;
	private Competitor c3;
	private Competitor c4;
	private Methode methode;
	private List<League> league;
	private League league1;
	private League league2;

	@Before
	public void before() {
		this.c1 = new Competitor("Joel");
		this.c2 = new Competitor("Bouba");
		this.c3 = new Competitor("Lynx");
		this.c4 = new Competitor("Alex");
		this.methode = new SelectFirstTwo();
		this.league = new ArrayList<League>();
		this.league1 = new League(new ArrayList<Competitor>());
		this.league2 = new League(new ArrayList<Competitor>());
	}

	@Test
	public void testSelection() throws NumberNotPowerOf2Exception{
		this.league.add(league1);
		this.league.add(league2);
		this.league1.addCompetitors(this.c1);
		this.league1.addCompetitors(this.c2);
		this.league1.play();
		Map<Competitor, Integer> rank = this.league1.ranking();
		List<Competitor> liste1 = new ArrayList<Competitor>(rank.keySet());
		this.league2.addCompetitors(this.c3);
		this.league2.addCompetitors(this.c4);
		this.league2.play();
		Map<Competitor, Integer> rank1 = this.league2.ranking();
		List<Competitor> liste2 = new ArrayList<Competitor>(rank1.keySet());
		List<Competitor> liste3 = new ArrayList<Competitor>();
		liste3.add(liste1.get(0));
		liste3.add(liste1.get(1));
		liste3.add(liste2.get(0));
		liste3.add(liste2.get(1));
		List<Competitor> liste = this.methode.selection(this.league);
		assertEquals(liste,liste3);
	}
    // ---Pour permettre l'execution des tests ----------------------
    public static junit.framework.Test suite() {
			return new junit.framework.JUnit4TestAdapter(competition.SelectFirstTwoTest.class);
    }
}
