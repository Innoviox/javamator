package net.mrpaul.ads.xc70.ps09;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ExercisesGRTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testFillOne() {
		assertArrayEquals(ExercisesGR.fillOne(0), new int[] {});
		assertArrayEquals(ExercisesGR.fillOne(2), new int[] {1, 1});
		assertArrayEquals(ExercisesGR.fillOne(12), new int[] {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1});
	}

	@Test
	void testReverse() {
		assertArrayEquals(ExercisesGR.reverse(new int[]{1, 3, 2}), new int[]{2, 3, 1});
		assertArrayEquals(ExercisesGR.reverse(new int[]{}), new int[]{});
		assertArrayEquals(ExercisesGR.reverse(new int[]{1}), new int[]{1});
	}

	@Test
	void testInsertBetweenTriads() {
		assertArrayEquals(ExercisesGR.insertBetweenTriads(new int[]{1, 2, 3}, -1), new int[]{-1, 1, 2, 3, -1});
		assertArrayEquals(ExercisesGR.insertBetweenTriads(new int[]{1, 2, 3, 4}, 15), new int[]{15, 1, 2, 3, 15, 4});
		assertArrayEquals(ExercisesGR.insertBetweenTriads(new int[]{}, 15), new int[]{15});
	}

}
