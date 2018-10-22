package net.mrpaul.ads.xc70.ps10;

import net.mrpaul.ps10.distribution.Account;

/**
 * Account that filters 0 processing
 * This account will filter all transactions that are 0.
 * <p>
 * ADS PS10: Inheritance
 * 6/15/18
 * 
 * @author Kevin Higgs
 */
public class FilteredAccount extends Account {

	public int numTransactions;
	public int numFiltered;
	
	/**
	 * Instantiate a filtered account
	 * <p>The purpose of this method is to instantiate a filtered account with c.</p>
	 * 
	 * @author Kevin Higgs
	 * @param c a client used for instantiating a filtered account
	 */
	public FilteredAccount(Client c) {
		super(c);
	}
	
	/**
	 * Process method
	 * <p>The goal of this method is to process with t.</p>
	 * 
	 * @author Kevin Higgs
	 * @param t a transaction used for processing
	 * @return a boolean after processing
	 */
	public boolean process(Transaction t) {
		numTransactions += 1;
		if (t.value() != 0) super.process(t);
		else numFiltered += 1;
		return true;
	}

	/**
	 * Percent filtered
	 * <p>The goal of this method is to percent filtered.</p>
	 * 
	 * @author Kevin Higgs
	 * @return a double after percenting filtered
	 */
	public double percentFiltered() {
		return (numTransactions != 0 ? (double)numFiltered/numTransactions*100 : 0.0);
	}
	
}
