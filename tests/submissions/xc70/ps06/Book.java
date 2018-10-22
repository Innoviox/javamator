package net.mrpaul.ads.xc70.ps06;

/**
 * A book with an author and title
 * This class is a book with an author and title that can be set if they are empty.
 * <p>
 * ADS PS06: Cartesian
 * 4/22/18
 * 
 * @author Kevin Higgs
 */
public class Book {
	
	private String title;
	private String author;
	
	/**
	 * Instantiate a book
	 * <p>The goal of this method is to instantiate a book.</p>
	 * 
	 * @author Kevin Higgs
	 */
	public Book() {
		// default values
		this.title = "";
		this.author = "";
	}
	
	/**
	 * Instantiate a book
	 * <p>The goal of this method is to instantiate a book with title.</p>
	 * 
	 * @author Kevin Higgs
	 * @param title a string used as the title
	 */
	public Book(String title) {
		// set values
		this.title = title;
		this.author = "";
	}
	
	/**
	 * Instantiate a book
	 * <p>The use of this method is to instantiate a book with author and title.</p>
	 * 
	 * @author Kevin Higgs
	 * @param author a string used as the author
	 * @param title a string used as the title
	 */
	public Book(String author, String title) {
		// set values
		this.title = title;
		this.author = author;
	}
	
	/**
	 * Get the author
	 * <p>The use of this method is to get the author.</p>
	 * 
	 * @author Kevin Higgs
	 * @return a string after getting the author
	 */
	public String getAuthor() {
		// return author
		return this.author;
	}
	
	/**
	 * Get the title
	 * <p>The purpose of this method is to get the title.</p>
	 * 
	 * @author Kevin Higgs
	 * @return a string after getting the title
	 */
	public String getTitle() {
		return this.title;
	}
	
	/**
	 * Set the author
	 * <p>The use of this method is to set the author with auth.</p>
	 * 
	 * @author Kevin Higgs
	 * @param auth a string used as the auth
	 */
	public void setAuthor(String auth) {
		// set as author if blank string, otherwise keep the same
		this.author = this.author == "" ? auth : this.author;
	}
	
	/**
	 * Set the title
	 * <p>The use of this method is to set the title with title.</p>
	 * 
	 * @author Kevin Higgs
	 * @param title a string used as the title
	 */
	public void setTitle(String title) {
		// set title if blank, otherwise keep the same
		this.title = this.title == "" ? title : this.title;
	}
	
	/**
	 * Convert to a string
	 * <p>The purpose of this method is to convert to a string.</p>
	 * 
	 * @author Kevin Higgs
	 * @return a string after converting to a string
	 */
	public String toString() {
		// convert to a string
		return (this.getTitle() != "" ? this.getTitle() : "Unknown") + (this.getAuthor() != "" ? (", by " + this.getAuthor()) : "");
	}
	
}
