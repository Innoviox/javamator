package net.mrpaul.ads.xc70.ps06;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DiceTest {

	private Dice d1;
	
	@Before
	public void setUp() throws Exception {
		this.d1 = new Dice(1);
	}

	@After
	public void tearDown() throws Exception {
		this.d1 = null;
	}

	@Test
	public void testGetCurrentSide() {
		d1.roll();
		assertEquals(d1.getCurrentSide(), 4);
		d1.roll();
		assertEquals(d1.getCurrentSide(), 5);
	}

	@Test
	public void testGetNumRolls() {
		d1.roll();
		assertEquals(d1.getNumRolls(), 1);
		d1.roll();
		assertEquals(d1.getNumRolls(), 2);
	}

	@Test
	public void testGetNumRollsInt() {
		d1.roll();
		assertEquals(d1.getNumRolls(d1.getCurrentSide()), 1);
		d1.roll();
		assertNotEquals(d1.getNumRolls(d1.getCurrentSide()), 0);
	}

	@Test
	public void testGetPercentage() {
		assertEquals(d1.getPercentage(5), 0.0, 0);
		d1.roll();
		assertEquals(d1.getPercentage(d1.getCurrentSide()), 100.0, 0);
	}

	@Test
	public void testReset() {
		d1.roll();
		d1.reset();
		assertEquals(d1.getNumRolls(), 0);
		assertEquals(d1.getNumRolls(1), 0);
		assertEquals(d1.getNumRolls(2), 0);
		assertEquals(d1.getNumRolls(3), 0);
		assertEquals(d1.getNumRolls(4), 0);
		assertEquals(d1.getNumRolls(5), 0);
		assertEquals(d1.getNumRolls(6), 0);
	}

}
