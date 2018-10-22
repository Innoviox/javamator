package net.mrpaul.ads.xc70.ps04;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.*;

/**
 * Breaks a message encrypted with the Caeser cipher.
 * 
 * The program prompts for a message to break.
 * <p>
 * The program the decrypts the message with the Caeser cipher with all possible keys (0 through 25), and outputs the one with the most words in it.
 * <p>
 * Accel PS04: Crypto
 * 3/12/18
 * 
 * @author Kevin Higgs
 */
public class CaeserCracker {
	
	/**
	 * Breaks a message encrypted with the Caeser cipher.
	 * <p>This program prompts the user for the message to break.
	 * It then tries all possible keys to find the one with the most English words.
	 * Assumes there is a file name wordlist.txt in the root of the project directory.</p>
	 * 
	 * @author Kevin Higgs
	 * @param args unused
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// prepare word list (found in wordlist.txt)
		String words = new Scanner(new File("wordlist.txt")).useDelimiter("\\A").next().replaceAll("\n|\r\n", "|");
		Pattern wordPattern = Pattern.compile("(^| )("+words+")($| )");
		
		// read in encrypted string
		System.out.print("Enter the encrypted string to decrypt: ");
		String message = new Scanner(System.in).nextLine();
		
		// initialize variables
		int max = -1;
		int count;
		String decrypted;
		String mostWords = "";
		Matcher wordMatcher;
		
		// try all possible keys
		for (int key = 0; key < 26; key++) {
			
			// decrypt
			int i = key;
			decrypted = message.chars().mapToObj(c -> (char) c).map(c -> c >= 'A' && c <= 'Z' ? (c-'A'+i) % 26 + 'A' : c >= 'a' && c <='z' ? (c-'a'+i) % 26 + 'a' : c).map(c -> Character.toString((char)(int)c)).reduce("", (s, c) -> s + c);
			
			// find number of words and update max and mostWords if the number of words is greater than the current max
			count = 0;
			wordMatcher = wordPattern.matcher(decrypted.toLowerCase());
			while (wordMatcher.find()) count++;
			if (count > max) {
				mostWords = decrypted;
				max = count;
			} // end of if
		} // end of for loop
		
		// output the decrypted string
		System.out.println(mostWords);
	} // end of main
} // end of CaeserCracker
