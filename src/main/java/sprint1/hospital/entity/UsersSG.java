package sprint1.hospital.entity;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class UsersSG {

	@Id
	private String username;
	private String password;
	private String used;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsed() {
		return used;
	}

	public void setUsed(String used) {
		this.used = used;
	}
}