package competition;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MatchTest {

	private Competitor competitor1;
  private Competitor competitor2;
	private Match match;

	@Before
	public void before() {
			this.competitor1 = new Competitor("Joel");
	    this.competitor2 = new Competitor("Bouba");
			this.match = new Match(this.competitor1,this.competitor2);
	}

	@Test
	public void testGetCompetitor1() {
		assertSame(this.competitor1,this.match.getCompetitor1());
	}

	@Test
	public void testGetCompetitor2() {
		assertSame(this.competitor2,this.match.getCompetitor2());
	}

	@Test
	public void testPlay() {
		assertEquals(0,this.competitor1.getPoints());
		assertEquals(0,this.competitor2.getPoints());
		Competitor c = this.match.play();
		assertEquals(1,c.getPoints());
		assertSame(c,this.match.winner());
	}

	@Test
	public void testWinner() {
	    assertEquals(0,this.competitor1.getPoints());
	    assertEquals(0,this.competitor2.getPoints());
			Competitor c = this.match.play();
			assertEquals(1,c.getPoints());
			assertSame(c,this.match.winner());
	}

    // ---Pour permettre l'execution des tests ----------------------
    public static junit.framework.Test suite() {
	return new junit.framework.JUnit4TestAdapter(competition.MatchTest.class);
    }

}
