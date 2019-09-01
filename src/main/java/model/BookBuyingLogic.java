package model;

public class BookBuyingLogic {
	public double calculatePricePaid(Book book)
	{
		double pricePaid = 0;
		pricePaid = book.getSalePrice() * book.getPercentPaid();
		return pricePaid;
	}
	public boolean isBestSeller(Book book)
	{
		if (book.getAvgDaysToSell() <= 30)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
