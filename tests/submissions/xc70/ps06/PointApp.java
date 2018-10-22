package net.mrpaul.ads.xc70.ps06;

import java.util.Scanner;

/*
 * This class is an example of one way to use Point objects.  You'll write your own code to test 
 * manhattanDistance, isVertical, slope, and isCollinear.  
 */
public class PointApp{

	public static void main(String[] args){
		Scanner reader = new Scanner(System.in);
		Point p1, p2;
		int givenX, givenY;
		double dist;

		//Get user-generated point.
		System.out.println("Imagine a coordinate plane, like in math class.");
		System.out.println("This program will calculate the distance between a point you enter and (3, 14).");

		System.out.println("Enter the x coordinate of a point.");
		givenX = reader.nextInt();
		System.out.println("Enter the y coordinate of a point.");
		givenY = reader.nextInt();

		//create Point objects
		p1 = new Point(3, 14);
		p2 = new Point(givenX, givenY);

		//calculate distance
		dist = p1.distance(p2); //YOU COULD ALSO DO p2.distance(p1);

		System.out.println("The distance between " + p1.toString() + " and " + p2.toString() + " is " + dist + " units.");
		System.out.println("\n\tBut that number might be ugly.  So let's round it to about " + Math.round(dist) + " units.");
	}

}//end of PointApp class