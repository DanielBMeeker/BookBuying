package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Book;
import controller.BookBuyingLogic;

//Daniel Meeker
public class BookBuyingLogic {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("BookBuying");

	// This method will calculate how much money should be paid for a book depending
	// on what price it is expected to sell for
	// and what percentage is being paid depending on how quickly it sells.
	public double calculatePricePaid(Book book) {
		double pricePaid = 0;
		pricePaid = book.getSalePrice() * book.getPercentPaid();
		return pricePaid;
	}

	// This method will determine whether or not the book is considered a
	// best-seller by the store.
	public boolean isBestSeller(Book book) {
		if (book.getAvgDaysToSell() <= 30) {
			return true;
		} else {
			return false;
		}
	}

	public void insertItem(Book toAdd) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(toAdd);
		em.getTransaction().commit();
		em.close();

	}

	public void deleteItem(Book toDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Book> typedQuery = em.createQuery(
				"select book from Book	book	where	book.title	=	:selectedTitle	and	book.author	=	:selectedAuthor",
				Book.class);
		// Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedTitle", toDelete.getTitle());
		typedQuery.setParameter("selectedAuthor", toDelete.getAuthor());
		// we only want one result
		typedQuery.setMaxResults(1);
		// get the result and save it into a new list item
		Book result = typedQuery.getSingleResult();
		// remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	public void cleanUp() {
		// TODO Auto-generated method stub
		emfactory.close();
	}

	public Book searchForItemById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Book found = em.find(Book.class, idToEdit);
		em.close();
		return found;
	}

	public void updateItem(Book toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

	public List<Book> searchForItemByTitle(String title) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Book> typedQuery = em
				.createQuery("select	book	from Book	book	where	book.title	= :selectedTitle", Book.class);
		typedQuery.setParameter("selectedTitle", title);
		List<Book> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}

	public List<Book> searchForItemByAuthor(String author) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Book> typedQuery = em
				.createQuery("select	book	from Book	book	where	book.author	= :selectedAuthor", Book.class);
		typedQuery.setParameter("selectedAuthor", author);
		List<Book> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}

}
