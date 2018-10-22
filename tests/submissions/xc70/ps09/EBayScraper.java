package net.mrpaul.ads.xc70.ps09;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Scrape eBay for prices
 * This class scrapes eBay for prices of buy it now and auction items, outputting their name and prices.
 * <p>
 * ADS PS09: Greedy redux + eBay
 * 6/14/18
 * 
 * @author Kevin Higgs
 */
public class EBayScraper {
	
	// variable to keep track of outputted lines
	static int lineCount;

	/**
	 * Main method
	 * <p>This method runs the main program.</p>
	 * 
	 * @author Kevin Higgs
	 * @param args a string[] used as the args
	 */
	public static void main(String[] args) throws IOException {
		// scrape ebay for prices and names
		Files.lines(Paths.get("ebay_urls.txt")).map(l -> noExceptionURL(l)).<Matcher>map(c -> Pattern.compile("[\\s\\S]*<span id=\"vi-lkhdr-itmTitl\" class=\"u-dspn\">(.*?)<\\/span>[\\s\\S]*?(?:"+ (c.indexOf("id=\"prcIsum_bidPrice\"") != -1 ? "(?:<span class=\"notranslate\" id=\"prcIsum_bidPrice\" itemprop=\"price\" content=\".*?\">US (.*?)<\\/span>)" : "(-1)")+"[\\s\\S]*?"+(c.indexOf("id=\"prcIsum\"") != -1 ? "(?:<span class=\"notranslate\" id=\"prcIsum\" itemprop=\"price\"  style=\"\" content=\".*?\">US (.*?)<\\/span>)" : "(-1)") +")[\\s\\S]*").matcher(c)).map(r -> lineCount++ + "," + (r.matches() ? r.group(1) +","+ r.group(2) +","+ r.group(3) : "error")).forEach(System.out::println);
	}
	
	/**
	 * Get URL page contents without throwing a checked exception
	 * <p>This method is used to allow the creation of a URL object (and getting the page) within a lambda expression without a try and catch.</p>
	 * 
	 * @author Kevin Higgs
	 * @param url a string used as the url
	 * @return page contents
	 */
	public static String noExceptionURL(String url) {
		// unfortunately this is necessary because you can't do throws declaration with lambda functions and new URL has a checked exception
		// didn't want to put this in main expression because it's multiple statements - pretty sure there's no way around this
		try { return new Scanner(new URL(url).openConnection().getInputStream()).useDelimiter("\\A").next(); } catch (Exception e) { throw new RuntimeException(); }
	}
	
}