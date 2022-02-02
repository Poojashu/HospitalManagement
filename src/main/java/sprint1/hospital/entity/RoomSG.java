package sprint1.hospital.entity;

import javax.persistence.*;

@Entity
@Table(name="room")
public class RoomSG {

	@Id
	private int roomno;
	private String location;

	public int getRoomno() {
		return roomno;
	}

	public void setRoomno(int roomno) {
		this.roomno = roomno;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
}