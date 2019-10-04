package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Seller;

public class SellerHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("BookBuying");
		public void insertSeller(Seller s) {
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			em.persist(s);
			em.getTransaction().commit();
			em.close();
		}
		public List<Seller> showAllSellers() {
			EntityManager em = emfactory.createEntityManager();
			List<Seller> allSellers = em.createQuery("Select s from Seller s").getResultList();
			return allSellers;
			
		}
		public Seller searchForSellerByName(String sellerName) {
			// TODO Auto-generated method stub
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			TypedQuery<Seller> typedQuery = em.createQuery("select s from Shopper s where s.shopperName = :selectedName", Seller.class);
			typedQuery.setParameter("selectedName", sellerName);
			typedQuery.setMaxResults(1);

			Seller found = typedQuery.getSingleResult();
			em.close();
			return found;
		}
}
