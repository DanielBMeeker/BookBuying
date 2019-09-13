package test;
//Daniel Meeker
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import model.Book;
import controller.BookBuyingLogic;
public class TestBookBuyingLogic {
	BookBuyingLogic bbl = new BookBuyingLogic();
	Book prime = new Book("Where the Crawdads Sing", "Delia Owens", "0735219095", 12.99, 2);
	Book meh = new Book("Purpose Driven Life", "Rick Warren", "9780310205715", 2.00, 75);
	@Before
	public void setUp() throws Exception {
	}
	@Test
	//This test checks to make sure the correct percent paid is grabbed for the book depending on number of days sold.
	public void testCalculatePricePaid() {
		double pricePaid = bbl.calculatePricePaid(prime);
		assertEquals((12.99*.5), pricePaid, 0);
	}
	//This test verifies that a quick-selling book is considered as a best-seller for the store
	@Test
	public void testIsBestSeller() {
		assertTrue(bbl.isBestSeller(prime));
	}
	//This test verifies that a book that doesn't sell quickly is not considered a best-seller for the store 
	@Test
	public void testNotBestSeller() {
		assertFalse(bbl.isBestSeller(meh));
	}
}
