package sprint1.hospital.entity;

import javax.persistence.*;

@Entity
@Table(name = "patient")
public class PatientSG {

	@Id
	private int pid;
	private int proom;
	private String pname;
	private int page;
	private String pgender;
	private String psurgery;
	private String paddress;
	private int did;
	private int sid;

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getProom() {
		return proom;
	}

	public void setProom(int proom) {
		this.proom = proom;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public String getPgender() {
		return pgender;
	}

	public void setPgender(String pgender) {
		this.pgender = pgender;
	}

	public String getPsurgery() {
		return psurgery;
	}

	public void setPsurgery(String psurgery) {
		this.psurgery = psurgery;
	}

	public String getPaddress() {
		return paddress;
	}

	public void setPaddress(String paddress) {
		this.paddress = paddress;
	}

	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

}