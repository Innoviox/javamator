package net.mrpaul.ads.xc70.ps04;

/**
 * Encrypts a message with the Caeser cipher
 * 
 * The program takes the key for the Caeser cipher as a commnad line argument. The program then prompts for a message to encrypt.
 * <p>
 * The program the encrypts the message with the Caeser cipher and outputs the result.
 * <p>
 * Accel PS04: Crypto
 * 3/12/18
 * 
 * @author Kevin Higgs
 */
public class Caeser {
	
	/**
	 * Encrypts a message with the Caeser cipher.
	 * <p>This program takes user input for a message and a command line argument for the key.
	 * It then encrypts the message with the key and outputs the result.</p>
	 * 
	 * @author Kevin Higgs
	 * @param args an array of length 1, containing the encryption key
	 */
	public static void main(String args[]) {
		// takes user input and does the Caeser Cipher
		System.out.println(args.length == 1 && System.out.printf("Enter a string to encrypt: ").getClass().getName() ==  "java.io.PrintStream" ? new java.util.Scanner(System.in).nextLine().chars().mapToObj(c -> (char) c).map(c -> c >= 'A' && c <= 'Z' ? (c-'A'+Integer.parseInt(args[0])) % 26 + 'A' : c >= 'a' && c <='z' ? (c-'a'+Integer.parseInt(args[0])) % 26 + 'a' : c).map(c -> Character.toString((char)(int)c)).reduce("", (s, c) -> s + c) : "Please enter one command line argument: the key to use for encryption.");
	} // end of main
} // end of Caeser
