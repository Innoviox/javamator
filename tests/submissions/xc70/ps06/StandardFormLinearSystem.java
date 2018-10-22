package net.mrpaul.ads.xc70.ps06;

/**
 * A system of linear equations
 * This class is a system of linear equations that can be used to solve and compare two lines.
 * <p>
 * ADS PS06: Cartesian
 * 4/22/18
 * 
 * @author Kevin Higgs
 */
public class StandardFormLinearSystem {
	
	private StandardFormLine l1;
	private StandardFormLine l2;
	
	/**
	 * Instantiate a standard form linear system
	 * <p>The purpose of this method is to instantiate a standard form linear system with line1 and line2.</p>
	 * 
	 * @author Kevin Higgs
	 * @param line1 a standardformline used as the line1
	 * @param line2 a standardformline used as the line2
	 */
	public StandardFormLinearSystem(StandardFormLine line1, StandardFormLine line2) {
		this.l1 = line1;
		this.l2 = line2;
	}
	
	/**
	 * Instantiate a standard form linear system
	 * <p>The goal of this method is to instantiate a standard form linear system.</p>
	 * 
	 * @author Kevin Higgs
	 */
	public StandardFormLinearSystem() {
		this.l1 = new StandardFormLine();
		this.l2 = new StandardFormLine();
	}
	
	/**
	 * Set the line
	 * <p>The use of this method is to set the line with lineNumber and line.</p>
	 * 
	 * @author Kevin Higgs
	 * @param lineNumber an int used as the line number
	 * @param line a standardformline used as the line
	 */
	public void setLine(int lineNumber, StandardFormLine line) {
		if (lineNumber == 1) this.l1 = line;
		else if (lineNumber == 2) this.l2 = line;
	}
	
	/**
	 * Get the line
	 * <p>The goal of this method is to get the line with lineNumber.</p>
	 * 
	 * @author Kevin Higgs
	 * @param lineNumber an int used as the line number
	 * @return a standardformline after getting the line
	 */
	public StandardFormLine getLine(int lineNumber) {
		if (lineNumber == 1) return this.l1;
		if (lineNumber == 2) return this.l2;
		return null;
	}
	
	/**
	 * Convert to a string
	 * <p>The use of this method is to convert to a string.</p>
	 * 
	 * @author Kevin Higgs
	 * @return a string after converting to a string
	 */
	public String toString() {
		return this.l1 + "\n" + this.l2;
	}
	
	/**
	 * Check if they have same slope
	 * <p>The purpose of this method is to check if they have same slope.</p>
	 * 
	 * @author Kevin Higgs
	 * @return a boolean after checking if they have same slope
	 */
	public boolean haveSameSlope() {
		return this.l1.getSlope() == this.l2.getSlope();
	}
	
	/**
	 * Check if it has infinite solutions
	 * <p>The use of this method is to check if it has infinite solutions.</p>
	 * 
	 * @author Kevin Higgs
	 * @return a boolean after checking if it has infinite solutions
	 */
	public boolean hasInfiniteSolutions() {
		// check if slope is the same and y intercept is the same
		return this.l1.getSlope() == this.l2.getSlope() && this.l1.getC()/this.l1.getB() == this.l2.getC()/this.l2.getB();
	}
	
	/**
	 * Check if they are parallel
	 * <p>The purpose of this method is to check if they are parallel.</p>
	 * 
	 * @author Kevin Higgs
	 * @return a boolean after checking if they are parallel
	 */
	public boolean areParallel() {
		// check if slope is the same, but y intercept is not
		return this.l1.getSlope() == this.l2.getSlope() && this.l1.getC()/this.l1.getB() != this.l2.getC()/this.l2.getB();
	}
	
	/**
	 * Solve method
	 * <p>The purpose of this method is to solve.</p>
	 * 
	 * @author Kevin Higgs
	 * @return a point after solving
	 */
	public Point solve() {
		// null if the same line or parallel
		if (this.areParallel() || this.hasInfiniteSolutions()) return null;
		// use Cramer's principle to calculate solution
		return new Point((int)((l1.getC() * l2.getB() - l2.getC() * l1.getB()) / (l1.getA() * l2.getB() - l2.getA() * l1.getB())), (int)((l1.getA()*l2.getC() - l2.getA()*l1.getC())/(l1.getA()*l2.getB()-l2.getA()*l1.getB())));
	}
	
}
