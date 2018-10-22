package net.mrpaul.ads.xc70.ps06;

//A Point object represents a pair of (x, y) coordinates.
/**
 * A point on a cartesian grid
 * This class is a point on a cartesian grid that can give properties compared to other points.
 * <p>
 * ADS PS06: Cartesian
 * 4/22/18
 * 
 * @author Kevin Higgs
 */
public class Point {
	private int x;
	private int y;

	// Constructs a new point at the origin, (0, 0).
	public Point() {
		this(0, 0);  // calls Point(int, int) constructor
	}

	// Constructs a new point with the given (x, y) location.
	public Point(Point p) {
		setLocation(p.x, p.y);
	}

	// Constructs a new point with the given (x, y) location.
	// pre: x >= 0 && y >= 0
	public Point(int x, int y) {
		setLocation(x, y);
	}

	// Returns the distance between this Point and (0, 0).
	public double distanceFromOrigin() {
		return distance(new Point());
	}

	// Returns the distance between this Point and the given other Point.
	public double distance(Point p) {
		int dx = x - p.getX();
		int dy = y - p.getY();
		return Math.sqrt(dx * dx + dy * dy);
	}

	/*  Interesting aside: The following implementation of distance(p) is also legal.
 	It seems like it shouldn't be, since we are accessing p's private instance variables without using getters.
 	It is, however, legal.  One object may access another object's private instance variables directly (without 
 	getters and setters) IF they are of the same type.  So because "this" is a point, it can access p's private
 	instance variables directly because p is also a point.  In contrast, though, a Student object would NOT be able
 	to access p.x and p.y without getters and setters because it is not a Point object.
	public double distance(Point p) {
		int dx = x - p.x;
		int dy = y - p.y;
		return Math.sqrt(dx * dx + dy * dy);
	}
	*/


	// Returns whether o refers to a point with the same (x, y)
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 * @author Kevin Higgs
	 */
	// coordinates as this point.
	public final boolean equals(Object o) {
		if (o instanceof Point) {
			Point other = (Point) o;
			return x == other.getX() && y == other.getY();
		} else { // not a Point object
			return false;
		}
	}

	// Returns the x-coordinate of this point.
	public final int getX() {
		return x;
	}

	// Returns the y-coordinate of this point.
	public final int getY() {
		return y;
	}

	// Sets this point's (x, y) location to the given values.
	// pre: x >= 0 && y >= 0
	public void setLocation(int x, int y) {
		// if (x < 0 || y < 0) {
		//     throw new IllegalArgumentException();
		// }

		this.x = x;
		this.y = y;
	}

	// Sets the x-coordinate of this point to the given value.
	public void setX(int x) {
		this.x = x;
	}

	// Sets the y-coordinate of this point to the given value.
	public void setY(int y) {
		this.y = y;
	}

	// Returns a String representation of this point.
	public String toString() {
		return "(" + x + ", " + y + ")";
	}

	// Shifts this point's location by the given amount.
	// pre: x + dx >= 0 && y + dy >= 0
	public void translate(int dx, int dy) {
		setLocation(x + dx, y + dy);
	}

	//YOUR CODE GOES HERE: manhattanDistance, isVertical, slope, and isCollinear
	
	/**
	 * Manhattan distance
	 * <p>The goal of this method is to manhattan distance with other.</p>
	 * 
	 * @author Kevin Higgs
	 * @param other a point used as the other
	 * @return an int after manhattaning distance
	 */
	public int manhattanDistance(Point other) {
		// use formula
		return Math.abs(other.getX() - this.getX()) + Math.abs(other.getY() - this.getY());
	}
	
	/**
	 * Check if it is vertical
	 * <p>The goal of this method is to check if it is vertical with other.</p>
	 * 
	 * @author Kevin Higgs
	 * @param other a point used as the other
	 * @return a boolean after checking if it is vertical
	 */
	public boolean isVertical(Point other) {
		// vertical if x values are the same
		return this.x == other.getX();
	}
	
	/**
	 * Slope method
	 * <p>The purpose of this method is to slope with other.</p>
	 * 
	 * @author Kevin Higgs
	 * @param other a point used as the other
	 * @return a double after sloping
	 */
	public double slope(Point other) {
		// slope is undefined
		if (this.isVertical(other) || (this.getX() == other.getX() && this.getY() == other.getY())) {
			throw new IllegalArgumentException("Invalid: Slope is undefined between points (" + this.x + ", " + this.y + ") and (" + other.getX() + ", " + other.getY() + ")." );
		} else {
			// return slope
			return ((double)(this.getY() - other.getY()))/((double)(this.getX() - other.getX()));
		}
	}

	/**
	 * Check if it is collinear
	 * <p>The goal of this method is to check if it is collinear with p2 and p3.</p>
	 * 
	 * @author Kevin Higgs
	 * @param p2 a point used for checking if it is collinear
	 * @param p3 a point used for checking if it is collinear
	 * @return a boolean after checking if it is collinear
	 */
	public boolean isCollinear(Point p2, Point p3) {
		// check if slopes are the same to 4 decimals
		return this.getX() == p2.getX() && p2.getX() == p3.getX() || ((double)Math.round(this.slope(p2)*10000)/10000 == (double)Math.round(this.slope(p3)*10000)/10000);
	}
	
}