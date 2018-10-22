package net.mrpaul.ads.xc70.ps05;

import java.util.Scanner;

import images.APImage;			//Note: We need to import from the images package!
import images.Pixel;

/**
 * Topic exercises for APImage class
 * 
 * This class runs topic exercises on doge.png
 * <p>
 * Accel PS05: Foul Play
 * 4/3/18
 * 
 * @author Kevin Higgs
 */

public class FoulPlay {

	/**
	 * Runs topic exercises to learn to use APImage
	 * The main method runs topic exercises to learn to use APImage
	 * @author Kevin Higgs
	 * @param args not used
	 */
	public static void main(String[] args) {
		/* 
		 * The reason we can call topicExercses() like this without an object
		 * or a class name is that it is a static method in the same class as the method call.
		 * If we wanted to call topicExercises() from a different class, we'd have to write
		 * FoulPlay.topicExercises();
		 */
		topicExercises();			


	}//end of main
	
	
	/**
	 * Topic exercises to learn to use APImage
	 * Contains some topic exercises to learn to use APImage
	 * 
	 * @author Kevin Higgs
	 */
	public static void topicExercises(){
		//instantiate a new APImage object
		APImage image = new APImage("doge.png");
		
		//Use a Scanner object (and its nextLine() method) to trigger your APImage's draw() method
		System.out.println("Press enter to draw the image.");
		Scanner reader = new Scanner(System.in);
		reader.nextLine();
		image.draw();
		
		//Print the width and the height of your APImage object in pixels in the form, "W: # px\tH: # px"
		System.out.println("W: "+image.getWidth()+" px\tH: "+image.getHeight()+" px");
		
		//Print the R, G, and B values of the Pixel object at (10, 17)
		Pixel p = image.getPixel(10,  17);
		System.out.println("Pixel at (10, 17):\tR: "+p.getRed()+"\tG: "+p.getGreen()+"\tB: "+p.getBlue());
		
		//Iterate through each pixel in the image using a regular for loop; print R, G, and B in
		//the form: "Pixel at (<x>, <y>):\tR: #\tG: #\tB: #"
		//example: Pixel at (42, 53):	R: 10	G: 65	B: 157
		//Note that the console output is limited, so if you print enough stuff, the earlier stuff you printed disappears.
		for (int x = 0; x < image.getWidth(); x++) {
			for (int y = 0; y < image.getHeight(); y++) {
				p = image.getPixel(x,  y);
				System.out.println("Pixel at ("+x+", "+y+"):\tR: "+p.getRed()+"\tG: "+p.getRed()+"\tB: "+p.getBlue());
			}
		}
		
		//Rewrite your code from the last exercise so it uses an enhanced for loop.  You may omit the indices.
		for (Pixel p2 : image) {
			System.out.println("Pixel:\tR: "+p2.getRed()+"\tG: "+p2.getRed()+"\tB: "+p2.getBlue());
		}
		
		//Set every Pixel in each even column to white and every odd column to black.
		APImage image2 = image.clone();
		for (int x = 0; x < image2.getWidth(); x++) {
			for (int y = 0; y < image2.getHeight(); y++) {
				p = image2.getPixel(x, y);
				p.setRed(x % 2 * 255);
				p.setGreen(x % 2 * 255);
				p.setBlue(x % 2 * 255);
			}
		}
		System.out.println("Save modified image? y/n");
		if (reader.nextLine().equals("y")) image2.saveAs();
		
		//Adjust the brightness: multiply each Pixel's values by a constant and constrain values to 255
		APImage image3 = image.clone();
		final int CONSTANT = 2;
		for (Pixel p3 : image3) {
			p3.setRed(p3.getRed() * CONSTANT > 255 ? 255 : p3.getRed() * CONSTANT);
			p3.setGreen(p3.getGreen() * CONSTANT > 255 ? 255 : p3.getGreen() * CONSTANT);
			p3.setBlue(p3.getBlue() * CONSTANT > 255 ? 255 : p3.getBlue() * CONSTANT);
		}
		System.out.println("Save image with adjusted brightness? y/n");
		if (reader.nextLine().equals("y")) image3.saveAs();
		
	}//end of topicExercises
	

}//end of class FoulPlay
