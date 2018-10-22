package net.mrpaul.ads.xc70.ps06;

import java.util.Scanner;

/**
 * Calculates the GCD of two numbers
 * This class provides an output of the steps in the Euclidean algorithm for calculating GCD.
 * <p>
 * ADS PS06: Cartesian
 * 4/22/18
 * 
 * @author Kevin Higgs
 */
public class EuclideanGCD {
	
	/**
	 * Main method
	 * <p>This method runs the main program.</p>
	 * 
	 * @author Kevin Higgs
	 * @param args a string[] used as the args
	 */
	public static void main(String[] args) {
		// get user input
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter n1");
		int n1 = reader.nextInt();
		System.out.println("Enter n2");
		int n2 = reader.nextInt();
		int r;
		// perform algorithm
		while (n1 != 0 && n2 != 0) {
			System.out.println("Step:");
			r = n1 % n2;
			System.out.println("A Remainder: "+r);
			n1 = n2;
			n2 = r;
			System.out.println("B\tn1: "+n1+" and n2: "+n2);
		}
		// output
		System.out.println("GCD is "+n1);
	}
	
}
