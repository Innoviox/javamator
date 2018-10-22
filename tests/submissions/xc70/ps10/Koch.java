package net.mrpaul.ads.xc70.ps10;

import TurtleGraphics.*;

/*
 * Defines a static recursive method which draws a Koch curve
 */
public class Koch {
	
	//This actually draws the Koch curve.  It's recursive.  
	//n is the order other curve we want to draw; step is the step size.
	public static void koch(int n, double step, Pen p){
		if (n == 0){
			p.move(step);
			return;
		}
		koch(n-1, step, p);
		p.turn(60.0);
		koch(n-1, step, p);
		p.turn(-120.0);
		koch(n-1, step, p);
		p.turn(60.0);
		koch(n-1, step, p);
	}
	
	//main sets the important dimensions and the properties of the Koch curve.
	//It then calls the recursive koch method.
	public static void main(String[] args){
		
		//window dimensions
		int width = 500;
		int height = 500;
		
		int n = 3;			//play around with this value
		double step = 3;	//and play around with this value
		
		//make the window and the pen
        SketchPadWindow win = new SketchPadWindow(width, height);
        Pen p = new StandardPen(win);
        
        //put the pen where we want it to prepare to draw
        p.up();
        p.setDirection(0);
        p.move(0, 0);
        //p.move(-1*width/2,-1*height/2);
        p.down();
        
        //call our recursive drawing method
        koch(n, step, p);

	}

}
