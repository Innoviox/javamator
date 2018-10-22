package net.mrpaul.ads.xc70.ps06;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BookPatronTest {

	private Book b1;
	private Patron p1;

	@Before
	public void setUp() throws Exception {
		this.p1 = new Patron("Mr. Paul");
		this.b1 = new Book("", "The Adventures of Mr. Paul");
	}

	@After
	public void tearDown() throws Exception {
		this.p1 = null;
		this.b1 = null;
	}

	@Test
	public void testBookToString() {
		assertEquals(this.b1.toString(), "The Adventures of Mr. Paul");
		this.b1.setAuthor("Mr. Paul");
		assertEquals(this.b1.toString(), "The Adventures of Mr. Paul, by Mr. Paul");
		this.b1.setAuthor("fdsa");
		assertEquals(this.b1.toString(), "The Adventures of Mr. Paul, by Mr. Paul");
	}

	@Test
	public void testBorrowBook() {
		assertEquals(this.p1.borrowBook("The Adventures of Mr. Paul 1"), true);
		assertEquals(this.p1.borrowBook("The Adventures of Mr. Paul 2"), true);
		assertEquals(this.p1.borrowBook("The Adventures of Mr. Paul 3"), true);
		assertEquals(this.p1.borrowBook("The Adventures of Mr. Paul 4"), false);
	}

	@Test
	public void testHasBook() {
		assertFalse(this.p1.hasBook("The Adventures of Mr. Paul"));
		this.p1.borrowBook("The Adventures of Mr. Paul");
		assertTrue(this.p1.hasBook("The Adventures of Mr. Paul"));
	}

	@Test
	public void testReturnBook() {
		assertFalse(this.p1.returnBook("The Adventures of Mr. Paul"));
		this.p1.borrowBook("The Adventures of Mr. Paul");
		assertTrue(this.p1.returnBook("The Adventures of Mr. Paul"));

	}

}
