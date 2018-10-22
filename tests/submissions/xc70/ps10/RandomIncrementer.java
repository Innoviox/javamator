package net.mrpaul.ads.xc70.ps10;

import java.util.Random;

/**
 * This class increments randomly.
 * This class randomly increments from a random number.
 * <p>
 * ADS PS10: Inheritance
 * 6/15/18
 * 
 * @author Kevin Higgs
 */
public class RandomIncrementer implements Incrementable {

	public int value;
	
	public Random gen = new Random();
	
	/**
	 * Instantiate a random incrementer
	 * <p>The use of this method is to instantiate a random incrementer.</p>
	 * 
	 * @author Kevin Higgs
	 */
	public RandomIncrementer() {
		value = gen.nextInt(100)+1;
	}
	
	/**
	 * Get the value
	 * <p>The purpose of this method is to get the value.</p>
	 * 
	 * @author Kevin Higgs
	 * @return an int after getting the value
	 */
	public int getValue() { return value; }
	
	/**
	 * Increment method
	 * <p>The goal of this method is to increment.</p>
	 * 
	 * @author Kevin Higgs
	 */
	public void increment() { value += gen.nextInt(100)+1; }
	
}
