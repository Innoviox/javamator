package net.mrpaul.ads.xc70.ps09;

import java.util.stream.Stream;

/**
 * Calculate fibonacci numbers
 * This class calculate fibonacci numbers with both recursive and dynamic algorithms.
 * <p>
 * ADS PS09: Greedy redux + eBay
 * 6/14/18
 * 
 * @author Kevin Higgs
 */
public class Fibonacci {
	/**
	 * Main method
	 * <p>This method runs the main program.</p>
	 * 
	 * @author Kevin Higgs
	 * @param args a string[] used as the args
	 */
	public static void main(String[] args) {
		// output timing of recursive and dynamic fibonacci
		System.out.print(Stream.of(0, 5, 10, 15, 20, 25, 30, 35, 40, 45, 1, 6, 11, 16, 21, 26, 31, 36, 41, 46).map(x -> -(System.nanoTime() - new long[]{x % 5 == 0 ? recursiveFibonacci(x) : dynamicFibonacci(x-1), System.nanoTime()}[1])).map(x -> x.toString()).reduce("", (a, b) -> a + b + '\n'));
	}

	/**
	 * Recursive fibonacci
	 * <p>The use of this method is to recursive fibonacci with n.</p>
	 * 
	 * @author Kevin Higgs
	 * @param n an int used for recursiving fibonacci
	 * @return an int after recursiving fibonacci
	 */
	public static int recursiveFibonacci(int n) {
		// calculate nth fibonacci number recursively
		return n == 0 ? 0 : n == 1 ? 1 : recursiveFibonacci(n-1) + recursiveFibonacci(n-2);
	}

	/**
	 * Dynamic fibonacci
	 * <p>The use of this method is to dynamic fibonacci with n.</p>
	 * 
	 * @author Kevin Higgs
	 * @param n an int used for dynamicing fibonacci
	 * @return an int after dynamicing fibonacci
	 */
	public static int dynamicFibonacci(int n) {
		// calculate each fibonacci number as the sum of the previous two
		return n == 0 ? 0 : Stream.iterate(new int[]{0, 1}, i -> new int[]{i[1], i[0]+i[1]}).limit(n).reduce((a, b) -> b).orElse(null)[1];
	}
}
