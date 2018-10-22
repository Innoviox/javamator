package net.mrpaul.ads.xc70.ps09;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Calculate the minimum required coins to create change
 * This class uses both dynamic and recursive algorithms to calculate the minimum number of coins necessary to create change.
 * <p>
 * ADS PS09: Greedy redux + eBay
 * 6/14/18
 * 
 * @author Kevin Higgs
 */
public class ChangeCalculator {
	
	/**
	 * Recursive minimum change
	 * <p>The purpose of this method is to calculate minimum change with n and coins recursively.</p>
	 * 
	 * @author Kevin Higgs
	 * @param n an int used for calculating minimum change
	 * @param coins an int[] used as the coins
	 * @return minimum number of coins necessary
	 */
	public static int recursiveMinChange(int n, int[] coins) {
		// calculate the minimum number of coins needed recursively
		return n == 0 ? 0 : n < 0 ? Integer.MIN_VALUE : IntStream.of(coins).map(c -> recursiveMinChange(n-c, coins)+1).reduce(Integer.MAX_VALUE, (a, b) -> a < b || b < 0 ? a : b); 
	}
	
	/**
	 * Dynamic min change
	 * <p>The goal of this method is to calculate minimum change with n and coins dynamically.</p>
	 * 
	 * @author Kevin Higgs
	 * @param n an int used for calculating mininimum change
	 * @param coins an int[] used as the coins
	 * @return minimum number of coins necessary
	 */
	public static int dynamicMinChange(int n, int[] coins) {
		// calculate minimum number of coins needed dynamically
		return Stream.iterate(new int[]{0}, i -> IntStream.concat(IntStream.of(i), IntStream.of(new int[]{IntStream.of(coins).map(c -> i.length - c >= 0 ? i[i.length - c] : Integer.MAX_VALUE).min().getAsInt()+1})).toArray()).limit(n+1).reduce((a, b) -> b).orElse(null)[n];
	}
}
