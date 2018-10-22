package net.mrpaul.ads.xc70.ps06;

import java.util.Random;

/**
 * A die that can be rolled
 * This class is a six-sided die that can be rolled to generate random numbers and keep count of rolls.
 * <p>
 * ADS PS06: Cartesian
 * 4/22/18
 * 
 * @author Kevin Higgs
 */
public class Dice {
	
	private Random generator;
	private int currentSide;
	private int numRolls;
	private int numOnes;
	private int numTwos;
	private int numThrees;
	private int numFours;
	private int numFives;
	private int numSixes;

	/**
	 * Instantiate a dice
	 * <p>The goal of this method is to instantiate a dice.</p>
	 * 
	 * @author Kevin Higgs
	 */
	public Dice() {
		this.generator = new Random();
		this.currentSide = 1;
	}
	
	/**
	 * Instantiate a dice
	 * <p>The purpose of this method is to instantiate a dice with seed.</p>
	 * 
	 * @author Kevin Higgs
	 * @param seed a long used as the seed
	 */
	public Dice(long seed) {
		// seed random
		this.generator = new Random(seed);
		this.currentSide = 1;
	}
	
	/**
	 * Roll method
	 * <p>The use of this method is to roll.</p>
	 * 
	 * @author Kevin Higgs
	 */
	public void roll() {
		// generate number, increase num rolls, increase rolled number counter
		this.currentSide = this.generator.nextInt(6) + 1;
		this.numRolls++;
		if (this.currentSide == 1) this.numOnes++;
		if (this.currentSide == 2) this.numTwos++;
		if (this.currentSide == 3) this.numThrees++;
		if (this.currentSide == 4) this.numFours++;
		if (this.currentSide == 5) this.numFives++;
		if (this.currentSide == 6) this.numSixes++;
	}
	
	/**
	 * Get the current side
	 * <p>The use of this method is to get the current side.</p>
	 * 
	 * @author Kevin Higgs
	 * @return an int after getting the current side
	 */
	public int getCurrentSide() {
		return this.currentSide;
	}
	
	/**
	 * Get the number of rolls
	 * <p>The purpose of this method is to get the number of rolls.</p>
	 * 
	 * @author Kevin Higgs
	 * @return an int after getting the number of rolls
	 */
	public int getNumRolls() {
		return this.numRolls;
	}
	
	/**
	 * Get the number of rolls
	 * <p>The purpose of this method is to get the number of rolls with n.</p>
	 * 
	 * @author Kevin Higgs
	 * @param n an int used for getting the number of rolls
	 * @return an int after getting the number of rolls
	 */
	public int getNumRolls(int n) {
		if (n == 1) return this.numOnes;
		if (n == 2) return this.numTwos;
		if (n == 3) return this.numThrees;
		if (n == 4) return this.numFours;
		if (n == 5) return this.numFives;
		if (n == 6) return this.numSixes;
		return 0;
	}
	
	/**
	 * Get the percentage
	 * <p>The goal of this method is to get the percentage with n.</p>
	 * 
	 * @author Kevin Higgs
	 * @param n an int used for getting the percentage
	 * @return a double after getting the percentage
	 */
	public double getPercentage(int n) {
		return this.getNumRolls() == 0 ? 0.0 : (double)this.getNumRolls(n)/(double)this.getNumRolls() * 100.0;
	}
	
	/**
	 * Reset method
	 * <p>The use of this method is to reset.</p>
	 * 
	 * @author Kevin Higgs
	 */
	public void reset() {
		// set all counts to zero
		this.numOnes = 0;
		this.numTwos = 0;
		this.numThrees = 0;
		this.numFours = 0;
		this.numFives = 0;
		this.numSixes = 0;
		this.numRolls = 0;
	}
	
}
