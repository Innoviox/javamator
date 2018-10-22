package net.mrpaul.ads.xc70.ps05;

import images.APImage;			//Note: We need to import from the images package!
import images.Pixel;			//Note: We need to import from the images package!
import java.util.Scanner;

/**
 * Hides images within other images
 * Uses steganography to hide an image within another image
 * <p>
 * Accel PS05: Foul Play * @author Kevin Higgs
 * 4/3/18
 * 
 * @author Kevin Higgs
 */
public class Steganography { 
	/**
	 * Calls methods to hide image inside another image, then decode it
	 * Calls the proper methods to hide original_message.png within original_destination.png, then decode it
	 * <p>Assumes original_message.png exists and the user saves the images with the right filenames</p>
	 * @author Kevin Higgs
	 * @param args not used
	 */
	public static void main(String[] args) {

		/* generate black and white
		 * manually save the file you create in this method as original_message_bw.png
		 * make sure you save it in your project working directory
		 */
		generateBW("original_message.png");
		
		
		/*
		 * shave destination
		 * manually save the file you create in this method as original_destination_shaven.png
		 */
		shaveImage("original_destination.png");
		
		
		/*
		 * encode your black and white message into your shaven destination
		 * save the encoded image as destination_encoded.png
		 */
		encode("original_message_bw.png", "original_destination_shaven.png");
		
		
		
		/*
		 * decode your encoded image
		 */
		decode("destination_encoded.png");
		


	}//end of main
	
	
	/**
	 * Decodes a message
	 * Decodes the message that is hidden within a destination image
	 * 
	 * @author Kevin Higgs
	 * @param fileName name of file
	 */
	public static void decode(String fileName){
		// open image
		APImage image = new APImage(fileName);
		image.draw();
		Scanner reader = new Scanner(System.in);
		// decode the iamge
		for (Pixel p : image) {
			p.setRed((p.getRed() % 10) * 255);
			p.setGreen((p.getRed() % 10) * 255);
			p.setBlue((p.getRed() % 10) * 255);
		}
		// render and save
		System.out.println("Press enter to render decoded file.");
		reader.nextLine();
		image.draw();
		System.out.println("Save decoded image? y/n");
		if (reader.nextLine().equals("y")) image.saveAs();
	}//end of decode
	
	/**
	 * Converts an image to black and white
	 * Sets all pixels above a certain threshold to white, others to black
	 * 
	 * @author Kevin Higgs
	 * @param fileName name of file
	 */
	public static void generateBW(String fileName){
		// open image
		APImage image = new APImage(fileName);
		image.draw();
		System.out.println("Press enter to convert to black and white.");
		Scanner reader = new Scanner(System.in);
		reader.nextLine();
		// convert to b/w
		for (Pixel p : image) {
			if (p.getRed()+p.getGreen()+p.getBlue()/3 > 127) {
				p.setRed(255);
				p.setGreen(255);
				p.setBlue(255);
			} else {
				p.setRed(0);
				p.setGreen(0);
				p.setBlue(0);
			}
		}
		// display and save
		System.out.println("Press enter to view the black and white image.");
		reader.nextLine();
		image.draw();
		System.out.println("Save black and white image? y/n");
		String response = reader.nextLine();
		if (response.equals("y")) image.saveAs();
	}//end of generateBW
	/**
	 * Shave an image
	 * Remove the ones digit of the red pixels in an image
	 * 
	 * @author Kevin Higgs
	 * @param fileName name of file
	 */
	public static void shaveImage(String fileName){
		// open
		APImage image = new APImage(fileName);
		System.out.println("Press enter to shave the image.");
		Scanner reader = new Scanner(System.in);
		reader.nextLine();
		// shave
		for (Pixel p : image) p.setRed(p.getRed() - (p.getRed() % 10));
		image.draw();
		// save
		System.out.println("Save the shaven image? y/n");
		if (reader.nextLine().equals("y")) image.saveAs();
	}//end of shaveImage
	
	/**
	 * Encode message within destination
	 * Encodes a message image within a destination image.
	 * 
	 * @param messageFileName the file name of the image to be hidden
	 * @param destinationFileName the file name of the image that will have the message hidden in it
	 */
	public static void encode(String messageFileName, String destinationFileName){
		// open
		APImage message = new APImage(messageFileName);
		APImage destination = new APImage(destinationFileName);
		destination.draw();
		Scanner reader = new Scanner(System.in);
		System.out.println("Press enter to begin encoding.");
		reader.nextLine();
		// encode
		for (int x = 0; x < message.getWidth(); x++) {
			for (int y = 0; y < message.getHeight(); y++) {
				Pixel pixel = destination.getPixel(x, y);
				pixel.setRed(pixel.getRed() + (message.getPixel(x, y).getRed() == 0 ? 0 : 1));
			}
		}
		// save
		System.out.println("Save encoded image? y/n");
		if (reader.nextLine().equals("y")) destination.saveAs();
	}//end of encode

}//end of class Steganography
