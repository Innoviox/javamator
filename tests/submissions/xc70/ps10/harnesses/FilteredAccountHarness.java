package net.mrpaul.ads.xc70.ps10.harnesses;

import net.mrpaul.ads.xc70.ps10.FilteredAccount;
import net.mrpaul.ps10.distribution.Account;
import net.mrpaul.ps10.distribution.Account.Client;
import net.mrpaul.ps10.distribution.Account.Transaction;

//Notice the errors?  That's because you haven't yet written FilteredAccount.
public class FilteredAccountHarness {
	public static void main(String[] args){
		
		FilteredAccount f = new FilteredAccount(new Client());
		int[] transactionList = {0,0,0,10,30,2000,-50,0,-200,3000000};
		
		System.out.println("percentFiltered (initial): " + f.percentFiltered() + "\n");
		
		for(int i = 0; i < transactionList.length; i++){
			boolean processReturn = f.process(new Transaction(transactionList[i]));
			System.out.println("process(" + transactionList[i] + ")");
			System.out.println("\tprocess return value: " + processReturn);
			System.out.println("\tpercentFiltered: " + f.percentFiltered());
			System.out.println("\tsuper.process called: " + f.__processCalled + "\n");
		}
		
	}
}
