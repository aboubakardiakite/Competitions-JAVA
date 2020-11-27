package competition;
import competition.methode.*;
import java.util.*;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class SelectFirstTwoAndBestThirdsTest {

	private Competitor c1;
	private Competitor c2;
	private Competitor c3;
	private Competitor c4;
	private Competitor c5;
	private Competitor c6;
	private Methode methode;
	private List<League> league;
	private League league1;
	private League league2;

	@Before
	public void before() {
		this.c1 = new Competitor("Joel");
		this.c2 = new Competitor("Bouba");
		this.c3 = new Competitor("Lynx");
		this.c4 = new Competitor("Raven");
		this.c5 = new Competitor("Drift");
		this.c6 = new Competitor("Catalyst");
		this.methode = new SelectFirstTwoAndBestThirds();
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
		this.league1.addCompetitors(this.c3);
		this.league1.play();
		List<Competitor> liste1 = new ArrayList<Competitor>(league1.getCompetitors());
		this.league2.addCompetitors(this.c4);
		this.league2.addCompetitors(this.c5);
		this.league2.addCompetitors(this.c6);
		this.league2.play();
		List<Competitor> liste2 = new ArrayList<Competitor>(league2.getCompetitors());
		List<Competitor> liste = this.methode.selection(this.league);
		assertTrue(liste.contains(liste1.get(0)));
		assertTrue(liste.contains(liste1.get(1)));
		assertTrue(liste.contains(liste2.get(0)));
		assertTrue(liste.contains(liste2.get(1)));
		assertTrue(liste.contains(liste1.get(2)));
		assertTrue(liste.contains(liste2.get(2)));
	}
    // ---Pour permettre l'execution des tests ----------------------
    public static junit.framework.Test suite() {
			return new junit.framework.JUnit4TestAdapter(competition.SelectFirstTwoAndBestThirdsTest.class);
    }
}
