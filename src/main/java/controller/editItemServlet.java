package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Book;

/**
 * Servlet implementation class editItemServlet
 */
@WebServlet("/editItemServlet")
public class editItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BookBuyingLogic bbl = new BookBuyingLogic();
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String ISBN = request.getParameter("ISBN");
		double salePrice = Double.parseDouble(request.getParameter("salePrice"));
		int avgDaysToSell = Integer.parseInt(request.getParameter("avgDaysToSell"));
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		Book itemToUpdate = bbl.searchForItemById(tempId);
		itemToUpdate.setTitle(title.toUpperCase());
		itemToUpdate.setAuthor(author.toUpperCase());
		itemToUpdate.setISBN(ISBN);
		itemToUpdate.setSalePrice(salePrice);
		itemToUpdate.setAvgDaysToSell(avgDaysToSell);
		bbl.updateItem(itemToUpdate);
		getServletContext().getRequestDispatcher("/viewAllItems").forward(request, response);
	}

}
