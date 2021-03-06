package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Book;

/**
 * Servlet implementation class addItemServlet
 */
@WebServlet("/addItemServlet")
public class addItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String ISBN = request.getParameter("ISBN");
		double salePrice = Double.parseDouble(request.getParameter("salePrice"));
		int avgDaysToSell = Integer.parseInt(request.getParameter("avgDaysToSell"));
		Book b = new Book(title.toUpperCase(), author.toUpperCase(), ISBN, salePrice, avgDaysToSell);
		BookBuyingLogic bbl = new BookBuyingLogic();
		bbl.insertItem(b);
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}
