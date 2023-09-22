package alkaram.javatpoint;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Address  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int aid;
	
	
	@Column
	private String details;

	/*
	note: do NOT declare and create getr and setr for
	addressid which is set as foreign key in this entity/table
	
	public int getAddressid() {
		return addressid;
	}

	public void setAddressid(int addressid) {
		this.addressid = addressid;
	}

	
	@Column
	private int addressid;
	*/
	
	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}
	
	
	
}
