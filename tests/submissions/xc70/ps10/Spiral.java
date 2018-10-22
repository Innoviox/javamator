package net.mrpaul.ads.xc70.ps10;

import TurtleGraphics.*;

public class Spiral {

    public static void main(String[] args) { 
        int N         = 1440;//Integer.parseInt(args[0]);     // # sides if decay = 1.0
        double decay  = 1.0004;//Double.parseDouble(args[1]);   // decay factor

        double angle  = 360.0 / N;
        double step   = .5;//Math.sin(Math.toRadians(angle/2.0));
        
        SketchPadWindow win = new SketchPadWindow(600, 600);
        Pen turtle = new StandardPen(win);
        //Pen turtle = new StandardPen(0.5, 0.0, angle/2.0);
        for (int i = 0; i < 10*N; i++) {
            step /= decay; 
            turtle.move(step);
            turtle.turn(angle);
        }

    }
} 


