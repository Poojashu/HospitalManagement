package sprint1.hospital.entity;

import javax.persistence.*;

@Entity
@Table(name="doctor")
public class DoctorSG {

	@Id
	private int did;
	private String dname;
	private String daddress;
	private String dmobile;
	private String dspecialization;

	public String getDspecialization() {
		return dspecialization;
	}

	public void setDspecialization(String dspecialization) {
		this.dspecialization = dspecialization;
	}

	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getDaddress() {
		return daddress;
	}

	public void setDaddress(String daddress) {
		this.daddress = daddress;
	}

	public String getDmobile() {
		return dmobile;
	}

	public void setDmobile(String dmobile) {
		this.dmobile = dmobile;
	}
}