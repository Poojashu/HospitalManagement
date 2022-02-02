package sprint1.hospital.entity;

import javax.persistence.*;

@Entity
@Table(name="staffmember")
public class StaffsSG {

	@Id
	private int sid;
	private String sname;
	private int sroom;
	private String smobile;

	public StaffsSG() {
		super();
	}

	public StaffsSG(int sid, String sname, int sroom, String smobile) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.sroom = sroom;
		this.smobile = smobile;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public int getSroom() {
		return sroom;
	}

	public void setSroom(int sroom) {
		this.sroom = sroom;
	}

	public String getSmobile() {
		return smobile;
	}

	public void setSmobile(String smobile) {
		this.smobile = smobile;
	}
}