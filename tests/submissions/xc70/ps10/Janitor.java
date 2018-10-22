package net.mrpaul.ads.xc70.ps10;

import net.mrpaul.ps10.distribution.Employee;

/**
 * Janitor employee
 * This class is a janitor employee.
 * <p>
 * ADS PS10: Inheritance
 * 6/15/18
 * 
 * @author Kevin Higgs
 */
public class Janitor extends Employee {

	/**
	 * Get the salary
	 * <p>The goal of this method is to get the salary.</p>
	 * 
	 * @author Kevin Higgs
	 * @return a double after getting the salary
	 */
	public double getSalary() {
		return super.getSalary() - 10000.0;
	}
	
	/**
	 * Get the vacation days
	 * <p>The goal of this method is to get the vacation days.</p>
	 * 
	 * @author Kevin Higgs
	 * @return an int after getting the vacation days
	 */
	public int getVacationDays() {
		return super.getVacationDays()/2;
	}
	
	/**
	 * Clean method
	 * <p>The use of this method is to clean.</p>
	 * 
	 * @author Kevin Higgs
	 */
	public void clean() {
		System.out.println("Workin' for the man");
	}
	
	/**
	 * Get the hours
	 * <p>The purpose of this method is to get the hours.</p>
	 * 
	 * @author Kevin Higgs
	 * @return an int after getting the hours
	 */
	public int getHours() {
		return super.getHours() * 2;
	}
	
}
