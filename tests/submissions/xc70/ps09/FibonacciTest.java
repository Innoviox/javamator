package net.mrpaul.ads.xc70.ps09;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FibonacciTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testRecursiveFibonacci() {
		assertEquals(Fibonacci.recursiveFibonacci(0), 0);
		assertEquals(Fibonacci.recursiveFibonacci(1), 1);
		assertEquals(Fibonacci.recursiveFibonacci(23), 28657);
	}

	@Test
	void testDynamicFibonacci() {
		assertEquals(Fibonacci.dynamicFibonacci(0), 0);
		assertEquals(Fibonacci.dynamicFibonacci(1), 1);
		assertEquals(Fibonacci.dynamicFibonacci(23), 28657);
		assertEquals(Fibonacci.dynamicFibonacci(46), 1836311903);
	}

}
