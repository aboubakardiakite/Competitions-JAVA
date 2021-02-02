package competition;

import java.util.*;
import util.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public abstract class CompetitionTest {

	private Competitor c1;
	private Competitor c2;
	private Competitor c3;
	private Competitor c4;
	protected Competition competition;

	protected abstract Competition createCompetition();

	@Before
	public void init() {
		this.c1 = new Competitor("Joel");
		this.c2 = new Competitor("Bouba");
		this.c3 = new Competitor("Lynx");
    this.c4 = new Competitor("Raven");
		this.competition = this.createCompetition();

	}

	@Test
	public void addCompetitorsTest() {
		assertTrue(this.competition.getCompetitors().isEmpty());
		this.competition.addCompetitors(this.c1);
		this.competition.addCompetitors(this.c2);
		assertFalse(this.competition.getCompetitors().isEmpty());
	}

	@Test
	public void testPlayMatch() {
		this.competition.addCompetitors(this.c1);
		this.competition.addCompetitors(this.c2);
		assertEquals(0,this.c1.getPoints());
		assertEquals(0,this.c2.getPoints());
		assertEquals(this.c1.getPoints(),this.c2.getPoints());
		this.competition.playMatch(this.c1,this.c2);
		assertTrue(this.c1.getPoints()!=this.c2.getPoints());
	}

	@Test
	public void testPlay2() throws NumberNotPowerOf2Exception{
		this.competition.addCompetitors(this.c1);
		this.competition.addCompetitors(this.c2);
		this.competition.addCompetitors(this.c3);
		this.competition.addCompetitors(this.c4);
		this.competition.play();
		Map<Competitor, Integer> competiteur = new HashMap<Competitor, Integer>();
		competiteur.put(this.c1,this.c1.getPoints());
		competiteur.put(this.c2,this.c2.getPoints());
		competiteur.put(this.c3,this.c3.getPoints());
		competiteur.put(this.c4,this.c4.getPoints());
		assertEquals(this.competition.ranking(),MapUtil.sortByDescendingValue(competiteur));
	}

	@Test
	public void testRanking() throws NumberNotPowerOf2Exception{
		this.competition.addCompetitors(this.c1);
		this.competition.addCompetitors(this.c2);
		this.competition.addCompetitors(this.c3);
		this.competition.addCompetitors(this.c4);
		this.competition.play();
		Map<Competitor, Integer> competiteur = new HashMap<Competitor, Integer>();
		competiteur.put(this.c1,this.c1.getPoints());
		competiteur.put(this.c2,this.c2.getPoints());
		competiteur.put(this.c3,this.c3.getPoints());
		competiteur.put(this.c4,this.c4.getPoints());
		assertEquals(this.competition.ranking(),MapUtil.sortByDescendingValue(competiteur));
	}

    // ---Pour permettre l'execution des tests ----------------------
    public static junit.framework.Test suite() {
			return new junit.framework.JUnit4TestAdapter(competition.CompetitionTest.class);
    }

}
