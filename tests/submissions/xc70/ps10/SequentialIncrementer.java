package net.mrpaul.ads.xc70.ps10;

/**
 * Sequentially increments
 * This class increments sequentially from zero.
 * <p>
 * ADS PS10: Inheritance
 * 6/15/18
 * 
 * @author Kevin Higgs
 */
public class SequentialIncrementer implements Incrementable {

	public int value = 0;
	
	/**
	 * Get the value
	 * <p>The goal of this method is to get the value.</p>
	 * 
	 * @author Kevin Higgs
	 * @return an int after getting the value
	 */
	public int getValue() { return value; }
	
	/**
	 * Increment method
	 * <p>The purpose of this method is to increment.</p>
	 * 
	 * @author Kevin Higgs
	 */
	public void increment() { value++; }
	
}
