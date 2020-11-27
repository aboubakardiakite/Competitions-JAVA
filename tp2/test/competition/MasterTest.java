package competition;
import competition.methode.*;
import java.util.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MasterTest{
	private Competitor c1;
	private Competitor c2;
	private Competitor c3;
	private Competitor c4;
	private Methode methode;
	private List<Competitor> liste = new ArrayList<Competitor>();
	private Master competition;

	@Before
	public void before() {
		this.c1 = new Competitor("Joel");
		this.c2 = new Competitor("Bouba");
		this.c3 = new Competitor("Lynx");
    this.c4 = new Competitor("Raven");
		this.methode = new SelectFirst();
		this.competition = new Master(liste,2,methode);
	}

	@Test
	public void testPlayLeague() throws NumberNotPowerOf2Exception{
		this.competition.addCompetitors(this.c1);
		this.competition.addCompetitors(this.c2);
		this.competition.addCompetitors(this.c3);
		this.competition.addCompetitors(this.c4);
		this.competition.playLeague(this.competition.getCompetitors());
		assertTrue(this.c1.getPoints()<=2);
		assertTrue(this.c2.getPoints()<=2);
		assertTrue(this.c3.getPoints()<=2);
		assertTrue(this.c4.getPoints()<=2);
		assertTrue(this.c1.getPoints()+this.c2.getPoints()+this.c3.getPoints()+this.c4.getPoints()<=8);
	}

	@Test
	public void testPlayTournament() throws NumberNotPowerOf2Exception{
		this.competition.addCompetitors(this.c1);
		this.competition.addCompetitors(this.c2);
		this.competition.addCompetitors(this.c3);
		this.competition.addCompetitors(this.c4);
		this.competition.playLeague(this.competition.getCompetitors());
		this.competition.playTournament();
		assertTrue(this.competition.ranking().containsValue(1));
		assertTrue(this.competition.ranking().containsValue(0));
	}

	@Test
	public void testPlay() throws NumberNotPowerOf2Exception{
		this.competition.addCompetitors(this.c1);
		this.competition.addCompetitors(this.c2);
		this.competition.addCompetitors(this.c3);
		this.competition.addCompetitors(this.c4);
		this.competition.play(this.competition.getCompetitors());
		assertTrue(this.competition.ranking().containsValue(1));
		assertTrue(this.competition.ranking().containsValue(0));
	}

    // ---Pour permettre l'execution des tests ----------------------
    public static junit.framework.Test suite() {
			return new junit.framework.JUnit4TestAdapter(competition.MasterTest.class);
    }

}
