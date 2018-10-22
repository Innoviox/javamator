package net.mrpaul.ads.xc70.ps10;

import net.mrpaul.ps10.distribution.Employee;

/**
 * This is a marketer
 * This is a marketer that is an employee.
 * <p>
 * ADS PS10: Inheritance
 * 6/15/18
 * 
 * @author Kevin Higgs
 */
public class Marketer extends Employee {
	
	/**
	 * Get the salary
	 * <p>The goal of this method is to get the salary.</p>
	 * 
	 * @author Kevin Higgs
	 * @return a double after getting the salary
	 */
	public double getSalary() {
		return super.getSalary() + 10000.0;
	}
	
	/**
	 * Advertise method
	 * <p>The use of this method is to advertise.</p>
	 * 
	 * @author Kevin Higgs
	 */
	public void advertise() {
		System.out.println("Act now, while supplies last!");
	}
	
}
