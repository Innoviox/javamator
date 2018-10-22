package net.mrpaul.ads.xc70.ps06;

/**
 * A library patron that can borrow/return books
 * This class is a library patron that can borrow and return up to 3 books at a time.
 * <p>
 * ADS PS06: Cartesian
 * 4/22/18
 * 
 * @author Kevin Higgs
 */
public class Patron {

	private String name;
	private Book book1;
	private Book book2;
	private Book book3;
	
	/**
	 * Instantiate a patron
	 * <p>The goal of this method is to instantiate a patron with name.</p>
	 * 
	 * @author Kevin Higgs
	 * @param name a string used as the name
	 */
	public Patron(String name) {
		// initialize name
		this.name = name;
	}
	
	/**
	 * Return the book
	 * <p>The use of this method is to return the book with title.</p>
	 * 
	 * @author Kevin Higgs
	 * @param title a string used as the title
	 * @return a boolean after returning the book
	 */
	public boolean returnBook(String title) {
		// remove first book with the title provided
		if (this.book1 != null && this.book1.getTitle() == title) { this.book1 = null; return true; }
		if (this.book2 != null && this.book2.getTitle() == title) { this.book2 = null; return true; }
		if (this.book3 != null && this.book3.getTitle() == title) { this.book3 = null; return true; }
		return false;
	}
	
	/**
	 * Borrow book
	 * <p>The use of this method is to borrow book with title.</p>
	 * 
	 * @author Kevin Higgs
	 * @param title a string used as the title
	 * @return a boolean after borrowing book
	 */
	public boolean borrowBook(String title) {
		// create new book with title
		Book book = new Book(title);
		// set first open book to that book
		if (this.book1 == null) { this.book1 = book; return true; }
		if (this.book2 == null) { this.book2 = book; return true; }
		if (this.book3 == null) { this.book3 = book; return true; }
		return false;
	}
	
	/**
	 * Check if it has book
	 * <p>The purpose of this method is to check if it has book with title.</p>
	 * 
	 * @author Kevin Higgs
	 * @param title a string used as the title
	 * @return a boolean after checking if it has book
	 */
	public boolean hasBook(String title) {
		// checks each book to see if title matches
		if (this.book1 != null && this.book1.getTitle() == title) { return true; }
		if (this.book2 != null && this.book2.getTitle() == title) { return true; }
		if (this.book3 != null && this.book3.getTitle() == title) { return true; }
		return false;
	}
	
}
