package competition;

import java.util.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LeagueTest extends CompetitionTest{

	private Competitor c1;
	private Competitor c2;
	private Competitor c3;
	private Competitor c4;
	private Competition competition;
	private List<Competitor> liste = new ArrayList<Competitor>();
	protected Competition createCompetition(){
		return new League(liste);
	}

	@Before
	public void before() {
		this.c1 = new Competitor("Joel");
		this.c2 = new Competitor("Bouba");
		this.c3 = new Competitor("Lynx");
    this.c4 = new Competitor("Raven");
		this.competition = new League(liste);

	}

	@Test
	public void testPlay() throws NumberNotPowerOf2Exception{
		this.competition.addCompetitors(this.c1);
		this.competition.addCompetitors(this.c2);
		this.competition.addCompetitors(this.c3);
		this.competition.addCompetitors(this.c4);
		this.competition.play(this.competition.getCompetitors());
		assertTrue(this.c1.getPoints()<=6); // avec 4 competiteurs, il est impossible d'en avoir un avec plus de 6 victoires (points)
		assertTrue(this.c2.getPoints()<=6);
		assertTrue(this.c3.getPoints()<=6);
		assertTrue(this.c4.getPoints()<=6);
		assertTrue(this.c1.getPoints()+this.c2.getPoints()+this.c3.getPoints()+this.c4.getPoints()<=24);
	}

    // ---Pour permettre l'execution des tests ----------------------
    public static junit.framework.Test suite() {
			return new junit.framework.JUnit4TestAdapter(competition.LeagueTest.class);
    }

}
