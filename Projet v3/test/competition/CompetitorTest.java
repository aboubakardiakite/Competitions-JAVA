package competition;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CompetitorTest {

	private Competitor c1;

	@Before
	public void before() {
		this.c1 = new Competitor("Joel");
	}

	@Test
	public void testGetPoints() {
		assertEquals(0,this.c1.getPoints());
		this.c1.addPoint();
		assertEquals(1,this.c1.getPoints());
	}

	@Test
	public void testGetName() {
		assertEquals("Joel",this.c1.getName());
	}

	@Test
	public void testAddPoint() {
		assertEquals(0,this.c1.getPoints());
		this.c1.addPoint();
		assertEquals(1,this.c1.getPoints());
	}

    // ---Pour permettre l'execution des tests ----------------------
    public static junit.framework.Test suite() {
			return new junit.framework.JUnit4TestAdapter(competition.CompetitorTest.class);
    }

}
