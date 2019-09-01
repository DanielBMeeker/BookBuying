package model;
//Daniel Meeker
public class BookBuyingLogic {
	//This method will calculate how much money should be paid for a book depending on what price it is expected to sell for
	//and what percentage is being paid depending on how quickly it sells.
	public double calculatePricePaid(Book book)
	{
		double pricePaid = 0;
		pricePaid = book.getSalePrice() * book.getPercentPaid();
		return pricePaid;
	}
	//This method will determine whether or not the book is considered a best-seller by the store.
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
