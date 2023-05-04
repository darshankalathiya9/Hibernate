package ONEtoMANY;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int PID;
	private String P_Name;
	@ManyToOne
	private Seller seller;

	public int getPID() {
		return PID;
	}

	public void setPID(int pID) {
		PID = pID;
	}

	public String getP_Name() {
		return P_Name;
	}

	public void setP_Name(String p_Name) {
		P_Name = p_Name;
	}

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	@Override
	public String toString() {
		return "Product [PID=" + PID + ", P_Name=" + P_Name + ", seller=" + seller + "]";
	}

}
