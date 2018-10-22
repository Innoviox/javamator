package net.mrpaul.ads.xc70.ps08;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArraysPotpourriTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testLastIndexOf() {
		assertEquals(ArraysPotpourri.lastIndexOf(new int[]{74, 85, 102, 99, 101, 85, 56}, 85), 5);
		assertEquals(ArraysPotpourri.lastIndexOf(new int[]{74, 85, 102, 99, 101, 85, 56}, 120120), -1);
	}

	@Test
	void testRange() {
		assertEquals(ArraysPotpourri.range(new int[]{8, 3, 5, 7, 2, 4}), 7);
		assertEquals(ArraysPotpourri.range(new int[]{32}), 1);
		assertEquals(ArraysPotpourri.range(new int[]{3, 10000000, 5, -29, 4}), 10000030);
	}

	@Test
	void testCountInRange() {
		assertEquals(ArraysPotpourri.countInRange(new int[]{14, 1, 22, 17, 36, 7, -43, 5}, 4, 17), 4);
		assertEquals(ArraysPotpourri.countInRange(new int[]{}, 4, 17), 0);
	}

	@Test
	void testIsSorted() {
		assertTrue(ArraysPotpourri.isSorted(new double[]{5.0}));
		assertTrue(ArraysPotpourri.isSorted(new double[]{2.0, 3.0, 5.0}));
		assertFalse(ArraysPotpourri.isSorted(new double[]{2.0, 3.0, 5.0, 4.0}));
	}

	@Test
	void testMode() {
		assertEquals(ArraysPotpourri.mode(new int[]{27, 15, 15, 11, 27}), 15);
		assertEquals(ArraysPotpourri.mode(new int[]{0, 5, 0, 0, 2, 3}), 0);
	}

	@Test
	void testStdev() {
		assertEquals(ArraysPotpourri.stdev(new int[]{1, -2, 4, -4, 9, -6, 16, -8, 25, -10}), 11.237, 0.001);
		assertEquals(ArraysPotpourri.stdev(new int[]{600, 470, 170, 430, 300}), 164.712, .001);
	}

	@Test
	void testKthLargest() {
		assertEquals(ArraysPotpourri.kthLargest(2, new int[]{74, 85, 102, 99, 101, 56, 84}), 99);
		assertEquals(ArraysPotpourri.kthLargest(1, new int[]{4, 6, 12, 7, 12, 12}), 12);
		assertEquals(ArraysPotpourri.kthLargest(0, new int[]{4, 6, 12, 7, 12, 12}), 12);
	}

	@Test
	void testMinGap() {
		assertEquals(ArraysPotpourri.minGap(new int[]{1, 3, 6, 7, 12}), 1);
		assertEquals(ArraysPotpourri.minGap(new int[]{3, 5, 11, 4, 8}), -7);
		assertEquals(ArraysPotpourri.minGap(new int[]{8}), 0);
		assertEquals(ArraysPotpourri.minGap(new int[]{}), 0);
	}

	@Test
	void testPercentEven() {
		assertEquals(ArraysPotpourri.percentEven(new int[]{6, 2, 9, 11, 3}), 40.0, 0.001);
		assertEquals(ArraysPotpourri.percentEven(new int[]{5, 3, 9, 11, 3}), 0.0, 0.001);
	}

	@Test
	void testIsUnique() {
		assertTrue(ArraysPotpourri.isUnique(new int[]{3, 8, 12, 2, 9}));
		assertTrue(ArraysPotpourri.isUnique(new int[]{}));
		assertFalse(ArraysPotpourri.isUnique(new int[]{2, 2, 2, 2, 2, 2}));
	}

	@Test
	void testPriceIsRight() {
		assertEquals(ArraysPotpourri.priceIsRight(new int[]{900, 885, 989, 1}, 800), 1);
		assertEquals(ArraysPotpourri.priceIsRight(new int[]{200, 300, 250, 999, 40}, 280), 250);
		assertEquals(ArraysPotpourri.priceIsRight(new int[]{200}, 120), -1);
		assertEquals(ArraysPotpourri.priceIsRight(new int[]{500, 300, 241, 99, 501}, 50), -1);
	}
	
	@Test
	void testLongestSortedSequence() {
		assertEquals(ArraysPotpourri.longestSortedSequence(new int[]{}), 0);
		assertEquals(ArraysPotpourri.longestSortedSequence(new int[]{3, 8, 10, 1, 9, 14, -3, 0, 14, 207, 56, 98, 12}), 4);
		assertEquals(ArraysPotpourri.longestSortedSequence(new int[]{17, 42, 3, 5, 5, 5, 8, 2, 4, 6, 1, 19}), 5);
		assertEquals(ArraysPotpourri.longestSortedSequence(new int[]{4, 3, 2}), 1);
	}

	@Test
	void testContains() {
		assertTrue(ArraysPotpourri.contains(new int[]{1, 6, 2, 1, 4, 1, 2, 1, 8}, new int[]{1, 2, 1}));
		assertFalse(ArraysPotpourri.contains(new int[]{1, 6, 2, 1, 4, 1, 2, 1, 8}, new int[]{1, 2, 2}));
	}

	@Test
	void testCollapse() {
		assertArrayEquals(ArraysPotpourri.collapse(new int[]{7, 2, 8, 9, 4, 13, 7, 1, 9, 10}), new int[]{9, 17, 17, 8, 19});
		assertArrayEquals(ArraysPotpourri.collapse(new int[]{7, 2, 8, 9, 4, 13, 7, 1, 9, 10, 2}), new int[]{9, 17, 17, 8, 19, 2});
	}
	
	@Test
	void testAppend() {
		assertArrayEquals(ArraysPotpourri.append(new int[]{2, 4, 6}, new int[]{1, 2, 3, 4, 5}), new int[]{2, 4, 6, 1, 2, 3, 4, 5});
		assertArrayEquals(ArraysPotpourri.append(new int[]{2, 4, 6}, new int[]{}), new int[]{2, 4, 6});
	}

	@Test
	void testVowelCount() {
		assertArrayEquals(ArraysPotpourri.vowelCount("i think, therefore i am"), new int[]{1, 3, 3, 1, 0});
		assertArrayEquals(ArraysPotpourri.vowelCount(""), new int[5]);
	}

}
