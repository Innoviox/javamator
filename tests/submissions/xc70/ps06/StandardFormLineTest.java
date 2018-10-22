package net.mrpaul.ads.xc70.ps06;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StandardFormLineTest {

	private StandardFormLine line;
	
	@Before
	public void setUp() throws Exception {
		this.line = new StandardFormLine();
	}

	@After
	public void tearDown() throws Exception {
		this.line = null;
	}

	@Test
	public void testStandardFormLinePointPoint() {
		this.line = new StandardFormLine(new Point(0, 0), new Point(1, 1));
		assertEquals(line.getSlope(), 1.0, 0);
		this.line = new StandardFormLine(new Point(0, 0), new Point(2, 1));
		assertEquals(line.getSlope(), 0.5, 0);
	}

	@Test
	public void testGetSlope() {
		assertEquals(line.getSlope(), 1.0, 0);
		line.setA(1);
		assertEquals(line.getSlope(), -1.0, 0);
	}

	@Test
	public void testToString() {
		assertEquals(line.toString(), "-1.0x + 1.0y = 1.0");
		line.setA(1);
		assertEquals(line.toString(), "1.0x + 1.0y = 1.0");
	}

}
