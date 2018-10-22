package net.mrpaul.ads.xc70.ps06;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PointTest {

	private Point p1;
	private Point p2;
	private Point p3;
	private Point p4;
	private Point p5;
	private Point p6;
	private Point p7;

	@Before
	public void setUp() throws Exception {
		this.p1 = new Point(3, 14);
		this.p2 = new Point(5, 67);
		this.p3 = new Point(-22, 5);
		this.p4 = new Point(-22, -232);
		this.p5 = new Point(5, 20);
		this.p6 = new Point(7, 26);
		this.p7 = new Point(-22, 100);
	}

	@After
	public void tearDown() throws Exception {
		this.p1 = null;
		this.p2 = null;
		this.p3 = null;
		this.p4 = null;
	}

	@Test
	public void testManhattanDistance() {
		assertEquals(p1.manhattanDistance(p2), 55);
		assertEquals(p2.manhattanDistance(p3), 89);
	}

	@Test
	public void testIsVertical() {
		assertTrue(p4.isVertical(p3));
		assertFalse(p3.isVertical(p2));
	}
	
	@Test
	public void testSlope() {
		assertEquals(p1.slope(p2), 26.5, 0);
		assertEquals(p4.slope(p1), 246.0/25.0, 0);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void throwsExceptionWhenVerticalSlope() {
		p3.slope(p4);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void throwsExceptionWhenSamePoint() {
		p3.slope(p3);
	}
	
	@Test
	public void testIsCollinear() {
		assertFalse(this.p1.isCollinear(this.p2, this.p3));
		assertTrue(this.p1.isCollinear(this.p5, this.p6));
		assertTrue(this.p3.isCollinear(this.p4, this.p7));
	}
}
