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
		assertEquals(.10, one.getPercentPaid(), 0);
		one.setAvgDaysToSell(150);
		assertEquals(.05, one.getPercentPaid(), 0);
		one.setAvgDaysToSell(100);
		assertEquals(.10, one.getPercentPaid(), 0);
		one.setAvgDaysToSell(99);
		assertEquals(.20, one.getPercentPaid(), 0);
		one.setAvgDaysToSell(75);
		assertEquals(.20, one.getPercentPaid(), 0);
		one.setAvgDaysToSell(74);
		assertEquals(.30, one.getPercentPaid(), 0);
		one.setAvgDaysToSell(30);
		assertEquals(.30, one.getPercentPaid(), 0);
		one.setAvgDaysToSell(29);
		assertEquals(.40, one.getPercentPaid(), 0);
		one.setAvgDaysToSell(7);
		assertEquals(.40, one.getPercentPaid(), 0);
		one.setAvgDaysToSell(6);
		assertEquals(.50, one.getPercentPaid(), 0);
	}
	
}
