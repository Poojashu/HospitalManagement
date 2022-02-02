package sprint1.hospital.entity;

import javax.persistence.*;

@Entity
@Table(name = "surgerycharges")
public class ChargesSG {

	@Id
	private String sname;
	private int amount;

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

}