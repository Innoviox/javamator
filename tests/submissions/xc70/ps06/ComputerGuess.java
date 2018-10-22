package net.mrpaul.ads.xc70.ps06;

import java.util.Scanner;

/**
 * The computer guesses the user's number
 * The computer tries to guess the user's inputted number in as few tries as possible.
 * <p>
 * ADS PS06: Cartesian
 * 4/22/18
 * 
 * @author Kevin Higgs
 */
public class ComputerGuess {
	
	/**
	 * Main method
	 * <p>This method runs the main program.</p>
	 * 
	 * @author Kevin Higgs
	 * @param args a string[] used as the args
	 */
	public static void main(String[] args) {
		// initialize variables
		System.out.println("Hello.  I am a computer.  I am going to try to guess your whole number between 1 and 1000.  Please think of one.");
		int max = 1000;
		int min = 0;
		int n = 1;
		int guess = (max+min)/2;
		String response = "";
		Scanner reader = new Scanner(System.in);
		// guess until right
		while (true) {
			System.out.println("Is it "+guess+"?");
			// until valid input, get input
			while (!(response.equals("y") || response.equals("h") || response.equals("l"))) { 
				System.out.print("Type y if I am correct.  Type h if your number is higher, and type l if your number is lower: ");
				response = reader.nextLine();
			}
			// correct
			if (response.equals("y")) break;
			// set minimum to guess
			if (response.equals("h")) {
				min = guess;
				System.out.print("You said it was higher. ");
			} else if (response.equals("l")) {
				// set maximum to guess
				max = guess;
				System.out.print("You said it was lower. ");
			}
			n++;
			response = "";
			// guess is average of min and max
			guess = (max + min)/2;
		}
		System.out.println("Got it! It was "+guess+". It took me "+n+" guesses.");
	}
	
}
