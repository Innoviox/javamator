package net.mrpaul.ads.xc70.ps10;

import TurtleGraphics.Pen;
import TurtleGraphics.RainbowPen;

/**
 * Cool drawing
 * This class makes a cool turtle drawing.
 * <p>
 * ADS PS10: Inheritance
 * 6/15/18
 * 
 * @author Kevin Higgs
 */
public class TurtleDrawings {

	/**
	 * Main method
	 * <p>This method runs the main program.</p>
	 * 
	 * @author Kevin Higgs
	 * @param args a string[] used as the args
	 */
	public static void main(String[] args) {
		Pen p = new RainbowPen();
		
		for (int i = 0; i < 360; i++) {
			p.move(i);
			p.turn(i);
		}
	}
	
}
