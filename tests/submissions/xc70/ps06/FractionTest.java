package net.mrpaul.ads.xc70.ps06;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FractionTest {

	private Fraction f1;
	private Fraction f2;
	private Fraction f3;

	
	@Before
	public void setUp() throws Exception {
		this.f1 = new Fraction(2, 3);
		this.f2 = new Fraction(-2, 6);
		this.f3 = new Fraction(8, 2);
	}

	@After
	public void tearDown() throws Exception {
		this.f1 = null;
		this.f2 = null;
		this.f3 = null;
	}

	@Test
	public void testAdd() {
		assertEquals(f1.add(f2).getDoubleEquivalent(), 1.0/3.0, 0);
		assertEquals(f1.add(f3).getDoubleEquivalent(), 28.0/6.0, 0);
	}

	@Test
	public void testSubtract() {
		assertEquals(f1.subtract(f2).getDoubleEquivalent(), 1.0, 0);
		assertEquals(f1.subtract(f3).getDoubleEquivalent(), -20.0/6.0, 0);
	}

	@Test
	public void testMultiply() {
		assertEquals(f1.multiply(f2).getDoubleEquivalent(), -4.0/18.0, 0);
		assertEquals(f2.multiply(f3).getDoubleEquivalent(), -16.0/12.0, 0);
	}

	@Test
	public void testDivide() {
		assertEquals(f1.divide(f2).getDoubleEquivalent(), 12.0/-6.0, 0);
		assertEquals(f2.divide(f3).getDoubleEquivalent(), -4.0/48.0, 0);
	}

	@Test
	public void testReduce() {
		assertEquals(f2.reduce().toString(), new Fraction(1, -3).toString());
		assertEquals(f3.reduce().toString(), new Fraction(4, 1).toString());
	}

	@Test (expected = IllegalArgumentException.class)
	public void throwsExceptionWhenDenominatorIsZero() {
		new Fraction(5, 0);
	}
	
}
