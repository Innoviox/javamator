package net.mrpaul.ads.xc70.ps06;

/**
 * A fraction with a numerator and a denominator
 * This class is a fraction with a numerator and a denominator that can be used to do arithmetic.
 * <p>
 * ADS PS06: Cartesian
 * 4/22/18
 * 
 * @author Kevin Higgs
 */
public class Fraction {
	
	private int numerator;
	private int denominator;
	
	/**
	 * Instantiate a fraction
	 * <p>The purpose of this method is to instantiate a fraction with n and d.</p>
	 * 
	 * @author Kevin Higgs
	 * @param n an int used for instantiating a fraction
	 * @param d an int used for instantiating a fraction
	 */
	public Fraction(int n, int d) {
		this.setNumerator(n);
		this.setDenominator(d);
	}
	
	/**
	 * Instantiate a fraction
	 * <p>The goal of this method is to instantiate a fraction with f2.</p>
	 * 
	 * @author Kevin Higgs
	 * @param f2 a fraction used for instantiating a fraction
	 */
	public Fraction(Fraction f2) {
		this.setNumerator(f2.getNumerator());
		this.setDenominator(f2.getDenominator());
	}
	
	/**
	 * Get the numerator
	 * <p>The purpose of this method is to get the numerator.</p>
	 * 
	 * @author Kevin Higgs
	 * @return an int after getting the numerator
	 */
	public int getNumerator() {
		return this.numerator;
	}
	
	/**
	 * Get the denominator
	 * <p>The use of this method is to get the denominator.</p>
	 * 
	 * @author Kevin Higgs
	 * @return an int after getting the denominator
	 */
	public int getDenominator() {
		return this.denominator;
	}
	
	/**
	 * Set the numerator
	 * <p>The goal of this method is to set the numerator with n.</p>
	 * 
	 * @author Kevin Higgs
	 * @param n an int used for setting the numerator
	 */
	public void setNumerator(int n) {
		this.numerator = n;
	}
	
	/**
	 * Set the denominator
	 * <p>The use of this method is to set the denominator with d.</p>
	 * 
	 * @author Kevin Higgs
	 * @param d an int used for setting the denominator
	 */
	public void setDenominator(int d) {
		if (d == 0) {
			throw new IllegalArgumentException("Invalid: Denominator cannot be 0.");
		}
		this.denominator = d;
	}
	
	/**
	 * Add method
	 * <p>The goal of this method is to add with f2.</p>
	 * 
	 * @author Kevin Higgs
	 * @param f2 a fraction used for adding
	 * @return a fraction after adding
	 */
	public Fraction add(Fraction f2) {
		// multiply fractions by other's denominator to get common denominator and add numerators
		return new Fraction(this.getNumerator()*f2.getDenominator() + f2.getNumerator()*this.getDenominator(), this.getDenominator()*f2.getDenominator());
	}
	
	/**
	 * Subtract method
	 * <p>The purpose of this method is to subtract with f2.</p>
	 * 
	 * @author Kevin Higgs
	 * @param f2 a fraction used for subtracting
	 * @return a fraction after subtracting
	 */
	public Fraction subtract(Fraction f2) {
		// add negative
		return this.add(new Fraction(-f2.getNumerator(), f2.getDenominator()));
	}
	
	/**
	 * Multiply method
	 * <p>The purpose of this method is to multiply with f2.</p>
	 * 
	 * @author Kevin Higgs
	 * @param f2 a fraction used for multiplying
	 * @return a fraction after multiplying
	 */
	public Fraction multiply(Fraction f2) {
		// multiply numerators, multiply denominators
		return new Fraction(this.getNumerator()*f2.getNumerator(), this.getDenominator()*f2.getDenominator());
	}
	
	/**
	 * Divide method
	 * <p>The goal of this method is to divide with f2.</p>
	 * 
	 * @author Kevin Higgs
	 * @param f2 a fraction used for dividing
	 * @return a fraction after dividing
	 */
	public Fraction divide(Fraction f2) {
		// multiply by reciprocal
		return this.multiply(f2.getReciprocal());
	}
	
	/**
	 * Get the reciprocal
	 * <p>The purpose of this method is to get the reciprocal.</p>
	 * 
	 * @author Kevin Higgs
	 * @return a fraction after getting the reciprocal
	 */
	public Fraction getReciprocal() {
		// flip numerator and denominator
		return new Fraction(this.getDenominator(), this.getNumerator());
	}
	
	/**
	 * Get the double equivalent
	 * <p>The goal of this method is to get the double equivalent.</p>
	 * 
	 * @author Kevin Higgs
	 * @return a double after getting the double equivalent
	 */
	public double getDoubleEquivalent() {
		// divide
		return (double)this.getNumerator() / (double)this.getDenominator();
	}
	
	/**
	 * Reduce method
	 * <p>The purpose of this method is to reduce.</p>
	 * 
	 * @author Kevin Higgs
	 * @return a fraction after reducing
	 */
	public Fraction reduce() {
		int n = this.getNumerator();
		int d = this.getDenominator();
		int t;
		// euclidean gcd algorithm
		while (n != 0 && d != 0) {
			t = n % d;
			n = d;
			d = t;
		}
		// divide by gcd
		return new Fraction(this.getNumerator()/n, this.getDenominator()/n);
	}
	
	/**
	 * Convert to a string
	 * <p>The use of this method is to convert to a string.</p>
	 * 
	 * @author Kevin Higgs
	 * @return a string after converting to a string
	 */
	public String toString() {
		return this.getNumerator() + "/" + this.getDenominator();
	}
}
