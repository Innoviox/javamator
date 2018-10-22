package net.mrpaul.ads.xc70.ps05;

import java.util.Random;
import java.util.Scanner;

import images.APImage;			//Note: We need to import from the images package!
import images.Pixel;

/**
 * Scrambles and unscrambles images
 * 
 * Uses scrambling to encrypt an image by randomizing blue and green values, and suppressing red values
 * Also can unscramble by keeping only amplified red values
 * <p>
 * Accel PS05: Foul Play
 * 4/3/18
 * 
 * @author Kevin Higgs
 */
public class Scrambling {

	/**
	 * Encrypts and decrypts the image asecretmessage.png/asecretmessage_encoded.png
	 * @author Kevin Higgs
	 * @param args unused
	 * Encrypts and decrypts the image asecretmessage.png/asecretmessage_encoded.png
	 * <p>Assumes asecretmessage.png is in the directory, and encoded image is saved as asecretmessage_encoded.png
	 */
	public static void main(String[] args) {
		//scrambe and unscramble
		scramble("asecretmessage.png");
		unscramble("asecretmessage_encoded.png");
	}//end of main
	
		
	
	/**
	 * Unscrambles an image puzzle for ps05: Foul play.
	 * @author Kevin Higgs
	 * @param fileName a String holding the file name of a .png file in the current working directory.  Example: "scrambled_image.png"
	 * Creates an APImage object out of the file called fileName
	 * <p>Renders the scrambled APImage
	 * <p>Goes through each Pixel in that APImage object and mutes Green and Blue
	 * <p>Pixel values while amplifying red values by a factor of 5.
	 * <p>Then renders the unscrambled (i.e. modified) APImage object
	 * <p>Then prompts the user to save the unscrambled image.
	 * <p>Assumes: valid filename ending in .png that exists in the directory
	 */
	public static void unscramble(String fileName){
		// open image and prompt to unscramble
		APImage image = new APImage(fileName);
		image.draw();
		System.out.println("Hit enter to unscramble the image.");
		Scanner reader = new Scanner(System.in);
		reader.nextLine();
		
		// unscramble image
		for (Pixel p : image) {
			p.setBlue(0);
			p.setGreen(0);
			p.setRed(p.getRed()*10);
		}
		System.out.println("Hit enter to display decrypted image.");
		reader.nextLine();
		image.draw();
		
		// prompt to save
		System.out.println("Save image? y/n");
		if (reader.nextLine().equals("y")) image.saveAs();
	}//end of unscramble
	
	
	
	
	/**
	 * Scrambles an image for ps05.
	 * @author 
	 * @param fileName a String holding the file name of a .png file
	 * Creates an APImage object out of the file called fileName
	 * <p>Renders the regular APImage
	 * <p>Goes through each Pixel in that APImage object and randomizes the Green and Blue
	 * <p>Pixel values while diminishing red values by a factor of 10.
	 * <p>Then renders the scrambled (i.e. modified) APImage object
	 * <p>Then prompts the user to save the unscrambled image.
	 * <p>Assumes: valid filename ending in .png that exists in the directory
	 */
	public static void scramble(String fileName){
		// open image and prompt to scramble
		APImage image = new APImage(fileName);
		image.draw();
		System.out.println("Hit enter to scramble the image.");
		Scanner reader = new Scanner(System.in);
		reader.nextLine();
		
		// scramble image
		Random r = new Random();
		for (Pixel p : image) {
			p.setBlue(r.nextInt(256));
			p.setGreen(r.nextInt(256));
			p.setRed(p.getRed()/10);
		}
		System.out.println("Hit enter to display encrypted image.");
		reader.nextLine();
		image.draw();
		
		// prompt to save
		System.out.println("Save image? y/n");
		if (reader.nextLine().equals("y")) image.saveAs();
	}//end of scramble

}
