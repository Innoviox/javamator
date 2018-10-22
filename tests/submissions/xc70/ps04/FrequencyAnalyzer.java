package net.mrpaul.ads.xc70.ps04;

import java.math.BigInteger;
import java.util.*;


// this is unfinished because I had trouble getting it to always determine the correct key length

public class FrequencyAnalyzer {
	public static void main(String args[]) {
		// get the encrypted message
		System.out.print("Enter the encrypted string: ");
		String original = new Scanner(System.in).nextLine();
		String message = original.replaceAll("[^A-Za-z]", "").toLowerCase();
		
		// find locations of occurrences of substrings
		List<Integer> indices = new ArrayList<Integer>();
		HashMap<String,ArrayList<Integer>> occurrences = new HashMap<String,ArrayList<Integer>>();
		for (int i = 0; i < message.length(); i++) {
			for (int j = 2; j < message.length()-i; j++) {
				if (!indices.contains(i)) {
					String sub = message.substring(i, i+j);
					ArrayList<Integer> current = occurrences.getOrDefault(sub, new ArrayList<Integer>());
					current.add(i);
					indices.add(i);
					occurrences.put(sub, current);
				}
			}
		}
		
		// remove non repeated strings
		Set<String> keys = new HashSet<String>(occurrences.keySet());
		for (String sub : keys) {
			if (occurrences.get(sub).size() <= 1) occurrences.remove(sub);
		}
				
		// find factors of intervals of strings
		HashMap<Integer,Integer> factors = new HashMap<Integer,Integer>();
		for (String sub : occurrences.keySet()) {
			double interval = occurrences.get(sub).get(1) - occurrences.get(sub).get(0);
			for (double i = 0.0; i < Math.sqrt(interval); i++) {
				if (interval/i == (int)(interval/i)) {
					factors.put((int)(interval/i), factors.getOrDefault((int)(interval/i), 1)+1);
				}
			}
		}
		
		// find the GCD of the most common factors, which is the key length
		int gcd = -1;
		while (true) {
			int maxFactor = -1;
			int max = -1;
			Set<Integer> factorSet = new HashSet<Integer>(factors.keySet());
			for (int factor : factorSet) {
				int count = factors.get(factor);
				if (count > max) {
					maxFactor = factor;
					factors.remove(factor);
					max = count;
				}
			}
			int newGCD;
			if (gcd == -1) { newGCD = maxFactor; }
			else { newGCD = BigInteger.valueOf(maxFactor).gcd(BigInteger.valueOf(gcd)).intValue(); }
			if (newGCD != 1 && newGCD != 2) gcd = newGCD;
			else { break; }
		}
		int keyLength = gcd;
		System.out.println("The key length is "+keyLength+".");		
	}
}
