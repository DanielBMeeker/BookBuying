import java.time.LocalDate;
import java.util.List;

import controller.ListDetailsHelper;
import controller.SellerHelper;
import model.ListDetails;
import model.Seller;

public class SellerTester {

	public static void main(String[] args) {
		Seller bill = new Seller("Bill", "978xx1234");
		SellerHelper sh = new SellerHelper();
		sh.insertSeller(bill);
		ListDetailsHelper ldh = new ListDetailsHelper();
		ListDetails billList = new ListDetails("Bill's List", LocalDate.now(), bill);
		ldh.insertNewListDetails(billList);
		List<ListDetails> allLists = ldh.getLists();
		for (ListDetails a : allLists) {
			System.out.println(a.toString());
		}
		List<Seller> allSellers = sh.showAllSellers();
		for (Seller a : allSellers) {
			System.out.println(a.toString());
		}
	}
}
