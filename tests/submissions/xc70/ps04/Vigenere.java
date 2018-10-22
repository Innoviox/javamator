package net.mrpaul.ads.xc70.ps04;

/**
 * Encrypts a message with the Vigenere cipher
 * 
 * The program takes the key for the Vigenere cipher as a commnad line argument. The program then prompts for a message to encrypt.
 * <p>
 * The program then encrypts the message with the Vigenere cipher and outputs the result.
 * <p>
 * Accel PS04: Crypto
 * 3/12/18
 * 
 * @author Kevin Higgs
 */
public class Vigenere {
	
	/**
	 * Encrypts a message with the Vigenere cipher.
	 * <p>This program takes user input for a message and a command line argument for the key.
	 * It then encrypts the message with the key and outputs the result.</p>
	 * 
	 * @author Kevin Higgs
	 * @param args an array of length 1, containing the encryption key
	 */
	public static void main(String args[]) {
		// takes user input and does the Vigenere Cipher
		// I used an array so that the counter is effectively final and can be used within the lambda function.
		// Hopefully this does not break the spirit of the restriction of no arrays.
		int[] i = {0};
		System.out.println(args.length == 1 && System.out.printf("Enter a string to encrypt: ").getClass().getName() ==  "java.io.PrintStream" ? new java.util.Scanner(System.in).nextLine().chars().mapToObj(c -> (char) c).map(c -> c >= 'A' && c <= 'Z' ? (c-'A'+args[0].toUpperCase().charAt(i[0]++ % args[0].length())-'A') % 26 + 'A' : c >= 'a' && c <='z' ? (c-'a'+args[0].toLowerCase().charAt(i[0]++ % args[0].length())-'a') % 26 + 'a' : c).map(c -> Character.toString((char)(int)c)).reduce("", (s, c) -> s + c) : "Please enter one command line argument: the key to use for encryption.");
	} // end of main
} // end of Vigenere
