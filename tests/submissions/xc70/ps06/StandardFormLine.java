package net.mrpaul.ads.xc70.ps06;

/**
 * Creates a line with standard form
 * This class allows a line to be created in standard form, ax + by = c.
 * <p>
 * ADS PS06: Cartesian
 * 4/22/18
 * 
 * @author Kevin Higgs
 */
public class StandardFormLine {
	
	private double a;
	private double b;
	private double c;
	
	/**
	 * Instantiate a standard form line
	 * <p>The goal of this method is to instantiate a standard form line with a and b and c.</p>
	 * 
	 * @author Kevin Higgs
	 * @param a a double used for instantiating a standard form line
	 * @param b a double used for instantiating a standard form line
	 * @param c a double used for instantiating a standard form line
	 */
	public StandardFormLine(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	/**
	 * Instantiate a standard form line
	 * <p>The purpose of this method is to instantiate a standard form line with p1 and p2.</p>
	 * 
	 * @author Kevin Higgs
	 * @param p1 a point used for instantiating a standard form line
	 * @param p2 a point used for instantiating a standard form line
	 */
	public StandardFormLine(Point p1, Point p2) {
		this.a = -p1.slope(p2);
		this.b = 1;
		this.c = p2.getY() - p1.slope(p2) * p2.getX();
	}
	
	/**
	 * Instantiate a standard form line
	 * <p>The goal of this method is to instantiate a standard form line.</p>
	 * 
	 * @author Kevin Higgs
	 */
	public StandardFormLine() {
		// default coefficient values
		this.a = -1;
		this.b = 1;
		this.c = 1;
	}
	
	/**
	 * Get the slope
	 * <p>The goal of this method is to get the slope.</p>
	 * 
	 * @author Kevin Higgs
	 * @return a double after getting the slope
	 */
	public double getSlope() {
		// the formula for slope in standard form is -A/B
		return -this.getA()/this.getB();
	}
	
	/**
	 * Convert to a string
	 * <p>The use of this method is to convert to a string.</p>
	 * 
	 * @author Kevin Higgs
	 * @return a string after converting to a string
	 */
	public String toString() {
		// convert to a human-readable string
		return this.getA() + "x + " + this.getB() + "y = " + this.getC();
	}
	
	/**
	 * Get the a
	 * <p>The use of this method is to get the a.</p>
	 * 
	 * @author Kevin Higgs
	 * @return a double after getting the a
	 */
	public double getA() {
		return this.a;
	}
	
	/**
	 * Get the b
	 * <p>The use of this method is to get the b.</p>
	 * 
	 * @author Kevin Higgs
	 * @return a double after getting the b
	 */
	public double getB() {
		return this.b;
	}
	
	/**
	 * Get the c
	 * <p>The use of this method is to get the c.</p>
	 * 
	 * @author Kevin Higgs
	 * @return a double after getting the c
	 */
	public double getC() {
		return this.c;
	}
	
	/**
	 * Set the a
	 * <p>The use of this method is to set the a with a.</p>
	 * 
	 * @author Kevin Higgs
	 * @param a a double used for setting the a
	 */
	public void setA(double a) {
		this.a = a;
	}
	
	/**
	 * Set the b
	 * <p>The purpose of this method is to set the b with b.</p>
	 * 
	 * @author Kevin Higgs
	 * @param b a double used for setting the b
	 */
	public void setB(double b) {
		this.b = b;
	}
	
	/**
	 * Set the c
	 * <p>The purpose of this method is to set the c with c.</p>
	 * 
	 * @author Kevin Higgs
	 * @param c a double used for setting the c
	 */
	public void setC(double c) {
		this.c = c;
	}
	
}
