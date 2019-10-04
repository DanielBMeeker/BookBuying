package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Book;
import model.ListDetails;
import model.Seller;

/**
 * Servlet implementation class editExistingListServlet
 */
@WebServlet("/editExistingListServlet")
public class editExistingListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editExistingListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ListDetailsHelper slh = new ListDetailsHelper();
		BookBuyingLogic bbl = new BookBuyingLogic();
		SellerHelper sh = new SellerHelper();

		// search for object to make changes to
		int idToEdit = Integer.parseInt(request.getParameter("id"));
		ListDetails toEdit = slh.searchForListById(idToEdit);

		// update the listName first
		String listName = request.getParameter("listName");
		System.out.println("List Name: " + listName);
		toEdit.setListName(listName);

		// update the date
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");

		LocalDate ld;
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		} catch (NumberFormatException ex) {
			ld = LocalDate.now();
		}
		toEdit.setSellDate(ld);

		// update the shopper
		String sellerName = request.getParameter("sellerName");
		String sellerDriverLicense = request.getParameter("sellerDriverLicense");
		Seller seller;
		try {
			seller = sh.searchForSellerByName(sellerName);
		} catch (NoResultException ex) {
			seller = new Seller(sellerName, sellerDriverLicense);
		} catch (Exception ex) {
			seller = new Seller(sellerName, sellerDriverLicense);
		}

		toEdit.setSeller(seller);

		// update the list of items
		List<Book> previousListOfItems = toEdit.getListOfItems();

		String[] selectedItems = request.getParameterValues("itemsToAdd");
		List<Book> selectedItemsInList = new ArrayList<Book>();

		if (selectedItems != null && selectedItems.length > 0 ) {
			for (int i = 0; i < selectedItems.length; i++) {
				System.out.println(selectedItems[i]);
				Book c = bbl.searchForItemById(Integer.parseInt(selectedItems[i]));
				selectedItemsInList.add(c);

			}

			previousListOfItems.addAll(selectedItemsInList);
		}

		toEdit.setListOfItems(previousListOfItems);

		slh.updateList(toEdit);

		System.out.println("Success!");
		System.out.println(toEdit.toString());

		getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
