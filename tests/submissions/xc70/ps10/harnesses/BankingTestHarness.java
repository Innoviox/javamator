package net.mrpaul.ads.xc70.ps10.harnesses;

import net.mrpaul.ads.xc70.ps10.MinMaxAccount;
import net.mrpaul.ps10.distribution.BankingAccount.*;


//Notice the errors?  That's because you haven't yet written MinMaxAccount.
public class BankingTestHarness {
	public static void main(String[] args){
		
		/* Test MinMaxAccount(s) constructor */
		//give starting balances in cents
		MinMaxAccount a1 = new MinMaxAccount(new Startup(0));
		MinMaxAccount a2 = new MinMaxAccount(new Startup(150));
		MinMaxAccount a3 = new MinMaxAccount(new Startup(-300));
		System.out.println("new MinMaxAccount(0): " + a1);
		System.out.println("new MinMaxAccount(150): " + a2);
		System.out.println("new MinMaxAccount(-300): " + a3);
		String output = a1.toString() + a2.toString() + a3.toString();
		if(output.equals("$0.00$1.50-$3.00"))
			System.out.println("\nTest 1 passed:\t MinMaxAccount() works properly");
		else
			System.out.println("\nTest 1 failed:\t MinMaxAccount() does not work properly");
		System.out.println("------------------------------------------------------");
			
		
		
		/* Test debit() and credit() */
		String output2 = "";
		
		//make new accounts and run credits and debits
		MinMaxAccount b1 = new MinMaxAccount(new Startup(150));
		System.out.println(b1.historyTransactionToString() + " : " + b1);
		
		MinMaxAccount b2 = new MinMaxAccount(new Startup(300));
		b2.credit(new Credit(150));
		System.out.println(b2.historyTransactionToString() + " : " + b2);

		MinMaxAccount b3 = new MinMaxAccount(new Startup(450));
		b3.debit(new Debit(-225));
		System.out.println(b3.historyTransactionToString() + " : " + b3);

		MinMaxAccount b4 = new MinMaxAccount(new Startup(150));
		b4.debit(new Debit(-25));
		b4.credit(new Credit(75));
		System.out.println(b4.historyTransactionToString() + " : " + b4);


		MinMaxAccount b5 = new MinMaxAccount(new Startup(75));
		b5.credit(new Credit(100));
		b5.debit(new Debit(-25));
		System.out.println(b5.historyTransactionToString() + " : " + b5);


		MinMaxAccount b6 = new MinMaxAccount(new Startup(0));
		b6.credit(new Credit(150));
		b6.debit(new Debit(-75));
		b6.credit(new Credit(450));
		b6.debit(new Debit(-175));
		System.out.println(b6.historyTransactionToString() + " : " + b6);


		MinMaxAccount b7 = new MinMaxAccount(new Startup(0));
		b7.debit(new Debit(-150));
		b7.credit(new Credit(25));
		b7.credit(new Credit(75));
		b7.debit(new Debit(-300));

		//check if account objects ended with correct balances
		if(("" + b1+b2+b3+b4+b5+b6+b7).equals("$1.50$4.50$2.25$2.00$1.50$3.50-$3.50"))
			System.out.println("\nTest 2 passed:\tdebit() and credit() updated successfully");
		else
			System.out.println("\nTest 2 failed:\tdebit() and credit() do not work");

		System.out.println("------------------------------------------------------");

		
		
		/* Test getMin and getMax() */
		String output3 = "";
		String output4 = "";
		
		//build strings of all mins and all maxes for comparison
		output3 = "" + b1.getMin() + b2.getMin() + b3.getMin() + b4.getMin() + b5.getMin() + b6.getMin() + b7.getMin();
		output4 = "" + b1.getMax() + b2.getMax() + b3.getMax() + b4.getMax() + b5.getMax() + b6.getMax() + b7.getMax();
		
		//print balance histories and mins/maxes
		System.out.println(b1.historyBalanceToString() + " : min: " + b1.getMin() + ",\tmax:" + b1.getMax() + "\n");
		System.out.println(b2.historyBalanceToString() + " : min: " + b2.getMin() + ",\tmax:" + b2.getMax() + "\n");
		System.out.println(b3.historyBalanceToString() + " : min: " + b3.getMin() + ",\tmax:" + b3.getMax() + "\n");
		System.out.println(b4.historyBalanceToString() + " : min: " + b4.getMin() + ",\tmax:" + b4.getMax() + "\n");
		System.out.println(b5.historyBalanceToString() + " : min: " + b5.getMin() + ",\tmax:" + b5.getMax() + "\n");
		System.out.println(b6.historyBalanceToString() + " : min: " + b6.getMin() + ",\tmax:" + b6.getMax() + "\n");
		System.out.println(b7.historyBalanceToString() + " : min: " + b7.getMin() + ",\tmax:" + b7.getMax() + "\n");

		
		//check if getMin worked
		if(output3.equals("150300225125750-350"))
			System.out.println("Test 3 passed:\tgetMin() working");
		else
			System.out.println("Test 3 failed:\tgetMin() not working");
		
		//check if getMax worked
		if(output4.equals("1504504502001755250"))
			System.out.println("Test 4 passed:\tgetMax() working");
		else
			System.out.println("Test 4 failed:\tgetMax() not working");

		
		
		//System.out.println(m2.historyTransactionToString());
		
		
	}
}
