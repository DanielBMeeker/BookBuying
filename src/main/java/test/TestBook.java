package test;
//Daniel Meeker
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import model.Book;

public class TestBook {
	Book one = new Book();
	@Before
	public void setUp() throws Exception {
	}
	@Test
	//This test is set up so that it will test all of the ranges in the
	//getPercentPaid() to make sure they are working properly. If any one
	//fails the whole test will fail. 
	public void testGetPercentPaid() {
		one.setAvgDaysToSell(149);
		assertEquals(one.getPercentPaid(), .10, 0);
		one.setAvgDaysToSell(150);
		assertEquals(one.getPercentPaid(), .05, 0);
		one.setAvgDaysToSell(100);
		assertEquals(one.getPercentPaid(), .10, 0);
		one.setAvgDaysToSell(99);
		assertEquals(one.getPercentPaid(), .20, 0);
		one.setAvgDaysToSell(75);
		assertEquals(one.getPercentPaid(), .20, 0);
		one.setAvgDaysToSell(74);
		assertEquals(one.getPercentPaid(), .30, 0);
		one.setAvgDaysToSell(30);
		assertEquals(one.getPercentPaid(), .30, 0);
		one.setAvgDaysToSell(29);
		assertEquals(one.getPercentPaid(), .40, 0);
		one.setAvgDaysToSell(7);
		assertEquals(one.getPercentPaid(), .40, 0);
		one.setAvgDaysToSell(6);
		assertEquals(one.getPercentPaid(), .50, 0);
	}
	
}
