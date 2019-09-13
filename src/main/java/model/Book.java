package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//Daniel Meeker

@Entity
@Table(name="items")
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	@Column(name="TITLE")
	private String title;
	@Column(name="AUTHOR")
	private String author;
	@Column(name="ISBN")
	private String ISBN;
	@Column (name ="SALEPRICE")
	private double salePrice;
	@Column (name="AVGDAYSTOSELL")
	private int avgDaysToSell;
	@Column (name="PERCENTPAID")
	private double percentPaid;
	public Book() {
		super();
	}
	public Book(String title, String author, String iSBN, double salePrice, int avgDaysToSell) {
		super();
		this.title = title;
		this.author = author;
		ISBN = iSBN;
		this.salePrice = salePrice;
		this.avgDaysToSell = avgDaysToSell;
		this.percentPaid = getPercentPaid();
	}
	public Book(String title, String author) {
		super();
		this.title = title;
		this.author = author;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public double getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}
	public int getAvgDaysToSell() {
		return avgDaysToSell;
	}
	public void setAvgDaysToSell(int avgDaysToSell) {
		this.avgDaysToSell = avgDaysToSell;
	}
	public double getPercentPaid() {
		if (avgDaysToSell >= 150) 
		{
			percentPaid = .05;
		}
		else if (avgDaysToSell >= 100)
		{
			percentPaid = .10;
		}
		else if (avgDaysToSell >= 75)
		{
			percentPaid = .20;
		}
		else if (avgDaysToSell >= 30)
		{
			percentPaid = .30;
		}
		else if (avgDaysToSell >= 7)
		{
			percentPaid = .40;
		}
		else
		{
			percentPaid = .50;
		}
		return percentPaid;
	}

	

}
