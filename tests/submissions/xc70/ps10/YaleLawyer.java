package net.mrpaul.ads.xc70.ps10;

import net.mrpaul.ps10.distribution.Lawyer;

/**
 * Lawyer from yale
 * This class is a lawyer, but from Yale.
 * <p>
 * ADS PS10: Inheritance
 * 6/15/18
 * 
 * @author Kevin Higgs
 */
public class YaleLawyer extends Lawyer {
	
	/**
	 * Get the salary
	 * <p>The purpose of this method is to get the salary.</p>
	 * 
	 * @author Kevin Higgs
	 * @return a double after getting the salary
	 */
	public double getSalary() {
		return super.getSalary() * 1.2;
	}
	
	/**
	 * Get the vacation days
	 * <p>The goal of this method is to get the vacation days.</p>
	 * 
	 * @author Kevin Higgs
	 * @return an int after getting the vacation days
	 */
	public int getVacationDays() {
		return super.getVacationDays() + 3;
	}
	
	/**
	 * Get the vacation form
	 * <p>The goal of this method is to get the vacation form.</p>
	 * 
	 * @author Kevin Higgs
	 * @return a string after getting the vacation form
	 */
	public String getVacationForm() {
		return "pinkpinkpinkpink";
	}
	
	
	
}
