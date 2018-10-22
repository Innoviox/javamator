package net.mrpaul.ads.xc70.ps06;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StandardFormLinearSystemTest {

	private StandardFormLinearSystem s;
	
	@Before
	public void setUp() throws Exception {
		this.s = new StandardFormLinearSystem();
	}

	@After
	public void tearDown() throws Exception {
		this.s = null;
	}

	@Test
	public void testToString() {
		assertEquals(s.toString(), "-1.0x + 1.0y = 1.0\n-1.0x + 1.0y = 1.0");
		this.s.setLine(1, new StandardFormLine(1, 1, 1));
		assertEquals(s.toString(), "1.0x + 1.0y = 1.0\n-1.0x + 1.0y = 1.0");
	}

	@Test
	public void testHaveSameSlope() {
		assertTrue(s.haveSameSlope());
		this.s.setLine(1, new StandardFormLine(1, 1, 1));
		assertFalse(s.haveSameSlope());
	}

	@Test
	public void testHasInfiniteSolutions() {
		assertTrue(s.hasInfiniteSolutions());
		this.s.setLine(1, new StandardFormLine(1, 1, 1));
		assertFalse(s.hasInfiniteSolutions());
	}

	@Test
	public void testAreParallel() {
		assertFalse(s.areParallel());
		this.s.setLine(1, new StandardFormLine(-2, 2, 1));
		assertTrue(s.areParallel());
	}

	@Test
	public void testSolve() {
		assertEquals(s.solve(), null);
		this.s.setLine(1, new StandardFormLine(-2, 2, 1));
		assertEquals(s.solve(), null);
		this.s.setLine(1, new StandardFormLine(1, 1, 1));
		assertEquals(s.solve().getX(), 0);
		assertEquals(s.solve().getY(), 1);
	}

}
