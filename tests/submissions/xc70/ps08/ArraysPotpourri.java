package net.mrpaul.ads.xc70.ps08;

import java.util.Arrays;
import java.util.Random;

/**
 * Methods to manipulate arrays
 * This class contains a variety of methods to manipulate arrays and calculate values.
 * <p>
 * ADS PS08: Arrays Potpourri
 * 5/16/18
 * 
 * @author Kevin Higgs
 */
public class ArraysPotpourri {
	
	/**
	 * Bogosort method
	 * <p>The goal of this method is to bogosort with arrayToProcess.</p>
	 * 
	 * @author Kevin Higgs
	 * @param arrayToProcess an int[] used as the array to process
	 * @return an int[] after bogosorting
	 */
	public static int[] bogosort(int[] arrayToProcess) {
		// cast to double so I can use isSorted
		double[] a = new double[arrayToProcess.length];
		for (int i = 0; i < arrayToProcess.length; i++) {
			a[i] = arrayToProcess[i];
		}
		// perform bogosort
		Random gen = new Random();
		while (!isSorted(a)) {
			// shuffle array
			double[] shuffled = new double[a.length];
			int[] used = new int[a.length];
			for (int i = 0; i < used.length; i++) used[i] = -1;
			// move each index to another index
			for (int index = 0; index < a.length; index++) {
				while (true) {
					// generate random destination index
					int dest = gen.nextInt(a.length);
					// check if destination has been used before in this shuffle, if so generate a new one
					boolean continueFlag = false;
					for (int i = 0; i < used.length; i++) {
						if (used[i] == dest) continueFlag = true;
					}
					if (continueFlag) continue;
					// if it has not been used, set it as used and place it in the shuffled array
					for (int i = 0; i < used.length; i++) {
						if (used[i] == -1) { used[i] = dest; break; }
					}
					shuffled[dest] = a[index];
					break;
				}
			}
			a = shuffled.clone();
		}
		// back to ints
		int[] ints = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			ints[i] = (int) a[i];
		}
		return ints;
	}
	
	/**
	 * Last index of
	 * <p>The purpose of this method is to last index of with arrayToSearch and valueToSearchFor.</p>
	 * 
	 * @author Kevin Higgs
	 * @param arrayToSearch an int[] used as the array to search
	 * @param valueToSearchFor an int used as the value to search for
	 * @return an int after lasting index of
	 */
	public static int lastIndexOf(int[] arrayToSearch, int valueToSearchFor) {
		// search for value from back of array
		for (int i = arrayToSearch.length-1; i >= 0; i--) {
			if (arrayToSearch[i] == valueToSearchFor) return i;
		}
		return -1;
	}
	
	/**
	 * Range method
	 * <p>The goal of this method is to range with arrayToProcess.</p>
	 * 
	 * @author Kevin Higgs
	 * @param arrayToProcess an int[] used as the array to process
	 * @return an int after ranging
	 */
	public static int range(int[] arrayToProcess) {
		// find min and max
		if (arrayToProcess.length == 1) return 1;
		int max = arrayToProcess[0];
		int min = arrayToProcess[0];
		
		for (int i = 1; i < arrayToProcess.length; i++) {
			if (arrayToProcess[i] > max) max = arrayToProcess[i];
			if (arrayToProcess[i] < min) min = arrayToProcess[i];
		}
		// return difference plus one
		return max-min+1;
	}
	
	/**
	 * Count in range
	 * <p>The purpose of this method is to count in range with arrayToProcess and minimumValue and maximumValue.</p>
	 * 
	 * @author Kevin Higgs
	 * @param arrayToProcess an int[] used as the array to process
	 * @param minimumValue an int used as the minimum value
	 * @param maximumValue an int used as the maximum value
	 * @return an int after counting in range
	 */
	public static int countInRange(int[] arrayToProcess, int minimumValue, int maximumValue) {
		// count values between max and min
		int count = 0;
		for (int i = 0; i < arrayToProcess.length; i++) {
			if (arrayToProcess[i] <= maximumValue && arrayToProcess[i] >= minimumValue) {
				count++;
			}
		}
		return count;
	}
	
	/**
	 * Check if it is sorted
	 * <p>The goal of this method is to check if it is sorted with arrayToCheck.</p>
	 * 
	 * @author Kevin Higgs
	 * @param arrayToCheck a double[] used as the array to check
	 * @return a boolean after checking if it is sorted
	 */
	public static boolean isSorted(double[] arrayToCheck) {
		// check if always less than previous
		for (int i = 1; i < arrayToCheck.length; i++) {
			if (arrayToCheck[i] < arrayToCheck[i-1]) return false;
		}
		return true;
	}
	
	/**
	 * Mode method
	 * <p>The goal of this method is to mode with arrayToProcess.</p>
	 * 
	 * @author Kevin Higgs
	 * @param arrayToProcess an int[] used as the array to process
	 * @return an int after moding
	 */
	public static int mode(int[] arrayToProcess) {
		// count occurences and find max num
		int[] occurences = new int[101];
		for (int i = 0; i < arrayToProcess.length; i++) {
			occurences[arrayToProcess[i]]++;
		}
		int max = 0;
		for (int i = 0; i < 101; i++) {
			if (occurences[i] > occurences[max]) max = i;
		}
		return max;
	}
	
	/**
	 * Stdev method
	 * <p>The purpose of this method is to stdev with arrayToProcess.</p>
	 * 
	 * @author Kevin Higgs
	 * @param arrayToProcess an int[] used as the array to process
	 * @return a double after stdeving
	 */
	public static double stdev(int[] arrayToProcess) {
		// follow formula to get stdev
		int sum = 0;
		for (int i = 0; i < arrayToProcess.length; i++) {
			sum += arrayToProcess[i];
		}
		double avg = (double)sum/(double)arrayToProcess.length;
		double sumavgsq = 0;
		for (int i = 0; i < arrayToProcess.length; i++) {
			sumavgsq += (arrayToProcess[i] - avg)*(arrayToProcess[i] - avg);
		}
		double avgsumavgsq = sumavgsq/(double)(arrayToProcess.length-1);
		return Math.sqrt(avgsumavgsq);
	}
	
	/**
	 * Kth largest
	 * <p>The goal of this method is to kth largest with kthLargestNumber and arrayToProcess.</p>
	 * 
	 * @author Kevin Higgs
	 * @param kthLargestNumber an int used as the kth largest number
	 * @param arrayToProcess an int[] used as the array to process
	 * @return an int after kthing largest
	 */
	public static int kthLargest(int kthLargestNumber, int[] arrayToProcess) {
		// get nth from back in sorted array
		return bogosort(arrayToProcess)[arrayToProcess.length-kthLargestNumber-1];
	}
	
	/**
	 * Min gap
	 * <p>The use of this method is to min gap with arrayToProcess.</p>
	 * 
	 * @author Kevin Higgs
	 * @param arrayToProcess an int[] used as the array to process
	 * @return an int after mining gap
	 */
	public static int minGap(int[] arrayToProcess) {
		// find all gaps, and keep track of minimum
		if (arrayToProcess.length < 2) return 0;
		int min = arrayToProcess[1] - arrayToProcess[0];
		for (int i = 2; i < arrayToProcess.length; i++) {
			if (arrayToProcess[i] - arrayToProcess[i-1] < min) {
				min = arrayToProcess[i] - arrayToProcess[i-1];
			}
		}
		return min;
	}
	
	/**
	 * Percent even
	 * <p>The use of this method is to percent even with arrayToProcess.</p>
	 * 
	 * @author Kevin Higgs
	 * @param arrayToProcess an int[] used as the array to process
	 * @return a double after percenting even
	 */
	public static double percentEven(int[] arrayToProcess) {
		// get num deven
		int count = 0;
		for (int i = 0; i < arrayToProcess.length; i++) {
			if (arrayToProcess[i] % 2 == 0) count++;
		}
		// divide by total
		return (double)count/(double)arrayToProcess.length*100.0;
	}
	
	/**
	 * Check if it is unique
	 * <p>The goal of this method is to check if it is unique with arrayToProcess.</p>
	 * 
	 * @author Kevin Higgs
	 * @param arrayToProcess an int[] used as the array to process
	 * @return a boolean after checking if it is unique
	 */
	public static boolean isUnique(int[] arrayToProcess) {
		// check gaps are all greated than zero
		if (arrayToProcess.length == 0 || arrayToProcess.length == 1) return true;
		if (minGap(bogosort(arrayToProcess)) > 0) return true;
		return false;
	}
	
	/**
	 * Price is right
	 * <p>The purpose of this method is to price is right with bids and price.</p>
	 * 
	 * @author Kevin Higgs
	 * @param bids an int[] used as the bids
	 * @param price an int used as the price
	 * @return an int after pricing is right
	 */
	public static int priceIsRight(int[] bids, int price) {
		// loop over and check all
		int closest = bids[0];
		for (int i = 1; i < bids.length; i++) {
			if ((price-bids[i] < price-closest || price-closest < 0) && price-bids[i] >= 0) {
				closest = bids[i];
			}
		}
		return price-closest >= 0 ? closest : -1;
	}
	
	/**
	 * Longest sorted sequence
	 * <p>The purpose of this method is to longest sorted sequence with arrayToProcess.</p>
	 * 
	 * @author Kevin Higgs
	 * @param arrayToProcess an int[] used as the array to process
	 * @return an int after longesting sorted sequence
	 */
	public static int longestSortedSequence(int[] arrayToProcess) {
		// check all possibilities
		int max = 0;
		for (int i = 1; i < arrayToProcess.length; i++) {
			int prevI = i;
			int count = 1;
			while (i < arrayToProcess.length && arrayToProcess[i] >= arrayToProcess[i-1]) {count++; i++;}
			if (count > max) max = count;
			i = prevI;
		}
		return max;
	}
	
	/**
	 * Contains method
	 * <p>The use of this method is to contains with arrayToLookIn and arrayToLookFor.</p>
	 * 
	 * @author Kevin Higgs
	 * @param arrayToLookIn an int[] used as the array to look in
	 * @param arrayToLookFor an int[] used as the array to look for
	 * @return a boolean after containsing
	 */
	public static boolean contains(int[] arrayToLookIn, int[] arrayToLookFor) {
		// check if it is contained
		for (int i = 0; i < arrayToLookIn.length-arrayToLookFor.length+1; i++) {
			boolean contained = true;
			for (int j = 0; j < arrayToLookFor.length; j++) {
				if (arrayToLookIn[i+j] != arrayToLookFor[j]) contained = false;
			}
			if (contained == true) return true;
		}
		return false;
	}
	
	/**
	 * Collapse method
	 * <p>The purpose of this method is to collapse with arrayToCollapse.</p>
	 * 
	 * @author Kevin Higgs
	 * @param arrayToCollapse an int[] used as the array to collapse
	 * @return an int[] after collapsing
	 */
	public static int[] collapse(int[] arrayToCollapse) {
		// collapse
		int[] collapsed = new int[arrayToCollapse.length/2 + (arrayToCollapse.length % 2)];
		for (int i = 0; i < arrayToCollapse.length - arrayToCollapse.length % 2; i+=2) {
			collapsed[i/2] = arrayToCollapse[i]+arrayToCollapse[i+1];
		}
		// add last (odd) if necessary
		if (arrayToCollapse.length % 2 == 1) collapsed[arrayToCollapse.length/2 ] = arrayToCollapse[arrayToCollapse.length-1];
		return collapsed;
	}
	
	/**
	 * Append method
	 * <p>The purpose of this method is to append with firstArrayToAppend and secondArrayToAppend.</p>
	 * 
	 * @author Kevin Higgs
	 * @param firstArrayToAppend an int[] used as the first array to append
	 * @param secondArrayToAppend an int[] used as the second array to append
	 * @return an int[] after appending
	 */
	public static int[] append(int[] firstArrayToAppend, int[] secondArrayToAppend) {
		// append together
		int[] appended = new int[firstArrayToAppend.length + secondArrayToAppend.length];
		for (int i = 0; i < firstArrayToAppend.length; i++) appended[i] = firstArrayToAppend[i];
		for (int i = 0; i < secondArrayToAppend.length; i++) appended[firstArrayToAppend.length + i] = secondArrayToAppend[i];
		return appended;
	}
	
	/**
	 * Vowel count
	 * <p>The purpose of this method is to vowel count with stringToCount.</p>
	 * 
	 * @author Kevin Higgs
	 * @param stringToCount a string used as the string to count
	 * @return an int[] after voweling count
	 */
	public static int[] vowelCount(String stringToCount) {
		// count vowels
		int[] vowels = new int[5];
		for (int i = 0; i < stringToCount.length(); i++) {
			if (stringToCount.charAt(i) == 'a') vowels[0]++;
			else if (stringToCount.charAt(i) == 'e') vowels[1]++;
			else if (stringToCount.charAt(i) == 'i') vowels[2]++;
			else if (stringToCount.charAt(i) == 'o') vowels[3]++;
			else if (stringToCount.charAt(i) == 'u') vowels[4]++;
		}
		return vowels;
	}
}
