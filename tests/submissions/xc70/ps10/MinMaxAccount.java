package net.mrpaul.ads.xc70.ps10;

import net.mrpaul.ps10.distribution.BankingAccount;

/**
 * Bank account that stores min and max balance
 * This class is a bank account that stores minimum and maximum balances.
 * <p>
 * ADS PS10: Inheritance
 * 6/15/18
 * 
 * @author Kevin Higgs
 */
public class MinMaxAccount extends BankingAccount {

	public int min;
	
	public int max;
	
	/**
	 * Instantiate a min max account
	 * <p>The use of this method is to instantiate a min max account with s.</p>
	 * 
	 * @author Kevin Higgs
	 * @param s a startup used for instantiating a min max account
	 */
	public MinMaxAccount(Startup s) {
		super(s);
		max = min = s.startup_getBalance();
	}
	
	/**
	 * Get the min
	 * <p>The use of this method is to get the min.</p>
	 * 
	 * @author Kevin Higgs
	 * @return an int after getting the min
	 */
	public int getMin() {
		return min;
	}
	
	/**
	 * Debit method
	 * <p>The goal of this method is to debit with d.</p>
	 * 
	 * @author Kevin Higgs
	 * @param d a debit used for debiting
	 */
	public void debit(Debit d) {
		super.debit(d);
		min = Math.min(min, super.getBalance());
		max = Math.max(max, super.getBalance());
	}
	
	/**
	 * Credit method
	 * <p>The purpose of this method is to credit with c.</p>
	 * 
	 * @author Kevin Higgs
	 * @param c a credit used for crediting
	 */
	public void credit(Credit c) {
		super.credit(c);
		min = Math.min(min, super.getBalance());
		max = Math.max(max, super.getBalance());
	}
	
	/**
	 * Get the max
	 * <p>The purpose of this method is to get the max.</p>
	 * 
	 * @author Kevin Higgs
	 * @return an int after getting the max
	 */
	public int getMax() {
		return max;
	}
	
}
