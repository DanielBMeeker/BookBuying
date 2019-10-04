package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="seller")
public class Seller {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="SELLER_ID")
	private int id;
	@Column(name="SELLER_NAME")
	private String sellerName;
	@Column(name="SELLER_DRIVER_LICENSE")
	private String sellerDriverLicense;
	public Seller() {
		super();
	}
	public Seller(int id, String sellerName, String sellerDriverLicense) {
		super();
		this.id = id;
		this.sellerName = sellerName;
		this.sellerDriverLicense = sellerDriverLicense;
	}
	public Seller(String sellerName, String sellerDriverLicense) {
		super();
		this.sellerName = sellerName;
		this.sellerDriverLicense = sellerDriverLicense;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSellerName() {
		return sellerName;
	}
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
	public String getSellerDriverLicense() {
		return sellerDriverLicense;
	}
	public void setSellerDriverLicense(String sellerDriverLicense) {
		this.sellerDriverLicense = sellerDriverLicense;
	}
	@Override
	public String toString() {
		return "Seller [id=" + id + ", sellerName=" + sellerName + ", sellerDriverLicense=" + sellerDriverLicense + "]";
	}

}
