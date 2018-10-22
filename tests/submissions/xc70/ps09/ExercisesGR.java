package net.mrpaul.ads.xc70.ps09;

import java.util.stream.IntStream;

/**
 * Exercises with arrays
 * This class contains exercises that perform modifications on arrays.
 * <p>
 * ADS PS09: Greedy redux + eBay
 * 6/14/18
 * 
 * @author Kevin Higgs
 */
public class ExercisesGR {
	/**
	 * Fill one
	 * <p>The purpose of this method is to fill one with length.</p>
	 * 
	 * @author Kevin Higgs
	 * @param length an int used as the length
	 * @return an int[] after filling one
	 */
	public static int[] fillOne(int length) {
		// generate array with 1s of desired length
		return IntStream.generate(() -> 1).limit(length).toArray();
	}
	
	/**
	 * Reverse method
	 * <p>The goal of this method is to reverse with a.</p>
	 * 
	 * @author Kevin Higgs
	 * @param a an int[] used for reversing
	 * @return an int[] after reversing
	 */
	public static int[] reverse(int[] a) {
		// reverse array
		return IntStream.range(0, a.length).map(i -> a[a.length - i - 1]).toArray();
	}
	
	/**
	 * Insert between triads
	 * <p>The use of this method is to insert between triads with a and i.</p>
	 * 
	 * @author Kevin Higgs
	 * @param a an int[] used for inserting between triads
	 * @param i an int used for inserting between triads
	 * @return an int[] after inserting between triads
	 */
	public static int[] insertBetweenTriads(int[] a, int i) {
		// insert element between triads in array
		return IntStream.range(0, a.length+a.length/3+1).map(j -> j % 4 == 0 ? i : a[j-j/4-1]).toArray(); 
	}
}
