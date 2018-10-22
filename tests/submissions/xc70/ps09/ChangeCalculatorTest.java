package net.mrpaul.ads.xc70.ps09;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ChangeCalculatorTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testRecursiveMinChange() {
		assertEquals(ChangeCalculator.recursiveMinChange(0, new int[]{1, 5, 10, 25}), 0);
		assertEquals(ChangeCalculator.recursiveMinChange(1, new int[]{1, 5, 10, 25}), 1);
		assertEquals(ChangeCalculator.recursiveMinChange(22, new int[]{1, 5, 10, 25}), 4);
		assertEquals(ChangeCalculator.recursiveMinChange(14, new int[]{1, 5, 10, 25}), 5);
		assertEquals(ChangeCalculator.recursiveMinChange(30, new int[]{1, 5, 10, 25}), 2);
		assertEquals(ChangeCalculator.recursiveMinChange(0, new int[]{1, 3, 9, 27}), 0);
		assertEquals(ChangeCalculator.recursiveMinChange(1, new int[]{1, 3, 9, 27}), 1);
		assertEquals(ChangeCalculator.recursiveMinChange(22, new int[]{1, 3, 9, 27}), 4);
		assertEquals(ChangeCalculator.recursiveMinChange(14, new int[]{1, 3, 9, 27}), 4);
		assertEquals(ChangeCalculator.recursiveMinChange(30, new int[]{1, 3, 9, 27}), 2);
	}

	@Test
	void testDynamicMinChange() {
		assertEquals(ChangeCalculator.dynamicMinChange(17852, new int[]{1, 3, 9, 27}), 664);
		assertEquals(ChangeCalculator.dynamicMinChange(0, new int[]{1, 5, 10, 25}), 0);
		assertEquals(ChangeCalculator.dynamicMinChange(1, new int[]{1, 5, 10, 25}), 1);
		assertEquals(ChangeCalculator.dynamicMinChange(22, new int[]{1, 5, 10, 25}), 4);
		assertEquals(ChangeCalculator.dynamicMinChange(14, new int[]{1, 5, 10, 25}), 5);
		assertEquals(ChangeCalculator.dynamicMinChange(30, new int[]{1, 5, 10, 25}), 2);
		assertEquals(ChangeCalculator.dynamicMinChange(0, new int[]{1, 3, 9, 27}), 0);
		assertEquals(ChangeCalculator.dynamicMinChange(1, new int[]{1, 3, 9, 27}), 1);
		assertEquals(ChangeCalculator.dynamicMinChange(22, new int[]{1, 3, 9, 27}), 4);
		assertEquals(ChangeCalculator.dynamicMinChange(14, new int[]{1, 3, 9, 27}), 4);
		assertEquals(ChangeCalculator.dynamicMinChange(30, new int[]{1, 3, 9, 27}), 2);	}

}
